<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employees List</title>
</head>
<body>
	<a href="/CRUD_Operation/emp?action=new">New Register</a>
	
	<a href="/CRUD_Operation/logsign?action=login">Login</a>
	
	<a href="/CRUD_Operation/logsign?action=signup">Sign Up</a>
	
	<a href="/CRUD_Operation/add?action=addimage">Add Customer</a>
	<table align="center" border="0">
		
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>NIC</td>
			<td>Designation</td>
			<td>Company</td>
			<td>Email</td>
			<td>Update</td>
			<td>Delete</td>
			
		</tr>
		
		<c:forEach items="${employees}" var="emp">
			<tr>
			<td>${emp.employeeId} </td>
			<td>${emp.employeeName}</td>
			<td>${emp.nic}</td>
			<td>${emp.designation}</td>
			<td>${emp.company}</td>
			<td>${emp.email}</td>
			<td><a href="/CRUD_Operation/emp?action=update&id=${emp.employeeId}">Update</a></td>
			<td><a href="/CRUD_Operation/emp?action=delete&id=${emp.employeeId}">Delete</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>