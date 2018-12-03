package edu.srh.bikehire.dto;


public interface OrderPaymentDTO {

	public String getPaymentReference();
	public String getOrderID();
	public int getDepositAmount();
	public int getRentPerHour();
	public int getRentPerDay();
	public void setCurrentOrderDTO(CurrentOrderDTO pCurrentOrderDTO);
}
