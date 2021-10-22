package com.perficient.Controller;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		String LoginUserName = req.getParameter("UserName");
		String LoginPassword = req.getParameter("Password");
		// System.out.println(PhoneNumber);
		PrintWriter out = res.getWriter();
		// System.out.println(LoginUserName);
		out.println("Hai " + LoginUserName);

		LoginSetGet ls = new LoginSetGet();
		ls.SetParameters(LoginUserName, LoginPassword);
		LoginDao ldb = new LoginDao();
		try {
			int a = ldb.LoginData(ls);
			if (a == 1) {
				HttpSession session=req.getSession();  
		        session.setAttribute("name",LoginUserName); 
		        System.out.println(LoginUserName+"\n");
				RequestDispatcher rd = req.getRequestDispatcher("RoomSqlTag.jsp");
				rd.forward(req, res);
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
				rd.forward(req, res);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
