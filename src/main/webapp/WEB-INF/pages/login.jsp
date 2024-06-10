<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 

 
 <title>Login Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

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


<div class="container">
  <h2> Login Form </h2>
  
   <img src="images/login.jpg" alt="registration image" style="height:140px">
	
	<form action="loginValidate" method="post">
 <h4>${message}</h4>


   
    <div class="form-group">
      <label for="customer id">CustomerID</label>
      <input type="text" class="form-control" placeholder="Customer id" name="customerId">
    </div>
    
    <div class="form-group">
      <label for="customer name">CustomerName</label>
      <input type="text" class="form-control" placeholder="Customer Name" name="customerName">
    </div>
    
    
   
    <button type="submit" class="btn btn-success">Submit</button>
    <button type="reset" class="btn btn-danger">Reset</button>
  
  
  </form>
</div>




</body>
</html>