package com.votingapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VoteCheck {

	public int voteCheck(String candidate) throws SQLException, ClassNotFoundException {

		int count;

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/voteingapp", "root", "");

		Statement st = con.createStatement();
		ResultSet result = st.executeQuery("select count from vote where candidate='" + candidate + "'");
		result.next();
		count = result.getInt(1);
		result.close();
		st.close();
		con.close();

		return count;
	}

	public void voteRegister(String candidate, String vote) {

		try {
	
			Statement st = MySqlConnector.getConnection().createStatement();
			int result = st.executeUpdate("insert into vote (username,vote) values ('" + candidate + "','" + vote + "')");

			st.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
