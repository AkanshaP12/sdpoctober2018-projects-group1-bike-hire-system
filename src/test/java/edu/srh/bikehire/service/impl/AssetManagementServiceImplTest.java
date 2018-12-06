package edu.srh.bikehire.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.service.core.impl.BikeRentInfo;
import edu.srh.bikehire.service.core.impl.BikeStockInfo;
import edu.srh.bikehire.service.core.impl.BikeTypeInfo;

public class AssetManagementServiceImplTest {

	AssetManagementServiceImpl assetService = new AssetManagementServiceImpl();

	@Test
	public void testInitializeService() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddNewBikeType() throws BikeHireSystemException {
		BikeTypeInfo bikeTypeInfo = new BikeTypeInfo();
		bikeTypeInfo.setBikeType("sports bike");
		bikeTypeInfo.setAgeCategory("8");
		
		BikeStockInfo bikeStockInfo = new BikeStockInfo();
		bikeStockInfo.setTotalQuantity(100);
		
		BikeRentInfo bikeRentInfo = new BikeRentInfo();
		bikeRentInfo.setRentPerDay(23);
		bikeRentInfo.setRentPerHour(3);
		
		int bikeTypeId = assetService.addNewBikeType(bikeTypeInfo, bikeStockInfo, bikeRentInfo);
		assertTrue(bikeTypeId > 0);

	}
	
	@Test(expected = BikeHireSystemException.class)
	public void testAddNewBikeTypeInvalidTotalQuantity() throws BikeHireSystemException {
		BikeTypeInfo bikeTypeInfo = new BikeTypeInfo();
		bikeTypeInfo.setBikeType("sports bike");
		bikeTypeInfo.setAgeCategory("8");
		
		BikeStockInfo bikeStockInfo = new BikeStockInfo();
		bikeStockInfo.setTotalQuantity(-2);
		
		BikeRentInfo bikeRentInfo = new BikeRentInfo();
		bikeRentInfo.setRentPerDay(23);
		bikeRentInfo.setRentPerHour(3);
		
		int bikeTypeId = assetService.addNewBikeType(bikeTypeInfo, bikeStockInfo, bikeRentInfo);
	}

	@Test
	public void testAddNewBikeDetails() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddNewWarehouse() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteBikeDetails() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateWarehouse() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateBikeDetails() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateBikeRent() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateBikeStock() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateBikeStatus() {
		fail("Not yet implemented");
	}

}
