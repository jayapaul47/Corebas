package com.umtest.testframe.lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.zaxxer.hikari.HikariDataSource;

public class SQLConnectionHelper {
	private static Logger logger = LogManager.getLogger(SQLConnectionHelper.class);
	private static String testDBIP;
	private static String testDBPort;
	private static String testDBSchema;
	private static String testDBUsername;
	private static String testDBPassword;
	
	private static String selfcareDBIP;
	private static String selfcareDBPort;
	private static String selfcareDBSchema;
	private static String selfcareDBUsername;
	private static String selfcareDBPassword;
	
	private static String crmDBIP;
	private static String crmDBPort;
	private static String crmDBSchema;
	private static String crmDBUsername;
	private static String crmDBPassword;

	private static HikariDataSource testDBSource;
	private static HikariDataSource crmDBSource;
	private static HikariDataSource selfcareDBSource;


	/*static {
		testDBIP = PropertyHelper.getProperties("TEST_DB_IP");
		testDBPort = PropertyHelper.getProperties("TEST_DB_PORT");
		testDBSchema = PropertyHelper.getProperties("TEST_DB_UM_SCHEMA");
		testDBUsername = PropertyHelper.getProperties("TEST_DB_USERNAME");
		testDBPassword = PropertyHelper.getProperties("TEST_DB_PASSWORD");
		System.out.println(testDBIP +";"+ testDBPort +";"+ testDBSchema +";"+ testDBUsername +";"+ testDBPassword);
	}*/

	private SQLConnectionHelper() {
	}

	public static Connection getTestDBConnection() throws Exception
	{
		testDBIP = PropertyHelper.getProperties("TEST_DB_IP");
		testDBPort = PropertyHelper.getProperties("TEST_DB_PORT");
		testDBSchema = PropertyHelper.getProperties("TEST_DB_UM_SCHEMA");
		testDBUsername = PropertyHelper.getProperties("TEST_DB_USERNAME");
		testDBPassword = PropertyHelper.getProperties("TEST_DB_PASSWORD");

		String DB_URL = "jdbc:mysql://"+testDBIP+":"+testDBPort+"/"+testDBSchema+"?useSSL=false&useTimezone=true&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

		Connection con = DriverManager.getConnection(DB_URL, testDBUsername, testDBPassword);
		return con;

	}
	
	public static Connection getSelfcareDBConnection() throws Exception
	{
		selfcareDBIP = PropertyHelper.getENVProperties("SELFCARE_DB_IP");
		selfcareDBPort = PropertyHelper.getENVProperties("SELFCARE_DB_PORT");
		selfcareDBSchema = PropertyHelper.getENVProperties("SELFCARE_DB_UM_SCHEMA");
		selfcareDBUsername = PropertyHelper.getENVProperties("SELFCARE_DB_USERNAME");
		selfcareDBPassword = PropertyHelper.getENVProperties("SELFCARE_DB_PASSWORD");

		String DB_URL = "jdbc:mysql://"+selfcareDBIP+":"+selfcareDBPort+"/"+selfcareDBSchema+"?useTimezone=true&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

		Connection con = DriverManager.getConnection(DB_URL, selfcareDBUsername, selfcareDBPassword);
		return con;

	}
	
	public static Connection getCRMConnection() throws Exception
	{
		crmDBIP = PropertyHelper.getENVProperties("CRM_DB_IP");
		crmDBPort = PropertyHelper.getENVProperties("CRM_DB_PORT");
		crmDBSchema = PropertyHelper.getENVProperties("CRM_DB_UM_SCHEMA");
		crmDBUsername = PropertyHelper.getENVProperties("CRM_DB_USERNAME");
		crmDBPassword = PropertyHelper.getENVProperties("CRM_DB_PASSWORD");

		String DB_URL = "jdbc:mysql://"+crmDBIP+":"+crmDBPort+"/"+crmDBSchema+"?useTimezone=true&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

		Connection con = DriverManager.getConnection(DB_URL, crmDBUsername, crmDBPassword);
		return con;

	}

	private void closeTestDBConnection(Connection con) throws Exception
	{
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
			}
		}
	}


	/*private static HikariDataSource setMySqlConnDS(String ip, String port, String schema, String userName,
			String password, int min, int max) {
		logger.info("calling setMySqlConnDS");
		HikariConfig config = new HikariConfig();
		HikariDataSource hikariDataSource;
		config.setJdbcUrl("jdbc:mysql://" + ip + ":" + port + "/" + schema + "?autoReconnect=true&useSSL=false");
		config.setMinimumIdle(0);
		config.setMaximumPoolSize(100);
		config.setUsername(userName);
		config.setPassword(password);
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		hikariDataSource = new HikariDataSource(config);
		return hikariDataSource;
	}*/

	/*public static Connection getTestDBConnectionOld() {
		try {
			logger.info("Getting the Test Database Connection from the pool");
			return testDBSource.getConnection();
		} catch (SQLException sqe) {
			logger.error("Error in getting the database connection from the pool", sqe);
		}
		return null;
	}*/


	public static Connection getDBConnection(String dbname) {
		try {
			switch (dbname) {
			case "CRM":
				return crmDBSource.getConnection();
			case "SELFCARE":
				return selfcareDBSource.getConnection();
			default:
				throw new IllegalStateException("Unexpected value: " + dbname);
			}
		} catch (SQLException e) {
			logger.error("Error while accessing the connection\n", e);
		}
		return null;
	}


	public static void closeDBConnPool() {
		{
			logger.info("Closing the DB Connection Pool");
			logger.info("Closing Test DB Source");
			//testDBSource.close();

		}
	}
}