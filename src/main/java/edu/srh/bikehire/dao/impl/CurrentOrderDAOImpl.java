package edu.srh.bikehire.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.srh.bikehire.dao.CurrentOrderDAO;
import edu.srh.bikehire.daoimpl.util.PersistenceManager;
import edu.srh.bikehire.dto.CurrentOrderDTOImpl;
import edu.srh.bikehire.dtointerface.CurrentOrderDTO;

public class CurrentOrderDAOImpl implements CurrentOrderDAO {

	public CurrentOrderDTOImpl getCurrentOrderByOrderId(String pOrderId) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = em.createQuery("from CurrentOrder where OrderID = :typeId ");
		lQuery.setParameter("typeId", pOrderId);
		List<CurrentOrderDTOImpl> results = lQuery.getResultList();
		if(results == null || results.size() == 0)
		{
			return null;
		}
		return results.get(0);
	}

	public CurrentOrderDTOImpl getCurrentOrderByBikeId(String pBikeId) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = em.createQuery("from CurrentOrder where BikeID = :typeId ");
		lQuery.setParameter("typeId", pBikeId);
		List<CurrentOrderDTOImpl> results = lQuery.getResultList();
		if(results == null || results.size() == 0)
		{
			return null;
		}
		return results.get(0);
	}

	public boolean addCurrentOrder(CurrentOrderDTO pCurrentOrderDTO) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(pCurrentOrderDTO);
		em.getTransaction().commit();
		return true;
	}

	public boolean updateCurrentOrder(CurrentOrderDTO pCurrentOrderDTO) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		CurrentOrderDTOImpl lCurrentOrderDTOImpl = getCurrentOrderByOrderId(pCurrentOrderDTO.getOrderID());
		em.getTransaction().begin();
		
		lCurrentOrderDTOImpl.setPickupTimeStamp(pCurrentOrderDTO.getPickupTimeStamp());
		
		em.getTransaction().commit();
		return true;
	}

	public boolean deleteCurrentOrder(CurrentOrderDTO pCurrentOrderDTO) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = em.createQuery("delete from CurrentOrder where OrderID = :typeId ");
		lQuery.setParameter("typeId", pCurrentOrderDTO.getOrderID());
		int lRowsAffected = lQuery.executeUpdate();
		if(lRowsAffected > 0)
		{
			return true;
		}
		return false;
	}

}
