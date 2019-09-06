<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Hello
	<jsp:useBean id="stu" class="com.dao.Student" scope="request"></jsp:useBean>
	
	Student name:<jsp:getProperty property="stuName" name="stu"/>
	<br>Using Expression Language <br>
	Student name: ${stu.stuName}

</body>
</html>