<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>FlyAway</h1>
<h2>Booking Conirmation</h2>
<h3><%=request.getAttribute("name")%>, your booking of <%=request.getAttribute("persons") %> seats has been confirmed</h3>
<h3>The tickets have already been forwarded to email: <%=request.getAttribute("email") %> and phone number <%=request.getAttribute("phone") %> </h3>
<h2>Enjoy a happy journey</h2>
<form action="./index.jsp" method="post">
<input type="submit" value="Go to home page">
</form>
</body>
</html>