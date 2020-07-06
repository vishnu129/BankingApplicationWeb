<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
<style type="text/css">
table, th, td {
border:px solid black;
width:100%;
text-align:center;
}
</style>
</head>
<body bgcolor="#EACBAB">

<table>
<tr><td><br></td></tr>
<tr><td><br></td></tr>

<tr><td><br></td></tr>
<tr><td><h1>User LogIn</h1></td></tr>

	
<form action="user" method="post">
<tr><td>	Enter Account Number:<input type="text" name="accno"></td></tr>
 <tr><td>   Enter Password:      <input type="password" name="password"></td></tr>
<tr><td><input type="submit" id="login" value="LogIn" style="height:30px;width:70px; font-size:20px"></td></tr> 
</form> 

</body>

</html>