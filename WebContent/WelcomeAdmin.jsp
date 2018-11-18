<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="WelcomeAdmin.css">
</head>
<body>
	<div class="box1">
		<form action="SearchServelet" method="post">
			<p>Enter Record You want To Search</p>
			<br> <input type="text" name="uname" placeholder="Enter Name" />
			<input type="submit" value="SEARCH" />
		</form>
	</div>

	<div class="box2">
		<a href="LogoutServelet" class="ref">LogOut</a>
		<form action="DisplayServelet" method="post">
			<p>Want To See All The Records</p>
			<br> <input type="submit" value="DISPLAY ALL" />
		</form>

	</div>


</body>
</html>