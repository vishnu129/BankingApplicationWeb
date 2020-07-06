<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Options</title>
<style type="text/css">
table, th, td {
border:0px solid black;
width:100%;
border-collapse:collapse;
text-align:center;
}
</style>
<style>
.button {
  border-width: 2px;
  width:300px;
  border-color:green;
  color: white;
  padding: 10px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 19px;
  margin: 4px 2px;
  cursor: pointer;
  background-color: black;
}

</style>
</head>
<body bgcolor="lightblue">


<table>
<tr><td><br></td></tr>
<tr><td><br></td></tr>

<tr><td><br></td></tr>
<tr><td><h1>Admin Options</h1></td></tr>

<tr><td>	<form>
<button class="button" type="submit" name="btn" formaction="adduser.jsp" >Add New Customer</button>
</form> </td></tr>
<tr>
<td><form>
<button class="button" type="submit" name="btn" formaction="usersearch.jsp">Search Customer Details</button>
</form></td></tr>

<tr>
<td><form>
<button class="button" type="submit" name="btn" formaction="modify.jsp" >Modify Customer Details</button>
</form></td></tr>

<tr>
<td><form>
<button class="button" type="submit" name="btn" formaction="cbalance.jsp">Customer Balance Enquiry</button>
</form></td></tr>

<tr>
<td><form>
<button class="button" type="submit" name="btn" formaction="close.jsp">Close Account</button>
</form></td></tr>

<tr>
<td><form>
<button class="button" type="submit" name="btn" formaction="adminoption" value="display">Display All Customers</button>
</form></td></tr>

<tr>
<td><form>
<button class="button" type="submit" name="btn" formaction="adminoption" value="logout">Log Out</button>
</form></td></tr>
</table>


</body>
</html>