package edu.srh.bikehire.dto;

import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import edu.srh.bikehire.dtointerface.UserDTO;

@Entity
@Table(name="User")
public class UserDTOImpl implements UserDTO{

	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "FirstName")
	private String firstName;
	
	@Column(name = "LastName")
	private String lastName;
	
	@Column(name = "Gender")
	private String gender;
	
	@Column(name = "DOB")
	private Calendar dOB;
	
	@Column(name = "Address")
	private String address;
	
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name = "Photo")
	private byte[] photo;
	
	@Column(name = "EmailId")
	private String emailId;
	
	@Column(name = "PhoneNo")
	private String phoneNo;
	
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name = "IdentityProof")
	private byte[] identityProof;
	
	public String getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getGender() {
		return gender;
	}
	
	public String getAddress() {
		return address;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public String getEmailId() {
		return emailId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public byte[] getIdentityProof() {
		return identityProof;
	}
	protected void setId(String id) {
		this.id = id;
	}
	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	protected void setLastName(String lastName) {
		this.lastName = lastName;
	}
	protected void setGender(String gender) {
		this.gender = gender;
	}
	
	protected void setAddress(String address) {
		this.address = address;
	}
	protected void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	protected void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	protected void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	protected void setIdentityProof(byte[] identityProof) {
		this.identityProof = identityProof;
	}
	
	public Calendar getDOB() {
		return dOB;
	}
	protected void setDOB(Calendar dOB) {
		this.dOB = dOB;
	}
}
