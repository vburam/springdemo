<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<form action="update">
<h1 align="center">EDIT DATA</h1>

<table border="1">
 <c:forEach items="${data}" var="k"> 


<input type="hidden" name="uid" value="${k.uid}">

<tr>
<td>NAME:-</td>
<td><input type="text" name="name" value="${k.name}"></td>
</tr>
<tr>
<td>UNAME:-</td>
<td><input type="text" name="uname" value="${k.uname}"></td>
</tr>
<tr>
<td>PASSWORD:-</td>
<td><input type="text" name="password" value="${k.password}"></td>
</tr>
<tr>
<td>ADDRESS:-</td>
<td><input type="text" name="address" value="${k.address}"></td>
</tr>
<tr>
<td><input type="submit" value="UPDATE"></td>
</tr>
 </c:forEach> 

</table>
</form>
</body>
</html>