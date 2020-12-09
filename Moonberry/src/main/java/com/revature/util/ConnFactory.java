package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {
//	//singleton Factory
	
	//pain peko
	//hard coding cuz war doesn't like db.prop
	private String url = "jdbc:postgresql://nrobinson.csx9icmpd5xi.us-east-2.rds.amazonaws.com:5432/trmsdb";
	private String username = "moonflower";
	private String password = "NightSkyKidMoon";
	
	
		private static ConnFactory cf;
		
		//private no args constructor
		
		private ConnFactory() {
			super();
		}
		
		
		public static synchronized ConnFactory getInstance() {
			if(cf == null) {
				cf = new ConnFactory();
			}
			return cf;
		}
		
		//method that do stuff
		public Connection getConnection() {
			Connection conn = null;
			Properties prop = new Properties();
			try {
//				try {
//					prop.load(new FileReader("database.properties"));
//				} catch (FileNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				Class.forName("org.postgresql.Driver");  
//				conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
				conn = DriverManager.getConnection(this.url, this.username, this.password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return conn;
			
		}
	
}
