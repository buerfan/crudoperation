<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer</title>
</head>
<body>
	
	<form enctype="multipart/form-data"  action="/CRUD_Operation/add" method="post">
		<table align="center">
			
			
			<c:out value="${action}"></c:out>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstname"  value="${customer.firstName}"></td>
			</tr>
			
			<tr>
				<td>First Name</td>
				<td><input type="text" name="lastname"  value="${customer.lastName}"></td>
			</tr>
			
			<tr>
				<td>Image</td>
				<td><input type="file" name="chooser" value="${customer.path}"></td>
			</tr>
			
			
			<tr>
				<td>
				
				<c:if test="${action=='addimage'}">
				<input type="hidden" value="addimage" name="action">
				</c:if>
				
				</td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>

</body>
</html>