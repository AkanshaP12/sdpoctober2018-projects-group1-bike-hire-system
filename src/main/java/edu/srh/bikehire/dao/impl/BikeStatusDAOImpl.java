package edu.srh.bikehire.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.srh.bikehire.dao.BikeStatusDAO;
import edu.srh.bikehire.daoimpl.util.PersistenceManager;
import edu.srh.bikehire.dto.BikeStatusDTOImpl;
import edu.srh.bikehire.dtointerface.BikeStatusDTO;

public class BikeStatusDAOImpl implements BikeStatusDAO {

	public BikeStatusDTOImpl getBikeStatus(String pBikeId) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		
		Query lQuery = em.createQuery("from BikeStatus where BikeId = :typeId ");
		lQuery.setParameter("typeId", pBikeId);
		
		List<BikeStatusDTOImpl> lBikeStatues = lQuery.getResultList();
		if(lBikeStatues.size() == 0)
		{
			return null;
		}
		return lBikeStatues.get(0);
	}

	public boolean addBikeStatus(BikeStatusDTO pBikeStatus) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(pBikeStatus);
		em.getTransaction().commit();
		return true;
	}

	public boolean updateBikeStatus(BikeStatusDTO pBikeStatus) {
		BikeStatusDTOImpl lOrgBikeStatus = getBikeStatus(pBikeStatus.getBikeId());
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		lOrgBikeStatus.setStatus(pBikeStatus.getStatus());
		lOrgBikeStatus.setLastServiceDate(pBikeStatus.getLastServiceDate());
		lOrgBikeStatus.setLastModifiedDate(Calendar.getInstance());
		em.getTransaction().commit();
		return true;
	}

	public List<BikeStatusDTO> getAllBikesBasedOnStatus(String pStatus) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = em.createQuery("from BikeStatus where Status = :statusType ");
		lQuery.setParameter("statusType", pStatus);
		//If fails, use BikeStatusDTOImpl
		List<BikeStatusDTO> lBikeStatues = lQuery.getResultList();
		return lBikeStatues;
	}
}
