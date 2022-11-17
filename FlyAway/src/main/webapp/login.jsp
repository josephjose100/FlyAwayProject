<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>FlyAway Admin Login</h1>
<form action="./login" method="post">
Admin Id:<input type="text" name="adminId"><br><br>
Password:<input type="password" name="password"><br><br>
<input type="submit" value="login">
</form>
<br><br><br>
<a href="./register.jsp">Register new Admin</a><br><br>
<a href="./index.jsp">Go back to welcome page</a>
<p>${msg}</p>
</body>
</html>