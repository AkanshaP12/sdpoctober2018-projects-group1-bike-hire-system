package edu.srh.bikehire.dto;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import edu.srh.bikehire.dtointerface.UserCredentialDTO;

@Entity
@Table(name="Credentials")
public class UserCredentialDTOImpl implements UserCredentialDTO {

	@Id
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "UserID")
	private UserDTOImpl userDTO;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "UserName")
	private UserAccountDTOImpl userAccount;
	
	@Column(name = "PasswordSalt")
	private String passwordSalt;
	
	@Column(name = "PasswordHash")
	private String passwordHash;
	
	@Column(name = "LastModifiedTimeStamp")
	private Calendar lastModifiedTimeStamp;
	
	public String getUserID() {
		return userDTO.getId();
	}
	
	public String getUserName() {
		return userAccount.getUserName();
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

	protected UserDTOImpl getUserDTO() {
		return userDTO;
	}

	protected void setUserDTO(UserDTOImpl userDTO) {
		this.userDTO = userDTO;
	}

	protected UserAccountDTOImpl getUserAccount() {
		return userAccount;
	}

	protected void setUserAccount(UserAccountDTOImpl userAccount) {
		this.userAccount = userAccount;
	}
	
}
