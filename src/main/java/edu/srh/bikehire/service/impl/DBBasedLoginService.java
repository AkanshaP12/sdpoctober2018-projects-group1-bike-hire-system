package edu.srh.bikehire.service.impl;

import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.srh.bikehire.dao.DAOFactory;
import edu.srh.bikehire.dao.UserAccountDAO;
import edu.srh.bikehire.dao.UserCredentialDAO;
import edu.srh.bikehire.dao.UserDAO;
import edu.srh.bikehire.dto.UserAccountDTO;
import edu.srh.bikehire.dto.UserCredentialDTO;
import edu.srh.bikehire.dto.UserDTO;
import edu.srh.bikehire.dto.impl.UserAccountDTOImpl;
import edu.srh.bikehire.dto.impl.UserCredentialDTOImpl;
import edu.srh.bikehire.dto.impl.UserDTOImpl;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.login.LoginConstants;
import edu.srh.bikehire.login.ResetPasswordValidator;
import edu.srh.bikehire.login.core.CustomerCredentialValidator;
import edu.srh.bikehire.login.core.UserDetailsValidator;
import edu.srh.bikehire.login.core.UserRegistrationCredentialValidator;
import edu.srh.bikehire.login.impl.DBBasedResetPasswordValidator;
import edu.srh.bikehire.login.util.LoginUtil;
import edu.srh.bikehire.login.util.PasswordHashGenerator;
import edu.srh.bikehire.service.Login;
import edu.srh.bikehire.service.core.Entity;
import edu.srh.bikehire.service.core.EntityAccount;
import edu.srh.bikehire.service.core.EntityLoginCredential;
import edu.srh.bikehire.service.core.EntityRegistrationCredential;
import edu.srh.bikehire.service.core.impl.Customer;
import edu.srh.bikehire.service.core.impl.CustomerAccount;
import edu.srh.bikehire.util.Util;

public class DBBasedLoginService implements Login {
	
	private static final Logger LOG = LogManager.getLogger(DBBasedLoginService.class);
	
	private UserDAO mUserDAO;
	
	private UserAccountDAO mUserAccountDAO;
	
	private UserCredentialDAO mUserCredentialDAO;
	
	public DBBasedLoginService()
	{
		mUserDAO = DAOFactory.getDefaultUserDAOImpl();
		mUserAccountDAO = DAOFactory.getDefaultUserAccountDAOImpl();
		mUserCredentialDAO = DAOFactory.getDefaultUserCredentialDAOImpl();
	}
	
	
	public Entity authenticate(EntityLoginCredential pInputEntityCredentials) throws BikeHireSystemException {
		LOG.info("authenticate : Start");
		CustomerCredentialValidator lLoginCredentialValidator = new CustomerCredentialValidator(pInputEntityCredentials);
		int userId = lLoginCredentialValidator.validateLoginCredentials(mUserCredentialDAO);
		LOG.info("authenticate : password validated successfully.");
		//If correct password, fetch entity object and return it
		UserDTO lLoggedInUser = mUserDAO.getUser(userId);
		
		if(lLoggedInUser == null)
		{
			//ERROR_MESSAGE : Invalid login credentials provided. Username doesn't exists.
			throw new BikeHireSystemException(10024);
		}
		UserAccountDTO lLoggedInUserAccountDTO = mUserAccountDAO.getUserAccount(userId);
		
		if(lLoggedInUserAccountDTO == null)
		{
			//ERROR_MESSAGE : Invalid login credentials provided. Username doesn't exists.
			throw new BikeHireSystemException(10024);
		}
		
		Entity lLoggedInEntity = getEntityFromUserDTO(lLoggedInUser, lLoggedInUserAccountDTO);
		// Client should maintain User Sessions
		LOG.info("authenticate : End");
		return lLoggedInEntity;
	}

