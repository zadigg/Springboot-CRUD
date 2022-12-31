<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Add Alien</h1>
	<form action="addAlien">
		<input type="text" name="aid"> <br> <input type="text"
			name="aname"> <br> <input type="submit"> <br>
	</form>

	<h1>get Alien By Id</h1>
	<form action="getAlien">
		<input type="text" name="aid"> <br> <input type="submit">
		<br>
	</form>


	<h1>get All Aliens</h1>
	<form action="getAllAlien">
		<input type="submit"> <br>
	</form>


	<h1>Delete Alien By Id</h1>
	<form action="deleteAlien">
		<input type="text" name="aid"> <br> <input type="submit">
		<br>
	</form>


	<h1>Update Alien By Id</h1>
	<form action="updateAlien">
		<input type="text" name="aid"> <br> <input type="text"
			name="aname"> <br> <input type="submit"> <br>
		<br>
	</form>

</body>
</html>