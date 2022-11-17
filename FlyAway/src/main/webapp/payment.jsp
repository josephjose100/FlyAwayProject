<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Payment portal</h1>
<%
int fNo=Integer.parseInt(request.getParameter("fNo"));
String name=request.getParameter("name");
String address=request.getParameter("address");
String email=request.getParameter("email");
String phone=request.getParameter("phone");
int persons=Integer.parseInt(request.getParameter("persons"));
%>
<h2>Enter credit card details</h2><br><br>
<form action="./book" method="post">
<input type="hidden" name="fNo" value=<%=fNo%>> 
<input type="hidden" name="name" value=<%=name%>> 
<input type="hidden" name="address" value=<%=address%>> 
<input type="hidden" name="email" value=<%=email%>> 
<input type="hidden" name="phone" value=<%=phone%>> 
<input type="hidden" name="persons" value=<%=persons%>> 
Name of the CardHolder:<input type="text" name="cardname"><br><br>
Card Number:<input type="text" name="cardnumber"><br><br>
Expiry Date:<input type="date" name="expirydate"><br><br>
CVV number:<input type="text" name="cvvnumber"><br><br>
<input type="submit" value="Proceed to pay">
</form>
</body>
</html>