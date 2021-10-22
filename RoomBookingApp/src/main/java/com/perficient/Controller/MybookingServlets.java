package com.perficient.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MybookingServlets extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		HttpSession session=req.getSession(false);  
        String n=(String)session.getAttribute("name");  
        System.out.println(n);
        try {
			Connection myconn = null;
			Statement myStmt = null;
			ResultSet myRs = null;
			Class.forName("com.mysql.jdbc.Driver");
			String DbUrl = "jdbc:mysql://localhost:3306/roombooking";
			String user = "student";
			String pass = "student";

			myconn = DriverManager.getConnection(DbUrl, user, pass);

			myStmt = myconn.createStatement();

			myRs = myStmt.executeQuery("select UserName,Password from userregistration");
			System.out.println(n);
			PrintWriter out = res.getWriter();
//			out.print(""<HTML>");
//			out.print("<body>");
//			out.print("<table>");
//			out.print("<tr>");
//			String k=myRs.getString("UserName");
//			System.out.println(k);
//			out.print("</tr>");
//			out.print("</table>");
//			out.print("<body>");
//			out.print("</HTML>");
			
			
			String k=myRs.getString("UserName");
			out.print("<table>");
            out.print("<center><h1>Result:</h1></center>");
            
           // out.print(k);
            /* Printing column names */
            
            out.print("<tr>");
      
           //  out.print(" <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>");
            //    out.print(" <script src=\"js/index.js\"></script>");
            while(myRs.next())
               {
            //	String k=myRs.getString("UserName");
                                        
                out.print("<td>"+myRs.getString("roomnumber"));                                   
               // out.print("<button type=\"button\" onclick=friendnamebtn() id=\"btn_friends\">");
              // out.print("<button type=\"button\" onclick='javascript:return friendnamebtn(this)' id=\"btn_friends\">");
               // out.print("<button type=\"button\" onclick='friendnamebtn(\""+ friendname +"\")' id=\"btn_friends\">");
                out.print("Add" + n);
                out.print("</button>");
                out.print("</td></tr>");
        //        out.print(rs.getString(2));
            }
            out.print("</table>");   
			
			//System.out.println(k);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
	