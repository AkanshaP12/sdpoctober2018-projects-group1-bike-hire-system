package edu.srh.bikehire.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.srh.bikehire.dao.UserCredentialDAO;
import edu.srh.bikehire.dao.impl.util.PersistenceManager;
import edu.srh.bikehire.dto.UserCredentialDTO;
import edu.srh.bikehire.dto.impl.UserCredentialDTOImpl;

public class UserCredentialDAOImpl implements UserCredentialDAO{

	public UserCredentialDTOImpl getUserCredentialByUserId(int pUserId) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = em.createQuery("from Credentials where UserID = :typeId ");
		lQuery.setParameter("typeId", pUserId);
		List<UserCredentialDTOImpl> results = lQuery.getResultList();
		if(results == null || results.size() == 0)
		{
			return null;
		}
		return results.get(0);
	}

	public UserCredentialDTOImpl getUserCredentialByUserName(String pUserName) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = em.createQuery("from Credentials where UserName = :typeId ");
		lQuery.setParameter("typeId", pUserName);
		List<UserCredentialDTOImpl> results = lQuery.getResultList();
		if(results == null || results.size() == 0)
		{
			return null;
		}
		return results.get(0);
	}

	public boolean addUserCredential(UserCredentialDTO pUserCredentialDTO) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(pUserCredentialDTO);
		em.getTransaction().commit();
		return true;
	}

	public boolean updateUserCredential(UserCredentialDTO pUserCredentialDTO) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		UserCredentialDTOImpl lUserCredentialDTOImpl = null;
		if(pUserCredentialDTO.getUserID() > 0)
		{			
			lUserCredentialDTOImpl = getUserCredentialByUserId(pUserCredentialDTO.getUserID());
		}
		else
		{
			lUserCredentialDTOImpl = getUserCredentialByUserName(pUserCredentialDTO.getUserName());
		}
		em.getTransaction().begin();
		
		lUserCredentialDTOImpl.setPasswordHash(pUserCredentialDTO.getPasswordHash());
		lUserCredentialDTOImpl.setPasswordSalt(pUserCredentialDTO.getPasswordSalt());
		lUserCredentialDTOImpl.setLastModifiedTimeStamp(Calendar.getInstance());
		
		em.getTransaction().commit();
		return true;
	}

}
