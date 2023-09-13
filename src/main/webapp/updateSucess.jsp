<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Sucess</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
	
<style media="screen">
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

#admin {
	/* height: 30px;
 width: 30px; */
	position: relative;
	left: 80rem;
}

#admin1 {
	/* height: 30px;
 width: 30px; */
	position: relative;
	left: 85rem;
}

body {
	background: #fcfcfc;
	font-family: sans-serif;
}

footer {
	position: absolute;
	bottom: 0;
	left: 0;
	right: 0;
	background: #111;
	height: auto;
	width: 100vw;
	padding-top: 40px;
	color: #fff;
}

.footer-content {
	display: flex;
	align-items: center;
	justify-content: center;
	flex-direction: column;
	text-align: center;
}

.footer-content h3 {
	font-size: 2.1rem;
	font-weight: 500;
	text-transform: capitalize;
	line-height: 3rem;
}

.footer-content p {
	max-width: 500px;
	margin: 10px auto;
	line-height: 28px;
	font-size: 14px;
	color: #cacdd2;
}

.socials {
	list-style: none;
	display: flex;
	align-items: center;
	justify-content: center;
	margin: 1rem 0 3rem 0;
}

.socials li {
	margin: 0 10px;
}

.socials a {
	text-decoration: none;
	color: #fff;
	border: 1.1px solid white;
	padding: 5px;
	border-radius: 50%;
}

.socials a i {
	font-size: 1.1rem;
	width: 20px;
	transition: color .4s ease;
}

.socials a:hover i {
	color: aqua;
}

.footer-bottom {
	background: #000;
	width: 100vw;
	padding: 20px;
	padding-bottom: 40px;
	text-align: center;
}

.footer-bottom p {
	float: left;
	font-size: 14px;
	word-spacing: 2px;
	text-transform: capitalize;
}

.footer-bottom p a {
	color: #44bae8;
	font-size: 16px;
	text-decoration: none;
}

.footer-bottom span {
	text-transform: uppercase;
	opacity: .4;
	font-weight: 200;
}

.footer-menu {
	float: right;
}

.footer-menu ul {
	display: flex;
}

.footer-menu ul li {
	padding-right: 10px;
	display: block;
}

.footer-menu ul li a {
	color: #cfd2d6;
	text-decoration: none;
}

.footer-menu ul li a:hover {
	color: #27bcda;
}

@media ( max-width :500px) {
	.footer-menu ul {
		display: flex;
		margin-top: 10px;
		margin-bottom: 20px;
	}
	
}
</style>
</head>

<body>
<nav class="navbar navbar-expand-sm bg-dark"
		style="background-color: black;">
		<div>
			<img height="50px"
				src="https://img.freepik.com/free-vector/parking_24908-54061.jpg?size=626&ext=jpg&ga=GA1.1.1163619451.1684595486&semt=ais">
				</div>
				<a href="userloginSuccess.jsp"><button type="button" class="btn btn-primary button">Home</button></a>

 				</nav>
				<div class="nav navbar-nav navbar-right">
  			<p class="navbar-text" style="color: white; font-size: 20px; font-family:serif;">User: ${userDto.userName}</p>
  		</div>
				<h3 align="center">User Information</h3>
				
				<div class="views">
<table class="table table-border">
	
		<tr>
			<th>userName</th>
			<th>userEmail</th>
			<th>userMobileNo</th>
		</tr>
	
		<tr>
			<td>${userDto.userName}</td>
			<td>${userDto.userEmail}</td>
			<td>${userDto.userMobileNo}</td>
		</tr>
</table>

<table class="table table-border">

		<tr>
			<th>Location</th>
			<th>Vtype</th>
			<th>Vclassification</th>
			<th>Term</th>
			<th>Price</th>
			<th>Discount</th>
			<th>Total Amount</th>
			<th>Image</th>
			<th>Action</th>
		</tr>
		
	
		<tr>
			<td>${parkingid.location}</td>
			<td>${parkingid.vtype}</td>
			<td>${parkingid.vclassification}</td>
			<td>${parkingid.term}</td>
			<td>${parkingid.price}</td>
			<td>${parkingid.discount}</td>
			<td>${parkingid.totalAmount}</td>
			<td><a target="_blank" href="fileDownload?fileName= ${parkingid.fileName}&contentType=${parkingid.contentType}">${parkingid.fileName}</a></td>
			<td><a href="update/${parkingid.parkingId}">Update</a></td>
		</tr>

</table>
</div>		
				<footer>
		<!-- <div class="footer-content">
			<h4 class="">X-Workz(ODC)</h4>
			<ul class="socials">
				<li><a href="#"><i class="fa fa-facebook"></i></a></li>
				<li><a href="#"><i class="fa fa-twitter"></i></a></li>
				<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
				<li><a href="#"><i class="fa fa-youtube"></i></a></li>
				<li><a href="#"><i class="fa fa-linkedin-square"></i></a></li>
			</ul>
		</div> -->
		<div class="footer-bottom">

			<small>@ 2023 Copyright &copy; xworkz.com:last_login_time: ${dto.loginTime}</small>
		

		</div>

	</footer>
</body>

</html>