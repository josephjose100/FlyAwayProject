<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to FlyAway</h1>
<form action="./search" method="post">
<h2>Search flights</h2><br>
Source:<input type="text" name="source">
Destination:<input type="text" name="destination"><br><br>
Date:<input type="text" name="date"> Format:dd/mm/yyyy<br><br>
Number of person:<input type="text" name="persons"><br><br>
<input type="submit" value="SUBMIT">
</form>
<p>${msg}</p>
<a href="./login.jsp">Admin Login</a>
</body>
</html>