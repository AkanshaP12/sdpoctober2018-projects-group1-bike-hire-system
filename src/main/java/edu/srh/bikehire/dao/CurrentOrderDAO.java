package edu.srh.bikehire.dao;

import edu.srh.bikehire.dto.CurrentOrderDTO;

public interface CurrentOrderDAO {
	public CurrentOrderDTO getCurrentOrderByOrderId(String pOrderId);
	
	public CurrentOrderDTO getCurrentOrderByBikeId(String pBikeId);
	
	public String addCurrentOrder(CurrentOrderDTO pCurrentOrderDTO);
	
	public boolean updateCurrentOrder(CurrentOrderDTO pCurrentOrderDTO);
	
	public boolean deleteCurrentOrder(CurrentOrderDTO pCurrentOrderDTO);
}
