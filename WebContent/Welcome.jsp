<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	margin: 0px;
	padding: 0px;
	background: url(cool.jpg);
	background-size: cover;
}

.para {
	margin-top: 0px;
	text-align: center;
	width: 100%;
	height: 10%;
	font-style: italic;
	color: #fff;
	font-size: 40px;
	font-weight: bold;
	display: block;
}

a {
	margin-top: 5px;
	text-align: right;
	display: block;
	width: 100%;
	color: #fff;
	font-size: 20px;
	font-weight: bold;
	text-decoration: none;
}

.Parent {
	width: 350px;
	height: 520px;
	top: 35%;
	left: 45%;
	position: absolute;
	border: 2px solid white;
	padding: 50px 50px;
	color: #fff;
	font-size: 25px;
	font-style: italic;
}

.Parent p {
	margin-bottom: 0px;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p class="para">Welocome To RECHARGE GURU</p>
	<a href="LogoutServelet">LogOut</a>


	<%
   String str = (String)request.getSession().getAttribute("str");
   out.println("<h1 align='center' style='color:white;''>Hello :  "+str+"</h1>");

%>
	<hr>
	<div class="Parent">

		<form action="CheckBalance" method="post">
			<p>Balance Enquiry :</p>
			<p>
				<input type="submit" value="Check">
			</p>
			<br>
		</form>



		<form action="Recharge" method="post">
			<p>Mobile No:</p>
			<p>
				<input type="text" name="mobile">
			</p>
			<br>
			<p>Recharge Plan</p>
			<select name="plan">
				<option value="1000">1000</option>
				<option value="1500">1500</option>
				<option value="2000">2000</option>
			</select><br>
			<p>
				<input type="submit" value="Recharge">
			</p>
		</form>


		<form action="AddMoney" method="post">
			<p>Add Money :</p>
			<p>
				<input type="text" name="paisa" required>
			<p>
				<input type="submit" value="ADD">
			</p>
			<br>
		</form>

	</div>
</body>
</html>