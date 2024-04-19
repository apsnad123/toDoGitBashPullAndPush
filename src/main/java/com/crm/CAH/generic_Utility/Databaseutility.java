package com.crm.CAH.generic_Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Databaseutility {
	
	Connection con=null;
	
	public void connectToDB() throws SQLException {
		//Step1:register the driver
		 Driver driver = new Driver();
		 DriverManager.registerDriver(driver);
	
		//Step2:get the connection to the database
		con=DriverManager.getConnection(IPathConstant.DBURL, IPathConstant.DBUsername, IPathConstant.DBPassword);
	}
	
	public void executeAndgetdata(String querry,int colIndex, String expData) throws SQLException {
		//Step3:create the statement
		Statement state = con.createStatement();
		
		//Step4:execute the query/update query
		ResultSet result = state.executeQuery(querry);
		Boolean flag=false;
		while(result.next()) {
			String actual = result.getString(colIndex);
			if(actual.equals(expData)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println("--data is verified--");
		}else {
			System.out.println("--data is not verified");
		}
	
	}
	
	public void closeDB() throws SQLException {
		//Step5:close the database
     con.close();
		
	}
	
	
	//done
	
	
	
	
	

}
