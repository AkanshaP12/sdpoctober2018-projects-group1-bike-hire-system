package edu.srh.bikehire.serviceimpl;

import java.util.List;

import edu.srh.bikehire.dao.BikeDAO;
import edu.srh.bikehire.service.BikeService;

public class BikeServiceImpl implements BikeService {

	private BikeDAO bikeDAO;

	public List<BikeDAO> getAllBikes(boolean pSortPriceDescending) {
		return bikeDAO.getAllBikes(pSortPriceDescending);
	}

	public BikeDAO getBikeByID(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addNewBikeType(BikeDAO bike) {
		// TODO Auto-generated method stub

	}

	public void addNewBike(BikeDAO bike) {
		// TODO Auto-generated method stub

	}

	public void deleteBikeByID(int ID) {
		// TODO Auto-generated method stub

	}

}
