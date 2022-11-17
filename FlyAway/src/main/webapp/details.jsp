<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
int fNo=(int)request.getAttribute("fNo");
String name=(String)request.getAttribute("name");
String address=(String)request.getAttribute("address");
String email=(String)request.getAttribute("email");
String phone=(String)request.getAttribute("phone");
int persons=(int)request.getAttribute("persons");
String source=(String)request.getAttribute("soure");
String destination=(String)request.getAttribute("destination");
String date=(String)request.getAttribute("date");
int price=(int)request.getAttribute("price");
String airlines=(String)request.getAttribute("airlines");
%>
<h1>Your Booking details</h1><br><br>
<h2>Flight details</h2>
<h3>Flight Number:<%=fNo %></h3>
<h3>Source:<%=source %></h3>
<h3>Destination:<%=destination %></h3>
<h3>Date of travel:<%=date %></h3>
<h3>Airlines:<%=airlines %></h3>
<h3>Ticket price:<%=price %></h3>
<h3>No.of tickets:<%=persons %></h3><br><br>
<h2>Personal Details</h2>
<h3>Name:<%=name %></h3>
<h3>Address:<%=address %></h3>
<h3>E-mail:<%=email %></h3>
<h3>Phone number:<%=phone %></h3>
<form action="./payment.jsp" method="post">
<input type="hidden" name="fNo" value=<%=fNo %>>
<input type="hidden" name="name" value=<%=name %>>
<input type="hidden" name="address" value=<%=address %>>
<input type="hidden" name="email" value=<%=email %>>
<input type="hidden" name="persons" value=<%=persons %>>
<input type="hidden" name="phone" value=<%=phone %>>
<input type="submit" value="proceed to pay">
</form>
<br><br>
<a href="./index.jsp">Go Back</a> 


</body>
</html>