package com.dhruv.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBConnection {

	
	public static Connection CONN=null;
	
	public static Connection getConnection() throws SQLException {

		if (CONN == null) {
			
			
			String url1 = "jdbc:mysql://localhost:3306/learndb";
			String user = "root";
			String password = "root";
			CONN = DriverManager.getConnection(url1, user, password);
			if (CONN != null) {
				System.out.println("Connected to the database test1");
			}
			
		
			
		}
		return CONN;
	}
	
	public static List<Map<String, String>> getResultByQuery(String sql) throws SQLException {
		if (sql == null) {
			return null;
		}

		List<Map<String, String>> table = null;
		Connection connection = getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		if (rs != null) {

			table = new ArrayList<Map<String, String>>();
			while (rs.next()) {

				int colCount = rs.getMetaData().getColumnCount();
				int i = 1;
				Map<String, String> row = new HashMap<String, String>();
				while (i <= colCount) {
					String colName = rs.getMetaData().getColumnName(i);
					String value = rs.getString(i);
					row.put(colName, value);
					i++;
				}
				table.add(row);
			}
		}
		return table;

	}
	
	
	public static int updateBySql(String sql) throws SQLException {
		if (sql == null) {
			return -1;
		}

		Connection connection = getConnection();
		PreparedStatement preparedStmt = connection.prepareStatement(sql);
		int rowUpdate=preparedStmt.executeUpdate();
		return rowUpdate;

	}
	
	
	public static void testCOnnection() throws SQLException
	{
		 String url1 = "jdbc:mysql://localhost:3306/learndb";
		                     //https://www.w3schools.com/sq
         String user = "root";
         String password = "root";

         Connection  conn1 = DriverManager.getConnection(url1, user, password);
         if (conn1 != null) {
             System.out.println("Connected to the database test1");
         }
         
         Statement stmt=conn1.createStatement();            
         ResultSet rs=stmt.executeQuery("Select * from users");  
         if(rs!=null)
         {
        	while (rs.next())
        	{
             String id = rs.getString("id");
             String Name = rs.getString("name");
             System.out.println("ID :"+id +" Name: "+Name);
          
           }
         }
	}
}
