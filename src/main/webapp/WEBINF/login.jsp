<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<jsp:include page="Component/navbar.jsp"></jsp:include>

	<div class="container d-flex justify-content-center mt-5">
		<div class="card " style="width: 500px;">

			<div class="card-body">
			<a href="/api/admin/adminLogin">
				<button class="btn btn-primary d-grid mx-auto"
					style="width: 250px; font-size: 25px;">AdminLogin</button>
			</a>
			<a href="/api/seller/sellerLogin">
				<button class="btn btn-primary d-grid mx-auto mt-3"
					style="width: 250px; font-size: 25px;">SellerLogin</button>
			</a>
			<a href="/api/buyer/buyerLogin">	
				<button class="btn btn-primary d-grid mx-auto mt-3"
					style="width: 250px; font-size: 25px;">BuyerLogin</button>
			</a>
			</div>

		</div>
	</div>

	<jsp:include page="Component/footer.jsp"></jsp:include>

</body>
</html>