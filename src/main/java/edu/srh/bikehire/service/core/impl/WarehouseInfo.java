package edu.srh.bikehire.service.core.impl;

import edu.srh.bikehire.service.core.Warehouse;

public class WarehouseInfo implements Warehouse {
	private String warehouseId;
	private String name;
	private String location;
	private int storageCapacity;
	
	public String getWarehouseId() {
		return warehouseId;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public int getStorageCapacity() {
		return storageCapacity;
	}

}
