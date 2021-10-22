package com.perficient.Controller;
	import java.io.*;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.http.*;

	public class AdminLoginServlet extends HttpServlet {

		public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

			String LoginUserName = req.getParameter("AdminName");
			String LoginPassword = req.getParameter("Pass");
			// System.out.println(PhoneNumber);
			PrintWriter out = res.getWriter();
			// System.out.println(LoginUserName);
			out.println("Hai " + LoginUserName);

			AdminLoginSetGet als = new AdminLoginSetGet();
			als.SetParameters(LoginUserName, LoginPassword);
			AdminLoginDao aldb = new AdminLoginDao();
			try {
				int a = aldb.AdminLoginData(als);
				if (a == 1) {
					HttpSession session=req.getSession();  
			        session.setAttribute("name",LoginUserName); 
			        System.out.println(LoginUserName+"\n");
					RequestDispatcher rd = req.getRequestDispatcher("AdminHome.jsp");
					rd.forward(req, res);
				} else {
					RequestDispatcher rd = req.getRequestDispatcher("AdminLogin.jsp");
					rd.forward(req, res);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
