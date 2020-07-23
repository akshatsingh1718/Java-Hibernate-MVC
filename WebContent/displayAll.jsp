<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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

<title>Display All Employees</title>
</head>
<body>
	<div class="container text-center my-3">
		<div class="text-right">
			<a class="btn btn-primary" href="index.jsp">Back</a>
		</div>
		<c:choose>
			<c:when test="${requestScope.emplist != null}">
				<h1>
					<span class="badge badge-warning">Employees</span>
				</h1>
				<table class="table table-dark">
					<thead>
						<tr>
							<th scope="col">Emp Id</th>
							<th scope="col">Name</th>
							<th scope="col">City</th>
							<th scope="col">DOB</th>
							<th scope="col">Last Login</th>
							<th scope="col">Salary</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="emp" items="${requestScope.emplist}">
							<tr>
								<td scope="col"><c:out value="${emp.employeeNo}"></c:out></td>
								<th scope="col"><c:out value="${emp.employeeName}"></c:out></th>
								<th scope="col"><c:out value="${emp.employeeCity}"></c:out></th>
								<th scope="col"><c:out value="${emp.employeeDOB}"></c:out></th>
								<th scope="col"><c:out value="${emp.employeeLastLogin}"></c:out></th>
								<th scope="col"><c:out value="${emp.employeeSalary}"></c:out></th>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<h1>
					<span class="badge badge-danger">No Employees!</span>
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