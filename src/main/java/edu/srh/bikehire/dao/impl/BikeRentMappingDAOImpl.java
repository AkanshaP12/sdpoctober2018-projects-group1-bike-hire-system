package edu.srh.bikehire.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.srh.bikehire.dao.BikeRentMappingDAO;
import edu.srh.bikehire.dao.impl.util.PersistenceManager;
import edu.srh.bikehire.dto.BikeRentMappingDTO;
import edu.srh.bikehire.dto.impl.BikeDTOImpl;
import edu.srh.bikehire.dto.impl.BikeRentMappingDTOImpl;
import edu.srh.bikehire.dto.impl.BikeTypeDTOImpl;

public class BikeRentMappingDAOImpl implements BikeRentMappingDAO {

	public BikeRentMappingDTOImpl getBikeRentMapping(int pBikeTypeId) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		
		Query lQuery = em.createQuery("from BikeRentMappingDTOImpl where BikeTypeId = :typeId ");
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
		if(pBikeRentMappingDTO.getRentPerDay() != 0)
		{
			lBikeRentMapping.setRentPerDay(pBikeRentMappingDTO.getRentPerDay());
		}
		
		if(pBikeRentMappingDTO.getRentPerHour() != 0)
		{
			lBikeRentMapping.setRentPerHour(pBikeRentMappingDTO.getRentPerHour());
		}
		em.getTransaction().begin();
		
		Query lQuery = em.createQuery("UPDATE BikeRentMappingDTOImpl brm SET brm.rentPerHour = :rph, brm.rentPerDay = :rpd, brm.lastModifiedTimeStamp = :lm where brm.bikeType = :bikeTypeId");
		lQuery.setParameter("rph", lBikeRentMapping.getRentPerHour());
		lQuery.setParameter("rpd", lBikeRentMapping.getRentPerDay());
		lQuery.setParameter("lm", Calendar.getInstance());
		BikeTypeDTOImpl bikeTypeDTO = new BikeTypeDTOImpl();
		bikeTypeDTO.setBikeTypeId(pBikeRentMappingDTO.getBikeTypeId());
		lQuery.setParameter("bikeTypeId", bikeTypeDTO);
		int rowsUpdated = lQuery.executeUpdate();
		em.getTransaction().commit();
		if(rowsUpdated <= 0)
		{
			return false;
		}
		return true;
	}

}
