<%@page import="com.votingapp.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Voting Done</title>
</head>
<body>
<h1>Voting Done</h1>

<%
HttpSession sessio = request.getSession(false);
sessio.invalidate();
%>
<a href="index.html">Logout</a>
</body>
</html>