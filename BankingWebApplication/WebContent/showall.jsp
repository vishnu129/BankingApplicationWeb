<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All users</title>
<style type="text/css">
table, th, td {
border:2px solid black;
width:auto;
border-collapse:collapse;
text-align:center;
}
</style>
</head>
<body bgcolor="#DBCFF9">


<h3>
<table>
<tr>
<th>Account Number</th>
<th>Name</th>
<th>Balance</th>
</tr>
<c:forEach var="s" items="${allusers}">
    <tr>
    <td style="width:30%"><c:out value="${s.getAccno()}  "></c:out></td>
    <td style="width:30%"><c:out value="${s.getName()}  "></c:out></td>
    <td style="width:30%"><c:out value="${s.getBalance()} Rs "></c:out></td>
    </tr>
</c:forEach>  
</table>
</h3>


</body>
</html>