package edu.srh.bikehire.service;


public interface PaymentService {
	
	public String processDepositPayment(String orderId);
	
	public String processInvoicePayment(String invoiceId);
	
	public boolean paymentRefund(String orderId);
}
