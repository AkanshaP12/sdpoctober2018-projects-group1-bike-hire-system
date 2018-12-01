package edu.srh.bikehire.dto;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import edu.srh.bikehire.dtointerface.BikeRentMappingDTO;

@Entity
@Table(name="BikeRentMapping")
public class BikeRentMappingDTOImpl implements BikeRentMappingDTO {
	
	@Id
	@OneToOne
	@JoinColumn(name = "BikeTypeId")
	private BikeTypeDTOImpl bikeType;
	
	@Column(name = "RentPerHour")
	private int rentPerHour;
	
	@Column(name = "RentPerDay")
	private int rentPerDay;

	@Column(name = "LastModifiedTimeStamp")
	private Calendar lastModifiedTimeStamp;

	public BikeTypeDTOImpl getBikeType() {
		return bikeType;
	}
	public void setBikeType(BikeTypeDTOImpl bikeType) {
		this.bikeType = bikeType;
	}
	public int getRentPerHour() {
		return rentPerHour;
	}
	public void setRentPerHour(int rentPerHour) {
		this.rentPerHour = rentPerHour;
	}
	public int getRentPerDay() {
		return rentPerDay;
	}
	public void setRentPerDay(int rentPerDay) {
		this.rentPerDay = rentPerDay;
	}
	public Calendar getLastModifiedTimeStamp() {
		return lastModifiedTimeStamp;
	}
	public void setLastModifiedTimeStamp(Calendar lastModifiedTimeStamp) {
		this.lastModifiedTimeStamp = lastModifiedTimeStamp;
	}
	public String getBikeTypeId() {
		return getBikeType().getBikeTypeId();
	}
	
		
}
