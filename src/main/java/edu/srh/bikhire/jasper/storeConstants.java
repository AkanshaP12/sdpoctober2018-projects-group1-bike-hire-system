package edu.srh.bikhire.jasper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class storeConstants {
	static Date date = new Date();
	static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	static String dateStr = dateFormat.format(date);
	static String file_directory_daily = System.getProperty("user.home") + "\\Documents\\SDPproject\\Reports\\DailyReports\\" + dateStr + " DailyReport.pdf";
	static String file_directory_monthly = System.getProperty("user.home") + "\\Documents\\SDPproject\\Reports\\MonthlyReports\\" + dateStr + " MonthlyReport.pdf";
	static String file_directory_custom = System.getProperty("user.home") + "\\Documents\\SDPproject\\Reports\\CustomDateReports\\" + dateStr + " CustomDateReport.pdf";
	static String sqlConnection = "jdbc:mysql://localhost:3306/bikehiresystemschema";
	static String sqlDB_password = "pramod";
}
