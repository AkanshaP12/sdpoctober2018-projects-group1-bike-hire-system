package edu.srh.bikehire.service.impl;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import edu.srh.bikehire.dashboard.BikeStatusType;
import edu.srh.bikehire.dto.BikeDTO;
import edu.srh.bikehire.dto.BikeRentMappingDTO;
import edu.srh.bikehire.dto.BikeStatusDTO;
import edu.srh.bikehire.dto.BikeTypeDTO;
import edu.srh.bikehire.dto.WareHouseDTO;
import edu.srh.bikehire.exception.BikeHireSystemException;
import edu.srh.bikehire.service.core.impl.BikeStatusInfo;

public class BikeServiceImplTest {

	BikeServiceImpl bikeServiceImplTest = new BikeServiceImpl();

	@Test
	public void testGetAllBikes() throws BikeHireSystemException {
		boolean sortDescending = true;
		List<BikeDTO> getBikes = bikeServiceImplTest.getAllBikes(sortDescending);
		assertNotNull(getBikes);
		assertTrue(getBikes.size() > 0);
	}

	@Test
	public void testGetBikeByID() throws BikeHireSystemException {
		BikeDTO BikeReturn = bikeServiceImplTest.getBikeByID(1);
		assertNotNull(BikeReturn);
	}

	@Test(expected = BikeHireSystemException.class)
	public void testGetBikeByIDInvalid() throws BikeHireSystemException {
		BikeDTO BikeReturnInvalid = bikeServiceImplTest.getBikeByID(-1);
	}

	@Test
	public void testUpdateBikeStatus() throws BikeHireSystemException {
		bikeServiceImplTest.updateBikeStatus(1, BikeStatusType.AVALIABLE_BIKE);
	}

	@Test(expected = BikeHireSystemException.class)
	public void testUpdateBikeStatusInvalid() throws BikeHireSystemException {
		bikeServiceImplTest.updateBikeStatus(1, null);
	}

	@Test(expected = BikeHireSystemException.class)
	public void testUpdateBikeStatusInvalidBikeId() throws BikeHireSystemException {
		bikeServiceImplTest.updateBikeStatus(-1, BikeStatusType.AVALIABLE_BIKE);
	}

	@Test
	public void testGetAllBikesBasedOnType() throws BikeHireSystemException {
		boolean sortDescending = true;
		List<BikeDTO> basedOnType = bikeServiceImplTest.getAllBikesBasedOnType(1, sortDescending);
		assertNotNull(basedOnType);
		assertTrue(basedOnType.size() > 0);
	}

	@Test
	public void testGetAllBikesBasedOnWarehouse() throws BikeHireSystemException {

		boolean sortPriceDescending = true;
		List<BikeDTO> bikesbasedonwarehouse = bikeServiceImplTest.getAllBikesBasedOnWarehouse(1, sortPriceDescending);
		assertNotNull(bikesbasedonwarehouse);
		assertTrue(bikesbasedonwarehouse.size() > 0);
	}

	@Test(expected = BikeHireSystemException.class)
	public void testGetAllBikesBasedOnWarehouseInvalid() throws BikeHireSystemException {

		boolean sortPriceDescending = false;
		List<BikeDTO> bikesbasedonwarehouse = bikeServiceImplTest.getAllBikesBasedOnWarehouse(-1, sortPriceDescending);

	}

	@Test
	public void testGetBikeTypeInfo() throws BikeHireSystemException {
		BikeTypeDTO biketypeinfo = bikeServiceImplTest.getBikeTypeInfo(1);
		assertNotNull(biketypeinfo);
	}

	@Test(expected = BikeHireSystemException.class)
	public void testGetBikeTypeInfoinvalid() throws BikeHireSystemException {
		BikeTypeDTO biketypeinfo = bikeServiceImplTest.getBikeTypeInfo(-1);

	}

	@Test
	public void testGetBikeTypes() throws BikeHireSystemException {
		List<BikeTypeDTO> biketype = bikeServiceImplTest.getBikeTypes();
		assertNotNull(biketype);
		assertTrue(biketype.size() > 0);
	}

	@Test
	public void testGetAllBikesBasedOnStatus() throws BikeHireSystemException {

		List<BikeDTO> bikes = bikeServiceImplTest.getAllBikesBasedOnStatus(BikeStatusType.AVALIABLE_BIKE, true);
		assertNotNull(bikes);
		assertTrue(bikes.size() > 0);
		boolean isCorrectOrder = true;
		int previousDeposit = Integer.MAX_VALUE;
		for (BikeDTO bikeDTO : bikes) {
			if (bikeDTO.getDepositAmount() > previousDeposit) {
				isCorrectOrder = false;
				break;
			} else {
				previousDeposit = bikeDTO.getDepositAmount();
			}
		}

		assertTrue(isCorrectOrder);
	}

