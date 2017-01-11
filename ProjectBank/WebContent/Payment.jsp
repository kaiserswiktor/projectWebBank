<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>JSP input</title>
</head>
<body>
	
	<form action="MyServlet" method="POST">
	<input type="hidden" name="command" value="Payment">
		Введите сумму платежа : <input name="sumPayment" type="Integer"> 
		Введите  тип &nbsp; платежа &nbsp;(payment-для проведения платежа,refill-для пополнения счета) : <input name="typePaymen" type="text"><br> 
		<input type="submit" Value="transaction">
	</form>
</body>
</html>