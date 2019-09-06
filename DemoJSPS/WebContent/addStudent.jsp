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
String message = (String) request.getAttribute("msg");
out.println(message);
%>

<br>


	<h1><%=message %></h1>
	<br> Fill the form to add Student record
	<form action="readStudent.jsp" method="get">
		Student Name:<input type="text" name="stuName"><br>
		Student RollNo:<input type="text" name="rollNo"><br>
		Student Total:<input type="text" name="total"><br>
		<input type="submit" value="Add new record">
	</form>

</body>
</html>