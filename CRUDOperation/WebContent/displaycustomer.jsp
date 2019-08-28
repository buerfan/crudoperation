<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display</title>
</head>
<body>
	
	<table align="center" border="0">
		
		<tr>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Image </td>			
		</tr>
		
		<c:forEach items="${customers}" var="cm">
			<tr>
			<td>${cm.firstName} </td>
			<td>${cm.lastName}</td>
			<td><img src="images/${cm.fileName}" height="100" width="100"></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>