<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

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

.container{
	max-width: 900px;
	margin: auto;
	height:650px;
	top: 0;
	bottom: 0;
	right: 0;
	left: 0;	
	
}
}
</style>
<body>

				
				<div class="nav navbar-nav navbar-right">
  			<a href="userlogin.jsp"><button type="button" class="btn btn-light">LogOut</button></a>
  			<p class="navbar-text" style="color: white; font-size: 20px; font-family:serif;">User: ${userDto.userName}</p>
  		</div>
  		
  		<h3 align="center">User Parking Information Form</h3>
  		
  		<div class="container">
<div class="card border-0 shadow">
<div class="card card-body"> 

	<c:forEach items="${errors}" var="error">
		<span style="color: red;">${error.defaultMessage}</span></br>
	</c:forEach>  
	
	
	<form action="${pageContext.request.contextPath}/updateuserpark" method="post" enctype="multipart/form-data">
	
		<div class="form-group">
			<input type="text" value="${parkingid.getParkingId()}" name="parkingId" readonly="readonly"> 
		</div>
	
	<div class="form-group">
			<select name="location" class="form-control" id="location">
				<option value="">${parkingid.getLocation()}</option>
				<option>Rajajinagar</option>
				<option>Vijaynagar</option>
				<option>Shivajinagar</option>
				<option>Basaweshwarnagar</option>
				<option>kamalanagar</option>
			</select>
		</div>
		
		<div class="form-group">
			<select name="vtype" class="form-control" id="vtype"  >
				<option value="">${parkingid.getVtype()}</option>
				<option>2 Wheeler</option>
				<option>4 Wheeler</option>
				<option>Ev</option>
			</select>
		</div>
		
		<div class="form-group">
			<select name="vclassification" class="form-control" id="vclassification" >
				<option value="">${parkingid.getVclassification()}</option>
				<option>Bike</option>
				<option>Kia</option>
				<option>Bmw</option>
				<option>Verna</option>
				<option>Mini Copper</option>
				<option>Tata Tiago EV</option>
				<option>i20</option>
				<option>Etica</option>
				<option>Swift</option>
				<option>Hyunduai Kona Electric</option>
				<option>Audi</option>
				<option>Skoda</option>
			</select>
		</div>
		
		<div class="form-group">
			<select name="term" class="form-control" id="terms" onchange="findPrice()" >
				<option value="">${parkingid.getTerm()}</option>
				<option>1 Day</option>
				<option>7 Days</option>
				<option>15 Days</option>
				<option>30 Days</option>
				<option>60 Days</option>
				<option>90 Days</option>
				<option>180 Days</option>
				<option>365 Days</option>
			</select>
		</div>
		
		<div class="form-group">
			Price: <input type="number" name="price"  class="form-control" id="price" value="${parkingid.getPrice()}"readonly="readonly" >
		</div>
		
		<div class="form-group">
			Discount: <input type="number" name="discount" class="form-control" id="discount" value="${parkingid.getDiscount()}"readonly="readonly" >
		</div>
		
		<div class="form-group">
			Total Amount: <input type="number" name="totalAmount" class="form-control" id="totalAmount" value="${parkingid.getTotalAmount()}" readonly="readonly">
		</div>
		
		<div >
			Upload Vehicle Image <input type="file" name="file" id="fileName" class="form-control" value="<a target="_blank" href="fileDownload?fileName=${parkingid.getFileName()}&contentType=${parkingid.getContentType()}">${parkingid.getFileName()}</a>">
		</div>
		
		<button type="submit" class="btn btn-primary">Save</button>
		
	</form>
	</div>
</div>
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