package edu.srh.bikehire.dao;

import edu.srh.bikehire.dtointerface.InvoiceDTO;

public interface InvoiceDAO {
	public InvoiceDTO getInvoiceByInvoiceId(String pInvoiceId);
	
	public InvoiceDTO getInvoiceByOrderId(String pOrderId);
	
	public String addInvoice(InvoiceDTO pInvoiceDTO);
}
