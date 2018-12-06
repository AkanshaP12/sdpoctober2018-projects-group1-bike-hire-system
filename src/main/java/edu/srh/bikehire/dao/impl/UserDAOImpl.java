package edu.srh.bikehire.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.srh.bikehire.dao.UserDAO;
import edu.srh.bikehire.dao.impl.util.PersistenceManager;
import edu.srh.bikehire.dto.UserDTO;
import edu.srh.bikehire.dto.impl.UserDTOImpl;
import edu.srh.bikehire.login.util.LoginUtil;

public class UserDAOImpl implements UserDAO {

	public UserDTOImpl getUser(int pUserId) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = em.createQuery("from UserDTOImpl where ID = :typeId ");
		lQuery.setParameter("typeId", pUserId);
		List<UserDTOImpl> results = lQuery.getResultList();
		if(results == null || results.size() == 0)
		{
			return null;
		}
		return results.get(0);
	}

	public UserDTO getUserByEmailId(String pEmailId) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = em.createQuery("from UserDTOImpl where EmailId = :typeId ");
		lQuery.setParameter("typeId", pEmailId);
		List<UserDTOImpl> results = lQuery.getResultList();
		if(results == null || results.size() == 0)
		{
			return null;
		}
		return results.get(0);
	}
	
	public int addUser(UserDTO pNewUser) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		//Generate user id
		//UserDTOImpl lUserDTOImpl = new UserDTOImpl();
		em.getTransaction().begin();
		em.persist(pNewUser);
		em.getTransaction().commit();
		return pNewUser.getId();
	}

	public boolean updateUser(UserDTO pUser) {
		
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		UserDTOImpl lUserDTOImpl = getUser(pUser.getId());
		em.getTransaction().begin();
		Query lQuery = em.createQuery("UPDATE UserDTOImpl ud SET ud.address = :add, ud.firstName = :fn, ud.lastName = :ln, ud.phoneNo = :pn where ud.id = :identity");
		
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
		lQuery.setParameter("add", lUserDTOImpl.getAddress());
		lQuery.setParameter("fn", lUserDTOImpl.getFirstName());
		lQuery.setParameter("ln", lUserDTOImpl.getLastName());
		lQuery.setParameter("pn", lUserDTOImpl.getPhoneNo());
		lQuery.setParameter("identity", lUserDTOImpl.getId());
		int rowsUpdated = lQuery.executeUpdate();
		em.getTransaction().commit();
		if(rowsUpdated <= 0)
		{
			return false;
		}
		return true;
	}

}
