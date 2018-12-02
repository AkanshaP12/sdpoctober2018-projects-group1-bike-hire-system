package edu.srh.bikehire.dto;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import edu.srh.bikehire.dtointerface.BikeTypeDTO;

@Entity
@Table(name="BikeType")
public class BikeTypeDTOImpl implements BikeTypeDTO {
	
	@Id
	@Column(name="BikeTypeId")
	private String bikeTypeId;
	
	@Column(name="Type")
	private String bikeType;
	
	@Column(name="AgeCategory")
	private String ageCategory;
	
	@Column(name="CreationTimeStamp")
	private Calendar creationTimeStamp;

	public String getBikeTypeId() {
		return bikeTypeId;
	}

	public void setBikeTypeId(String bikeTypeId) {
		this.bikeTypeId = bikeTypeId;
	}

	public String getBikeType() {
		return bikeType;
	}

	public void setBikeType(String bikeType) {
		this.bikeType = bikeType;
	}

	public String getAgeCategory() {
		return ageCategory;
	}

	public void setAgeCategory(String ageCategory) {
		this.ageCategory = ageCategory;
	}

	public Calendar getCreationTimeStamp() {
		return creationTimeStamp;
	}

	public void setCreationTimeStamp(Calendar creationTimeStamp) {
		this.creationTimeStamp = creationTimeStamp;
	}
	
}
