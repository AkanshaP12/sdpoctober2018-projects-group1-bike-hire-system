package edu.srh.bikehire.jasper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StoreConstants {
	
	public static final String FILE_DIRECTORY_BIKERENTEDREPORTS_DAILY = System.getProperty("user.dir") + "/Reports/BikeRentedReports/DailyReports/" + getDateInString() + " DailyReport.xlsx";
	public static final String FILE_DIRECTORY_BIKERENTEDREPORTS_WEEKLY = System.getProperty("user.dir") + "/Reports/BikeRentedReports/WeeklyReports/" + getDateInString() + " WeeklyReport.xlsx";
	public static final String FILE_DIRECTORY_BIKERENTEDREPORTS_MONTHLY = System.getProperty("user.dir") + "/Reports/BikeRentedReports/MonthlyReports/" + getDateInString() + " MonthlyReport.xlsx";
	public static final String FILE_DIRECTORY_INVOICEREPORTS_DAILY = System.getProperty("user.dir") + "/Reports/InvoiceReports/DailyReports/" + getDateInString() + " DailyReport.xlsx";
	public static final String FILE_DIRECTORY_INVOICEREPORTS_WEEKLY = System.getProperty("user.dir") + "/Reports/InvoiceReports/WeeklyReports/" + getDateInString() + " WeeklyReport.xlsx";
	public static final String FILE_DIRECTORY_INVOICEREPORTS_MONTHLY = System.getProperty("user.dir") + "/Reports/InvoiceReports/MonthlyReports/" + getDateInString() + " MonthlyReport.xlsx";
	public static final String SQL_CONNECTION_STRING = "jdbc:mysql://localhost:3306/jpa_db";
	public static final String SQL_USERNAME = "root";
	public static final String SQL_PASSWORD = "pramod";
	public static final String SQL_DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	
	public static String getDateInString()
	{
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		String dateStr = dateFormat.format(date);
		return dateStr;
	}
}
