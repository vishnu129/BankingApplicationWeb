<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show details</title>
<style type="text/css">
table, th, td {
border:2px solid black;
width:auto;
border-collapse:collapse;
text-align:center;
}
</style>
</head>
<body>

<h3>
<table>
<tr>
<th>Account Number</th>
<th>Name</th>
<th>Balance</th>
</tr>
<c:set var="user" value="${userdetails}"> </c:set>
    <tr>
    <td style="width:30%"><c:out value="${user.getAccno()}  "></c:out></td>
    <td style="width:30%"><c:out value="${user.getName()}  "></c:out></td>
    <td style="width:30%"><c:out value="${user.getBalance()} Rs"></c:out></td>
    </tr>  
</table>
</h3>


</body>
</html>