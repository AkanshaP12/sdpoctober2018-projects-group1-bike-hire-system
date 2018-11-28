package edu.srh.bikehire.dtointerface;

import java.math.BigInteger;
import java.sql.Timestamp;

public interface BikeType {
	
	public BigInteger getBikeTypeId();
	public String getType();
	public String getAgeCategory();
	public Timestamp getCreationTimeStamp();	

}
