<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Create Bill</title>
	</head>
	<body>
		<h2>Bill | Create</h2>
		<hr>
		
		<form action="gstCalculate" method="post">
		Amount(@GST Calculation): <input type="number" name="num1" value="${gst.Total()}"/>
			<input type="submit" value="Calculate"/>
		</form>
		<form action="generateBill" method="post">
			<pre>
				First Name: <input type="text" name="firstName" value="${contact.firstName}"/>
				Last Name: <input type="text" name="lastName" value="${contact.lastName}"/>
				Email: <input type="email" name="email" value="${contact.email}"/>
				Mobile: <input type="number" name="mobile" value="${contact.mobile}"/>
				Product: <input type="text" name="product"/>
				Amount: <input type="number" name="amount"/>
				<input type="submit" value="Generate Bill"/>
			</pre>
		</form>
		
	</body>
</html>