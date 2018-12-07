package edu.srh.bikehire.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.srh.bikehire.dao.UserAccountDAO;
import edu.srh.bikehire.dao.impl.util.PersistenceManager;
import edu.srh.bikehire.dto.UserAccountDTO;
import edu.srh.bikehire.dto.impl.UserAccountDTOImpl;
import edu.srh.bikehire.dto.impl.UserDTOImpl;

public class UserAccountDAOImpl implements UserAccountDAO{

	public UserAccountDTOImpl getUserAccount(int pUserId) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = em.createQuery("from UserAccountDTOImpl where ID = :typeId ");
		lQuery.setParameter("typeId", pUserId);
		List<UserAccountDTOImpl> results = lQuery.getResultList();
		if(results == null || results.size() == 0)
		{
			return null;
		}
		return results.get(0);
	}

	public UserAccountDTOImpl getUserAccountUsingUserName(String pUserName)
	{
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = em.createQuery("from UserAccountDTOImpl where UserName = :typeId ");
		lQuery.setParameter("typeId", pUserName);
		List<UserAccountDTOImpl> results = lQuery.getResultList();
		if(results == null || results.size() == 0)
		{
			return null;
		}
		return results.get(0);
	}
	
	public boolean addUserAccount(UserAccountDTO pUserAccountDTO) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(pUserAccountDTO);
		em.getTransaction().commit();
		return true;
	}

	public boolean updateUserAccount(UserAccountDTO pUserAccountDTO) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		Query lQuery = em.createQuery("UPDATE UserAccountDTOImpl uad SET uad.accountStatus = :as, uad.lastModifiedTimeStamp= :lm where uad.userDTO = :identity ");
		lQuery.setParameter("as", pUserAccountDTO.getAccountStatus());
		lQuery.setParameter("lm", Calendar.getInstance());
		UserDTOImpl lUserDTO = new UserDTOImpl();
		lUserDTO.setId(pUserAccountDTO.getId());
		lQuery.setParameter("identity", lUserDTO);
		int rowsUpdated = lQuery.executeUpdate();
		em.getTransaction().commit();
		if(rowsUpdated <= 0)
		{
			return false;
		}
		return true;
	}

}
