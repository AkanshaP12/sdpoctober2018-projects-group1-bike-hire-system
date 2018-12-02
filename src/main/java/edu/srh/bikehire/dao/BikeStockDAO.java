package edu.srh.bikehire.dao;

import edu.srh.bikehire.dtointerface.BikeStockDTO;
import edu.srh.bikehire.dtointerface.BikeTypeDTO;

public interface BikeStockDAO {
	public BikeStockDTO getBikeStock(BikeTypeDTO bikeType);
	
	public boolean addBikeStock(BikeStockDTO bikeStock);
	
	public boolean updateBikeStock(BikeStockDTO bikeStock, BikeTypeDTO bikeType);
}
