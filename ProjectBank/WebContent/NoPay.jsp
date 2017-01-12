<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>JSP input</title>
</head>
<body>
	На вашем балансе не достаточно средств !
	Или ваш счет заблокирован!
		<form action="MyServlet" method="POST">
	<input type="hidden" name="command" value="Balance">
		<input type="submit" value="Balance">
</body>
</html>