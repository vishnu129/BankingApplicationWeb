<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mini-Statement</title>
<style type="text/css">
table, th, td {
border:0px solid black;
width:100%;
border-collapse:collapse;
text-align:center;
}
</style>
</head>
<body bgcolor="#D5F6E7">


<h3>
<table>

<tr>
<td><h2> Last five transactions</</h2></td>
</tr>
<c:forEach var="s" items="${statement}">
 	<c:if test="${s<0}">
    <tr>
    <td><h2><c:out value="Withdraw: ${s*-1} "></c:out></h2></td>
    </tr>
    </c:if>
    
    <c:if test="${s>0}">
    <tr>
    <td><h2><c:out value="Deposit: ${s} "></c:out></h2></td>
    </tr>
    </c:if>
    
    <c:if test="${s==0}">
    <tr>
    <td><h2><c:out value=""></c:out></h2></td>
    </tr>
    </c:if>
</c:forEach>
 
</table>
</h3>

</body>
</html>