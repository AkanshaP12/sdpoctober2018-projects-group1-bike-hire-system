package edu.srh.bikehire.service.impl;

import java.util.Calendar;

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
	private UserDAO mUserDAO;
	
	private UserAccountDAO mUserAccountDAO;
	
	private UserCredentialDAO mUserCredentialDAO;
	
	public void initializeService()
	{
		mUserDAO = DAOFactory.getDefaultUserDAOImpl();
		mUserAccountDAO = DAOFactory.getDefaultUserAccountDAOImpl();
		mUserCredentialDAO = DAOFactory.getDefaultUserCredentialDAOImpl();
	}
	
	
	public Entity authenticate(EntityLoginCredential pInputEntityCredentials) throws BikeHireSystemException {
		
		CustomerCredentialValidator lLoginCredentialValidator = new CustomerCredentialValidator(pInputEntityCredentials);
		int userId = lLoginCredentialValidator.validateLoginCredentials(mUserCredentialDAO);
		
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
		return lLoggedInEntity;
	}

	public ResetPasswordValidator sendSecurityTokenForResetPassword(String pEmailAddress) throws BikeHireSystemException {
		
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
		DBBasedResetPasswordValidator lResetPasswordValidator = new DBBasedResetPasswordValidator(pEmailAddress, false);
		lResetPasswordValidator.generateToken();

		//send email notification for security code
		lResetPasswordValidator.sendNotfificationForSecurityCode();
		
		return lResetPasswordValidator;
	}

	public ResetPasswordValidator registerUserAccount(Entity pEntity, EntityRegistrationCredential pEntityCredential) throws BikeHireSystemException {
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
		
		UserRegistrationCredentialValidator lCredentialValidator = new UserRegistrationCredentialValidator(pEntityCredential);
		lCredentialValidator.validateEntityCredentials();
		
		//TODO: Validate whether username exist in system or not. USERNAME SHOULD NOT EXIST
		UserAccountDTO lUserAccountDTO = mUserAccountDAO.getUserAccountUsingUserName(pEntityCredential.getUserName());
		
		if(lUserAccountDTO != null)
		{
			//ERROR_MESSAGE : User with username {0} already exists. 
			throw new BikeHireSystemException(10028, new Object[] {pEntityCredential.getUserName()});
		}
		
		//Insert information using mUserDAO
		UserDTO lNewUserDTO = getUserDTOFromInputs(pEntity);
		int userId = mUserDAO.addUser(lNewUserDTO);
		
		//Insert information using mUserAccounrDAO
		UserAccountDTO lNewUserAccountDTO = getUserAccountDTOFromInputs(pEntity.getEntityAccount(), lNewUserDTO);
		boolean lbIsAdded = mUserAccountDAO.addUserAccount(lNewUserAccountDTO);
		
		//Insert information using mUserCredentialDAO
		UserCredentialDTO lNewUserCredentials = getUserCredentialDTOFromInputs(pEntityCredential, lNewUserAccountDTO, lNewUserDTO);
		boolean lbIsCredentialAdded = mUserCredentialDAO.addUserCredential(lNewUserCredentials);
		
		DBBasedResetPasswordValidator lResetPasswordValidator = new DBBasedResetPasswordValidator(pEntity.getEmailId(), true);
		lResetPasswordValidator.generateToken();

		//send email notification for security code
		lResetPasswordValidator.sendNotfificationForSecurityCode();
		return lResetPasswordValidator;
	}
	
	public void resetPassword(EntityRegistrationCredential pEntityCredential) throws BikeHireSystemException
	{
		//Check EntityRegistrationCredentials
		UserRegistrationCredentialValidator lCredentialValidator = new UserRegistrationCredentialValidator(pEntityCredential);
		lCredentialValidator.validateEntityCredentials();
		
		UserAccountDTO lUserAccountDTO = mUserAccountDAO.getUserAccountUsingUserName(pEntityCredential.getUserName());
		UserDTO lUserDTO = mUserDAO.getUser(lUserAccountDTO.getId());
		
		UserCredentialDTO lUserCredentialDTO = getUserCredentialDTOFromInputs(pEntityCredential, lUserAccountDTO, lUserDTO);
		boolean lbCredentials = mUserCredentialDAO.updateUserCredential(lUserCredentialDTO);
		
	}
	
	public void deactivateAccount(Entity pEntity) throws BikeHireSystemException {
		UserDetailsValidator lUserDetailsValidator = new UserDetailsValidator(pEntity);
		lUserDetailsValidator.validateUserInformationForDeactiviation();
		
		UserDTO lUserDTO = mUserDAO.getUserByEmailId(pEntity.getEmailId());
		UserAccountDTO lUserAccountDTO = getUserAccountForDeactivation(lUserDTO);
		boolean lbResult = mUserAccountDAO.updateUserAccount(lUserAccountDTO);
		//TODO: Call DAO to change user status in USERACCOUNT table.
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
		lCustomer.setDOB(pUserDTO.getDOB());
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
		lUserDTO.setDOB(pEntity.getDOB());
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
}
