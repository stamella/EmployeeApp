<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Employee Page</title>
</head>
<body bgcolor="Bisque" style="text-align:center" >
	<h1>Add New Employee</h1>
	<hr>
	<form action="addEmployee.do" method="post">
	<br><br><br>
		<label> Employee Id: </label> 
		<input type="number" name="empId" required /> 
		<br> <br>
		<label>Employee Name: </label> 
		<input type="text" name="empName" size="15" required /> 
		<br> <br>
		<label> Employee Salary: </label> 
		<input type="number" name="empSalary" size="15" required /> 
		<br> <br>
		<label>Employee Department: </label> 
		<select name="empDept" required>
		<option value="">--Select--</option>
			<option value="IT">IT</option>
			<option value="HR">HR</option>
			<option value="ADMIN">ADMIN</option>
			<option value="ACCOUNTS">ACCOUNTS</option>
		</select>
		<br><br><br>
		<input type="submit" value="Add Employee"/>
	</form>
</body>
</html>