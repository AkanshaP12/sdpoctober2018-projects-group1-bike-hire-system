package edu.srh.bikehire.dao;

import java.math.BigInteger;

import edu.srh.bikehire.dtointerface.Bike;

public interface BikeDao {
	
	public Bike getBike(String iD);
	public Bike getallbike();

}
