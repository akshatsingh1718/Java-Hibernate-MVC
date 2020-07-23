<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<title>Display Employee</title>
</head>
<body class="bg-dark">
	<div class="container text-center">
		<div class="text-right">
			<a class="btn btn-primary mt-3" href="displayEmpForm.html">Back</a>
		</div>
		<c:choose>
			<c:when test="${requestScope.employee != null}">
				<c:set var="employee" value="${requestScope.employee}"></c:set>
				<h1>
					<span class="badge badge-warning mt-3">Employees Details</span>
				</h1>
				<div class="col-xs-offset-3 col-xs-6 col-md-offset-4 col-md-4">
					<input class="form-control mt-2" type="text"
						value="Employee No : ${employee.employeeNo}" readonly> <input
						class="form-control mt-2" type="text"
						value="Name : ${employee.employeeName}" readonly> <input
						class="form-control mt-2" type="text"
						value="City : ${employee.employeeCity}" readonly> <input
						class="form-control mt-2" type="text"
						value="Salary : ${employee.employeeSalary}" readonly> <input
						class="form-control mt-2" type="text"
						value="DOB : ${employee.employeeDOB}" readonly> <input
						class="form-control mt-2" type="text"
						value="LastLogin : ${employee.employeeLastLogin}" readonly>
				</div>
			</c:when>
			<c:otherwise>
				<h1>
					<span class="badge badge-danger mt-3">No Employee Found!</span>
				</h1>
			</c:otherwise>
		</c:choose>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
</body>
</html>
