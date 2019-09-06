<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	using scriptlet:
	<%
		String message = (String) request.getAttribute("msg");
		out.println(message);
	%>
	
	<br>
using expression
	<h1><%= message %></h1>
	
using EL: ${message}
<br> Fill the form to add student record
	<a href="addStudent.jsp">Add new Student Record</a>

</body>
</html>