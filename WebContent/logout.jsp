<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	session.removeAttribute("username");
	session.removeAttribute("password");
	session.invalidate();
%>
<div align="center">
<h3><span class="badge badge-primary">You have successfully logged out</span></h3>
</div>
<jsp:include page="login.html"/>
</body>
</html>