	public ResetPasswordValidator sendSecurityTokenForResetPassword(String pEmailAddress) throws BikeHireSystemException {
		LOG.info("sendSecurityTokenForResetPassword : Start");
		if(Util.isEmptyOrNullString(pEmailAddress))
		{
			//ERROR_MESSAGE : Invalid email address provided for reset password.
			throw new BikeHireSystemException(10025);
		}
		
		UserDTO lUserDTO = mUserDAO.getUserByEmailId(pEmailAddress);
		
		if(lUserDTO == null)
		{
			//ERROR_MESSAGE : Invalid email address {0} provided for reset password. 
			throw new BikeHireSystemException(10026, new Object[] {pEmailAddress});
		}
		
		// Initialize resetpassword validator
		DBBasedResetPasswordValidator lResetPasswordValidator = new DBBasedResetPasswordValidator(lUserDTO.getId(),pEmailAddress, false);
		lResetPasswordValidator.generateToken();

		//send email notification for security code
		lResetPasswordValidator.sendNotfificationForSecurityCode();
		LOG.info("sendSecurityTokenForResetPassword : Security code email sent successfully.");
		
		LOG.info("sendSecurityTokenForResetPassword : End");
		return lResetPasswordValidator;
	}

	public ResetPasswordValidator registerUserAccount(Entity pEntity, EntityRegistrationCredential pEntityCredential) throws BikeHireSystemException {
		LOG.info("registerUserAccount : Start");
		
		//Validate entity details
		UserDetailsValidator lUserDetailsValidator = new UserDetailsValidator(pEntity);
		lUserDetailsValidator.validateUserInformationForRegistartion();
		
		//Validate that user email address is not registered before.
		UserDTO lUserDTO = mUserDAO.getUserByEmailId(pEntity.getEmailId());
		
		if(lUserDTO != null)
		{
			//ERROR_MESSAGE : User with email address {0} already exists. 
			throw new BikeHireSystemException(10027, new Object[] {pEntity.getEmailId()});
		}
		LOG.info("registerUserAccount : No user exists with email address. Proceed to user creation.");
		
		UserRegistrationCredentialValidator lCredentialValidator = new UserRegistrationCredentialValidator(pEntityCredential);
		lCredentialValidator.validateEntityCredentials();
		
		UserAccountDTO lUserAccountDTO = mUserAccountDAO.getUserAccountUsingUserName(pEntityCredential.getUserName());
		
		if(lUserAccountDTO != null)
		{
			//ERROR_MESSAGE : User with username {0} already exists. 
			throw new BikeHireSystemException(10028, new Object[] {pEntityCredential.getUserName()});
		}
		
		//Insert information using mUserDAO
		UserDTO lNewUserDTO = getUserDTOFromInputs(pEntity);
		int userId = mUserDAO.addUser(lNewUserDTO);
		LOG.info("registerUserAccount : User added successfully.");
		//Insert information using mUserAccounrDAO
		UserAccountDTO lNewUserAccountDTO = getUserAccountDTOFromInputs(pEntity.getEntityAccount(), lNewUserDTO);
		boolean lbIsAdded = mUserAccountDAO.addUserAccount(lNewUserAccountDTO);
		LOG.info("registerUserAccount : User account details created successfully.");
		
		//Insert information using mUserCredentialDAO
		UserCredentialDTO lNewUserCredentials = getUserCredentialDTOFromInputs(pEntityCredential, lNewUserAccountDTO, lNewUserDTO);
		boolean lbIsCredentialAdded = mUserCredentialDAO.addUserCredential(lNewUserCredentials);
		LOG.info("registerUserAccount : User credentials added successfully.");
		
		DBBasedResetPasswordValidator lResetPasswordValidator = new DBBasedResetPasswordValidator(userId, pEntity.getEmailId(), true);
		lResetPasswordValidator.generateToken();

		//send email notification for security code
		lResetPasswordValidator.sendNotfificationForSecurityCode();
		LOG.info("registerUserAccount : Security code for email verification sent successfully.");
		LOG.info("registerUserAccount : End");
		return lResetPasswordValidator;
	}
	
