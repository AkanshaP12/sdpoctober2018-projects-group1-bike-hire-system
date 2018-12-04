package edu.srh.bikehire.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import edu.srh.bikehire.dao.CurrentOrderDAO;
import edu.srh.bikehire.dao.impl.util.PersistenceManager;
import edu.srh.bikehire.dto.CurrentOrderDTO;
import edu.srh.bikehire.dto.impl.CurrentOrderDTOImpl;
import edu.srh.bikehire.util.Util;

public class CurrentOrderDAOImpl implements CurrentOrderDAO {

	public CurrentOrderDTOImpl getCurrentOrderByOrderId(int pOrderId) {
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

	public CurrentOrderDTOImpl getCurrentOrderByBikeId(int pBikeId) {
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

	public int addCurrentOrder(CurrentOrderDTO pCurrentOrderDTO) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		CurrentOrderDTOImpl lCurrentOrderDTOImpl = (CurrentOrderDTOImpl) pCurrentOrderDTO;
		em.persist(lCurrentOrderDTOImpl);
		em.getTransaction().commit();
		return lCurrentOrderDTOImpl.getOrderID();
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
	
	public List<CurrentOrderDTO> getOrdersBasedOnPickUpDate(Calendar pFromCalendar, Calendar pToCalendar)
	{
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = em.createQuery("from CurrentOrder where PickupTimeStamp >= :fromTime and PickupTimeStamp <= :toTime ");
		lQuery.setParameter("fromTime", pFromCalendar, TemporalType.TIMESTAMP);
		lQuery.setParameter("toTime", pToCalendar, TemporalType.TIMESTAMP);
		
		List<CurrentOrderDTO> results = lQuery.getResultList();
		return results;
	}
	
	public List<CurrentOrderDTO> getOrdersBasedOnDropOffDate(Calendar pFromCalendar, Calendar pToCalendar)
	{
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = em.createQuery("from CurrentOrder where DropOffTimeStamp >= :fromTime and DropOffTimeStamp <= :toTime ");
		lQuery.setParameter("fromTime", pFromCalendar, TemporalType.TIMESTAMP);
		lQuery.setParameter("toTime", pToCalendar, TemporalType.TIMESTAMP);
		
		List<CurrentOrderDTO> results = lQuery.getResultList();
		return results;
	}
}
