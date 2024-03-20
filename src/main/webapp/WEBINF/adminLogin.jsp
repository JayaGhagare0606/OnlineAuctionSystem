<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body>

	<jsp:include page="Component/navbar.jsp"></jsp:include>

	<div class="container mt-5">
		<div class="card">

			<form:form action="/api/admin/doAdminLogin" method="post" modelAttribute="admin">
				<div class="row mt-5">

					<div class=" col-md-5">
						<div class="card-body">
							<div class="d-flex justify-content-center display-5">AdminLogin</div>
							<div class="d-flex justify-content-center text-danger mt-3">${error}</div>
							<div class="d-flex justify-content-center text-success">${success}</div>
							<div class="form-floating mb-4">
								<form:input path="email" type="email" class="form-control mt-5" id="floatingInput"
									placeholder="name@example.com"/> <label
									for="floatingInput">Email address</label>
							</div>
							<div class="form-floating">
								<form:input path="password" type="password" class="form-control"
									id="floatingPassword" placeholder="Password"/> <label
									for="floatingPassword">Password</label>
							</div>
							<a class="mx-2" href="/api/login">
							<button class="btn btn-primary mt-4" type="button">Back</button>
							</a>
							<button class="btn btn-primary mt-4" type="submit">Admin Login</button>
						</div>
					</div>
					<div class="col-md-2">&nbsp;</div>
					<div class="col-md-5">
						<img alt="photo" src="/img/auction (1).png" />
					</div>

				</div>
			</form:form>

		</div>
	</div>

	<jsp:include page="Component/footer.jsp"></jsp:include>
</body>
</html>