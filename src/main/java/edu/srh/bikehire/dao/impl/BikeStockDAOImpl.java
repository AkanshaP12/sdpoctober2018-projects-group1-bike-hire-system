package edu.srh.bikehire.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.srh.bikehire.dao.BikeStockDAO;
import edu.srh.bikehire.dao.impl.util.PersistenceManager;
import edu.srh.bikehire.dto.BikeStockDTO;
import edu.srh.bikehire.dto.BikeTypeDTO;
import edu.srh.bikehire.dto.impl.BikeStockDTOImpl;
import edu.srh.bikehire.dto.impl.BikeTypeDTOImpl;

public class BikeStockDAOImpl implements BikeStockDAO {

	public BikeStockDTOImpl getBikeStock(BikeTypeDTO bikeType) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		
		Query lQuery = em.createQuery("from BikeStockDTOImpl where BikeTypeId = :typeId ");
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
		Query lQuery = em.createQuery("UPDATE BikeStockDTOImpl bs SET bs.totalQuantity = :tq, bs.lastModifiedTimeStamp = :lm where bs.bikeType = :bti");
		lQuery.setParameter("tq", bikeStock.getTotalQuantity());
		lQuery.setParameter("lm", Calendar.getInstance());
		BikeTypeDTOImpl bikeTypeDTO = new BikeTypeDTOImpl();
		bikeTypeDTO.setBikeTypeId(lBikeStock.getBikeTypeId());
		lQuery.setParameter("bti", bikeTypeDTO);
		int rowsUpdated = lQuery.executeUpdate();
		em.getTransaction().commit();
		if(rowsUpdated <= 0)
		{
			return false;
		}
		return true;
	}

}
