package edu.srh.bikehire.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.srh.bikehire.dao.BikeDAO;
import edu.srh.bikehire.dao.impl.util.PersistenceManager;
import edu.srh.bikehire.dto.BikeDTO;
import edu.srh.bikehire.dto.impl.BikeDTOImpl;
import edu.srh.bikehire.dto.impl.WareHouseDTOImpl;

public class BikeDAOImpl implements BikeDAO {
	private static final Logger LOG = LogManager.getLogger(BikeDAOImpl.class);
	
	public BikeDTOImpl getBike(int pBikeId) {
		LOG.debug("getBike : Start");
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		
		Query lQuery = em.createQuery("from BikeDTOImpl where BikeId = :typeId ");
		lQuery.setParameter("typeId", pBikeId);
		
		List<BikeDTOImpl> lBikes = lQuery.getResultList();
		if(lBikes.size() == 0)
		{
			LOG.debug("getBike : End");
			return null;
		}
		LOG.debug("getBike : End");
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
		if(pBike.getBikeTitle() != null)
		{			
			lBike.setBikeTitle(pBike.getBikeTitle());
		}
		if(pBike.getDepositAmount() > 0)
		{
			lBike.setDepositAmount(pBike.getDepositAmount());
		}
		WareHouseDTOImpl lWareHouse = new WareHouseDTOImpl();
		if(pBike.getWareHouseID() > 0) 
		{
			lWareHouse.setWarehouseId(pBike.getWareHouseID());
			lBike.setWarehouse(lWareHouse);
		}
		em.getTransaction().begin();
		Query lQuery = em.createQuery("UPDATE BikeDTOImpl bd SET bd.bikeTitle = :bt, bd.depositAmount = :da, bd.warehouse = :wa where bd.bikeId = :bi");
		lQuery.setParameter("bt", lBike.getBikeTitle());
		lQuery.setParameter("da", lBike.getDepositAmount());
		lQuery.setParameter("wa", lWareHouse);
		lQuery.setParameter("bi", lBike.getBikeId());
		
		int rowsUpdated = lQuery.executeUpdate();
		em.getTransaction().commit();
		if(rowsUpdated <= 0)
		{
			return false;
		}
		return true;
	}

	public List<BikeDTO> getBikeForWarehouseId(int pWarehouseId, boolean pSortPriceDescending) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = null;
		if(pSortPriceDescending)
		{
			lQuery = em.createQuery("from BikeDTOImpl where WareHouseId = :typeId Order by DepositAmount DESC");
		}
		else
		{			
			lQuery = em.createQuery("from BikeDTOImpl where WareHouseId = :typeId Order by DepositAmount ASC");
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
			lQuery = em.createQuery("from BikeDTOImpl where BikeTypeId = :typeId Order by DepositAmount DESC");
		}
		else
		{
			lQuery = em.createQuery("from BikeDTOImpl where BikeTypeId = :typeId Order by DepositAmount ASC");
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
			lQuery = em.createQuery("from BikeDTOImpl Order by DepositAmount DESC");
		}
		else
		{
			lQuery = em.createQuery("from BikeDTOImpl Order by DepositAmount ASC");
		}
		
		List<BikeDTO> lBikes = lQuery.getResultList();
		return lBikes;
		
	}
}