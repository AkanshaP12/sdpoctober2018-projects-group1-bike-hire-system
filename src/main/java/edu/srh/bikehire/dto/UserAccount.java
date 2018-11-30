package edu.srh.bikehire.dto;

import java.util.Calendar;

import javax.persistence.Column;

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

	@Column(name = "ID")
	private String iD;
	@Column(name = "UserName")
	private String userName;
	@Column(name = "Role")
	private String role;
	@Column(name = "AccountStatus")
	private String accountStatus;
	@Column(name = "CreationTimeStamp")
	private Calendar creationTimeStamp;
	@Column(name = "LastModifiedTimeStamp")
	private Calendar lastModifiedTimeStamp;
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
	public Calendar getCreationTimeStamp() {
		return creationTimeStamp;
	}
	public void setCreationTimeStamp(Calendar creationTimeStamp) {
		this.creationTimeStamp = creationTimeStamp;
	}
	public Calendar getLastModifiedTimeStamp() {
		return lastModifiedTimeStamp;
	}
	public void setLastModifiedTimeStamp(Calendar lastModifiedTimeStamp) {
		this.lastModifiedTimeStamp = lastModifiedTimeStamp;
	}
	
	
	
}
