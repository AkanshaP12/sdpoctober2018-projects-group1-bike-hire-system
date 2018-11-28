package edu.srh.bikehire.dto;

import java.sql.Timestamp;

public class UserAccount {
	
	/*
	 CREATE TABLE `UserAccount` (
	`ID` varchar(100) NOT NULL,
	`UserName` varchar(200) NOT NULL,
	`Role` varchar(50) NOT NULL,
	`AccountStatus` varchar(20) NOT NULL,
	`CreationTimeStamp` TIMESTAMP NOT NULL,
	`LastModifiedTimeStamp` TIMESTAMP NOT NULL
	);
	 */

	private String iD;
	private String userName;
	private String role;
	private String accountStatus;
	private Timestamp creationTimeStamp;
	private Timestamp lastModifiedTimeStamp;
	public String getiD() {
		return iD;
	}
	public void setiD(String iD) {
		this.iD = iD;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public Timestamp getCreationTimeStamp() {
		return creationTimeStamp;
	}
	public void setCreationTimeStamp(Timestamp creationTimeStamp) {
		this.creationTimeStamp = creationTimeStamp;
	}
	public Timestamp getLastModifiedTimeStamp() {
		return lastModifiedTimeStamp;
	}
	public void setLastModifiedTimeStamp(Timestamp lastModifiedTimeStamp) {
		this.lastModifiedTimeStamp = lastModifiedTimeStamp;
	}
	
	
}
