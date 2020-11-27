<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<strong>List of Publications in the Database</strong>
<p></p>
<table border="1"> 
	<thead> 
		<tr> 
			<th>#</th> 
			<th>Name</th> 
			<th>Date</th> 
			<th>Type</th> 
		</tr> 
	</thead> 
	<tbody> 
			<c:set var="i" value="1" /> 
	<c:forEach items="${myListOfPubs}" var="u"> 
		<tr> 
			<td>${i}</td> 
			<td>${u.name}</td> 
			<td>${u.date}</td> 
			<td>${u.type}</td> 
		</tr> 
		<c:set var="i" value="${i+1}" /> 
	</c:forEach> 
	</tbody> 
</table> 
</body>
</html>