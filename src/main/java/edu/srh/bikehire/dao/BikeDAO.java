package edu.srh.bikehire.dao;


import java.util.List;

import edu.srh.bikehire.dto.BikeDTO;

public interface BikeDAO {
	public BikeDTO getBike(String pBikeId);
	
	public String addBike(BikeDTO pBike);
	
	public boolean updateBike(BikeDTO pBike);
	
	public List<BikeDTO> getBikeForWarehouseId(String pWarehouseId, boolean pSortPriceDescending);
	
	public List<BikeDTO> getBikeForBikeType(String pBikeTypeId, boolean pSortPriceDescending);
	
	public List<BikeDTO> getAllBikes(boolean pSortPriceDescending);
}
