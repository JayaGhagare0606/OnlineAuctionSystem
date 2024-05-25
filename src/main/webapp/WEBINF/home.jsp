<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

<style type="text/css">
body{
	background-image: linear-gradient(to left, #CDE8E5, #7AB2B2);
}
</style>

</head>

<body>
	<jsp:include page="Component/navbar.jsp"></jsp:include>


	<section class="container py-5 hero-section">
		<div class="row align-items-center">
			<div class="col-md-9">
				<h2 class="display-3">
					<B>Find Amazing Deals on Unique Items</B>
				</h2>
				<p style="font-size: 20px;">
					<i>Bid and win on a wide variety of products, from collectibles
						and electronics to furniture and art.</i>
				</p>

			</div>

		</div>
	</section>
	<div class="container-fluid">
		<div class="row">
			<main class="col-md-9"></main>
			<div id="sticky-section"
				class="col-md-3 d-none d-md-block sticky-top">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">
						
						You can be a Buyer or Seller please contribute...</h5>
						
						
					</div>
				</div>
			</div>
		</div>
	</div>
	
	


	<jsp:include page="Component/footer.jsp"></jsp:include>

</body>
</html>