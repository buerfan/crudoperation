<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="css/signup.css" type="text/css" />
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<body>

 <form class="modal-content" action="" method="post">
    <div class="container">
      <h1>Sign Up</h1>
      ${action}
      <p>Please fill in this form to create an account.</p>
      <hr>
      
      <label for="username"><b>User Name</b></label>
      <input type="text" placeholder="Enter User Name" name="username" required>
      
      <label for="email"><b>Email</b></label>
      <input type="text" placeholder="Enter Email" name="email" required>

      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="psw" required>

      <label for="psw-repeat"><b>Repeat Password</b></label>
      <input type="password" placeholder="Repeat Password" name="psw-repeat" required>
      
      <label>
        <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
      </label>

      <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

      <div class="clearfix">
      <c:if test="${action=='signup'}">
				<input type="hidden" value="signup" name="action">	
	  </c:if>
        <button type="button" class="cancelbtn">Cancel</button>
        <button type="submit" class="signupbtn" >Sign Up</button>
      </div>
    </div>
  </form>
  
</body>
</html>