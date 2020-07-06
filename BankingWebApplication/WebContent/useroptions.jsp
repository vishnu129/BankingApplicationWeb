<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Options</title>
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
<body bgcolor="green">

<table>
<tr><td><br></td></tr>
<tr><td><br></td></tr>

<tr><td><br></td></tr>
<tr><td><h1>User Options</h1></td></tr>

<tr><td>	<form>
<button class="button" type="submit" name="btn" formaction="deposit.jsp">Deposit</button>
</form> </td></tr>
<tr>
<td><form>
<button class="button" type="submit" name="btn" formaction="transfer.jsp">Money Transfer</button>
</form></td></tr>

<tr>
<td><form>
<button class="button" type="submit" name="btn" formaction="withdraw.jsp">Withdraw Money</button>
</form></td></tr>

<tr>
<td><form>
<button class="button" type="submit" name="btn" formaction="useroption" value="balance">Balance Enquiry</button>
</form></td></tr>

<tr>
<td><form>
<button class="button" type="submit" name="btn" formaction="useroption" value="statement">Mini-Statement</button>
</form></td></tr>

<tr>
<td><form>
<button class="button" type="submit" name="btn" formaction="changepass.jsp">Change Password</button>
</form></td></tr>

<tr>
<td><form>
<button class="button" type="submit" name="btn" formaction="useroption" value="logout">Log Out</button>
</form></td></tr>
</table>


</body>
</html>