	@Test
	public void testGetAllBikesBasedOnStatusrent() throws BikeHireSystemException {

		List<BikeDTO> bikes = bikeServiceImplTest.getAllBikesBasedOnStatus(BikeStatusType.RENTED_BIKE, true);
		assertNotNull(bikes);
		assertTrue(bikes.size() > 0);
		boolean isCorrectOrder = true;
		int previousDeposit = Integer.MAX_VALUE;
		for (BikeDTO bikeDTO : bikes) {
			if (bikeDTO.getDepositAmount() > previousDeposit) {
				isCorrectOrder = false;
				break;
			} else {
				previousDeposit = bikeDTO.getDepositAmount();
			}
		}

		assertTrue(isCorrectOrder);

	}

	@Test
	public void testGetAllBikesBasedOnStatusrentmaintainance() throws BikeHireSystemException {

		List<BikeDTO> bikes = bikeServiceImplTest.getAllBikesBasedOnStatus(BikeStatusType.UNDERMAINTAINCE_BIKE, true);
		assertNotNull(bikes);
		assertTrue(bikes.size() > 0);
		boolean isCorrectOrder = true;
		int previousDeposit = Integer.MAX_VALUE;
		for (BikeDTO bikeDTO : bikes) {
			if (bikeDTO.getDepositAmount() > previousDeposit) {
				isCorrectOrder = false;
				break;
			} else {
				previousDeposit = bikeDTO.getDepositAmount();
			}
		}

		assertTrue(isCorrectOrder);

	}

	@Test(expected = BikeHireSystemException.class)
	public void testGetAllBikesBasedOnStatusinvalidavaliable() throws BikeHireSystemException {

		List<BikeDTO> bikes = bikeServiceImplTest.getAllBikesBasedOnStatus(BikeStatusType.AVALIABLE_BIKE, false);
		assertNotNull(bikes);
		assertTrue(bikes.size() > 0);
		boolean isCorrectOrder = true;
		int previousDeposit = 0;
		for (BikeDTO bikeDTO : bikes) {
			if (bikeDTO.getDepositAmount() < previousDeposit) {
				isCorrectOrder = false;
				break;
			} else {
				previousDeposit = bikeDTO.getDepositAmount();
			}
		}

		assertTrue(isCorrectOrder);
	}

	@Test(expected = BikeHireSystemException.class)
	public void testGetAllBikesBasedOnStatusinvalidrented() throws BikeHireSystemException {
		List<BikeDTO> bikes = bikeServiceImplTest.getAllBikesBasedOnStatus(BikeStatusType.RENTED_BIKE, false);
		assertNotNull(bikes);
		assertTrue(bikes.size() > 0);
		boolean isCorrectOrder = true;
		int previousDeposit = 0;
		for (BikeDTO bikeDTO : bikes) {
			if (bikeDTO.getDepositAmount() < previousDeposit) {
				isCorrectOrder = false;
				break;
			} else {
				previousDeposit = bikeDTO.getDepositAmount();
			}
		}

		assertTrue(isCorrectOrder);
	}

	@Test(expected = BikeHireSystemException.class)
	public void testGetAllBikesBasedOnStatusinvalidmaintaince() throws BikeHireSystemException {
		List<BikeDTO> bikes = bikeServiceImplTest.getAllBikesBasedOnStatus(BikeStatusType.UNDERMAINTAINCE_BIKE, false);
		assertNotNull(bikes);
		assertTrue(bikes.size() > 0);
		boolean isCorrectOrder = true;
		int previousDeposit = 0;
		for (BikeDTO bikeDTO : bikes) {
			if (bikeDTO.getDepositAmount() < previousDeposit) {
				isCorrectOrder = false;
				break;
			} else {
				previousDeposit = bikeDTO.getDepositAmount();
			}
		}

		assertTrue(isCorrectOrder);
	}

	@Test
	public void testGetBikeRent() throws BikeHireSystemException {
		BikeRentMappingDTO bikerent = bikeServiceImplTest.getBikeRent(1);
		assertNotNull(bikerent);
	}

	@Test(expected = BikeHireSystemException.class)
	public void testGetBikeRentinvalid() throws BikeHireSystemException {
		BikeRentMappingDTO bikerent = bikeServiceImplTest.getBikeRent(-1);
	}

	@Test
	public void testGetAllWarehouses() throws BikeHireSystemException {
		List<WareHouseDTO> allWarehouses = bikeServiceImplTest.getAllWarehouses();
		assertNotNull(allWarehouses);
		assertTrue(allWarehouses.size() > 0);

	}

}
