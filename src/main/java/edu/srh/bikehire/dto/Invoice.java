package edu.srh.bikehire.dto;

import java.util.Calendar;

public class Invoice {
	
	/*
	 CREATE TABLE `Invoice` (
	`InvoiceID` bigint NOT NULL,
	`OrderID` bigint NOT NULL,
	`CreationTimeStamp` TIMESTAMP NOT NULL,
	`FinalAmount` int(10) NOT NULL,
	`ReturnDeposit` int(10) NOT NULL,
	`DamageCharges` int(10) NOT NULL,
	`WarehouseId` bigint NOT NULL,    <---- make ID
	PRIMARY KEY (`InvoiceID`)
	);
	 */

	private String invoiceID;
	private String orderID;
	private Calendar creationTimeStamp;
	private int finalAmount;
	private int returnDeposit;
	private int	damageCharges;
	private String warehouseID;
	public String getInvoiceID() {
		return invoiceID;
	}
	public void setInvoiceID(String invoiceID) {
		this.invoiceID = invoiceID;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public Calendar getCreationTimeStamp() {
		return creationTimeStamp;
	}
	public void setCreationTimeStamp(Calendar creationTimeStamp) {
		this.creationTimeStamp = creationTimeStamp;
	}
	public int getFinalAmount() {
		return finalAmount;
	}
	public void setFinalAmount(int finalAmount) {
		this.finalAmount = finalAmount;
	}
	public int getReturnDeposit() {
		return returnDeposit;
	}
	public void setReturnDeposit(int returnDeposit) {
		this.returnDeposit = returnDeposit;
	}
	public int getDamageCharges() {
		return damageCharges;
	}
	public void setDamageCharges(int damageCharges) {
		this.damageCharges = damageCharges;
	}
	public String getWarehouseID() {
		return warehouseID;
	}
	public void setWarehouseID(String warehouseID) {
		this.warehouseID = warehouseID;
	}
		
	
	
}