	public void resetPassword(EntityRegistrationCredential pEntityCredential) throws BikeHireSystemException
	{
		LOG.info("resetPassword : Start");
		//Check EntityRegistrationCredentials
		UserRegistrationCredentialValidator lCredentialValidator = new UserRegistrationCredentialValidator(pEntityCredential);
		lCredentialValidator.validateEntityCredentials();
		
		UserAccountDTO lUserAccountDTO = mUserAccountDAO.getUserAccountUsingUserName(pEntityCredential.getUserName());
		if(lUserAccountDTO == null)
		{
			//TODO: resolve
			throw new BikeHireSystemException(-1);
		}
		UserDTO lUserDTO = mUserDAO.getUser(lUserAccountDTO.getId());
		
		UserCredentialDTO lUserCredentialDTO = getUserCredentialDTOFromInputs(pEntityCredential, lUserAccountDTO, lUserDTO);
		boolean lbCredentials = mUserCredentialDAO.updateUserCredential(lUserCredentialDTO);
		LOG.info("resetPassword : Password reset successfully.");
		
		//send reset password notification
		EmailNotificationService emailNotificationService = new EmailNotificationService();
		emailNotificationService.passwordResetSuccess(lUserDTO.getEmailId());
		LOG.info("resetPassword : password reset email sent.");
		LOG.info("resetPassword : End");
	}
	
	public void deactivateAccount(Entity pEntity) throws BikeHireSystemException {
		LOG.info("deactivateAccount : Start");
		UserDetailsValidator lUserDetailsValidator = new UserDetailsValidator(pEntity);
		lUserDetailsValidator.validateUserInformationForDeactiviation();
		
		UserDTO lUserDTO = mUserDAO.getUserByEmailId(pEntity.getEmailId());
		UserAccountDTO lUserAccountDTO = getUserAccountForDeactivation(lUserDTO);
		boolean lbResult = mUserAccountDAO.updateUserAccount(lUserAccountDTO);
		LOG.info("deactivateAccount : User account deactivated successfully.");
		LOG.info("deactivateAccount : End");
	}
	
	public EntityAccount getAccountInfo(int pUserId){
		LOG.info("getAccountInfo : Start");
		UserAccountDTO lUserAccountDTO = mUserAccountDAO.getUserAccount(pUserId);
		LOG.info("getAccountInfo : End");
		return getEntityAccountFromDTO(lUserAccountDTO);
	}

	private Entity getEntityFromUserDTO(UserDTO pUserDTO, UserAccountDTO pUserAccountDTO)
	{
		Customer lCustomer = new Customer();
		lCustomer.setAddress(pUserDTO.getAddress());
		lCustomer.setEmailID(pUserDTO.getEmailId());
		lCustomer.setFirstName(pUserDTO.getFirstName());
		lCustomer.setGender(pUserDTO.getGender());
		lCustomer.setLastName(pUserDTO.getLastName());
		lCustomer.setUserId(pUserDTO.getId());
		lCustomer.setDOB(pUserDTO.getDob());
		lCustomer.setIdentityProofBytes(pUserDTO.getIdentityProof());
		lCustomer.setPhoneNumber(pUserDTO.getPhoneNo());
		lCustomer.setPhotoBytes(pUserDTO.getPhoto());
		
		CustomerAccount lCustomerAccount = new CustomerAccount();
		lCustomerAccount.setUserId(pUserAccountDTO.getId());
		lCustomerAccount.setUserName(pUserAccountDTO.getUserName());
		lCustomerAccount.setUserRole(pUserAccountDTO.getRole());
		lCustomerAccount.setAccountStatus(pUserAccountDTO.getAccountStatus());
		
		lCustomer.setEntityAccount(lCustomerAccount);
		
		return lCustomer;
	}
	
