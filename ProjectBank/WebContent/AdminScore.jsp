<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>UserName</title>
</head>
<body>
<table border="1">
	<th>Id Credit Card - ${idCard}</th>
	<th>Id Score - ${idScore}</th>
	<th>Balance - ${balance}</th>
	<th>Condition - ${condition}</th>
	</table>
	<form action="MyServlet" method="POST">
	<input type="hidden" name="command" value="AdminScore">
		Для блокировки счёта введите -blocked;для разблокировки-unblocked : <input name="condition" type="String"> 
		<input type="submit" value="tranzaction">
	</form>
</body>
</html>