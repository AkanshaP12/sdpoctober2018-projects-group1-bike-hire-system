package edu.srh.bikhire.jasper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StoreConstants {
	
	public static final String FILE_DIRECTORY_DAILY = "/Reports/DailyReports/" + getDateInString() + " DailyReport.pdf";
	public static final String FILE_DIRECTORY_MONTHLY = "/Reports/MonthlyReports/" + getDateInString() + " MonthlyReport.pdf";
	public static final String FILE_DIRECTORY_CUSTOM = "/Reports/CustomDateReports/" + getDateInString() + " CustomDateReport.pdf";
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
