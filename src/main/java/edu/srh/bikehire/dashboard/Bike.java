package edu.srh.bikehire.dashboard;

public class Bike<varchar> {
	
	private Object avaliablebike;
	private Object Bikeid;
	
	
	

	public varchar Bikeid() {
		
		while ( avaliablebike.next()) {
            int Bikeid = avaliablebike.getInt("Bikeid");
            System.out.println("Bikeid+");   
	}
	
	public varchar Biketypeid()
	{
		int Biketypeid = avaliablebike.getString("Biketypeid");
		System.out.println("Biketypeid+");
		
		
	}
	 
		 
	 }
	 
	

}