	private UserDTO getUserDTOFromInputs(Entity pEntity)
	{
		UserDTOImpl lUserDTO = new UserDTOImpl();
		lUserDTO.setAddress(pEntity.getAddress());
		lUserDTO.setDob(pEntity.getDOB());
		lUserDTO.setEmailId(pEntity.getEmailId());
		lUserDTO.setFirstName(pEntity.getFirstName());
		lUserDTO.setGender(pEntity.getGender());
		lUserDTO.setIdentityProof(pEntity.getIdentityProof());
		lUserDTO.setLastName(pEntity.getLastName());
		lUserDTO.setPhoneNo(pEntity.getPhoneNumber());
		lUserDTO.setPhoto(pEntity.getPhoto());
		
		return lUserDTO;
	}
	
	private UserAccountDTO getUserAccountDTOFromInputs(EntityAccount pEntityAccount, UserDTO pUserDTO)
	{
		UserAccountDTOImpl lUserAccountDTOImpl = new UserAccountDTOImpl();
		lUserAccountDTOImpl.setAccountStatus(LoginConstants.LOGIN_ACCOUNT_STATUS_UNVERIFIED);
		lUserAccountDTOImpl.setCreationTimeStamp(Calendar.getInstance());
		lUserAccountDTOImpl.setLastModifiedTimeStamp(Calendar.getInstance());
		lUserAccountDTOImpl.setRole(pEntityAccount.getUserRole());
		lUserAccountDTOImpl.setUserName(pEntityAccount.getUserName());
		lUserAccountDTOImpl.setUserDTO(pUserDTO);
		
		return lUserAccountDTOImpl;
	}
	
	private EntityAccount getEntityAccountFromDTO(UserAccountDTO userAccountDTO)
	{
		CustomerAccount lCustomerAccount = new CustomerAccount();
		lCustomerAccount.setAccountStatus(userAccountDTO.getAccountStatus());
		lCustomerAccount.setUserId(userAccountDTO.getId());
		lCustomerAccount.setUserName(userAccountDTO.getUserName());
		lCustomerAccount.setUserRole(userAccountDTO.getRole());
		return lCustomerAccount;
	}
	
	private UserCredentialDTO getUserCredentialDTOFromInputs(EntityRegistrationCredential pCredentials, UserAccountDTO pUserAccountDTO, UserDTO pUserDTO) throws BikeHireSystemException
	{
		UserCredentialDTOImpl lUserCredentialDTO = new UserCredentialDTOImpl();
		lUserCredentialDTO.setLastModifiedTimeStamp(Calendar.getInstance());
		lUserCredentialDTO.setUserAccount((UserAccountDTOImpl)pUserAccountDTO);
		
		String lstrSalt = PasswordHashGenerator.generateSalt();
		lUserCredentialDTO.setPasswordSalt(lstrSalt);
		lUserCredentialDTO.setPasswordHash(PasswordHashGenerator.getSHA512Hash(pCredentials.getNewPassword(), lstrSalt));
		
		lUserCredentialDTO.setUserDTO(pUserDTO);
		
		return lUserCredentialDTO;
	}
	
	private UserAccountDTO getUserAccountForDeactivation(UserDTO pUserDTO)
	{
		UserAccountDTOImpl lUserAccountDTOImpl = new UserAccountDTOImpl();
		lUserAccountDTOImpl.setAccountStatus(LoginConstants.LOGIN_ACCOUNT_STATUS_INACTIVE);
		lUserAccountDTOImpl.setUserDTO(pUserDTO);
		lUserAccountDTOImpl.setLastModifiedTimeStamp(Calendar.getInstance());
		return lUserAccountDTOImpl;
	}
	
	public boolean markUserAccountAsActive(int pUserId)
	{
		UserAccountDTOImpl userAccountDTOImpl = (UserAccountDTOImpl) mUserAccountDAO.getUserAccount(pUserId);
		userAccountDTOImpl.setAccountStatus(LoginConstants.LOGIN_ACCOUNT_STATUS_ACTIVE);
		return mUserAccountDAO.updateUserAccount(userAccountDTOImpl);
	}
}
