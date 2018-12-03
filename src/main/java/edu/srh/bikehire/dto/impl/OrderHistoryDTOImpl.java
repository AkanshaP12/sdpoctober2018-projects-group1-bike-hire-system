package edu.srh.bikehire.dto.impl;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import edu.srh.bikehire.dto.BikeDTO;
import edu.srh.bikehire.dto.InvoiceDTO;
import edu.srh.bikehire.dto.OrderHistoryDTO;
import edu.srh.bikehire.dto.UserDTO;

@Entity
@Table(name = "OrderHistory")
public class OrderHistoryDTOImpl implements OrderHistoryDTO {

	@Id
	@Column(name = "OrderID")
	private String orderID;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "InvoiceID")
	private InvoiceDTOImpl invoiceDTO;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "UserID")
	private UserDTOImpl userDTO;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "BikeID")
	private BikeDTOImpl bikeDTO;
	
	@Column(name = "BookingTimeStamp")
	private Calendar bookingTimeStamp;
	
	@Column(name = "PickupTimeStamp")
	private Calendar pickupTimeStamp;
	
	@Column(name = "ReturnedTimeStamp")
	private Calendar returnedTimeStamp;
	
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getInvoiceID() {
		return invoiceDTO.getInvoiceID();
	}
	
	public String getUserID() {
		return userDTO.getId();
	}
	
	public String getBikeID() {
		return bikeDTO.getBikeId();
	}
	
	public BikeDTOImpl getBikeDTO(){
		return bikeDTO;
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
	public Calendar getReturnedTimeStamp() {
		return returnedTimeStamp;
	}
	public void setReturnedTimeStamp(Calendar returnedTimeStamp) {
		this.returnedTimeStamp = returnedTimeStamp;
	}
	public InvoiceDTOImpl getInvoiceDTO() {
		return invoiceDTO;
	}
	public void setInvoiceDTO(InvoiceDTOImpl invoiceDTO) {
		this.invoiceDTO = invoiceDTO;
	}
	public UserDTOImpl getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(UserDTOImpl userDTO) {
		this.userDTO = userDTO;
	}
	public void setBikeDTO(BikeDTOImpl bikeID) {
		this.bikeDTO = bikeID;
	}
	public void setInvoiceDTO(InvoiceDTO pInvoiceDTO) {
		this.invoiceDTO = (InvoiceDTOImpl) pInvoiceDTO;
	}
	public void setUserDTO(UserDTO pUserDTO) {
		this.userDTO = (UserDTOImpl) pUserDTO;
	}
	public void setBikeDTO(BikeDTO pBikeDTO) {
		this.bikeDTO = (BikeDTOImpl) pBikeDTO;
	}
}
