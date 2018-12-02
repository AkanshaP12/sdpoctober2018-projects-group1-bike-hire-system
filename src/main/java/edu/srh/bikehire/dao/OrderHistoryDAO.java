package edu.srh.bikehire.dao;

import java.util.List;

import edu.srh.bikehire.dtointerface.OrderHistoryDTO;

public interface OrderHistoryDAO {
	public OrderHistoryDTO getOrderHistoryByOrderId(String pOrderId);
	
	public OrderHistoryDTO getOrderHistoryByInvoiceId(String pInvoiceId);
	
	public List<OrderHistoryDTO> getOrderHistoryByBikeId(String pBikeId);
	
	public List<OrderHistoryDTO> getOrderHistoryByUserId(String pUserId);
	
	public boolean addOrderHistory(OrderHistoryDTO pOrderHistoryDTO);
}
