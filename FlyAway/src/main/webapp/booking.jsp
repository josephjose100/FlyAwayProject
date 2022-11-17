<%@page import="org.simplilearn.entities.Flight"%>
<%@page import="java.util.List"%>
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
List<Flight> flights=(List<Flight>)request.getAttribute("availableFlights");
int persons=(int)request.getAttribute("persons");
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
<th>Booking link</th>
</tr>
<%
for(Flight flight:flights){
%>
<tr>
<td><%=flight.getfNo() %></td>
<td><%=flight.getAirlines() %></td>
<td><%=flight.getDate() %></td>
<td><%=flight.getDestination() %></td>
<td><%=flight.getPrice() %></td>
<td><%=flight.getSeats() %></td>
<td><%=flight.getSource() %></td>
<td><a href="./form.jsp?fNo=<%=flight.getfNo()%>&persons=<%=persons%>">Book tickets</a></td>
</tr>
<%
}
%>
</table>
</body>
</html>