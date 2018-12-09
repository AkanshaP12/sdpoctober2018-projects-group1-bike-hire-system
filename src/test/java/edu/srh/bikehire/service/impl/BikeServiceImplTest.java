package edu.srh.bikehire.service.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.srh.bikehire.dao.DAOFactory;
import edu.srh.bikehire.dashboard.BikeStatusType;
import edu.srh.bikehire.exception.BikeHireSystemException;

public class BikeServiceImplTest {

	String expected;
	BikeServiceImpl bikeService = new BikeServiceImpl();

	@Before
	public void testInitializeService() {
		// TODO
		// fail("Not yet implemented");
	}

	@Test
	public void testGetAllBikes() {
		assertNotNull(bikeService.getAllBikes(true));
		assertNotNull(bikeService.getAllBikes(false));
	}

	@Test
	// change the id as required
	public void testGetBikeByID() {
		assertNotNull(bikeService.getBikeByID(1));
	}

	@Test
	public void testUpdateBikeStatus() {
		// TODO
	}

	@Test(expected = BikeHireSystemException.class)
	public void testGetAllBikesBasedOnType() throws BikeHireSystemException {
		assertNotNull(bikeService.getAllBikesBasedOnType(1, true));
		assertNotNull(bikeService.getAllBikesBasedOnType(1, false));
		// TODO --- expected needs to be defined
		assertNotNull(bikeService.getAllBikesBasedOnType(1, true));
		assertNotNull(bikeService.getAllBikesBasedOnType(1, false));

	}

	@Test
	public void testGetAllBikesBasedOnWarehouse() throws BikeHireSystemException {
		assertNotNull(bikeService.getAllBikesBasedOnWarehouse(1, true));
		assertNotNull(bikeService.getAllBikesBasedOnWarehouse(1, false));
	}

	@Test
	public void testGetBikeTypeInfo() {
		assertNotNull(bikeService.getBikeTypeInfo(1));
	}

	@Test
	public void testGetBikeTypes() {
		assertNotNull(bikeService.getBikeTypes());
	}

	@Test
	public void testGetAllBikesBasedOnStatus() {
		assertNotNull(bikeService.getAllBikesBasedOnStatus(BikeStatusType.AVALIABLE_BIKE, true));
		assertNotNull(bikeService.getAllBikesBasedOnStatus(BikeStatusType.RENTED_BIKE, true));
		assertNotNull(bikeService.getAllBikesBasedOnStatus(BikeStatusType.UNDERMAINTAINCE_BIKE, true));
		assertNotNull(bikeService.getAllBikesBasedOnStatus(BikeStatusType.AVALIABLE_BIKE, false));
		assertNotNull(bikeService.getAllBikesBasedOnStatus(BikeStatusType.RENTED_BIKE, false));
		assertNotNull(bikeService.getAllBikesBasedOnStatus(BikeStatusType.UNDERMAINTAINCE_BIKE, false));
	}

	@Test
	public void testGetBikeRent() {
		assertNotNull(bikeService.getBikeRent(1));
	}

	@Test
	public void testGetAllWarehouses() {
		assertNotNull(bikeService.getAllWarehouses());
	}

}
