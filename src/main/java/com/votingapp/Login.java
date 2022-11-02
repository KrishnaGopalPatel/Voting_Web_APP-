package com.votingapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String uname = request.getParameter("username");
		String pass = request.getParameter("password");

		try {
			PreparedStatement pr = MySqlConnector.getConnection().prepareStatement("select * from users where username = ? and password = ? ");
			pr.setString(1, uname);
			pr.setString(2, pass);
			ResultSet rs = pr.executeQuery();

			if (rs.next()) {
				out.println("<h3> Login Successfully </h3>");
				   Cookie ck=new Cookie("name",uname);  
		            response.addCookie(ck);
				request.getRequestDispatcher("Voting.html").include(request, response);
			} else {
				out.println("<h3> invalid Username and password </h3>");
				request.getRequestDispatcher("index.html").include(request, response);
			}
			pr.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
