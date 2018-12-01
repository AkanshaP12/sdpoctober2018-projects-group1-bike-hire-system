package edu.srh.bikehire.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.srh.bikehire.dao.BikeStockDAO;
import edu.srh.bikehire.daoimpl.util.PersistenceManager;
import edu.srh.bikehire.dto.BikeStockDTOImpl;
import edu.srh.bikehire.dtointerface.BikeStockDTO;
import edu.srh.bikehire.dtointerface.BikeTypeDTO;

public class BikeStockDAOImpl implements BikeStockDAO {

	public BikeStockDTOImpl getBikeStock(BikeTypeDTO bikeType) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		
		Query lQuery = em.createQuery("from BikeStock where BikeTypeId = :typeId ");
		lQuery.setParameter("typeId", bikeType.getBikeTypeId());
		
		List<BikeStockDTOImpl> lBikeStocks = lQuery.getResultList();
		if(lBikeStocks.size() == 0)
		{
			return null;
		}
		return lBikeStocks.get(0);
	}

	public boolean addBikeStock(BikeStockDTO bikeStock) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(bikeStock);
		em.getTransaction().commit();
		return false;
	}

	public boolean updateBikeStock(BikeStockDTO bikeStock, BikeTypeDTO bikeType) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		
		BikeStockDTOImpl lBikeStock = getBikeStock(bikeType);
		em.getTransaction().begin();
		lBikeStock.setTotalQuantity(bikeStock.getTotalQuantity());
		lBikeStock.setLastModifiedTimeStamp(Calendar.getInstance());
		em.getTransaction().commit();
		return true;
	}

}
