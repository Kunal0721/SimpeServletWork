<%@page import="entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
	crossorigin="anonymous">
</head>
<body>

	<%@ include file="navbar.jsp"%>
	<%
	Student st = (Student) request.getAttribute("Student");
	%>

	<div class="container">
		<div class="row justify-content-center align-items-center"
			style="height: 90vh;">
			<div class="col-5 shadow rounded-4 p-4">
				<h1 class="text-center my-3">Update Student :</h1>
				<form action="update" method="post">
					<input type="hidden" name="id" value="<%=st.getId()%>">
					<div class="mb-3">
						<input type="text" class="form-control" name="name"
							placeholder="Enter name" value="<%=st.getName()%>">

					</div>
					<div class="mb-3">

						<input type="number" class="form-control" name="age"
							placeholder="Enter age" value="<%=st.getAge()%>">
					</div>
					<div class="mb-3">
						<input type="text" class="form-control" name="course"
							placeholder="Enter course" value="<%=st.getCourse()%>">

					</div>
					<div class="d-grid">
						<button type="submit" class="btn btn-danger">Update</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
		crossorigin="anonymous"></script>

</body>
</html>