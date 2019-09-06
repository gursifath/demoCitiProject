<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Appliaiton</title>
</head>
<body>
Fill the form to add Student record
<form action="readStudent.jsp" method="get">
	Student Name:<input type="text" name="name"><br>
	Student rollNo:<input type="text" name="rollNo"><br>
	Student Total:<input type="text" name="total"><br>
	
		<input type ="submit" value="Add new record">
</form>
</body>
</html>