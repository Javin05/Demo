<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<form action="login" method="post">
		<table style="with: 50%">



			<tr>
				<td>email</td>
				<td><input type="email" name="email" required="required" /></td>

			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" required="required" /></td>
			</tr>
		</table>
		<input type="submit" value="Login" />
	</form>

</body>
</html>