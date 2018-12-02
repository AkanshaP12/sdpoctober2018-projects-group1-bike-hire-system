package edu.srh.bikehire.dto;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import edu.srh.bikehire.dtointerface.CurrentOrderDTO;

@Entity
@Table(name= "CurrentOrder")
public class CurrentOrderDTOImpl implements CurrentOrderDTO {

	@Id
	@Column(name = "OrderID")
	private String orderID;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "UserID")
	private UserDTOImpl userDTO;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "BikeID")
	private BikeDTOImpl bikeDTO;
	
	@Column(name = "BookingTimeStamp")
	private Calendar bookingTimeStamp;
	
	@Column(name = "PickupTimeStamp")
	private Calendar pickupTimeStamp;
	
	@Column(name = "DropOffTimeStamp")
	private Calendar dropOffTimeStamp;
	
	@Column(name = "ActualDropOffTimeStamp")
	private Calendar actualDropOffTimeStamp;
	
	@Column(name = "OrderMode")
	private String orderMode;
	
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getUserID() {
		return userDTO.getId();
	}
	public String getBikeID() {
		return bikeDTO.getBikeId();
	}
	public Calendar getBookingTimeStamp() {
		return bookingTimeStamp;
	}
	public void setBookingTimeStamp(Calendar bookingTimeStamp) {
		this.bookingTimeStamp = bookingTimeStamp;
	}
	public Calendar getPickupTimeStamp() {
		return pickupTimeStamp;
	}
	public void setPickupTimeStamp(Calendar pickupTimeStamp) {
		this.pickupTimeStamp = pickupTimeStamp;
	}
	public Calendar getDropOffTimeStamp() {
		return dropOffTimeStamp;
	}
	public void setDropOffTimeStamp(Calendar dropOffTimeStamp) {
		this.dropOffTimeStamp = dropOffTimeStamp;
	}
	public Calendar getActualDropOffTimeStamp() {
		return actualDropOffTimeStamp;
	}
	public void setActualDropOffTimeStamp(Calendar actualDropOffTimeStamp) {
		this.actualDropOffTimeStamp = actualDropOffTimeStamp;
	}
	public String getOrderMode() {
		return orderMode;
	}
	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
	}
	protected UserDTOImpl getUserDTO() {
		return userDTO;
	}
	protected void setUserDTO(UserDTOImpl userDTO) {
		this.userDTO = userDTO;
	}
	protected BikeDTOImpl getBikeDTO() {
		return bikeDTO;
	}
	protected void setBikeDTO(BikeDTOImpl bikeDTO) {
		this.bikeDTO = bikeDTO;
	}
}