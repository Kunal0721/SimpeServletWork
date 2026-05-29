<%@page import="entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Student</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
</head>
<body>
	<%@ include file="navbar.jsp"%>

	<%
	String msg = (String) request.getAttribute("msg");
	if (msg != null) {
	%>
	<p class="text-center text-danger my-4">
		<%=msg%>
	</p>

	<%
	}
	%>


	<div class="container my-5">
		<div class="row justify-content-center">
			<div class="col-lg-10">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Name</th>
							<th scope="col">Age</th>
							<th scope="col">Course</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<%
						List<Student> list = (List<Student>) request.getAttribute("List");
						for (Student s : list) {
						%>
						<tr>
							<th scope="row"><%=s.getId()%></th>
							<td><%=s.getName()%></td>
							<td><%=s.getAge()%></td>
							<td><%=s.getCourse()%></td>
							<td><a class="btn btn-warning"
								href="update?id=<%=s.getId()%>"><i class="bi bi-pencil-square"></i></a> <a
								class="btn btn-danger"
								onclick="return confirm('Are you sure you want to delete this : <%=s.getName()%> ')"
								href="delete?id=<%=s.getId()%>"><i class="bi bi-trash3-fill"></i></a></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>




	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
		crossorigin="anonymous"></script>
</body>
</html>