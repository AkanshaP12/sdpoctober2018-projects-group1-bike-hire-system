package edu.srh.bikhire.jasper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.builders.FastReportBuilder;
import edu.srh.bikehire.exception.BikeHireSystemException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class GenerateReport {

	private ResultSet rs = null;

	public String generateQuery() {
		String queryString = "";
		String reportType = null;
		String bikeRentedReport = null;
		String startDate;
		String endDate;

		Scanner scanner = new Scanner(System.in);
		System.out.println("Do you want a report which contains the details of bike rented :  [y/n]");
		bikeRentedReport = scanner.nextLine().trim();

		System.out.println("Select the type of Report:  [daily/monthly/custom]");
		reportType = scanner.nextLine().trim();
		
	
		if(reportType == "custom") {
			System.out.println("Enter the start date in dd/mm/yyyy");
			startDate = scanner.nextLine().trim();
			endDate = scanner.nextLine().trim();
		}

		if ("y".equalsIgnoreCase(bikeRentedReport) && "daily".equalsIgnoreCase(reportType)) {
			queryString += "SELECT * FROM bikestatus WHERE MONTH(columnName) = MONTH(CURRENT_DATE())\r\n"
					+ "AND YEAR(columnName) = YEAR(CURRENT_DATE())'" + reportType + "'";
		} else if (!"".equalsIgnoreCase(bikeRentedReport) && "monthly".equalsIgnoreCase(reportType)) {
			queryString += "SELECT * FROM bikestatus WHERE MONTH(columnName) = MONTH(CURRENT_DATE())\r\n"
					+ "AND YEAR(columnName) = YEAR(CURRENT_DATE())'" + reportType + "'";
		} else if (!"".equalsIgnoreCase(bikeRentedReport) && "custom".equalsIgnoreCase(reportType)) {
			queryString += "SELECT * FROM bikestatus WHERE MONTH(columnName) = MONTH(CURRENT_DATE())\r\n"
					+ "AND YEAR(columnName) = YEAR(CURRENT_DATE())'" + "'";
		} else {
			queryString += "SELECT * FROM bikestatus WHERE MONTH(columnName) = MONTH(CURRENT_DATE())\r\n"
					+ "AND YEAR(columnName) = YEAR(CURRENT_DATE())'";
		}

		scanner.close();
		System.out.println();
		return queryString;

	}

	public void exportDailyReport() throws BikeHireSystemException, ClassNotFoundException, SQLException, JRException {

		String query = generateQuery();
		rs = connectToMySQL(query);
		FastReportBuilder reportBuilder = new FastReportBuilder();
		reportBuilder.addColumn("Bike Type ID", "BikeTypeId", String.class.getName(), 3)

				.addColumn("Type", "Type", String.class.getName(), 3)
				.addColumn("Age Category", "AgeCategory", String.class.getName(), 3)
				.addColumn("Creation TimeStamp", "CreationTimeStamp", String.class.getName(), 3)
				.setTitle("List Of Bike Type").setSubtitle("This report was generated at " + new Date())
				.setPrintBackgroundOnOddRows(true).setUseFullPageWidth(true);
		String path = storeConstants.file_directory_daily;
		JasperPrint jp = generateDJreport(rs, reportBuilder);
		exportPDF(jp, path);
	}

	public void exportMonthlyReport()
			throws BikeHireSystemException, ClassNotFoundException, SQLException, JRException {
		String query = generateQuery();
		rs = connectToMySQL(query);
		FastReportBuilder reportBuilder = new FastReportBuilder();
		reportBuilder.addColumn("Bike Type ID", "BikeTypeId", String.class.getName(), 3)

				.addColumn("Type", "Type", String.class.getName(), 3)
				.addColumn("Age Category", "AgeCategory", String.class.getName(), 3)
				.addColumn("Creation TimeStamp", "CreationTimeStamp", String.class.getName(), 3)
				.setTitle("List Of Bike Type").setSubtitle("This report was generated at " + new Date())
				.setPrintBackgroundOnOddRows(true).setUseFullPageWidth(true);
		String path = storeConstants.file_directory_monthly;
		JasperPrint jp = generateDJreport(rs, reportBuilder);
		exportPDF(jp, path);
	}

	public void exportCustomDateReport()
			throws BikeHireSystemException, ClassNotFoundException, SQLException, JRException {
		String query = generateQuery();
		rs = connectToMySQL(query);
		FastReportBuilder reportBuilder = new FastReportBuilder();
		reportBuilder.addColumn("Bike Type ID", "BikeTypeId", String.class.getName(), 3)

				.addColumn("Type", "Type", String.class.getName(), 3)
				.addColumn("Age Category", "AgeCategory", String.class.getName(), 3)
				.addColumn("Creation TimeStamp", "CreationTimeStamp", String.class.getName(), 3)
				.setTitle("List Of Bike Type").setSubtitle("This report was generated at " + new Date())
				.setPrintBackgroundOnOddRows(true).setUseFullPageWidth(true);
		String path = storeConstants.file_directory_custom;
		JasperPrint jp = generateDJreport(rs, reportBuilder);
		exportPDF(jp, path);

	}

	private JasperPrint generateDJreport(ResultSet rs, FastReportBuilder reportBuilder) throws JRException {
		DynamicReport djReport = reportBuilder.build();
		JRResultSetDataSource resultsetdatasource = new JRResultSetDataSource(rs);
		JasperPrint jp = DynamicJasperHelper.generateJasperPrint(djReport, new ClassicLayoutManager(),
				resultsetdatasource);
		JasperViewer.viewReport(jp);
		return jp;
	}

	private void exportPDF(JasperPrint jp, String path) throws JRException {
		JasperExportManager.exportReportToPdfFile(jp, path);
	}

	private ResultSet connectToMySQL(String query) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(storeConstants.sqlConnection, "root",
				storeConstants.sqlDB_password);

		Statement querystatement = connection.createStatement();

		rs = querystatement.executeQuery(query);
		return rs;
	}

}
