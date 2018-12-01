package edu.srh.bikehire.dto;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CredentialsDTOImpl {
	
	/*
	 
	 CREATE TABLE `Credentials` (
	`UserID` varchar(100) NOT NULL,
	`UserName` varchar(200) NOT NULL,
	`PasswordSalt` varchar(200) NOT NULL,
	`PasswordHash` varchar(256) NOT NULL,
	`LastModifiedTimeStamp` TIMESTAMP NOT NULL
	);
	 */

	@Column(name = "UserID")
	private String userID;
	@Column(name = "UserName")
	private String userName;
	@Column(name = "PasswordSalt")
	private String passwordSalt;
	@Column(name = "PasswordHash")
	private String passwordHash;
	@Column(name = "LastModifiedTimeStamp")
	private Calendar lastModifiedTimeStamp;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasswordSalt() {
		return passwordSalt;
	}
	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	public Calendar getLastModifiedTimeStamp() {
		return lastModifiedTimeStamp;
	}
	public void setLastModifiedTimeStamp(Calendar lastModifiedTimeStamp) {
		this.lastModifiedTimeStamp = lastModifiedTimeStamp;
	}
	
	
	
	
	
	
}
