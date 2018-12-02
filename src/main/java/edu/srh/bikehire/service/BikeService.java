package edu.srh.bikehire.service;

import java.util.List;

import edu.srh.bikehire.dao.BikeDAO;
import edu.srh.bikehire.dto.BikeDTO;

public interface BikeService{

	List<BikeDTO> getAllBikes(boolean pSortPriceDescending);

	BikeDTO getBikeByID(int ID);
	
	void addNewBikeType(BikeDTO bike);

	void addNewBike(BikeDTO bike);

	void deleteBikeByID(int ID);

}
