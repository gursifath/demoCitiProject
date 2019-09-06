<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="stu" class="com.pojo.Student" scope="request"></jsp:useBean>
Student name:<jsp:getProperty property="name" name="stu"/>
<br>using Expression Language<br>
Student name:${stu.name}
</body>
</html>