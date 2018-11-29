package edu.srh.bikehire.assetmangement;

public interface AssetManager {
	public String addNewBikeType(BikeType pNewBikeType, BikeStock pBikeStock, BikeRentDetails pRentMapping);
	
	public String addNewBikeDetails(Bike pNewBike, BikeStatus pBikeStatus);
	
	public String addNewWarehouse(Warehouse pNewWarehouse);
	
	public String deleteBikeDetails(Bike pDeleteBike);
	
	public String updateWarehouse(Warehouse pUpdatedWarehouse);
	
	public String updateBikeDetails(Bike pUpdatedBike);
	
	public String updateBikeRent(BikeRentDetails pUpdatedBikeRent);
	
	public String updateBikeStock(BikeStock pUpdatedBikeStock);
	
	public String updateBikeStatus(BikeStatus pUpdatedBikeStatus);

	
}
