package edu.srh.bikehire.dashboard;

public enum BikeStatusType {

	AVALIABLE_BIKE(1,""),
	RENTED_BIKE(2,""),
	UNDERMAINTAINCE_BIKE(3,"");
	
	
	private int lbiketype;
	
	private String lbikestatus;
	
	
	private BikeStatusType(int ptype,String pstatus) {
		
		lbiketype = ptype;
		
		lbikestatus = pstatus;
		
		
		
		
	}
	
	
	
	
}
