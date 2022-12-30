<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Coupons" method="post">
		<pre>
Coupon Code: <input type="text" name="couponCode">
Discount : <input type="text" name="discount">
Expiry Date: <input type="text" name="expiryDate">
<input type="hidden" name="action" value="create" />
<input type="submit" value="Save">
</pre>
	</form>

</body>
</html>