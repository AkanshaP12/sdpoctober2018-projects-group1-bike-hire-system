package edu.srh.bikehire.dto;

import java.sql.Blob;

public class User {

	/*
	 CREATE TABLE `User` (
	`ID` varchar(100) NOT NULL,
	`FirstName` varchar(100) NOT NULL,
	`LastName` varchar(100) NOT NULL,
	`Gender` varchar(50) NOT NULL,
	`Age` int(3) NOT NULL,
	`Address` varchar(200),
	`Photo` blob,
	`EmailId` varchar(200) NOT NULL UNIQUE,
	`PhoneNo` varchar(20) NOT NULL,
	`IdentityProof` blob NOT NULL,
	PRIMARY KEY (`ID`)
	);
	 */
	
	private String iD;
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private String address;
	private Blob photo;
	private String emailId;
	private String phoneNo;
	private Blob identityProof;
	public String getiD() {
		return iD;
	}
	public void setiD(String iD) {
		this.iD = iD;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Blob getPhoto() {
		return photo;
	}
	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Blob getIdentityProof() {
		return identityProof;
	}
	public void setIdentityProof(Blob identityProof) {
		this.identityProof = identityProof;
	}
	
	
}
