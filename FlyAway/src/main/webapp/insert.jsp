<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add Flight details</h1>
<form action="./insert" method="post">
Flight Number:<input type="text" name="fNo"><br><br>
Airlines:<input type="text" name="airlines"><br><br>
Date:<input type="text" name="date">Format:dd/mm/yyyy<br><br>
Destination:<input type="text" name="destination"><br><br>
Ticket price:<input type="text" name="price"><br><br>
Number of seats:<input type="text" name="seats"><br><br>
Source:<input type="text" name="source"><br><br>
<input type="submit" value="Add Flight">
</form>
<p>${msg}</p>
<a href="./home.jsp">Return to home page</a>
</body>
</html>