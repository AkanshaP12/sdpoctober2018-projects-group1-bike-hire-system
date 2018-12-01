package edu.srh.bikehire.dao;

import edu.srh.bikehire.dtointerface.BikeRentMappingDTO;

public interface BikeRentMappingDAO {
	public BikeRentMappingDTO getBikeRentMapping(String pBikeTypeId);
	
	public boolean addBikeRentMapping(BikeRentMappingDTO pBikeRentMappingDTO);
	
	public boolean updateBikeRentMapping(BikeRentMappingDTO pBikeRentMappingDTO);
}
