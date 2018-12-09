package edu.srh.bikehire.service.impl;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.login.ResetPasswordValidator;
import edu.srh.bikehire.service.core.Entity;
import edu.srh.bikehire.service.core.EntityAccount;
import edu.srh.bikehire.service.core.impl.Customer;
import edu.srh.bikehire.service.core.impl.CustomerAccount;
import edu.srh.bikehire.service.core.impl.CustomerRegistrationCredential;
import edu.srh.bikehire.service.core.impl.LoginCredential;

public class DBBasedLoginServiceTest {
	
	private int userId = 0;
	
	@Test(expected = BikeHireSystemException.class)
	public void testRegisterUserAccountInvalidFirstName() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		Customer customer = new Customer();
		customer.setFirstName(null);
		customer.setLastName("patel");
		customer.setAddress("Germany");
		customer.setDOB(Calendar.getInstance());
		customer.setEmailID("something@mailinator.com");
		customer.setGender("Male");
		customer.setIdentityProofBytes(new byte[] {23,35,5,53,34,12,2});
		customer.setPhotoBytes(new byte[] {23,12,45,23,7,3,7,23,78,23,5});
		customer.setPhoneNumber("56262949562626");
		CustomerAccount customerAccount = new CustomerAccount();
		customerAccount.setUserName("viraj-p");
		customerAccount.setUserRole("Customer");
		
		customer.setEntityAccount(customerAccount);
		
		CustomerRegistrationCredential registrationValidator = new CustomerRegistrationCredential();
		registrationValidator.setUserName("viraj-p");
		registrationValidator.setNewPassword("Srh@2018");
		registrationValidator.setConfirmPassword("Srh@2018");
		
		ResetPasswordValidator resetPasswordValidator = dbBasedLoginService.registerUserAccount(customer, registrationValidator);
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testRegisterUserAccountInvalidLastName() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		Customer customer = new Customer();
		customer.setFirstName("viraj");
		customer.setLastName(null);
		customer.setAddress("Germany");
		customer.setDOB(Calendar.getInstance());
		customer.setEmailID("something@mailinator.com");
		customer.setGender("Male");
		customer.setIdentityProofBytes(new byte[] {23,35,5,53,34,12,2});
		customer.setPhotoBytes(new byte[] {23,12,45,23,7,3,7,23,78,23,5});
		customer.setPhoneNumber("56262949562626");
		CustomerAccount customerAccount = new CustomerAccount();
		customerAccount.setUserName("viraj-p");
		customerAccount.setUserRole("Customer");
		
		customer.setEntityAccount(customerAccount);
		
		CustomerRegistrationCredential registrationValidator = new CustomerRegistrationCredential();
		registrationValidator.setUserName("viraj-p");
		registrationValidator.setNewPassword("Srh@2018");
		registrationValidator.setConfirmPassword("Srh@2018");
		
		ResetPasswordValidator resetPasswordValidator = dbBasedLoginService.registerUserAccount(customer, registrationValidator);
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testRegisterUserAccountInvalidAddress() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		Customer customer = new Customer();
		customer.setFirstName("viraj");
		customer.setLastName("patel");
		customer.setAddress(null);
		customer.setDOB(Calendar.getInstance());
		customer.setEmailID("something@mailinator.com");
		customer.setGender("Male");
		customer.setIdentityProofBytes(new byte[] {23,35,5,53,34,12,2});
		customer.setPhotoBytes(new byte[] {23,12,45,23,7,3,7,23,78,23,5});
		customer.setPhoneNumber("56262949562626");
		CustomerAccount customerAccount = new CustomerAccount();
		customerAccount.setUserName("viraj-p");
		customerAccount.setUserRole("Customer");
		
		customer.setEntityAccount(customerAccount);
		
		CustomerRegistrationCredential registrationValidator = new CustomerRegistrationCredential();
		registrationValidator.setUserName("viraj-p");
		registrationValidator.setNewPassword("Srh@2018");
		registrationValidator.setConfirmPassword("Srh@2018");
		
