<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Check Out</title>
	<style type="text/css">
		table { border: 0; }
		table td { padding: 10px; }
	</style>
</head>
<body>
<div align="center">
	<h1>Check Out</h1>
	<br/>
	<form action="authorize_payment" method="post">

<!-- 		<tr> -->
<!-- 			<td>購買商品:</td> -->
<!-- 			<td><input type="text" name="product" value="Next iPhone" /></td> -->
<!-- 		</tr>				 -->

			<input type="text" name="total" value="100" />
	
				<input type="submit" value="購買" />
			<input type="hidden" name="subtotal" value="100" />
<!-- 		<tr> -->
<!-- 			<td><input type="hidden" name="shipping" value="0" /></td> -->
<!-- 		</tr>		 -->
<!-- 		<tr> -->
<!-- 			<td><input type="hidden" name="tax" value="0" /></td> -->
<!-- 		</tr> -->
	</form>
</div>
</body>
</html>