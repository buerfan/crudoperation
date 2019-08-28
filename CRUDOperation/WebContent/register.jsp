<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Employee</title>
</head>
<body>

	<h1>Employee CRUD</h1>
	Action value...
	<c:out value="${action}"></c:out>
	
	<form action="/CRUD_Operation/emp" method="post">
		<table align="center">
			
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"  value="${employee.employeeName}"></td>
			</tr>
			
			<tr>
				<td>NIC</td>
				<td><input type="text" name="nic" value="${employee.nic}"></td>
			</tr>
			
			<tr>
				<td>Designation</td>
				<td><input type="text" name="designation" value="${employee.designation}"></td>
			</tr>
			
			<tr>
				<td>Company</td>
				<td><input type="text" name="company" value="${employee.company}"></td>
			</tr>
			
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" value="${employee.email}"></td>
			</tr>
			<tr>
				<td>
				
				<c:if test="${action=='update'}">
				<input type="hidden" value="update" name="action">	
				</c:if>
				
				<c:if test="${action=='new'}">
				<input type="hidden" value="new" name="action">
				</c:if>
				
				<input type="hidden" value="${employee.employeeId}" name="employeeId">
				</td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>