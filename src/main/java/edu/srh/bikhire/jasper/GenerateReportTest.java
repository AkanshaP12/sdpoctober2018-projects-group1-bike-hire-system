package edu.srh.bikhire.jasper;

import java.sql.SQLException;
import edu.srh.bikehire.exception.BikeHireSystemException;
import net.sf.jasperreports.engine.JRException;

public class GenerateReportTest {

	public static void main(String[] args) throws ClassNotFoundException, BikeHireSystemException, SQLException, JRException {
		DBConnectionFactory.initializeFactory();
		GenerateReport er = new GenerateReport();
		//er.exportDailyReport();
		//er.exportMonthlyReport();
		//er.exportCustomDateReport();
		er.generateQuery();
		}
}