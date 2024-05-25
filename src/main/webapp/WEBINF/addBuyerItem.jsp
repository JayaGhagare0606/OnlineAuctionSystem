<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<section>
		<ul class="nav nav-tabs ">
			<li class="nav-item"><a class="nav-link "
				href="/api/buyer/buyerHome">Auction Item List</a></li>
			<!-- <li class="nav-item"><a class="nav-link active"
				aria-current="page" href="/api/buyer/addBuyerItem">Add Item</a></li> -->
			<li class="nav-item"><a class="nav-link"
				href="/api/buyer/buyerItemHistory">Purchased Item</a></li>

		</ul>
	</section>

	<div class="container d-flex justify-content-center mt-5">
		<form:form action="/api/buyer/addBuyerItem" method="post"
			modelAttribute="auctionItem" enctype="multipart/form-data">
			<div class="card" style="width: 400px;">
				<div class="d-flex justify-content-center text-danger mt-2">${error}</div>
				<div class="d-flex justify-content-center text-success">${success}</div>
				<div class="row">
					<div class="col">
						<div class="card-body">
							<div class="form-floating mt-3">
								<form:input type="text" path="productname" class="form-control" id="floatingProductname"
									placeholder="Productname"/> <label
									for="floatingProductname">ProductName</label>
							</div>
							<div class="form-floating mt-3">
								<form:input type="email" path="email" class="form-control" id="floatingInput"
									placeholder="name@example.com"/> <label
									for="floatingInput">Email address</label>
							</div>
							<div class="form-floating mt-3 mb-3">
								<input type="file" name="file" accept=".jpeg,.jpg,.png" class="form-control"
									id="floatingInput" placeholder="name@example.com"> <label
									style="margin-top: -10px;" for="floatingInput">Upload
									Image</label>
							</div>
							<div class="form-floating mt-3 mb-3">
								<form:input type="text" path="bidingStartingAmount" class="form-control" id="floatingInput"
									placeholder="BidingStartingAmount"/> <label
									for="floatingInput">Biding starting Amount</label>
							</div>
							<button class="btn btn-primary" type="Submit">Add Item</button>
						</div>
					</div>

				</div>
			</div>
		</form:form>
	</div>

	<jsp:include page="Component/footer.jsp"></jsp:include>

</body>
</html>