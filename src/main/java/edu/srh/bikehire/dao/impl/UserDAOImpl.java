package edu.srh.bikehire.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.srh.bikehire.dao.UserDAO;
import edu.srh.bikehire.daoimpl.util.PersistenceManager;
import edu.srh.bikehire.dto.UserDTOImpl;
import edu.srh.bikehire.dtointerface.UserDTO;

public class UserDAOImpl implements UserDAO {

	public UserDTOImpl getUser(String pUserId) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = em.createQuery("from User where ID = :typeId ");
		lQuery.setParameter("typeId", pUserId);
		List<UserDTOImpl> results = lQuery.getResultList();
		if(results == null || results.size() == 0)
		{
			return null;
		}
		return results.get(0);
	}

	public boolean addUser(UserDTO pNewUser) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(pNewUser);
		em.getTransaction().commit();
		return true;
	}

	public boolean updateUser(UserDTO pUser) {
		
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		UserDTOImpl lUserDTOImpl = getUser(pUser.getId());
		em.getTransaction().begin();
		
		if(pUser.getAddress() != null)
		{
			lUserDTOImpl.setAddress(pUser.getAddress());
		}
		
		if(pUser.getFirstName() != null)
		{
			lUserDTOImpl.setFirstName(pUser.getFirstName());
		}
		
		if(pUser.getLastName() != null)
		{
			lUserDTOImpl.setLastName(pUser.getLastName());
		}
		
		if(pUser.getPhoneNo() != null)
		{
			lUserDTOImpl.setPhoneNo(pUser.getPhoneNo());
		}
		
		em.getTransaction().commit();
		return true;
		
	}

}
