<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Auction System - Dashboard</title>

<!-- Custom fonts for this template-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			 <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/api/admin/dashboard">
                <div class="sidebar-brand-icon rotate-w-15">
                    <img src="/img/auction (1).png" alt="icon image" width="50px;" />
                </div>
                <div class="sidebar-brand-text mx-2">Online Auction System</div>
            </a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link"
				href="/api/admin/dashboard"> <i class="fas fa-fw fa-tachometer-alt"></i> 
				<span>Dashboard</span></a>
			</li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">Interface</div>

			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="true" aria-controls="collapseTwo"> <i
					class="	fas fa-user-alt"></i> <span>Admin</span>
			</a>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">Admin:</h6>
						<a class="collapse-item" href="/api/admin/addAdmin">Add Admin</a> <a
							class="collapse-item" href="/api/admin/adminList">Admin List</a>
					</div>
				</div></li>

			<!-- Nav Item - Utilities Collapse Menu -->
			<li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-user-alt"></i>
                    <span>Seller</span>
                </a>
                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Seller:</h6>
                        <a class="collapse-item" href="/api/seller/sellerList">Seller List</a>
                    </div>
                </div>
            </li>
            
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities1"
                    aria-expanded="true" aria-controls="collapseUtilities1">
                    <i class="fas fa-user-alt"></i>
                    <span>Buyer</span>
                </a>
                <div id="collapseUtilities1" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Buyer:</h6>
                        <a class="collapse-item" href="/api/buyer/buyerList">Buyer List</a>
                    </div>
                </div>
            </li>

			<!-- Divider -->
			<hr class="sidebar-divider d-none d-md-block">

			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>



		</ul>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>

					<!-- Topbar Search -->
					<form
						class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
						<div class="input-group">
							<input type="text" class="form-control bg-light border-0 small"
								placeholder="Search for..." aria-label="Search"
								aria-describedby="basic-addon2">
							<div class="input-group-append">
								<button class="btn btn-primary" type="button">
									<i class="fas fa-search fa-sm"></i>
								</button>
							</div>
						</div>
					</form>

					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">

						<!-- Nav Item - Search Dropdown (Visible Only XS) -->
						<li class="nav-item dropdown no-arrow d-sm-none"><a
							class="nav-link dropdown-toggle" href="#" id="searchDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-search fa-fw"></i>
						</a> <!-- Dropdown - Messages -->
							<div
								class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
								aria-labelledby="searchDropdown">
								<form class="form-inline mr-auto w-100 navbar-search">
									<div class="input-group">
										<input type="text"
											class="form-control bg-light border-0 small"
											placeholder="Search for..." aria-label="Search"
											aria-describedby="basic-addon2">
										<div class="input-group-append">
											<button class="btn btn-primary" type="button">
												<i class="fas fa-search fa-sm"></i>
											</button>
										</div>
									</div>
								</form>
							</div></li>

						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> 
								<span class="mr-2 d-none d-lg-inline text-gray-600 small">${fullname}</span>
                                <span class="mr-2 d-none d-lg-inline text-gray-900 small">(${type})</span> 
									<img class="img-profile rounded-circle"
								src="/img/undraw_profile.svg">
						</a> <!-- Dropdown - User Information -->
							<div
								class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
								<a class="dropdown-item" href="#" data-toggle="modal"
									data-target="#logoutModal"> <i
									class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
									Logout
								</a>
							</div></li>

					</ul>

				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">Seller</h1>
					</div>

					<div class="container d-flex justify-content-center mt-5">
						<div class="card" style="width: 400px;">

							<form:form action="${route}" method="post" modelAttribute="seller">
								<div class="row mt-4">

									<div class=" col">
										<div class="card-body">
											<div class="d-flex justify-content-center display-5">${TitleName}</div>
											<div class="d-flex justify-content-center text-danger mt-3">${error}</div>
											<div class="d-flex justify-content-center text-success">${success}</div>
											
											<div class="form-floating mt-4">
												
												<form:input path="fullname" type="text" class="form-control" value="${oneSeller.fullname}"
													id="floatingInput" placeholder="FullName" />
													<label for="floatingInput">FullName</label>
											</div>
											<div class="form-floating mt-4">
												
												<form:input path="email" type="email" class="form-control" value="${oneSeller.email}"
													id="floatingInput" placeholder="name@example.com" />
													<label for="floatingInput">Email address</label>
											</div>
											<div class="form-floating mt-4">
												
												<form:input path="mobile" type="tel" class="form-control" value="${oneSeller.mobile}"
													id="floatingInput" placeholder="Mobile" />
													<label for="floatingInput">Mobile</label>
											</div>
											<div class="form-floating mt-4">
												
												<form:input path="password" type="password"
													class="form-control" value="${oneSeller.password}" id="floatingPassword"
													placeholder="Password" />
													<label for="floatingPassword">Password</label>
											</div>
											<div class="form-floating mt-4">
												
												<form:input path="dob" type="text" class="form-control" value="${oneSeller.dob}"
													id="floatingInput" placeholder="Dob" />
													<label for="floatingInput">DOB</label>
											</div>
											<div class="form-floating mt-4">
												
												<form:input path="age" type="text" class="form-control" value="${oneSeller.age}"
													id="floatingInput" placeholder="Age" />
													<label for="floatingInput">Age</label>
											</div>
											<div class="form-floating mt-4">
												
												<form:input path="gender" type="text" class="form-control" value="${oneSeller.gender}"
													id="floatingInput" placeholder="Gender" />
													<label for="floatingInput">Gender</label>
											</div>
											<div class="form-floating mt-4">
												
												<form:input path="address" type="text" class="form-control" value="${oneSeller.address}"
													id="floatingInput" placeholder="Address" />
													<label for="floatingInput">Address</label>
											</div>
											<div class="form-floating mt-4">
												
												<form:input path="pincode" type="text" class="form-control" value="${oneSeller.pincode}"
													id="floatingInput" placeholder="Pincode" />
													<label for="floatingInput">Pin code</label>
											</div>
											<div class="form-floating mt-4">
												
												<form:input path="city" type="text" class="form-control" value="${oneSeller.city}"
													id="floatingInput" placeholder="City" />
													<label for="floatingInput">City</label>
											</div>
											<div class="form-floating mt-4">
												
												<form:input path="state" type="text" class="form-control" value="${oneSeller.state}"
													id="floatingInput" placeholder="State" />
													<label for="floatingInput">State</label>
											</div>
											<div class="form-floating mt-4">
												
												<form:input path="country" type="text" class="form-control" value="${oneSeller.country}"
													id="floatingInput" placeholder="Country" />
													<label for="floatingInput">Country</label>
											</div>
											
											<div class="form-floating mt-4">
												
												<form:input path="type" type="text" class="form-control" value="${oneSeller.type}"
													id="floatingInput" placeholder="Type" />
													<label for="floatingInput">Type</label>
											</div>
											<div class="form-floating mt-4">
												
												<form:input path="status" type="text" class="form-control" value="${oneSeller.status}"
													id="floatingInput" placeholder="Status" />
													<label for="floatingInput">Status</label>
											</div>
											<button class="btn btn-primary d-grid mx-auto mt-4" type="submit">${btn}</button>
										</div>
									</div>
								</div>
							</form:form>

						</div>
					</div>

				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white " style="margin-top: 200px;" >
					<div class="container my-auto">
						<div class="copyright text-center my-auto">
							<span>Online Auction System Copyright &copy; 2024</span>
						</div>
					</div>
				</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="/api/login">Logout</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="/vendor/jquery/jquery.min.js"></script>
	<script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="/vendor/chart.js/Chart.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="/js/demo/chart-area-demo.js"></script>
	<script src="/js/demo/chart-pie-demo.js"></script>
</body>

</html>