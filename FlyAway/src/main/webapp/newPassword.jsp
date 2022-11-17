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
String adminId=request.getParameter("adminId");
String password=request.getParameter("password");
%>
<form action="./change" method="post">
<input type="hidden" name="adminId" value=<%=adminId %>>
<input type="hidden" name="password" value=<%=password %>>
Old password:<input type="password" name="oldPassword">
New password:<input type="password" name="newPassword">
Re-enter New password:<input type="password"  name="newPassword1">
<input type="submit" value="Change password">
</form>
<p>${msg1}</p>
</body>
</html>