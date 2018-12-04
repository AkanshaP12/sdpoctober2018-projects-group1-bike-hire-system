package edu.srh.bikehire.service.core.impl;

import edu.srh.bikehire.service.core.BikeStock;

public class BikeStockInfo implements BikeStock {
	private int bikeTypeId;
	private long totalQuantity;
	
	public int getBikeTypeId() {
		return bikeTypeId;
	}

	public long getTotalQuantity() {
		return totalQuantity;
	}

}
