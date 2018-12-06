package edu.srh.bikehire.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.srh.bikehire.dao.OrderHistoryDAO;
import edu.srh.bikehire.dao.impl.util.PersistenceManager;
import edu.srh.bikehire.dto.OrderHistoryDTO;
import edu.srh.bikehire.dto.impl.OrderHistoryDTOImpl;

public class OrderHistoryDAOImpl implements OrderHistoryDAO {

	public OrderHistoryDTOImpl getOrderHistoryByOrderId(int pOrderId) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = em.createQuery("from OrderHistoryDTOImpl where OrderID = :typeId ");
		lQuery.setParameter("typeId", pOrderId);
		List<OrderHistoryDTOImpl> results = lQuery.getResultList();
		if(results == null || results.size() == 0)
		{
			return null;
		}
		return results.get(0);
	}

	public OrderHistoryDTO getOrderHistoryByInvoiceId(String pInvoiceId) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = em.createQuery("from OrderHistoryDTOImpl where InvoiceID = :typeId ");
		lQuery.setParameter("typeId", pInvoiceId);
		List<OrderHistoryDTOImpl> results = lQuery.getResultList();
		if(results == null || results.size() == 0)
		{
			return null;
		}
		return results.get(0);
	}

	public List<OrderHistoryDTO> getOrderHistoryByBikeId(int pBikeId) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = em.createQuery("from OrderHistoryDTOImpl where BikeID = :typeId ");
		lQuery.setParameter("typeId", pBikeId);
		List<OrderHistoryDTO> results = lQuery.getResultList();
		return results;
	}

	public List<OrderHistoryDTO> getOrderHistoryByUserId(int pUserId) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = em.createQuery("from OrderHistoryDTOImpl where UserID = :typeId ");
		lQuery.setParameter("typeId", pUserId);
		List<OrderHistoryDTO> results = lQuery.getResultList();
		return results;
	}

	public boolean addOrderHistory(OrderHistoryDTO pOrderHistoryDTO) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(pOrderHistoryDTO);
		em.getTransaction().commit();
		return true;
	}

}
