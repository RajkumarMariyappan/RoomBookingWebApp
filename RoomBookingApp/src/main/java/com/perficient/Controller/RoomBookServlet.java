package com.perficient.Controller;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class RoomBookServlet extends HttpServlet {

	

		public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

			String Persons = req.getParameter("Persons");
			String Id = req.getParameter("Id");
			String roomnumber = req.getParameter("roomnumber");
			String roomtype = req.getParameter("roomtype");
			
			
			
			HttpSession session=req.getSession(false);  
	        String n=(String)session.getAttribute("name");  
	        System.out.println(n);
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String dbUrl = "jdbc:mysql://localhost:3306/roombooking";
				String user = "student";
				String pass = "student";

				
				Connection conn = DriverManager.getConnection(dbUrl, user, pass);
				ResultSet myRs = null;
				Statement Stmnt1 = conn.createStatement();
				//myRs = Stmnt1.executeQuery("select * from userregistration");
				System.out.println(n);
				System.out.println(Id);
//				System.out.println(From);
//				System.out.println(To);
				Stmnt1.executeUpdate("alter table userregistration");
				PreparedStatement stmt = conn.prepareStatement("update userregistration set Persons=?,Id=?,roomnumber=?,roomtype=? where UserName=?");
				stmt.setString(1,Persons);
				
//				stmt.setString(2,From);
//				stmt.setString(3,DateTo);
				stmt.setString(2,Id);
				stmt.setString(3,roomnumber);
				stmt.setString(4,roomtype);
				stmt.setString(5,n);
				
				stmt.executeUpdate();
				
				Statement Stmnt2 = conn.createStatement();
				Stmnt2.executeUpdate("alter table roomdetails");
				PreparedStatement stmt1 = conn.prepareStatement("update roomdetails set availability=? where roomnumber=?");
				stmt1.setString(1,"Booked");
				stmt1.setString(2,roomnumber);
				stmt1.executeUpdate();
//				Stmnt1.executeUpdate("alter table userregistration");
//				PreparedStatement stmt1 = conn.prepareStatement("update userregistration set From=?where UserName=?");
//				stmt1.setString(1,From);
//				stmt1.setString(2,n);
//				stmt1.executeUpdate();
				
//				Stmnt1.executeUpdate("alter table userregistration");
//				PreparedStatement stmt2 = conn.prepareStatement("update userregistration set To=?where UserName=?");
//				stmt2.setString(1,To);
//				stmt2.setString(2, n);
//				stmt2.executeUpdate();
//				
//				Stmnt1.executeUpdate("alter table userregistration");
//				PreparedStatement stmt3 = conn.prepareStatement("update userregistration set Id=?where UserName=?");
//				stmt3.setString(1,Id);
//				stmt3.setString(2, n);	
//				stmt3.executeUpdate();
				System.out.println(roomnumber + " inserted into db");
				RequestDispatcher rd = req.getRequestDispatcher("RoomSqlTag.jsp");
				rd.forward(req, res);
				
			} catch (Exception e) {
				System.out.println(e);
			}

		}

	}
