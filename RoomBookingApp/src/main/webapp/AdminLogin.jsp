<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="Login.css">
<style type="text/css">
body {
	background-color: lightyellow;
	background-size: contain;
}
</style>
</head>
<body>
	<nav>

		<ul class="topnav" id="dropdownclick">
			<li class="logopad"><img src="D:\projectWork\logo.jpg"
				class="logo"></li>
			<li class="titlelogo">Raj<span>Hotel</span></li>

		</ul>
	</nav>
	<br>
	<br>
	<form action="Adminlogin" method="post">
		<h4>Login here..</h4>
		<br> AdminName :<input type="text" name="AdminName" required /><br>
		<br> Password :<input type="password" name="Pass" required><br>
		<br> <input type="submit" value="Login"><br> <br>
		

	</form>

</body>
</html>