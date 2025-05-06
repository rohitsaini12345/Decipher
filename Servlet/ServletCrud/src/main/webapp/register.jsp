<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register page</title>
</head>
<body>
	<h2>Entered Details</h2>
	<form action="regForm" method="post">
		Name:<input type="text" name="name1" pattern="[A-Za-z\s]+" required/><br/><br/>
		Email:<input type="email" name="email1" required/><br/><br/>
		password:<input type="password" name="pass1" required/><br/><br/>
		Gender:<input type="radio" name="gender1" value="male" required/> Male <input type="radio" name="gender1" value="female" required/> Female <br/><br/>
		City:<select name="city1" required>
				<option disabled selected>Select City</option>
				<option>Rajasthan</option>
				<option>Delhi</option>
				<option>Mumbai</option>
				<option>Chennai</option>
			</select><br/><br/><br/>
		Phone_no:<input type="tel" name="phone_no1" pattern="[0-9]{10}" required/><br/><br/>
		<input type="submit" value="Register"/>
		
	</form>
</body>
</html>