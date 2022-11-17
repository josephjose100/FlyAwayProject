<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Enter the passenger details </h1>
<%
int fNo=Integer.parseInt(request.getParameter("fNo"));
int persons=Integer.parseInt(request.getParameter("persons"));
%>
<form action="./details" method="post">
Flight Number:<input type="text" name="fNo" value=<%=fNo %> readonly/><br><br>
Name:<input type="text" name="name"><br><br>
Address:<input type="text" name="address"><br><br>
e-mail:<input type="text" name="email"><br><br>
phone:<input type="text" name="phone"><br><br>
Number of passengers:<input type="text" name="persons" value=<%=persons %> readonly/><br><br>
<input type="submit" value="SUBMIT AND PROCEED TO PAYMENT">
</form>
</body>
</html>