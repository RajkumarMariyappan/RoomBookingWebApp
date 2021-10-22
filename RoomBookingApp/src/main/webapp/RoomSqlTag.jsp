<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
<head>
<title>Home Page</title>
<link rel="stylesheet" href="dummy.css">
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
			<li class="topnav-right"><a href="HotelHome.jsp">Logout</a>|</li>
			<li class="topnav-right"><a href="aboutus.html">About Us</a></li>
			<li class="topnav-right"><a href="MyBooking.jsp">MyBookings</a></li>
		</ul>
	</nav>

	<h1 style="text-align: center; color: Green">Welcome to Raj Hotel</h1>
	<br>
	<h4>These are the room services which we provide ! choose your
		Room to Stay</h4>
	<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/roombooking" user="student"
		password="student" />
<h3 style="text-align:center" > Available - blue</h3>
<h3 style="text-align:center"> Booked - Red</h3>
	<sql:query dataSource="${db}" var="rs">  
SELECT * from roomdetails;  
</sql:query>

	<table border="1" width="50%">
		<tr>
			<th style="color: Green">RoomNumber</th>
			<th style="color: Green">RoomType</th>
			<th style="color: Green">Availability</th>
		</tr>
		<c:forEach var="table" items="${rs.rows}">
			<tr>
				<th><c:out value="${table.roomnumber}" /></th>
				<th><c:out value="${table.roomtype}" /></th>
				<c:choose>
					<c:when test="${table.availability=='Booked'}">
						<th style="color: Red"><c:out value="${table.availability }" /></th>
					</c:when>
					<c:otherwise>
						<th style="color: Blue"><c:out value="${table.availability }" /></th>
					</c:otherwise>
				</c:choose>
				
			</tr>
		</c:forEach>
	</table>
<a href="BookRoom.jsp"><button>Book</button></a>


	<div class="column" style="background-color: black; text-align: left">
		<ul style="color: white; text-align: left; line-height: 2.2;">
			<h4 style="margin: 0%;">Contact Us</h4>
			<br>
			<h4 style="margin: 0%; font-weight: normal">
				No.1 Gurumoorthy Street, DB Nagar,<br> Madurai-625001,
				TamilNadu, India
			</h4>
			<h4 style="margin: 0%; font-weight: normal">Ph.No.- 8949392919</h4>
			<h4 style="margin: 0%; font-weight: normal">Mail.-
				Rajhotel@gmail.com</h4>
		</ul>



	</div>

</body>
</html>
