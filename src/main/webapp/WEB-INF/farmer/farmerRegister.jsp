<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Farmer</title>
</head>
<body>
	<form action="farmerRegister.html" method="post">
		<table>
			<tr>
				<td>Username:</td>
				<td><input name="username" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" /></td>
			</tr>

			<tr>
				<td>First Name:</td>
				<td><input name="firstName" /></td>
			</tr>

			<tr>
				<td>Last Name:</td>
				<td><input name="lastName" /></td>
			</tr>

			<tr>
				<td>Email::</td>
				<td><input name="email" /></td>
			</tr>

			<tr>
				<td>Address:</td>
				<td><input name="address" /></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><input name="city" /></td>
			</tr>
			<tr>
				<td>Zip Code:</td>
				<td><input name="zip" /></td>
			</tr>

			<tr>
				<td>State:</td>
				<td><input name="state" /></td>
			</tr>


			<tr>
				<td>Country:</td>
				<td><input name="country" /></td>
			</tr>

			<tr>
				<td>Field Details:</td>
				<td><input name="fieldDetails" /></td>
			</tr>


			<tr>

				<td>Payment:</td>
			</tr>

			<tr>
				<td>Name on the card</td>
				<td><input name="cardName" /></td>
			</tr>

			<tr>
				<td>Card expiry date</td>
				<td><input name="cardExpiryDate" /></td>
			</tr>
			
			
			<tr>
				<td>Card Number</td>
				<td><input name="cardNumber" /></td>
			</tr>
			
			
			<tr>
				<td>CVV code</td>
				<td><input name="cvvCode" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" /></td>
			</tr>

		</table>

	</form>
</body>
</html>