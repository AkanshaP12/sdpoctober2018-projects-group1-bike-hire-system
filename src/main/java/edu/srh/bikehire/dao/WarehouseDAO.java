package edu.srh.bikehire.dao;

import edu.srh.bikehire.dto.WareHouseDTO;

public interface WarehouseDAO {
	public WareHouseDTO getWarehouse(int pWarehouseId);
	
	public int addWarehouse(WareHouseDTO pWarehouse);
	
	public boolean updateWarehouse(WareHouseDTO pWarehouse);
}
