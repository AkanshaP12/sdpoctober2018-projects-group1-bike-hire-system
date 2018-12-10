package edu.srh.bikehire.jasper;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import net.sf.jasperreports.view.JasperViewer;

public class ReportGenerator {

	public void createRentedBikeReportToday()
			throws SQLException, ColumnBuilderException, ClassNotFoundException, JRException, FileNotFoundException {
		Calendar fromCalendar = Calendar.getInstance();
		fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
		fromCalendar.set(Calendar.MINUTE, 0);
		fromCalendar.set(Calendar.SECOND, 0);
		fromCalendar.set(Calendar.MILLISECOND, 0);
		Calendar toCalendar = (Calendar) fromCalendar.clone();
		toCalendar.add(Calendar.DAY_OF_MONTH, 1);
		System.out.println(fromCalendar + "  " + toCalendar);
		String path = StoreConstants.FILE_DIRECTORY_BIKERENTEDREPORTS_DAILY;
		createRentedBikeReport(fromCalendar, toCalendar, path);

	}

	public void createRentedBikeReportMonthly(Calendar pStartDate)
			throws SQLException, ColumnBuilderException, ClassNotFoundException, JRException, FileNotFoundException {
		Calendar fromCalendar = pStartDate;
		fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
		fromCalendar.set(Calendar.MINUTE, 0);
		fromCalendar.set(Calendar.SECOND, 0);
		fromCalendar.set(Calendar.MILLISECOND, 0);
		Calendar toCalendar = (Calendar) fromCalendar.clone();
		toCalendar.add(Calendar.DAY_OF_MONTH, 30);
		String path = StoreConstants.FILE_DIRECTORY_BIKERENTEDREPORTS_MONTHLY;
		createRentedBikeReport(fromCalendar, toCalendar, path);
	}

	public void createRentedBikeReportWeekly(Calendar pStartDate)
			throws SQLException, ColumnBuilderException, ClassNotFoundException, JRException, FileNotFoundException {
		Calendar fromCalendar = pStartDate;
		fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
		fromCalendar.set(Calendar.MINUTE, 0);
		fromCalendar.set(Calendar.SECOND, 0);
		fromCalendar.set(Calendar.MILLISECOND, 0);
		Calendar toCalendar = (Calendar) fromCalendar.clone();
		toCalendar.add(Calendar.DAY_OF_MONTH, 7);
		String path = StoreConstants.FILE_DIRECTORY_BIKERENTEDREPORTS_WEEKLY;
		createRentedBikeReport(fromCalendar, toCalendar, path);
	}

	public void createInvoiceReportToday()
			throws SQLException, ColumnBuilderException, ClassNotFoundException, JRException, FileNotFoundException {
		Calendar fromCalendar = Calendar.getInstance();
		fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
		fromCalendar.set(Calendar.MINUTE, 0);
		fromCalendar.set(Calendar.SECOND, 0);
		fromCalendar.set(Calendar.MILLISECOND, 0);
		Calendar toCalendar = (Calendar) fromCalendar.clone();
		toCalendar.add(Calendar.DAY_OF_MONTH, 1);
		String path = StoreConstants.FILE_DIRECTORY_INVOICEREPORTS_DAILY;
		createInvoiceReport(fromCalendar, toCalendar, path);
	}

	public void createInvoiceReportMonthly(Calendar pStartDate)
			throws SQLException, ColumnBuilderException, ClassNotFoundException, JRException, FileNotFoundException {
		Calendar fromCalendar = pStartDate;
		fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
		fromCalendar.set(Calendar.MINUTE, 0);
		fromCalendar.set(Calendar.SECOND, 0);
		fromCalendar.set(Calendar.MILLISECOND, 0);
		Calendar toCalendar = (Calendar) fromCalendar.clone();
		toCalendar.add(Calendar.DAY_OF_MONTH, 30);
		String path = StoreConstants.FILE_DIRECTORY_INVOICEREPORTS_MONTHLY;
		createInvoiceReport(fromCalendar, toCalendar, path);
	}

	public void createInvoiceReportWeekly(Calendar pStartDate)
			throws SQLException, ColumnBuilderException, ClassNotFoundException, JRException, FileNotFoundException {
		Calendar fromCalendar = pStartDate;
		fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
		fromCalendar.set(Calendar.MINUTE, 0);
		fromCalendar.set(Calendar.SECOND, 0);
		fromCalendar.set(Calendar.MILLISECOND, 0);
		Calendar toCalendar = (Calendar) fromCalendar.clone();
		toCalendar.add(Calendar.DAY_OF_MONTH, 7);
		String path = StoreConstants.FILE_DIRECTORY_INVOICEREPORTS_WEEKLY;
		createInvoiceReport(fromCalendar, toCalendar, path);
	}

