package edu.srh.bikehire.dto;

import java.util.Calendar;

public interface BikeStockDTO {

	public String getBikeTypeId();
	public void setBikeTypeDTO(BikeTypeDTO pBikeTypeDTO);
	public long getTotalQuantity();
	public Calendar getCreationTimeStamp();
	public Calendar getLastModifiedTimeStamp();
}
