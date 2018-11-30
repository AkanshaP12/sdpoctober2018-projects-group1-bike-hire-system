package edu.srh.bikehire.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.srh.bikehire.dto.Bike;

public class EntityManager {
	static EntityManagerFactory factory;
	static javax.persistence.EntityManager entityManager;
	
	public static void main(String[] args) {
		
		begin();

		create();
			
		end();
	}
	
	private static void begin() {
		factory = Persistence.createEntityManagerFactory("BikeHireSystemUnit");
		entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
	}
	
	private static void create() {
		Bike newBike = new Bike();
		newBike.setBikeId("1");
		newBike.setBikeTitle("BMW MOUNTAIN BIKE");
		newBike.setBikeTypeId("BMW1");
		newBike.setCreationTimeStamp("29-11-2018");
		newBike.setManufacturer("BMW");
		newBike.setWareHouseID("WH-001");
		newBike.setYearOfManufacture(2018);
		entityManager.persist(newBike);
	}
	
	private static void end() {
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
	}

}
