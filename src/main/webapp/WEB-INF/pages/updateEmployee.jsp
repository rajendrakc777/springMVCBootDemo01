<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 
 
 <title>Edit Form</title>
  <meta charset="utf-7">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
body {
  background-color: skyblue;
}

h2 {
  color: white;
  margin-left: 20px;
}
</style>


</head>


<body>
<div class="container">
  <h2> Edit Form</h2>
  
  <form action="updateEmp" method ="post">
	
 <h3>${msg}</h3>
 <img alt="registration page" src="images/register.jpg" style = "height: 150px">
  
   
    <div class="form-group">
      <label for="Customer id">Customer Id </label>
      <input type="text" class="form-control" value="${employeeDTO.customerId}" name="customerId" readonly>
    </div>
    
    <div class="form-group">
      <label for="customer Name">customer Name</label>
      <input type="text" class="form-control"value="${employeeDTO.customerName}" name="customerName">
    </div>
    
    <div class="form-group">
      <label for="email">email</label>
      <input type="email" class="form-control" value="${employeeDTO.email}" name="email">
    </div>
    
        <div class="form-group">
      <label for="phone Number">Phone Number</label>
      <input type="tel" class="form-control" value="${employeeDTO.phoneNum}" name="phoneNum">
    </div>
    
     
   
    <button type="submit" class="btn btn-success">Update</button>
  
  
  </form>
</div>




</body>
</html>