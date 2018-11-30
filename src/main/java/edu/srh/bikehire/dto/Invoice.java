package edu.srh.bikehire.dto;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "InvoiceID")
	private String invoiceID;
	@Column(name = "OrderID")
	private String orderID;
	@Column(name = "CreationTimeStamp")
	private Calendar creationTimeStamp;
	@Column(name = "FinalAmount")
	private int finalAmount;
	@Column(name = "ReturnDeposit")
	private int returnDeposit;
	@Column(name = "DamageCharges")
	private int	damageCharges;
	@Column(name = "WarehouseID")
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
