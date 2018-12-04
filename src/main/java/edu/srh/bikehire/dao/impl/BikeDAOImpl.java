package edu.srh.bikehire.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.srh.bikehire.dao.BikeDAO;
import edu.srh.bikehire.dao.impl.util.PersistenceManager;
import edu.srh.bikehire.dto.BikeDTO;
import edu.srh.bikehire.dto.impl.BikeDTOImpl;
import edu.srh.bikehire.dto.impl.WareHouseDTOImpl;
import edu.srh.bikehire.util.Util;

public class BikeDAOImpl implements BikeDAO {

	public BikeDTOImpl getBike(int pBikeId) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		
		Query lQuery = em.createQuery("from Bike where BikeId = :typeId ");
		lQuery.setParameter("typeId", pBikeId);
		
		List<BikeDTOImpl> lBikes = lQuery.getResultList();
		if(lBikes.size() == 0)
		{
			return null;
		}
		return lBikes.get(0);
	}

	public int addBike(BikeDTO pBike) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		BikeDTOImpl lBikeDTOImpl = (BikeDTOImpl) pBike;
		em.getTransaction().begin();
		em.persist(lBikeDTOImpl);
		em.getTransaction().commit();
		return lBikeDTOImpl.getBikeId();
	}

	public boolean updateBike(BikeDTO pBike) {
		BikeDTOImpl lBike = getBike(pBike.getBikeId());
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		if(pBike.getBikeTitle() != null)
		{			
			lBike.setBikeTitle(pBike.getBikeTitle());
		}
		if(pBike.getDepositAmount() > 0)
		{
			lBike.setDepositAmount(pBike.getDepositAmount());
		}
		if(pBike.getWareHouseID() > 0) 
		{
			WareHouseDTOImpl lWareHouse = new WareHouseDTOImpl();
			lWareHouse.setWarehouseId(pBike.getWareHouseID());
			lBike.setWarehouse(lWareHouse);
		}
		
		em.getTransaction().commit();
		return true;
	}

	public List<BikeDTO> getBikeForWarehouseId(int pWarehouseId, boolean pSortPriceDescending) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = null;
		if(pSortPriceDescending)
		{
			lQuery = em.createQuery("from Bike where WareHouseId = :typeId Order by DepositAmount DESC");
		}
		else
		{			
			lQuery = em.createQuery("from Bike where WareHouseId = :typeId Order by DepositAmount ASC");
		}
		lQuery.setParameter("typeId", pWarehouseId);
		
		//IF failes, make list of List<BikeDTOImpl>
		List<BikeDTO> lBikes = lQuery.getResultList();
		return (List<BikeDTO>)lBikes;
	}

	public List<BikeDTO> getBikeForBikeType(int pBikeTypeId, boolean pSortPriceDescending) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = null;
		if(pSortPriceDescending)
		{			
			lQuery = em.createQuery("from Bike where BikeTypeId = :typeId Order by DepositAmount DESC");
		}
		else
		{
			lQuery = em.createQuery("from Bike where BikeTypeId = :typeId Order by DepositAmount ASC");
		}
		
		lQuery.setParameter("typeId", pBikeTypeId);
		
		List<BikeDTO> lBikes = lQuery.getResultList();
		return lBikes;
	}

	public List<BikeDTO> getAllBikes(boolean pSortPriceDescending)
	{
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = null;
		if(pSortPriceDescending)
		{
			lQuery = em.createQuery("from Bike Order by DepositAmount DESC");
		}
		else
		{
			lQuery = em.createQuery("from Bike Order by DepositAmount ASC");
		}
		
		List<BikeDTO> lBikes = lQuery.getResultList();
		return lBikes;
		
	}
}