package edu.srh.bikehire.service.core.impl;

import edu.srh.bikehire.service.core.BikeStock;

public class BikeStockInfo implements BikeStock {
	private String bikeTypeId;
	private long totalQuantity;
	
	public String getBikeTypeId() {
		return bikeTypeId;
	}

	public long getTotalQuantity() {
		return totalQuantity;
	}

}
