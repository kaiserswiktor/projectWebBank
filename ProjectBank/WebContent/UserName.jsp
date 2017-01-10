<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>UserName</title>
</head>
<body>
<table border="1">
	<th>Fio - ${Name}</th>
	<th>Role - ${role}</th>
	<th>Id Credit Card - ${idCard}</th>
	<th>Id Score - ${idScore}</th>
	<th>Balance - ${balance}</th>
	<th>Condition - ${condition}</th>
	</table>
	<form action="MyServlet" method="POST">
	<input type="hidden" name="command" value="Pay">
		<input type="submit" value="Go to payment">
	</form>
</body>
</html>