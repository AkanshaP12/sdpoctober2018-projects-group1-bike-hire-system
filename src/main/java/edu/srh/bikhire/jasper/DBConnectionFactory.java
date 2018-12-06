package edu.srh.bikhire.jasper;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DBConnectionFactory {
	
	private static BasicDataSource basicDataSource  = null;
	
	private static final String DB_LOCK = "db_lock"; 
	
	private DBConnectionFactory()
	{
		
	}
	
	public static void initializeFactory()
	{
		synchronized (DB_LOCK) {
			if(basicDataSource != null)
			{
				return;
			}
			BasicDataSource basicDataSourceTemp = new BasicDataSource();
			basicDataSourceTemp.setDriverClassName(StoreConstants.SQL_DRIVER_CLASS_NAME);
			basicDataSourceTemp.setUrl(StoreConstants.SQL_CONNECTION_STRING);
			basicDataSourceTemp.setUsername(StoreConstants.SQL_USERNAME);
			basicDataSourceTemp.setPassword(StoreConstants.SQL_PASSWORD);
			
			basicDataSource = basicDataSourceTemp;
		}
	}
	
	public static Connection getNewConnection() throws SQLException
	{
		return basicDataSource.getConnection();
	}
}
