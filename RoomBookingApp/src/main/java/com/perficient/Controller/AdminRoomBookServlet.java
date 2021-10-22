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
public class AdminRoomBookServlet extends HttpServlet {


			public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
				String FirstName = req.getParameter("FirstName");
				String LastName = req.getParameter("LastName");
				String UserName = req.getParameter("UserName");
				String Password = req.getParameter("Password");
				String DOB = req.getParameter("DOB");
				String PhoneNumber = req.getParameter("PhoneNumber");
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
//					System.out.println(From);
//					System.out.println(To);
					//Stmnt1.executeUpdate("alter table userregistration");
					PreparedStatement stmt=conn.prepareStatement("insert into userregistration values(?,?,?,?,?,?,?,?,?,?)");  
					stmt.setString(1,FirstName);//1 specifies the first parameter in the query  
					stmt.setString(2, LastName);
					stmt.setString(3, UserName);
					stmt.setString(4, Password);
					stmt.setString(5, DOB);
					stmt.setString(6, PhoneNumber);
					stmt.setString(7, Persons);
					stmt.setString(8, Id);
					stmt.setString(9, roomnumber);
					stmt.setString(10, roomtype);
					  
					int i=stmt.executeUpdate();  
					System.out.println(i+" records inserted");  
					
					Statement Stmnt2 = conn.createStatement();
					Stmnt2.executeUpdate("alter table roomdetails");
					PreparedStatement stmt1 = conn.prepareStatement("update roomdetails set availability=? where roomnumber=?");
					stmt1.setString(1,"Booked");
					stmt1.setString(2,roomnumber);
					stmt1.executeUpdate();
					System.out.println(roomnumber + " inserted into db");
					RequestDispatcher rd = req.getRequestDispatcher("AdminHome.jsp");
					rd.forward(req, res);
					
				} catch (Exception e) {
					System.out.println(e);
				}

			}

		}
