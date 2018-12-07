package edu.srh.bikehire.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.srh.bikehire.dao.UserCredentialDAO;
import edu.srh.bikehire.dao.impl.util.PersistenceManager;
import edu.srh.bikehire.dto.UserCredentialDTO;
import edu.srh.bikehire.dto.impl.UserCredentialDTOImpl;
import edu.srh.bikehire.dto.impl.UserDTOImpl;

public class UserCredentialDAOImpl implements UserCredentialDAO{

	public UserCredentialDTOImpl getUserCredentialByUserId(int pUserId) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = em.createQuery("from UserCredentialDTOImpl where UserID = :typeId ");
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
		Query lQuery = em.createQuery("from UserCredentialDTOImpl where UserName = :typeId ");
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
		Query lQuery = em.createQuery("UPDATE UserCredentialDTOImpl ucd SET ucd.passwordHash = :ph, ucd.passwordSalt = :ps, ucd.lastModifiedTimeStamp = :lm where ucd.userDTO =:identity");
		lQuery.setParameter("ph", pUserCredentialDTO.getPasswordHash());
		lQuery.setParameter("ps", pUserCredentialDTO.getPasswordSalt());
		lQuery.setParameter("lm", Calendar.getInstance());
		UserDTOImpl userDTO = new UserDTOImpl();
		userDTO.setId(lUserCredentialDTOImpl.getUserID());
		lQuery.setParameter("identity",userDTO);
		int rowsUpdated = lQuery.executeUpdate();
		em.getTransaction().commit();
		if(rowsUpdated <= 0)
		{
			return false;
		}
		return true;
	}

}
