package edu.srh.bikehire.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.srh.bikehire.dao.WarehouseDAO;
import edu.srh.bikehire.dao.impl.util.PersistenceManager;
import edu.srh.bikehire.dto.WareHouseDTO;
import edu.srh.bikehire.dto.impl.WareHouseDTOImpl;
import edu.srh.bikehire.util.Util;

public class WarehouseDAOImpl implements WarehouseDAO {

	public WareHouseDTOImpl getWarehouse(int pWarehouseId) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = em.createQuery("from WareHouseDTOImpl where WareHouseId = :typeId ");
		lQuery.setParameter("typeId", pWarehouseId);
		
		List<WareHouseDTOImpl> results = lQuery.getResultList();
		if(results == null || results.size() == 0)
		{
			return null;
		}
		return results.get(0);
	}

	public int addWarehouse(WareHouseDTO pWarehouse) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(pWarehouse);
		em.getTransaction().commit();
		return pWarehouse.getWarehouseId();
	}

	public boolean updateWarehouse(WareHouseDTO pWarehouse) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		Query lQuery = em.createQuery("UPDATE WareHouseDTOImpl wh SET wh.storageCapacity = :sc, wh.name = :name, wh.lastmodifiedTimeStamp = :lm where wh.warehouseId = :id ");
		lQuery.setParameter("sc", pWarehouse.getStorageCapacity());
		lQuery.setParameter("name", pWarehouse.getName());
		lQuery.setParameter("lm", Calendar.getInstance());
		lQuery.setParameter("id", pWarehouse.getWarehouseId());
		int rowsUpdated = lQuery.executeUpdate();
		em.getTransaction().commit();
		if(rowsUpdated <= 0)
		{
			return false;
		}
		return true;
	}
	
	public List<WareHouseDTO> getAllWarehouses()
	{
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = em.createQuery("from WareHouseDTOImpl");
		
		List<WareHouseDTO> results = lQuery.getResultList();
		return results;
		
	}
}
