package edu.srh.bikehire.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.srh.bikehire.dao.InvoiceDAO;
import edu.srh.bikehire.daoimpl.util.PersistenceManager;
import edu.srh.bikehire.dto.InvoiceDTOImpl;
import edu.srh.bikehire.dtointerface.InvoiceDTO;
import edu.srh.bikehire.util.Util;

public class InvoiceDAOImpl implements InvoiceDAO {

	public InvoiceDTOImpl getInvoiceByInvoiceId(String pInvoiceId) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = em.createQuery("from Invoice where InvoiceID = :typeId ");
		lQuery.setParameter("typeId", pInvoiceId);
		List<InvoiceDTOImpl> results = lQuery.getResultList();
		if(results == null || results.size() == 0)
		{
			return null;
		}
		return results.get(0);
	}

	public InvoiceDTO getInvoiceByOrderId(String pOrderId) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = em.createQuery("from Invoice where OrderID = :typeId ");
		lQuery.setParameter("typeId", pOrderId);
		List<InvoiceDTOImpl> results = lQuery.getResultList();
		if(results == null || results.size() == 0)
		{
			return null;
		}
		return results.get(0);
	}

	public String addInvoice(InvoiceDTO pInvoiceDTO) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		//Generate random invoice id.
		String lstrInvoiceId = Util.getRandomAlphaNumericId();
		InvoiceDTOImpl lInvoiceDTOImpl = (InvoiceDTOImpl) pInvoiceDTO;
		lInvoiceDTOImpl.setInvoiceID(lstrInvoiceId);
		em.getTransaction().begin();
		em.persist(lInvoiceDTOImpl);
		em.getTransaction().commit();
		return lstrInvoiceId;
	}

}
