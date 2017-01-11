<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>JSP input</title>
</head>
<body>
	Транзакция проведена!
		<form action="MyServlet" method="POST">
	<input type="hidden" name="command" value="Adminreturn">
		<input type="submit" value="return">
</body>
</html>