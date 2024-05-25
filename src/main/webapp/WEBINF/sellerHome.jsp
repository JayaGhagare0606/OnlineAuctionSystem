<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seller Home</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<jsp:include page="Component/navbar.jsp"></jsp:include>

	<section>
		<ul class="nav nav-tabs ">
			<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="/api/seller/sellerHome">Selling Item
					List</a></li>
			<li class="nav-item"><a class="nav-link"
				href="/api/seller/addSellerItem">Add Item</a></li>
			<li class="nav-item"><a class="nav-link"
				href="/api/seller/sellerItemHistory">Sold Item History</a></li>

		</ul>
	</section>
	<section style="width: 97%;">
		<hr class="text-white">
		<table class="table table-striped center mx-4">

			<thead class="text-center">
				<tr>
					<th>SrNo</th>
					<th>ProductName</th>
					<th>Email</th>
					<th>Image</th>
					<th>Biding Starting Amount</th>
					<th>Buyer</th>
					<th>Buyer Bid</th>
					<th>Bid Action</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody class="text-center">
				<c:forEach var="auctionItem" items="${auctionitemList}"
					varStatus="loop">
					<tr>
						<td>${loop.index+1}</td>
						<td>${auctionItem.productname}</td>
						<td>${auctionItem.email}</td>
						<td><c:if test="${auctionItem.image != null}">
								<img src="data:image/jpeg;base64,${auctionItem.encodeImage}"
									width="50" height="35" />
							</c:if></td>
						<td>${auctionItem.bidingStartingAmount}</td>
						<td>${auctionItem.buyerUserName}</td>
						<td>${auctionItem.buyerBid}</td>
						<td><a href="/api/auctionItem/acceptUpdate/${auctionItem.id}">
								<button class="btn btn-success mb-2" type="button">
									<i class="fa fa-check"></i> Accept
								</button>
						</a> <br> <a href="/api/auctionItem/declineUpdate/${auctionItem.id}">
								<button class="btn btn-danger" type="button">
									<i class="fa fa-close"></i> Decline
								</button>
						</a></td>
						<td><a href="/api/auctionItem/delete/${auctionItem.id}"><button
									class="btn btn-danger" type="button">Delete</button></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>

	<jsp:include page="Component/footer.jsp"></jsp:include>
</body>
</html>