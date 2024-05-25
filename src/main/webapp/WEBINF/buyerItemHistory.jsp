<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buyer Home</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<jsp:include page="Component/navbar.jsp"></jsp:include>

	<section>
		<ul class="nav nav-tabs ">
			<li class="nav-item"><a class="nav-link"
				aria-current="page" href="/api/buyer/buyerHome">Auction Item
					List</a></li>
			<!-- <li class="nav-item"><a class="nav-link"
				href="/api/buyer/addBuyerItem">Add Item</a></li> -->
			<li class="nav-item"><a class="nav-link active"
				href="/api/buyer/buyerItemHistory">Purchased Item</a></li>

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
					<th>Your Bid</th>
					<th>Remark</th>
				</tr>
			</thead>
			<tbody class="text-center">
				<c:forEach var="auctionItem" items="${auctionitemList}"
					varStatus="loop">
					<form:form action="/api/auctionItem/update/${auctionItem.id}" method="post" modelAttribute="auctionItem"> 
					<tr>
						<td>${loop.index+1}</td>
						<td>${auctionItem.productname}</td>
						<td>${auctionItem.email}</td>
						<td><c:if test="${auctionItem.image != null}">
								<img src="data:image/jpeg;base64,${auctionItem.encodeImage}"
									width="50" height="35" />
							</c:if></td>
						<td>${auctionItem.bidingStartingAmount}</td>
						<td>${auctionItem.buyerBid}</td>
						<td class="text-success">PURCHASED</td>
					</tr>
					</form:form>
				</c:forEach>
				
			</tbody>

		</table>

	</section>

	<jsp:include page="Component/footer.jsp"></jsp:include>
</body>
</html>