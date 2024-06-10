<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<title>congratulation page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>


<style>
body {
  background-color: lightblue;
}

h2 {
  color: purple;
  margin-left: 20px;
}
</style>

</head>
<body>

	<div class="container">
		<h2>Congratulations!</h2>

		<table class="table table-hover">
			<thead>
				<tr bgcolor="orange">
					<th>Customer ID</th>
					<th>Customer Name</th>
					<th>Email Address</th>
					<th>Phone Number</th>

				</tr>
			</thead>
			<tbody>


				<tr bgcolor="sky blue">
					<td>${employeeDTO.customerId}</td>
					<td>${employeeDTO.customerName}</td>
					<td>${employeeDTO.email}</td>
					<td>${employeeeDTO.phoneNum}</td>
				</tr>



			</tbody>
		</table>

<a href= "fetchAll" style="color: #ff0000; font-weight: bold;">Click Here To Fetch All Records</a>
	</div>
  

</body>
</html>