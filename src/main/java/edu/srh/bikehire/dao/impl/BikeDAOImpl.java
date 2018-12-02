package edu.srh.bikehire.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.srh.bikehire.dao.BikeDAO;
import edu.srh.bikehire.daoimpl.util.PersistenceManager;
import edu.srh.bikehire.dto.BikeDTOImpl;
import edu.srh.bikehire.dto.WareHouseDTOImpl;
import edu.srh.bikehire.dtointerface.BikeDTO;

public class BikeDAOImpl implements BikeDAO {

	public BikeDTOImpl getBike(String pBikeId) {
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

	public boolean addBike(BikeDTO pBike) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(pBike);
		em.getTransaction().commit();
		return true;
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
		if(pBike.getWareHouseID() != null) 
		{
			WareHouseDTOImpl lWareHouse = new WareHouseDTOImpl();
			lWareHouse.setWarehouseId(pBike.getWareHouseID());
			lBike.setWarehouse(lWareHouse);
		}
		
		em.getTransaction().commit();
		return true;
	}

	public List<BikeDTO> getBikeForWarehouseId(String pWarehouseId, boolean pSortPriceDescending) {
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

	public List<BikeDTO> getBikeForBikeType(String pBikeTypeId, boolean pSortPriceDescending) {
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