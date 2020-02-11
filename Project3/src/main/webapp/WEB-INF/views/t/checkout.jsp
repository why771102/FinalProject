<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check Out</title>
<style type="text/css">
table {
	border: 0;
}

table td {
	padding: 10px;
}
</style>
</head>
<body>
	<div align="center">
		<h1>Check Out</h1>
		<br />
		<form action="authorize_payment" method="post">			
				<input type="text" name="total" value="120" />

					<input type="submit"
						value="Checkout" />
				
		</form>
	</div>
</body>
</html>