		ResetPasswordValidator resetPasswordValidator = dbBasedLoginService.registerUserAccount(customer, registrationValidator);
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testRegisterUserAccountInvalidDOB() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		Customer customer = new Customer();
		customer.setFirstName("viraj");
		customer.setLastName("patel");
		customer.setAddress("Germany");
		customer.setDOB(null);
		customer.setEmailID("something@mailinator.com");
		customer.setGender("Male");
		customer.setIdentityProofBytes(new byte[] {23,35,5,53,34,12,2});
		customer.setPhotoBytes(new byte[] {23,12,45,23,7,3,7,23,78,23,5});
		customer.setPhoneNumber("56262949562626");
		CustomerAccount customerAccount = new CustomerAccount();
		customerAccount.setUserName("viraj-p");
		customerAccount.setUserRole("Customer");
		
		customer.setEntityAccount(customerAccount);
		
		CustomerRegistrationCredential registrationValidator = new CustomerRegistrationCredential();
		registrationValidator.setUserName("viraj-p");
		registrationValidator.setNewPassword("Srh@2018");
		registrationValidator.setConfirmPassword("Srh@2018");
		
		ResetPasswordValidator resetPasswordValidator = dbBasedLoginService.registerUserAccount(customer, registrationValidator);
	}

	@Test(expected = BikeHireSystemException.class)
	public void testRegisterUserAccountNullEmail() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		Customer customer = new Customer();
		customer.setFirstName("viraj");
		customer.setLastName("patel");
		customer.setAddress("Germany");
		customer.setDOB(Calendar.getInstance());
		customer.setEmailID(null);
		customer.setGender("Male");
		customer.setIdentityProofBytes(new byte[] {23,35,5,53,34,12,2});
		customer.setPhotoBytes(new byte[] {23,12,45,23,7,3,7,23,78,23,5});
		customer.setPhoneNumber("56262949562626");
		CustomerAccount customerAccount = new CustomerAccount();
		customerAccount.setUserName("viraj-p");
		customerAccount.setUserRole("Customer");
		
		customer.setEntityAccount(customerAccount);
		
		CustomerRegistrationCredential registrationValidator = new CustomerRegistrationCredential();
		registrationValidator.setUserName("viraj-p");
		registrationValidator.setNewPassword("Srh@2018");
		registrationValidator.setConfirmPassword("Srh@2018");
		
		ResetPasswordValidator resetPasswordValidator = dbBasedLoginService.registerUserAccount(customer, registrationValidator);
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testRegisterUserAccountInvalidEmail() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		Customer customer = new Customer();
		customer.setFirstName("viraj");
		customer.setLastName("patel");
		customer.setAddress("Germany");
		customer.setDOB(Calendar.getInstance());
		customer.setEmailID("something");
		customer.setGender("Male");
		customer.setIdentityProofBytes(new byte[] {23,35,5,53,34,12,2});
		customer.setPhotoBytes(new byte[] {23,12,45,23,7,3,7,23,78,23,5});
		customer.setPhoneNumber("56262949562626");
		CustomerAccount customerAccount = new CustomerAccount();
		customerAccount.setUserName("viraj-p");
		customerAccount.setUserRole("Customer");
		
		customer.setEntityAccount(customerAccount);
		
		CustomerRegistrationCredential registrationValidator = new CustomerRegistrationCredential();
		registrationValidator.setUserName("viraj-p");
		registrationValidator.setNewPassword("Srh@2018");
		registrationValidator.setConfirmPassword("Srh@2018");
		
		ResetPasswordValidator resetPasswordValidator = dbBasedLoginService.registerUserAccount(customer, registrationValidator);
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testRegisterUserAccountInvalidGender() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		Customer customer = new Customer();
		customer.setFirstName("viraj");
		customer.setLastName("patel");
		customer.setAddress("Germany");
		customer.setDOB(Calendar.getInstance());
		customer.setEmailID("something@mailinator.com");
		customer.setGender(null);
		customer.setIdentityProofBytes(new byte[] {23,35,5,53,34,12,2});
		customer.setPhotoBytes(new byte[] {23,12,45,23,7,3,7,23,78,23,5});
		customer.setPhoneNumber("56262949562626");
		CustomerAccount customerAccount = new CustomerAccount();
		customerAccount.setUserName("viraj-p");
		customerAccount.setUserRole("Customer");
		
		customer.setEntityAccount(customerAccount);
		
		CustomerRegistrationCredential registrationValidator = new CustomerRegistrationCredential();
		registrationValidator.setUserName("viraj-p");
		registrationValidator.setNewPassword("Srh@2018");
		registrationValidator.setConfirmPassword("Srh@2018");
		
		ResetPasswordValidator resetPasswordValidator = dbBasedLoginService.registerUserAccount(customer, registrationValidator);
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testRegisterUserAccountInvalidID() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		Customer customer = new Customer();
		customer.setFirstName("viraj");
		customer.setLastName("patel");
		customer.setAddress("Germany");
		customer.setDOB(Calendar.getInstance());
		customer.setEmailID("something@mailinator.com");
		customer.setGender("Male");
		customer.setIdentityProofBytes(null);
		customer.setPhotoBytes(new byte[] {23,12,45,23,7,3,7,23,78,23,5});
		customer.setPhoneNumber("56262949562626");
		CustomerAccount customerAccount = new CustomerAccount();
		customerAccount.setUserName("viraj-p");
		customerAccount.setUserRole("Customer");
		
		customer.setEntityAccount(customerAccount);
		
		CustomerRegistrationCredential registrationValidator = new CustomerRegistrationCredential();
		registrationValidator.setUserName("viraj-p");
		registrationValidator.setNewPassword("Srh@2018");
		registrationValidator.setConfirmPassword("Srh@2018");
		
		ResetPasswordValidator resetPasswordValidator = dbBasedLoginService.registerUserAccount(customer, registrationValidator);
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testRegisterUserAccountInvalidPhoto() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		Customer customer = new Customer();
		customer.setFirstName("viraj");
		customer.setLastName("patel");
		customer.setAddress("Germany");
		customer.setDOB(Calendar.getInstance());
		customer.setEmailID("something@mailinator.com");
		customer.setGender("Male");
		customer.setIdentityProofBytes(new byte[] {23,35,5,53,34,12,2});
		customer.setPhotoBytes(null);
		customer.setPhoneNumber("56262949562626");
		CustomerAccount customerAccount = new CustomerAccount();
		customerAccount.setUserName("viraj-p");
		customerAccount.setUserRole("Customer");
		
		customer.setEntityAccount(customerAccount);
		
		CustomerRegistrationCredential registrationValidator = new CustomerRegistrationCredential();
		registrationValidator.setUserName("viraj-p");
		registrationValidator.setNewPassword("Srh@2018");
		registrationValidator.setConfirmPassword("Srh@2018");
		
		ResetPasswordValidator resetPasswordValidator = dbBasedLoginService.registerUserAccount(customer, registrationValidator);
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testRegisterUserAccountNullPhoneNumber() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		Customer customer = new Customer();
		customer.setFirstName("viraj");
		customer.setLastName("patel");
		customer.setAddress("Germany");
		customer.setDOB(Calendar.getInstance());
		customer.setEmailID("something@mailinator.com");
		customer.setGender("Male");
		customer.setIdentityProofBytes(new byte[] {23,35,5,53,34,12,2});
		customer.setPhotoBytes(new byte[] {23,12,45,23,7,3,7,23,78,23,5});
		customer.setPhoneNumber(null);
		CustomerAccount customerAccount = new CustomerAccount();
		customerAccount.setUserName("viraj-p");
		customerAccount.setUserRole("Customer");
		
		customer.setEntityAccount(customerAccount);
		
		CustomerRegistrationCredential registrationValidator = new CustomerRegistrationCredential();
		registrationValidator.setUserName("viraj-p");
		registrationValidator.setNewPassword("Srh@2018");
		registrationValidator.setConfirmPassword("Srh@2018");
		
		ResetPasswordValidator resetPasswordValidator = dbBasedLoginService.registerUserAccount(customer, registrationValidator);
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testRegisterUserAccountInvalidPhoneNumber() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		Customer customer = new Customer();
		customer.setFirstName("viraj");
		customer.setLastName("patel");
		customer.setAddress("Germany");
		customer.setDOB(Calendar.getInstance());
		customer.setEmailID("something@mailinator.com");
		customer.setGender("Male");
		customer.setIdentityProofBytes(new byte[] {23,35,5,53,34,12,2});
		customer.setPhotoBytes(new byte[] {23,12,45,23,7,3,7,23,78,23,5});
		customer.setPhoneNumber("56262");
		CustomerAccount customerAccount = new CustomerAccount();
		customerAccount.setUserName("viraj-p");
		customerAccount.setUserRole("Customer");
		
		customer.setEntityAccount(customerAccount);
		
		CustomerRegistrationCredential registrationValidator = new CustomerRegistrationCredential();
		registrationValidator.setUserName("viraj-p");
		registrationValidator.setNewPassword("Srh@2018");
		registrationValidator.setConfirmPassword("Srh@2018");
		
		ResetPasswordValidator resetPasswordValidator = dbBasedLoginService.registerUserAccount(customer, registrationValidator);
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testRegisterUserAccountNullUserName() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		Customer customer = new Customer();
		customer.setFirstName("viraj");
		customer.setLastName("patel");
		customer.setAddress("Germany");
		customer.setDOB(Calendar.getInstance());
		customer.setEmailID("something@mailinator.com");
		customer.setGender("Male");
		customer.setIdentityProofBytes(new byte[] {23,35,5,53,34,12,2});
		customer.setPhotoBytes(new byte[] {23,12,45,23,7,3,7,23,78,23,5});
		customer.setPhoneNumber("56262949562626");
		CustomerAccount customerAccount = new CustomerAccount();
		customerAccount.setUserName(null);
		customerAccount.setUserRole("Customer");
		
		customer.setEntityAccount(customerAccount);
		
		CustomerRegistrationCredential registrationValidator = new CustomerRegistrationCredential();
		registrationValidator.setUserName(null);
		registrationValidator.setNewPassword("Srh@2018");
		registrationValidator.setConfirmPassword("Srh@2018");
		
		ResetPasswordValidator resetPasswordValidator = dbBasedLoginService.registerUserAccount(customer, registrationValidator);
	}
	
	
	@Test(expected = BikeHireSystemException.class)
	public void testRegisterUserAccountInvalidRole() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		Customer customer = new Customer();
		customer.setFirstName("viraj");
		customer.setLastName("patel");
		customer.setAddress("Germany");
		customer.setDOB(Calendar.getInstance());
		customer.setEmailID("something@mailinator.com");
		customer.setGender("Male");
		customer.setIdentityProofBytes(new byte[] {23,35,5,53,34,12,2});
		customer.setPhotoBytes(new byte[] {23,12,45,23,7,3,7,23,78,23,5});
		customer.setPhoneNumber("56262949562626");
		CustomerAccount customerAccount = new CustomerAccount();
		customerAccount.setUserName("viraj-p");
		customerAccount.setUserRole(null);
		
		customer.setEntityAccount(customerAccount);
		
		CustomerRegistrationCredential registrationValidator = new CustomerRegistrationCredential();
		registrationValidator.setUserName("viraj-p");
		registrationValidator.setNewPassword("Srh@2018");
		registrationValidator.setConfirmPassword("Srh@2018");
		
		ResetPasswordValidator resetPasswordValidator = dbBasedLoginService.registerUserAccount(customer, registrationValidator);
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testRegisterUserAccountNullAccountInfo() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		Customer customer = new Customer();
		customer.setFirstName("viraj");
		customer.setLastName("patel");
		customer.setAddress("Germany");
		customer.setDOB(Calendar.getInstance());
		customer.setEmailID("something@mailinator.com");
		customer.setGender("Male");
		customer.setIdentityProofBytes(new byte[] {23,35,5,53,34,12,2});
		customer.setPhotoBytes(new byte[] {23,12,45,23,7,3,7,23,78,23,5});
		customer.setPhoneNumber("56262949562626");
		CustomerAccount customerAccount = new CustomerAccount();
		customerAccount.setUserName("viraj-p");
		customerAccount.setUserRole("Customer");
		
		customer.setEntityAccount(null);
		
		CustomerRegistrationCredential registrationValidator = new CustomerRegistrationCredential();
		registrationValidator.setUserName("viraj-p");
		registrationValidator.setNewPassword("Srh@2018");
		registrationValidator.setConfirmPassword("Srh@2018");
		
		ResetPasswordValidator resetPasswordValidator = dbBasedLoginService.registerUserAccount(customer, registrationValidator);
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testRegisterUserAccountNullNewPassword() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		Customer customer = new Customer();
		customer.setFirstName("viraj");
		customer.setLastName("patel");
		customer.setAddress("Germany");
		customer.setDOB(Calendar.getInstance());
		customer.setEmailID("something@mailinator.com");
		customer.setGender("Male");
		customer.setIdentityProofBytes(new byte[] {23,35,5,53,34,12,2});
		customer.setPhotoBytes(new byte[] {23,12,45,23,7,3,7,23,78,23,5});
		customer.setPhoneNumber("56262949562626");
		CustomerAccount customerAccount = new CustomerAccount();
		customerAccount.setUserName("viraj-p");
		customerAccount.setUserRole("Customer");
		
		customer.setEntityAccount(customerAccount);
		
		CustomerRegistrationCredential registrationValidator = new CustomerRegistrationCredential();
		registrationValidator.setUserName("viraj-p");
		registrationValidator.setNewPassword(null);
		registrationValidator.setConfirmPassword("Srh@2018");
		
		ResetPasswordValidator resetPasswordValidator = dbBasedLoginService.registerUserAccount(customer, registrationValidator);
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testRegisterUserAccountNullConfirmPwd() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		Customer customer = new Customer();
		customer.setFirstName("viraj");
		customer.setLastName("patel");
		customer.setAddress("Germany");
		customer.setDOB(Calendar.getInstance());
		customer.setEmailID("something@mailinator.com");
		customer.setGender("Male");
		customer.setIdentityProofBytes(new byte[] {23,35,5,53,34,12,2});
		customer.setPhotoBytes(new byte[] {23,12,45,23,7,3,7,23,78,23,5});
		customer.setPhoneNumber("56262949562626");
		CustomerAccount customerAccount = new CustomerAccount();
		customerAccount.setUserName("viraj-p");
		customerAccount.setUserRole("Customer");
		
		customer.setEntityAccount(customerAccount);
		
		CustomerRegistrationCredential registrationValidator = new CustomerRegistrationCredential();
		registrationValidator.setUserName("viraj-p");
		registrationValidator.setNewPassword("Srh@2018");
		registrationValidator.setConfirmPassword(null);
		
		ResetPasswordValidator resetPasswordValidator = dbBasedLoginService.registerUserAccount(customer, registrationValidator);
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testRegisterUserAccountInvalidPassword() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		Customer customer = new Customer();
		customer.setFirstName("viraj");
		customer.setLastName("patel");
		customer.setAddress("Germany");
		customer.setDOB(Calendar.getInstance());
		customer.setEmailID("something@mailinator.com");
		customer.setGender("Male");
		customer.setIdentityProofBytes(new byte[] {23,35,5,53,34,12,2});
		customer.setPhotoBytes(new byte[] {23,12,45,23,7,3,7,23,78,23,5});
		customer.setPhoneNumber("56262949562626");
		CustomerAccount customerAccount = new CustomerAccount();
		customerAccount.setUserName("viraj-p");
		customerAccount.setUserRole("Customer");
		
		customer.setEntityAccount(customerAccount);
		
		CustomerRegistrationCredential registrationValidator = new CustomerRegistrationCredential();
		registrationValidator.setUserName("viraj-p");
		registrationValidator.setNewPassword("Sr2018");
		registrationValidator.setConfirmPassword("Sr2018");
		
		ResetPasswordValidator resetPasswordValidator = dbBasedLoginService.registerUserAccount(customer, registrationValidator);
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testRegisterUserAccountPasswordMismatch() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		Customer customer = new Customer();
		customer.setFirstName("viraj");
		customer.setLastName("patel");
		customer.setAddress("Germany");
		customer.setDOB(Calendar.getInstance());
		customer.setEmailID("something@mailinator.com");
		customer.setGender("Male");
		customer.setIdentityProofBytes(new byte[] {23,35,5,53,34,12,2});
		customer.setPhotoBytes(new byte[] {23,12,45,23,7,3,7,23,78,23,5});
		customer.setPhoneNumber("56262949562626");
		CustomerAccount customerAccount = new CustomerAccount();
		customerAccount.setUserName("viraj-p");
		customerAccount.setUserRole("Customer");
		
		customer.setEntityAccount(customerAccount);
		
		CustomerRegistrationCredential registrationValidator = new CustomerRegistrationCredential();
		registrationValidator.setUserName("viraj-p");
		registrationValidator.setNewPassword("Srh@2009");
		registrationValidator.setConfirmPassword("Srh@2018");
		
		ResetPasswordValidator resetPasswordValidator = dbBasedLoginService.registerUserAccount(customer, registrationValidator);
	}
	
	@Test
	public void testRegisterUserAccountSuccess() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		Customer customer = new Customer();
		customer.setFirstName("viraj");
		customer.setLastName("patel");
		customer.setAddress("Germany");
		customer.setDOB(Calendar.getInstance());
		customer.setEmailID("something@mailinator.com");
		customer.setGender("Male");
		customer.setIdentityProofBytes(new byte[] {23,35,5,53,34,12,2});
		customer.setPhotoBytes(new byte[] {23,12,45,23,7,3,7,23,78,23,5});
		customer.setPhoneNumber("56262949562626");
		CustomerAccount customerAccount = new CustomerAccount();
		customerAccount.setUserName("viraj-p");
		customerAccount.setUserRole("Customer");
		
		customer.setEntityAccount(customerAccount);
		
		CustomerRegistrationCredential registrationValidator = new CustomerRegistrationCredential();
		registrationValidator.setUserName("viraj-p");
		registrationValidator.setNewPassword("Srh@2018");
		registrationValidator.setConfirmPassword("Srh@2018");
		
		ResetPasswordValidator resetPasswordValidator = dbBasedLoginService.registerUserAccount(customer, registrationValidator);
		assertNotNull(resetPasswordValidator);
		userId = resetPasswordValidator.getUserId();
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testMarkUserAccountAsActiveInvalidId() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		dbBasedLoginService.markUserAccountAsActive(-1);
	}
	
	@Test
	public void testMarkUserAccountAsActiveSuccess() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		dbBasedLoginService.markUserAccountAsActive(userId);
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testAuthenticateNullUserName() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		LoginCredential loginCredential = new LoginCredential();
		loginCredential.setUserName(null);
		loginCredential.setPassword("Srh@2018");
		
		Entity loggedInEntity = dbBasedLoginService.authenticate(loginCredential);
		assertNotNull(loggedInEntity);
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testAuthenticateNullPassword() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		LoginCredential loginCredential = new LoginCredential();
		loginCredential.setUserName("viraj-p");
		loginCredential.setPassword(null);
		
		Entity loggedInEntity = dbBasedLoginService.authenticate(loginCredential);
		assertNotNull(loggedInEntity);
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testAuthenticateInvalidPassword() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		LoginCredential loginCredential = new LoginCredential();
		loginCredential.setUserName("viraj-p");
		loginCredential.setPassword("Srh@20");
		
		Entity loggedInEntity = dbBasedLoginService.authenticate(loginCredential);
		assertNotNull(loggedInEntity);
	}
	
	@Test
	public void testAuthenticateSuccess() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		LoginCredential loginCredential = new LoginCredential();
		loginCredential.setUserName("viraj-p");
		loginCredential.setPassword("Srh@2018");
		
		Entity loggedInEntity = dbBasedLoginService.authenticate(loginCredential);
		assertNotNull(loggedInEntity);
	}

	@Test(expected = BikeHireSystemException.class)
	public void testSendSecurityTokenForResetPasswordNullEmail() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		ResetPasswordValidator passwordValidator = dbBasedLoginService.sendSecurityTokenForResetPassword(null);
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testSendSecurityTokenForResetPasswordInvalidEmail() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		ResetPasswordValidator passwordValidator = dbBasedLoginService.sendSecurityTokenForResetPassword("somethinginator.com");
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testSendSecurityTokenForResetPasswordDoesntExistEmail() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		ResetPasswordValidator passwordValidator = dbBasedLoginService.sendSecurityTokenForResetPassword("something1231@mailinator.com");
	}
	
	@Test
	public void testSendSecurityTokenForResetPasswordSuccess() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		ResetPasswordValidator passwordValidator = dbBasedLoginService.sendSecurityTokenForResetPassword("something@mailinator.com");
	}

	@Test(expected = BikeHireSystemException.class)
	public void testResetPasswordNullUserName() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		CustomerRegistrationCredential registrationValidator = new CustomerRegistrationCredential();
		registrationValidator.setUserName(null);
		registrationValidator.setNewPassword("Srh@2018");
		registrationValidator.setConfirmPassword("Srh@2018");
		dbBasedLoginService.resetPassword(registrationValidator);
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testResetPasswordUsernameDoesntExist() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		CustomerRegistrationCredential registrationValidator = new CustomerRegistrationCredential();
		registrationValidator.setUserName("viraj-p123");
		registrationValidator.setNewPassword("Srh@2018");
		registrationValidator.setConfirmPassword("Srh@2018");
		dbBasedLoginService.resetPassword(registrationValidator);
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testResetPasswordNullNewPassword() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		CustomerRegistrationCredential registrationValidator = new CustomerRegistrationCredential();
		registrationValidator.setUserName("viraj-p");
		registrationValidator.setNewPassword(null);
		registrationValidator.setConfirmPassword("Srh@2018");
		dbBasedLoginService.resetPassword(registrationValidator);
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testResetPasswordNullConfirmPwd() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		CustomerRegistrationCredential registrationValidator = new CustomerRegistrationCredential();
		registrationValidator.setUserName("viraj-p");
		registrationValidator.setNewPassword("Srh@2018");
		registrationValidator.setConfirmPassword(null);
		dbBasedLoginService.resetPassword(registrationValidator);
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testResetPasswordInvalidPwd() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		CustomerRegistrationCredential registrationValidator = new CustomerRegistrationCredential();
		registrationValidator.setUserName("viraj-p");
		registrationValidator.setNewPassword("Srh018");
		registrationValidator.setConfirmPassword("Srh018");
		dbBasedLoginService.resetPassword(registrationValidator);
	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testResetPasswordPwdMismatch() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		CustomerRegistrationCredential registrationValidator = new CustomerRegistrationCredential();
		registrationValidator.setUserName("viraj-p");
		registrationValidator.setNewPassword("Srh@2099");
		registrationValidator.setConfirmPassword("Srh@2018");
		dbBasedLoginService.resetPassword(registrationValidator);
	}
	
	@Test
	public void testResetPasswordSuccess() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		CustomerRegistrationCredential registrationValidator = new CustomerRegistrationCredential();
		registrationValidator.setUserName("viraj-p");
		registrationValidator.setNewPassword("Srh@2018");
		registrationValidator.setConfirmPassword("Srh@2018");
		dbBasedLoginService.resetPassword(registrationValidator);
	}

	@Test
	public void testGetAccountInfoInvalidId() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		EntityAccount accountInfo = dbBasedLoginService.getAccountInfo(-1);
		assertNull(accountInfo);
	}

	@Test
	public void testGetAccountInfoSuccess() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		EntityAccount accountInfo = dbBasedLoginService.getAccountInfo(userId);
		assertNotNull(accountInfo);
	}

	@Test(expected = BikeHireSystemException.class)
	public void testDeactivateAccountInvalidUserId() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		Customer customer = new Customer();
		customer.setUserId(-1);
		dbBasedLoginService.deactivateAccount(customer);
	}
	
	@Test
	public void testDeactivateAccount() throws BikeHireSystemException {
		DBBasedLoginService dbBasedLoginService = new DBBasedLoginService();
		Customer customer = new Customer();
		customer.setUserId(userId);
		dbBasedLoginService.deactivateAccount(customer);
	}
}
