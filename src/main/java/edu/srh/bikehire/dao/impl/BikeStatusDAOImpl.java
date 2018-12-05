package edu.srh.bikehire.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.srh.bikehire.dao.BikeStatusDAO;
import edu.srh.bikehire.dao.impl.util.PersistenceManager;
import edu.srh.bikehire.dto.BikeDTO;
import edu.srh.bikehire.dto.BikeStatusDTO;
import edu.srh.bikehire.dto.impl.BikeStatusDTOImpl;

public class BikeStatusDAOImpl implements BikeStatusDAO {

	public BikeStatusDTOImpl getBikeStatus(int pBikeId) {
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
		if(pBikeStatus.getLastServiceDate() != null)
		{			
			lOrgBikeStatus.setLastServiceDate(pBikeStatus.getLastServiceDate());
		}
		lOrgBikeStatus.setLastModifiedDate(Calendar.getInstance());
		em.getTransaction().commit();
		return true;
	}
	
	public List<BikeDTO> getAllBikesBasedOnStatus(String pStatus, boolean sortPriceDescending) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = null;
		
		if(sortPriceDescending)
		{
			lQuery = em.createQuery("select b from Bike b, BikeStatus bs where b.bikeId = bs.bike and bs.status = :statusType Order by b.depositAmount DESC");
		}
		else
		{	
			lQuery = em.createQuery("select b from Bike b, BikeStatus bs where b.bikeId = bs.bike and bs.status = :statusType Order by b.depositAmount ASC");
		}
		
		lQuery.setParameter("statusType", pStatus);
		List<BikeDTO> lBikes = lQuery.getResultList();
		return lBikes;
	}
	
	public long getBikeCount(String pStatus, int pBikeTypeId)
	{
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Query lQuery = em.createQuery("select count(bs) from BikeStatus bs, Bike b, BikeType bt where b.bikeId = bs.bike and bs.status = :bikestatus and b.bikeType = bt.bikeTypeId and bt.bikeTypeId = :biketyp");
        lQuery.setParameter("bikestatus", pStatus);
        lQuery.setParameter("biketyp", pBikeTypeId);
        return (Long) lQuery.getSingleResult();
	}
}
