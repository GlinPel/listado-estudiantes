<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${estudiante.nombre}</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row mt-5">
			<div class="col-6">
				<h1><c:out value="${estudiante.nombre}"/></h1>
			</div>
			
		</div>
		<div class="row mt-5">
			<div class="col-6">
				<form action="/classes/savenewclass" method="post" class="mt-4">
					<div class="mb-4 row">
						<div class="col-6">
							<h5>Classes:</h5>
						</div>
						<div class="col-6">
							<select class="form-control" name="id_clase">
								<c:forEach var="clase" items="${clases}">
									<option value="${clase.id}">${clase.nombre}</option>
								</c:forEach>
						    </select>
						</div>
					</div>
					<input type="hidden" name="id_estudiante" value="${estudiante.id}">
					<div class="d-flex flex-row-reverse">
					  <input type="submit" value="Submit" class="btn btn-primary btn-lg"/>
					</div>
				</form>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-12 p-5">
				<table class="table table-striped">
				  <thead>
				    <tr>
				      <th scope="col">Class Name</th>
				      <th scope="col">Action</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach var="clase" items="${estudiante.clases}">
				  		<tr>
					      <td>
					      	<a href="/classes/${clase.id }">${clase.nombre}</a>
					      </td>
						  <td>
					      	<form action="/classes/dropclass" method="post">
								<input type="hidden" name="id_estudiante" value="${estudiante.id}">
								<input type="hidden" name="id_clase" value="${clase.id}">
								<input type="submit" value="Drop" class="btn btn-primary"/>
							</form>
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