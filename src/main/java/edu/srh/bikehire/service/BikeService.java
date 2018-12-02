package edu.srh.bikehire.service;

import java.util.List;

import edu.srh.bikehire.dao.BikeDAO;

public interface BikeService{

	List<BikeDAO> getAllBikes();

	BikeDAO getBikeByID(int ID);
	
	void addNewBikeType(BikeDAO bike);

	void addNewBike(BikeDAO bike);

	void deleteBikeByID(int ID);

}
