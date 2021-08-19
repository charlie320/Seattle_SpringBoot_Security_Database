<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<fieldset>
		<legend>Login Page</legend>
		<form action="./login" method="POST">
			<div>
				<label>Username:</label>
				<input type="text" name="username" />
			</div>
			<div>
				<label>Password:</label>
				<input type="text" name="password" />
			</div>
			<div>
				<input type="submit" value="Login" />
			</div>
		</form>
	</fieldset>
</body>
</html>