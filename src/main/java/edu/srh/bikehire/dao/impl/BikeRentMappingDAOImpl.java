package edu.srh.bikehire.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.srh.bikehire.dao.BikeRentMappingDAO;
import edu.srh.bikehire.dao.impl.util.PersistenceManager;
import edu.srh.bikehire.dto.BikeRentMappingDTO;
import edu.srh.bikehire.dto.impl.BikeRentMappingDTOImpl;

public class BikeRentMappingDAOImpl implements BikeRentMappingDAO {

	public BikeRentMappingDTOImpl getBikeRentMapping(String pBikeTypeId) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		
		Query lQuery = em.createQuery("from BikeRentMapping where BikeTypeId = :typeId ");
		lQuery.setParameter("typeId", pBikeTypeId);
		
		List<BikeRentMappingDTOImpl> lBikeRentMappings = lQuery.getResultList();
		if(lBikeRentMappings.size() == 0)
		{
			return null;
		}
		return lBikeRentMappings.get(0);
	}

	public boolean addBikeRentMapping(BikeRentMappingDTO pBikeRentMappingDTO) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(pBikeRentMappingDTO);
		em.getTransaction().commit();
		return true;
	}

	public boolean updateBikeRentMapping(BikeRentMappingDTO pBikeRentMappingDTO) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		
		BikeRentMappingDTOImpl lBikeRentMapping = getBikeRentMapping(pBikeRentMappingDTO.getBikeTypeId());
		em.getTransaction().begin();
		if(pBikeRentMappingDTO.getRentPerDay() != 0)
		{
			lBikeRentMapping.setRentPerDay(pBikeRentMappingDTO.getRentPerDay());
		}
		
		if(pBikeRentMappingDTO.getRentPerHour() != 0)
		{
			lBikeRentMapping.setRentPerHour(pBikeRentMappingDTO.getRentPerHour());
		}
		
		lBikeRentMapping.setLastModifiedTimeStamp(Calendar.getInstance());
		
		em.getTransaction().commit();
		return true;
	}

}
