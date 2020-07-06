<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin LogIn</title>
<style type="text/css">
table, th, td {
border:px solid black;
width:100%;
text-align:center;
}
</style>
</head>
<body bgcolor="#BEEDBA">

<table>
<tr><td><br></td></tr>
<tr><td><br></td></tr>

<tr><td><br></td></tr>
<tr><td><h1>Admin LogIn</h1></td></tr>

	
<form action="admin" method="post">
<tr><td>	Enter Admin Id:       <input type="text" name="id"></td></tr>
 <tr><td>   Enter Admin Password: <input type="password" name="password"></td></tr>
<tr><td><input type="submit" id="login" value="LogIn" style="height:30px;width:70px; font-size:20px"></td></tr> 
</form> 

</body>
</html>