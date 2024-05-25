<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<jsp:include page="Component/navbar.jsp"></jsp:include>

	<div class="container mt-5">
		<div class="card">
			<form action="/api/aboutUs" method="post">
				<div class="row">
					<div class="col-md-6">
						<div class="card-body">
							<div class="display-6 d-flex justify-content-center">ContactUs</div>
							<div class="d-flex justify-content-center text-danger mt-3">${error}</div>
							<div class="d-flex justify-content-center text-success">${success}</div>
							<div class="form-floating mb-3 mt-3">
								<input type="text" class="form-control" id="floatingFullname" name="fullname"
									placeholder="Fullname"> <label for="floatingFullname">FullName</label>
							</div>
							<div class="form-floating mb-3 mt-3">
								<input type="email" class="form-control" id="floatingInput" name="email"
									placeholder="name@example.com"> <label
									for="floatingInput">Email address</label>
							</div>
							<div class="form-floating mb-3">
								<input type="text" class="form-control" id="floatingPhone" name="phone"
									placeholder="Phone"> <label for="floatingPhone">Contact
									Number</label>
							</div>
							<div class="form-floating mb-3">
								<textarea class="form-control" placeholder="Message"
									id="floatingTextarea2" name="message" style="height: 100px"></textarea>
								<label for="floatingTextarea2">Message</label>
							</div>
							<button class="btn btn-primary mb-3" type="submit">Send</button>
						</div>
					</div>
					
					<div class="col-md-6">
						<img alt="photo" src="/img/ContactUs.png" style="width: 100%"
							height="100%" />
					</div>
				</div>
			</form>
		</div>
	</div>

	<jsp:include page="Component/footer.jsp"></jsp:include>

</body>
</html>