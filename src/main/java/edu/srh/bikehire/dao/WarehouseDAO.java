package edu.srh.bikehire.dao;

import edu.srh.bikehire.dtointerface.WareHouseDTO;

public interface WarehouseDAO {
	public WareHouseDTO getWarehouse(String pWarehouseId);
	
	public boolean addWarehouse(WareHouseDTO pWarehouse);
	
	public boolean updateWarehouse(WareHouseDTO pWarehouse);
}
