package com.mkj.insapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {
	public static Connection con;

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "user1", "user1");
			System.out.println("Connected ..." + con);
		} catch (Exception e) {
			System.out.println("con" + e);
		}
	}
}
