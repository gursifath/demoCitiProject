<%@page import="com.dao.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="stu" class="com.dao.Student" scope="request"></jsp:useBean>
	<jsp:setProperty property="*" name="stu"/>
	
	<jsp:forward page="display.jsp"></jsp:forward>
	
</body>
</html>