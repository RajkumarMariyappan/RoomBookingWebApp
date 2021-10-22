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
	<form action="BookRoom" method="post">
		No.of persons to stay :<input type="text" name="Persons" required><br>
		<br>Room number :<input type="text" name="roomnumber" required><br>
		<br>Room Type :<input type="text" name="roomtype" required><br>
		
		<br> GovtIDNum :<input type="text" name="Id" required><br>
		
		<br> <br> <input
			type="submit" value="Book"></input><br> <br> 
	</form>
</body>
</html>