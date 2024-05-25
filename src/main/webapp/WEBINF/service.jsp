<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style type="text/css">
body {
	background-image: linear-gradient(to left, #CDE8E5, #7AB2B2);
}
</style>
</head>
<body>

	<jsp:include page="Component/navbar.jsp"></jsp:include>

	<div class="container py-5">
		<div class="row row-cols-1 row-cols-md-2 g-4">
			<div class="col">
				<div class="card h-100">
					<div class="card-header bg-primary text-white">
						<h3>Buyer Services</h3>
					</div>
					<div class="card-body">
						<ul class="list-group list-group-flush">
							<li class="list-group-item">Search a wide variety of
								auctions</li>
							<li class="list-group-item">Place bids and track your
								progress</li>
							<li class="list-group-item">Secure payment processing</li>
							<li class="list-group-item">Dispute resolution for buyer
								protection</li>
						</ul>
					</div>
					<div class="card-footer">
						<a href="#" class="btn btn-primary">Learn More</a>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card h-100">
					<div class="card-header bg-success text-white">
						<h3>Seller Services</h3>
					</div>
					<div class="card-body">
						<ul class="list-group list-group-flush">
							<li class="list-group-item">List your items for auction
								easily</li>
							<li class="list-group-item">Manage bids and receive payments</li>
							<li class="list-group-item">Reach a wider audience of
								potential buyers</li>
							<li class="list-group-item">Fraud protection for sellers</li>
						</ul>
					</div>
					<div class="card-footer">
						<a href="#" class="btn btn-success">Learn More</a>
					</div>
				</div>
			</div>
		</div>
	</div>


	<jsp:include page="Component/footer.jsp"></jsp:include>

</body>
</html>