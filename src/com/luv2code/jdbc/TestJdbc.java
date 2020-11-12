package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl="jdbc:mysql://localhost:3306/hbstudent?useSSL=false";//for mysql8 ?useSSL=false&serverTimezone=UTC
		String user="hbstudent";
		String pass="hbstudent";
		
		try {
			System.out.println("Connecting to db: " + jdbcUrl);			
			Connection myConn=DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("Connection successful!!!");
		}catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
