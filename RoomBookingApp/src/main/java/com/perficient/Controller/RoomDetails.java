package com.perficient.Controller;

import java.sql.*;

import javax.servlet.http.HttpSession;

public class RoomDetails {
	public static void ret() {
		try {
			Connection myconn = null;
			Statement myStmt = null;

			Class.forName("com.mysql.jdbc.Driver");
			String DbUrl = "jdbc:mysql://localhost:3306/roombooking";
			String user = "student";
			String pass = "student";

			myconn = DriverManager.getConnection(DbUrl, user, pass);

			myStmt = myconn.createStatement();
			ResultSet rs = myStmt.executeQuery("select * from userregistration");

			while (rs.next()) {
				int n = rs.getInt("roomnumber");
				String nm = rs.getString("roomtype");

			}
			 
			myconn.close();
		} catch (Exception e) {

		}
	}
}
