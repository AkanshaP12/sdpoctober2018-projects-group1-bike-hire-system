package edu.srh.bikehire.daoimpl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.srh.bikehire.dao.WarehouseDAO;
import edu.srh.bikehire.daoimpl.util.PersistenceManager;
import edu.srh.bikehire.dto.WareHouseDTOImpl;
import edu.srh.bikehire.dtointerface.WareHouseDTO;

public class WarehouseDAOImpl implements WarehouseDAO {

	public WareHouseDTOImpl getWarehouse(String pWarehouseId) {
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

	public boolean addWarehouse(WareHouseDTO pWarehouse) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(pWarehouse);
		em.getTransaction().commit();
		return true;
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
