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

import edu.srh.bikehire.dto.CurrentOrderDTO;
import edu.srh.bikehire.dto.InvoiceDTO;
import edu.srh.bikehire.dto.WareHouseDTO;

@Entity
@Table(name= "Invoice")
public class InvoiceDTOImpl implements InvoiceDTO{

	@Id
	@Column(name = "InvoiceID")
	private String invoiceID;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "OrderID")
	private CurrentOrderDTOImpl currentOrderDTOImpl;
	
	@Column(name = "CreationTimeStamp")
	private Calendar creationTimeStamp;
	
	@Column(name = "FinalAmount")
	private int finalAmount;
	
	@Column(name = "ReturnDeposit")
	private int returnDeposit;
	
	@Column(name = "DamageCharges")
	private int	damageCharges;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "WarehouseId")
	private WareHouseDTOImpl warehouseDTO;
	
	public String getInvoiceID() {
		return invoiceID;
	}
	
	public void setInvoiceID(String invoiceID) {
		this.invoiceID = invoiceID;
	}
	
	public String getOrderID() {
		return currentOrderDTOImpl.getOrderID();
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
		return warehouseDTO.getWarehouseId();
	}
	
	public CurrentOrderDTOImpl getCurrentOrderDTOImpl() {
		return currentOrderDTOImpl;
	}
	
	public void setCurrentOrderDTOImpl(CurrentOrderDTOImpl currentOrderDTOImpl) {
		this.currentOrderDTOImpl = currentOrderDTOImpl;
	}

	public WareHouseDTOImpl getWarehouseDTO() {
		return warehouseDTO;
	}

	public void setWarehouseDTO(WareHouseDTOImpl warehouseDTO) {
		this.warehouseDTO = warehouseDTO;
	}
	
	public void setCurrentOrderDTO(CurrentOrderDTO pCurrentOrderDTO)
	{
		this.currentOrderDTOImpl = (CurrentOrderDTOImpl) pCurrentOrderDTO;
	}
	
	public void setWarehouseDTO(WareHouseDTO pWareHouseDTO)
	{
		this.warehouseDTO = (WareHouseDTOImpl) pWareHouseDTO;
	}
	
}
