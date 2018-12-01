package edu.srh.bikehire.dto;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UserDTOImpl {

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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private String iD;
	@Column(name = "FirstName")
	private String firstName;
	@Column(name = "LastName")
	private String lastName;
	@Column(name = "Gender")
	private String gender;
	@Column(name = "Age")
	private int age;
	@Column(name = "Address")
	private String address;
	@Column(name = "Photo")
	private File photo;
	@Column(name = "EmailId")
	private String emailId;
	@Column(name = "PhoneNo")
	private String phoneNo;
	@Column(name = "IdentityProof")
	private File identityProof;
	
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
	public File getPhoto() {
		return photo;
	}
	public void setPhoto(File photo) {
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
	public File getIdentityProof() {
		return identityProof;
	}
	public void setIdentityProof(File identityProof) {
		this.identityProof = identityProof;
	}

}
