<%@page import="com.votingapp.*"%>
<%@page import="java.sql.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table class="table1">
		<tr>
			<th>Candidate 1 =</th>
			<%
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voteingapp", "root", "");
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery("select count(*) from vote where vote='cnd1'");
				while (rs.next()) {
			%>
			<th><input type="text" value="<%=rs.getString(1)%>" size="1">Vote</th>
			<%
			}
			} catch (Exception ex) {
			ex.printStackTrace();
			}
			%>
		</tr>

	</table>
	<table class="table1">
		<tr>
			<th>Candidate 2 =</th>
			<%
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voteingapp", "root", "");
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery("select count(*) from vote where vote='cnd2'");
				while (rs.next()) {
			%>
			<th><input type="text" value="<%=rs.getString(1)%>" size="1">Vote</th>
			<%
			}
			} catch (Exception ex) {
			ex.printStackTrace();
			}
			%>
		</tr>

	</table>
	<table class="table1">
		<tr>
			<th>Candidate 3 =</th>
			<%
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voteingapp", "root", "");
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery("select count(*) from vote where vote='cnd3'");
				while (rs.next()) {
			%>
			<th><input type="text" value="<%=rs.getString(1)%>" size="1">Vote</th>
			<%
			}
			} catch (Exception ex) {
			ex.printStackTrace();
			}
			%>
		</tr>

	</table>
	<table class="table1">
		<tr>
			<th>Candidate 4 =</th>
			<%
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voteingapp", "root", "");
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery("select count(*) from vote where vote='cnd4'");
				while (rs.next()) {
			%>
			<th><input type="text" value="<%=rs.getString(1)%>" size="1">Vote</th>
			<%
			}
			} catch (Exception ex) {
			ex.printStackTrace();
			}
			%>
		</tr>

	</table>
	<a href="index.html">Logout</a>

</body>
</html>