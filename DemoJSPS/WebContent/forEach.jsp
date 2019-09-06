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

	<%
		String[] numbers =
			{"one", "two", "nine", "six", "five" };
		pageContext.setAttribute("num", numbers);
	%>
	
	<table border="1">
		<c:forEach var="myNum" varStatus="st" items="${num }">
		<tr>
			<td><c:out value="${myNum }"></c:out></td>
			<td><c:out value="${st.first }"></c:out></td>
			<td><c:out value="${st.last }"></c:out></td>
			<td><c:out value="${st.current }"></c:out></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>