<%
if(session.getAttribute("admin")!=null)
{	
%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.simplilearn.entities.Flight"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> ${sessionScope.admin.adminId} Welcome to FlyAway home page</h1> 
<h2>FlyAway Admin Operations</h2>
<p>${msg1}</p>
<a href="./newPassword.jsp?adminId=${sessionScope.admin.adminId}&password=${sessionScope.admin.password}">Change Admin password</a><br><br>
<a href="./all">List of all flight details</a><br><br>
<a href="./airlines">List of all airlines</a><br><br>
<a href="./srcDestination">List of all source and destination</a><br><br>
<a href="./insert.jsp">Add flights</a><br><br>
<form action="./index.jsp" class="inline">
    <button class="float-right submit-button" >LogOut</button>
</form>
<%
List<Flight> flights=new ArrayList<>();
flights=(List<Flight>)request.getAttribute("flights");
if(flights!=null){
%>
<table border="1">
<tr>
<th>Flight Number</th>
<th>Airlines</th>
<th>Date</th>
<th>Destination</th>
<th>Ticket Price</th>
<th>Available Seats</th>
<th>Source</th>
</tr>
<%
  for(Flight flight:flights){

%>
<tr>
<td><%=flight.getfNo() %></td>
<td><%=flight.getAirlines() %></td>
<td><%=flight.getDate() %></td>
<td><%=flight.getDestination()%></td>
<td><%=flight.getPrice()%></td>
<td><%=flight.getSeats()%></td>
<td><%=flight.getSource()%></td>
<td><a href="./delete?fNo=<%=flight.getfNo() %>">DELETE</a></td>
</tr>
<%
  }
%>
</table>
<%
}
List<String> airlines=(List<String>)request.getAttribute("airlines");
if(airlines!=null){
%>
<table border="1">
<tr>
<th>List of airlines</th>
</tr>
<%
for(String airline:airlines){
%>
<tr>
<td><%=airline %></td>
</tr>
<%
}
%>
</table>
<%
}
List<Object[]> srcDestinations=(List<Object[]>)request.getAttribute("srcDestinations");
if(srcDestinations!=null){
%>
<table border="1">
<tr>
<th>Source</th>
<th>Destination</th>
</tr>
<%
for(Object[] srcDestination:srcDestinations){
%>
<tr>
<td><%=(String)srcDestination[0] %> </td>
<td><%=(String)srcDestination[1] %> </td>
</tr>
<%
}
%>
</table>
<%
}
%>
</body>
</html>
<%
}
else
{
	request.setAttribute("msg", "login first");
	RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
	rd.forward(request, response);
}
%>