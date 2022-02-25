<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Class</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row mt-5">
			<div class="col-12">
				<h1>Classes</h1>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-6 p-5">
				<form action="/classes/save" method="post" class="mt-4">
					<div class="mb-4 row">
						<div class="col-6">
							<h5>Name:</h5>
						</div>
						<div class="col-6">
							<input name="nombre" class="form-control">
						</div>
					</div>
					<div class="d-flex flex-row-reverse">
					  <input type="submit" value="Submit" class="btn btn-primary btn-lg"/>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>