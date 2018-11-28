package edu.srh.bikehire.dto;

import java.sql.Timestamp;

public class Credentials {
	
	/*
	 
	 CREATE TABLE `Credentials` (
	`UserID` varchar(100) NOT NULL,
	`UserName` varchar(200) NOT NULL,
	`PasswordSalt` varchar(200) NOT NULL,
	`PasswordHash` varchar(256) NOT NULL,
	`LastModifiedTimeStamp` TIMESTAMP NOT NULL
	);
	 */

	private String userID;
	private String userName;
	private String passwordSalt;
	private String passwordHash;
	private Timestamp lastModifiedTimeStamp;
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
	public Timestamp getLastModifiedTimeStamp() {
		return lastModifiedTimeStamp;
	}
	public void setLastModifiedTimeStamp(Timestamp lastModifiedTimeStamp) {
		this.lastModifiedTimeStamp = lastModifiedTimeStamp;
	}
	
	
}
