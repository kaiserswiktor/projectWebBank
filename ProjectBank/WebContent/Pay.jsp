<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>JSP input</title>
</head>
<body>
	Платеж прошел !
		<form action="MyServlet" method="POST">
	<input type="hidden" name="command" value="eMail">
		<input type="submit" value="Balance">
</body>
</html>