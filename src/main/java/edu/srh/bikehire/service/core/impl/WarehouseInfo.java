package edu.srh.bikehire.service.core.impl;

import edu.srh.bikehire.service.core.Warehouse;

public class WarehouseInfo implements Warehouse {
	private int warehouseId;
	private String name;
	private String location;
	private int storageCapacity;
	
	public int getWarehouseId() {
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
