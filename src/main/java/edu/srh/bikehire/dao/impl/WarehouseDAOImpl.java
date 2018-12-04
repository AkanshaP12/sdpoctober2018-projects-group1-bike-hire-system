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
		Query lQuery = em.createQuery("from WareHouse where WareHouseId = :typeId ");
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
		//Generate warehouse id
		WareHouseDTOImpl lWareHouseDTOImpl = new WareHouseDTOImpl();
		em.getTransaction().begin();
		em.persist(lWareHouseDTOImpl);
		em.getTransaction().commit();
		return lWareHouseDTOImpl.getWarehouseId();
	}

	public boolean updateWarehouse(WareHouseDTO pWarehouse) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		
		WareHouseDTOImpl lWarehouse = getWarehouse(pWarehouse.getWarehouseId());
		em.getTransaction().begin();
		lWarehouse.setStorageCapacity(pWarehouse.getStorageCapacity());
		lWarehouse.setName(pWarehouse.getName());
		lWarehouse.setLastmodifiedTimeStamp(Calendar.getInstance());
		em.getTransaction().commit();
		return true;
	}
}
