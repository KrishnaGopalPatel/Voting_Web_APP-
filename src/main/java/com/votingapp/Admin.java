package com.votingapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String uname = request.getParameter("username");
		String pass = request.getParameter("password");

		if (pass.equals("admin") && uname.equals("admin")) {
			out.print("<h3>Welcome, " + uname + "</h3>");
			request.getRequestDispatcher("voteresult.jsp").include(request, response);
			HttpSession session = request.getSession();
			session.setAttribute("name", uname);
		} else {
			out.println("<h3>Invalid Username and Password!!..</h3>");
			request.getRequestDispatcher("AdminLogin.html").include(request, response);
		}

		out.close();
	}

}
