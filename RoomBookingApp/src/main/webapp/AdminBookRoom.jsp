<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Registration</title>
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
	<form action="AdminBookRoom" method="post">
		FirstName :<input type="text" name="FirstName" required><br>
		<br> LastName :<input type="text" name="LastName" required><br>
		<br> UserName :<input type="text" name="UserName" required><br>
		<br> Password :<input type="password" name="Password" required><br>
		<br> DOB :<input type="date" name="DOB" required><br>
		<br> phoneNumber :<input type="number" name="PhoneNumber"  max="9900000000" required><br>
		<br>No.of persons to stay :<input type="text" name="Persons" required><br>
		<br> GovtIDNum :<input type="text" name="Id" required><br>
		<br>Room number :<input type="text" name="roomnumber" required><br>
		<br>Room Type :<input type="text" name="roomtype" required><br>
		
		
		<br> <br> <input
			type="submit" value="Book"></input><br> <br> 
	</form>
</body>
</html>