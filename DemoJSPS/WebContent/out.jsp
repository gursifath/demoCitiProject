<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:out value="displaying from out tag"></c:out>
<br>Please fill the form
<form action="out.jsp">
	Username:<input type="text" name="username">
			 <input type="submit" name="SUBMIT">
</form>

<c:out value="${param.username }"></c:out>

<c:set var="name" value="${param.username }"></c:set>

<c:if test="${name eq 'abc' }">
	<c:out value="welcome"></c:out>
</c:if>

<c:choose>
	<c:when test="${name eq 'abc' }"> <c:out value="welcome"></c:out>
	</c:when>
	<c:when test="${name eq 'pql' }"> <c:out value="welcome"></c:out>
	</c:when>
	<c:when test="${name eq 'xyz' }"> <c:out value="welcome"></c:out>
	</c:when>
	<c:otherwise> <c:out value="Not existing"></c:out></c:otherwise>
</c:choose>

</body>