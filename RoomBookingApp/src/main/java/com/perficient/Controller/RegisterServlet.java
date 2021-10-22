package com.perficient.Controller;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class RegisterServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String FirstName = req.getParameter("FirstName");
		String LastName = req.getParameter("LastName");
		String UserName = req.getParameter("UserName");
		String Password = req.getParameter("Password");
		String DOB = req.getParameter("DOB");
		String PhoneNumber = req.getParameter("PhoneNumber");
		// System.out.println(PhoneNumber);
		// PrintWriter out = res.getWriter();
		// out.println("Add " + FirstName + " " + LastName);

		RegisterSetGet rs = new RegisterSetGet();
		rs.SetParameters(FirstName, LastName, UserName, Password, DOB, PhoneNumber);
		RegisterDao rdb = new RegisterDao();
		try {
			rdb.RegisterData(rs);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
		rd.forward(req, res);
	}
}
