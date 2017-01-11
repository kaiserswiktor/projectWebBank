<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>JSP input</title>
</head>
<body>
	
	<form action="MyServlet" method="POST">
	<input type="hidden" name="command" value="Admin">
		Введите ID Card(user) : <input name="idCard" type="Integer"> 
	
		<input type="submit" Value="transaction">
	</form>
</body>
</html>