	private void createRentedBikeReport(Calendar fromTime, Calendar toTime, String path)
			throws SQLException, JRException, ColumnBuilderException, ClassNotFoundException, FileNotFoundException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBConnectionFactory.getNewConnection();
			String query = "select * from RENTEDBIKEINFO where modifiedtime > ? AND modifiedtime < ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setTimestamp(1, new Timestamp(fromTime.getTimeInMillis()));
			preparedStatement.setTimestamp(2, new Timestamp(toTime.getTimeInMillis()));

			resultSet = preparedStatement.executeQuery();

			FastReportBuilder reportBuilder = new FastReportBuilder();
			DynamicReport djReport = reportBuilder.addColumn("ORDER ID", "ORDERID", String.class.getName(), 50)
					.addColumn("BIKE ID", "BIKEID", String.class.getName(), 50)
					.addColumn("BIKE TYPE", "BIKETYPE", String.class.getName(), 50)
					.addColumn("BIKE NAME", "BIKENAME", String.class.getName(), 50)
					.addColumn("USER ID", "USERID", String.class.getName(), 50)
					.addColumn("USER EMAIL", "USEREMAIL", String.class.getName(), 50)
					.addColumn("DEPOSIT", "DEPOSIT", String.class.getName(), 50)
					.addColumn("MODIFIED TIME", "MODIFIEDTIME", String.class.getName(), 50)
					.setTitle("Rented Bike Report").setSubtitle("This report was generated at " + new Date())
					.setPrintBackgroundOnOddRows(true).setUseFullPageWidth(true).build();
			JRResultSetDataSource resultsetdatasource = new JRResultSetDataSource(resultSet);
			JasperPrint jp = DynamicJasperHelper.generateJasperPrint(djReport, new ClassicLayoutManager(),
					resultsetdatasource);
			JasperViewer.viewReport(jp);

			// excel
			generateExcelReport(jp, path);

			// pdf
			// JasperExportManager.exportReportToPdfFile(jp, path);

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

	/**
	 * @param jp
	 * @throws FileNotFoundException
	 * @throws JRException
	 */
	private void generateExcelReport(JasperPrint jp, String path) throws FileNotFoundException, JRException {
		JRXlsxExporter xlsExporter = new JRXlsxExporter();
		xlsExporter.setExporterInput(new SimpleExporterInput(jp));
		
		FileOutputStream filePath = new FileOutputStream(path);
		
		xlsExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(filePath));
		SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
		configuration.setDetectCellType(true);
		configuration.setCollapseRowSpan(false);
		xlsExporter.setConfiguration(configuration);
		xlsExporter.exportReport();
	}

	private void createInvoiceReport(Calendar fromTime, Calendar toTime, String path)
			throws SQLException, ColumnBuilderException, ClassNotFoundException, JRException, FileNotFoundException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBConnectionFactory.getNewConnection();
			String query = "select * from INVOICEINFO where modifiedtime > ? AND modifiedtime < ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setTimestamp(1, new Timestamp(fromTime.getTimeInMillis()));
			preparedStatement.setTimestamp(2, new Timestamp(toTime.getTimeInMillis()));

			resultSet = preparedStatement.executeQuery();

			FastReportBuilder reportBuilder = new FastReportBuilder();
			DynamicReport djReport = reportBuilder.addColumn("INVOICE ID", "INVOICEID", String.class.getName(), 50)
					.addColumn("BIKE TYPE", "BIKETYPE", String.class.getName(), 50)
					.addColumn("USER ID", "USERID", String.class.getName(), 50)
					.addColumn("MODIFIED TIME", "MODIFIEDTIME", String.class.getName(), 50)
					.addColumn("DAMAGE CHARGES", "DAMAGECHARGES", String.class.getName(), 50)
					.addColumn("AMOUNT PAID", "AMOUNTPAID", String.class.getName(), 50).setTitle("Invoice Report")
					.setSubtitle("This report was generated at " + new Date()).setPrintBackgroundOnOddRows(true)
					.setUseFullPageWidth(true).build();
			JRResultSetDataSource resultsetdatasource = new JRResultSetDataSource(resultSet);
			JasperPrint jp = DynamicJasperHelper.generateJasperPrint(djReport, new ClassicLayoutManager(),
					resultsetdatasource);
			JasperViewer.viewReport(jp);

			// excel
			generateExcelReport(jp, path);

			// pdf
			// JasperExportManager.exportReportToPdfFile(jp, path);

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
