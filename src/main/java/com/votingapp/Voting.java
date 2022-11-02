package com.votingapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/Voting")
public class Voting extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int count = 0;
		String name = null;
		VoteCheck vb = new VoteCheck();
		String candidate = request.getParameter("candidate");
		try {
			Cookie ck[] = request.getCookies();
			if (ck != null) {
				 name = ck[0].getValue();
			}
			vb.voteRegister(name, candidate);
		} catch (Exception e) {
			e.printStackTrace();
			out.println("Invalid vote");
		}
		RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
		rd.forward(request, response);

	}

}
