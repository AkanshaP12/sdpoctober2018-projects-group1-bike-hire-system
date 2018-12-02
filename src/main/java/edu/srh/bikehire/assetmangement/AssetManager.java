package edu.srh.bikehire.assetmangement;

import edu.srh.bikehire.dtointerface.BikeDTO;
import edu.srh.bikehire.dtointerface.BikeRentMappingDTO;
import edu.srh.bikehire.dtointerface.BikeStatusDTO;
import edu.srh.bikehire.dtointerface.BikeStockDTO;
import edu.srh.bikehire.dtointerface.BikeTypeDTO;
import edu.srh.bikehire.dtointerface.WareHouseDTO;

public interface AssetManager {
	public String addNewBikeType(BikeTypeDTO pNewBikeType, BikeStockDTO pBikeStock, BikeRentMappingDTO pRentMapping);
	
	public String addNewBikeDetails(BikeDTO pNewBike, BikeStatusDTO pBikeStatus);
	
	public String addNewWarehouse(WareHouseDTO pNewWarehouse);
	
	public String deleteBikeDetails(BikeDTO pDeleteBike);
	
	public String updateWarehouse(WareHouseDTO pUpdatedWarehouse);
	
	public String updateBikeDetails(BikeDTO pUpdatedBike);
	
	public String updateBikeRent(BikeRentMappingDTO pUpdatedBikeRent);
	
	public String updateBikeStock(BikeStockDTO pUpdatedBikeStock);
	
	public String updateBikeStatus(BikeStatusDTO pUpdatedBikeStatus);

	
}
