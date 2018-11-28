package edu.srh.bikehire.dto;

import java.math.BigInteger;
import java.sql.Timestamp;

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

	private BigInteger invoiceID;
	private BigInteger orderID;
	private Timestamp creationTimeStamp;
	private int finalAmount;
	private int returnDeposit;
	private int	damageCharges;
	private BigInteger warehouseID;
	
	public BigInteger getInvoiceID() {
		return invoiceID;
	}
	public void setInvoiceID(BigInteger invoiceID) {
		this.invoiceID = invoiceID;
	}
	public BigInteger getOrderID() {
		return orderID;
	}
	public void setOrderID(BigInteger orderID) {
		this.orderID = orderID;
	}
	public Timestamp getCreationTimeStamp() {
		return creationTimeStamp;
	}
	public void setCreationTimeStamp(Timestamp creationTimeStamp) {
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
	public BigInteger getWarehouseID() {
		return warehouseID;
	}
	public void setWarehouseID(BigInteger warehouseID) {
		this.warehouseID = warehouseID;
	}
	
	
}
