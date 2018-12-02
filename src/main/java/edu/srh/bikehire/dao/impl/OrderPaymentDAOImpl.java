package edu.srh.bikehire.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.srh.bikehire.dao.OrderPaymentDAO;
import edu.srh.bikehire.daoimpl.util.PersistenceManager;
import edu.srh.bikehire.dto.OrderPaymentDTOImpl;
import edu.srh.bikehire.dtointerface.OrderPaymentDTO;

public class OrderPaymentDAOImpl implements OrderPaymentDAO {

	public OrderPaymentDTOImpl getOrderPaymentByPaymentReference(String pPaymentReference) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = em.createQuery("from OrderPayment where PaymentReference = :typeId ");
		lQuery.setParameter("typeId", pPaymentReference);
		List<OrderPaymentDTOImpl> results = lQuery.getResultList();
		if(results == null || results.size() == 0)
		{
			return null;
		}
		return results.get(0);
	}

	public OrderPaymentDTO getOrderPaymentByOrderId(String pOrderId) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = em.createQuery("from OrderPayment where OrderID = :typeId ");
		lQuery.setParameter("typeId", pOrderId);
		List<OrderPaymentDTOImpl> results = lQuery.getResultList();
		if(results == null || results.size() == 0)
		{
			return null;
		}
		return results.get(0);
	}

	public boolean addOrderPayment(OrderPaymentDTO pOrderPaymentDTO) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(pOrderPaymentDTO);
		em.getTransaction().commit();
		return true;
	}

}
