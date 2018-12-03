package edu.srh.bikehire.service.impl;

import java.util.List;

import edu.srh.bikehire.dao.BikeDAO;
import edu.srh.bikehire.dto.BikeDTO;
import edu.srh.bikehire.service.BikeService;

public class BikeServiceImpl implements BikeService {

	private BikeDAO bikeDAO;

	public List<BikeDTO> getAllBikes(boolean pSortPriceDescending) {
		return bikeDAO.getAllBikes(pSortPriceDescending);
	}

	public BikeDTO getBikeByID(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addNewBikeType(BikeDTO bike) {
		// TODO Auto-generated method stub

	}

	public void addNewBike(BikeDTO bike) {
		// TODO Auto-generated method stub

	}

	public void deleteBikeByID(int ID) {
		// TODO Auto-generated method stub

	}

}
