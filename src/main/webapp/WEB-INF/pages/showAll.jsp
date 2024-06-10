<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<title>Congratulation Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


<style>
body {
  background-color: lightgreen;
}

h2 {
  color: purple;
  margin-left: 20px;
}
</style>

</head>
<body>

	<div class="container">
		<h2> Congratulations! You Fetch All Records</h2>

		<table class="table table-hover">
			<thead>
				<tr bgcolor="orange">
					<th>Customer ID</th>
					<th>Customer Name</th>
					<th>Email Address</th>
					<th>Phone Number</th>
					<th colspan=2>Action(Delete/Edit)</th>
				
	
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${employeeDtoList}" var="temp">

					<tr bgcolor="sky blue">
					<td>${temp.customerId}</td>
					<td>${temp.customerName}</td>
					<td>${temp.email}</td>
					<td>${temp.phoneNum}</td>
					<td> 
					<a href ="deleteEmployee?customerId=${temp.customerId}">
					<button type ="button" class ="btn btn-danger">
					<img src= "images/delete.jpeg" alt= "delete image" style = "height :40px">
					 	</button>
					 	</a>
					</td>
					 
					<td>
					<a href ="updateEmployee?customerId=${temp.customerId}">
					<button type ="button" class="btn btn-success">
					<img src= "images/edit.jpg" alt = "Edit image" style= "height:40px">
						</button>
						</a>
					</td>

				</c:forEach>

		</table>
		
		

	</div>


</body>
</html>