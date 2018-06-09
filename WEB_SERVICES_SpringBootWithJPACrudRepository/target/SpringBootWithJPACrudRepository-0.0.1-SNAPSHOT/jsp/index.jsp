<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">

function register() {
	alert("registration page");
	document.fn.action="registerPage";
	document.fn.submit();
}
</script>
{{msg}}
</head>
<body>
<form action="login" name="fn">
<table border="1" align="center">
<tr><td>Username:</td>
<td><input type="text" name="uname"></td>
</tr>
<tr><td>PASSWORD:</td>
<td><input type="password" name="password"></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Login"></td>
</tr>
<tr>
<td></td>
<td><input type="button" value="Register Here" onclick="register()"></td>
</tr>
</table>
</form>
</body>
</html>