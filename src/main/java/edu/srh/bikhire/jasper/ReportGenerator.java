package edu.srh.bikhire.jasper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.builders.ColumnBuilderException;
import ar.com.fdvs.dj.domain.builders.FastReportBuilder;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class ReportGenerator {

	public void createRentedBikeReportToday() throws SQLException {
		Calendar fromCalendar = Calendar.getInstance();
		fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
		fromCalendar.set(Calendar.MINUTE, 0);
		fromCalendar.set(Calendar.SECOND, 0);
		fromCalendar.set(Calendar.MILLISECOND, 0);

		Calendar toCalendar = (Calendar) fromCalendar.clone();
		toCalendar.add(Calendar.DAY_OF_MONTH, 1);
		createRentedBikeReport(fromCalendar, toCalendar);
	}

	public void createRentedBikeReportMonthly(Calendar pStartDate) throws SQLException {
		Calendar fromCalendar = pStartDate;
		fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
		fromCalendar.set(Calendar.MINUTE, 0);
		fromCalendar.set(Calendar.SECOND, 0);
		fromCalendar.set(Calendar.MILLISECOND, 0);

		Calendar toCalendar = (Calendar) fromCalendar.clone();
		toCalendar.add(Calendar.DAY_OF_MONTH, 30);
		createRentedBikeReport(fromCalendar, toCalendar);
	}

	public void getRentedBikeReportWeekly(Calendar pStartDate) throws SQLException {
		Calendar fromCalendar = pStartDate;
		fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
		fromCalendar.set(Calendar.MINUTE, 0);
		fromCalendar.set(Calendar.SECOND, 0);
		fromCalendar.set(Calendar.MILLISECOND, 0);

		Calendar toCalendar = (Calendar) fromCalendar.clone();
		toCalendar.add(Calendar.DAY_OF_MONTH, 7);
		createRentedBikeReport(fromCalendar, toCalendar);
	}

	public void getInvoiceReportToday() throws SQLException {
		Calendar fromCalendar = Calendar.getInstance();
		fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
		fromCalendar.set(Calendar.MINUTE, 0);
		fromCalendar.set(Calendar.SECOND, 0);
		fromCalendar.set(Calendar.MILLISECOND, 0);

		Calendar toCalendar = (Calendar) fromCalendar.clone();
		toCalendar.add(Calendar.DAY_OF_MONTH, 1);
		createInvoiceReport(fromCalendar, toCalendar);
	}

	public void createInvoiceReportMonthly(Calendar pStartDate) throws SQLException {
		Calendar fromCalendar = pStartDate;
		fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
		fromCalendar.set(Calendar.MINUTE, 0);
		fromCalendar.set(Calendar.SECOND, 0);
		fromCalendar.set(Calendar.MILLISECOND, 0);

		Calendar toCalendar = (Calendar) fromCalendar.clone();
		toCalendar.add(Calendar.DAY_OF_MONTH, 30);
		createInvoiceReport(fromCalendar, toCalendar);
	}

	public void createInvoiceReportWeekly(Calendar pStartDate) throws SQLException {
		Calendar fromCalendar = pStartDate;
		fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
		fromCalendar.set(Calendar.MINUTE, 0);
		fromCalendar.set(Calendar.SECOND, 0);
		fromCalendar.set(Calendar.MILLISECOND, 0);

		Calendar toCalendar = (Calendar) fromCalendar.clone();
		toCalendar.add(Calendar.DAY_OF_MONTH, 7);
		createInvoiceReport(fromCalendar, toCalendar);
	}

	private void createRentedBikeReport(Calendar fromTime, Calendar toTime) throws SQLException, JRException, ColumnBuilderException, ClassNotFoundException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBConnectionFactory.getNewConnection();
			String query = "select * from RENTEDBIKEINFO where modifiedtime > ? AND modifiedtime < ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setTimestamp(0, new Timestamp(fromTime.getTimeInMillis()));
			preparedStatement.setTimestamp(1, new Timestamp(toTime.getTimeInMillis()));

			resultSet = preparedStatement.executeQuery();

			FastReportBuilder reportBuilder = new FastReportBuilder();
			DynamicReport djReport = reportBuilder.addColumn("Bike Type ID", "BikeTypeId", String.class.getName(), 50)
					.addColumn("Type", "Type", String.class.getName(), 50)
					.addColumn("Age Category", "AgeCategory", String.class.getName(), 50)
					.addColumn("Creation TimeStamp", "CreationTimeStamp", String.class.getName(), 50)
					.setTitle("Rented Bike Report").setSubtitle("This report was generated at " + new Date())
					.setPrintBackgroundOnOddRows(true).setUseFullPageWidth(true).build();
			String path = StoreConstants.FILE_DIRECTORY_CUSTOM;
			JRResultSetDataSource resultsetdatasource = new JRResultSetDataSource(resultSet);
			JasperPrint jp = DynamicJasperHelper.generateJasperPrint(djReport, new ClassicLayoutManager(),
					resultsetdatasource);
			JasperViewer.viewReport(jp);
			JasperExportManager.exportReportToPdfFile(jp, path);

		} finally {
			if (connection != null) {
				connection.close();
			}

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (resultSet != null) {
				resultSet.close();
			}
		}
	}

	private void createInvoiceReport(Calendar fromTime, Calendar toTime) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBConnectionFactory.getNewConnection();
			String query = "select * from INVOICEINFO where modifiedtime > ? AND modifiedtime < ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setTimestamp(0, new Timestamp(fromTime.getTimeInMillis()));
			preparedStatement.setTimestamp(1, new Timestamp(toTime.getTimeInMillis()));

			resultSet = preparedStatement.executeQuery();

			// ADD JASPER CODE

		} finally {
			if (connection != null) {
				connection.close();
			}

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (resultSet != null) {
				resultSet.close();
			}
		}
	}

}
