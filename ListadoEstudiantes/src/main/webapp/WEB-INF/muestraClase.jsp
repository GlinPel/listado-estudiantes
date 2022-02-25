<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${clase.nombre}</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row mt-5">
			<div class="col-6">
				<h1><c:out value="${clase.nombre}"/></h1>
			</div>
			
		</div>
		<div class="row mt-5">
			<div class="col-12 p-5">
				<h2>Students taking this class:</h2>
				<table class="table table-striped">
				  <thead>
				    <tr>
				      <th scope="col">Student Name</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach var="estudiante" items="${clase.estudiantes}">
				  		<tr>
					      <td>
					      	<c:out value="${estudiante.nombre}"/>
					      </td>
					    </tr>
				  	</c:forEach>
				  </tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>