<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Parking Information</title>
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
}
</style>

<script>
		function findPrice() {
			var location = document.getElementById("location").value;
			var vtype = document.getElementById("vtype").value;
			var classification = document.getElementById("vclassification").value;
			var term = document.getElementById("term").value;

			const httpRequest = new XMLHttpRequest();
			httpRequest.open("GET", "http://localhost:8080/parking-rental-system/userAjax/"+location + "/" + vtype + "/" + classification + "/" + term);
			
			httpRequest.send();

			httpRequest.onload = function() {
				console.log(this.responseText);
				const obj=JSON.parse(this.responseText);
				console.log(obj)
				console.log(obj.price)
				console.log(obj.discount)
				console.log(obj.total)
			    var pr=document.getElementById("price").value=obj.price;	
				var dis=document.getElementById("discount").value=obj.discount;
				var t = dis/100; /* we r getting value in float */
				var d =pr*t; /* float value and actual value multiply */
				var fi=pr-d; /* original price sub with discount we get total amount */
				document.getElementById("total").value=fi;
			}
		}
		
		function terms_changed(check) {
			if(check.checked) {
				document.getElementById("submit_button").disable = false;
			}
			else{
				document.getElementById("submit_button").disable = true;
			}
		}
	</script>

</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<body>

	<script>
		function findPrice() {
			var location = document.getElementById("location").value;
			var vtype = document.getElementById("vtype").value;
			var classification = document.getElementById("vclassification").value;
			var term = document.getElementById("term").value;

			const httpRequest = new XMLHttpRequest();
			httpRequest.open("GET", "http://localhost:8080/parking-rental-system/userAjax/"+location + "/" + vtype + "/" + classification + "/" + term);
			
			httpRequest.send();

			httpRequest.onload = function() {
				console.log(this.responseText);
				const obj=JSON.parse(this.responseText);
				console.log(obj)
				console.log(obj.price)
				console.log(obj.discount)
				console.log(obj.total)
			    var pr=document.getElementById("price").value=obj.price;	
				var dis=document.getElementById("discount").value=obj.discount;
				var t = dis/100; /* we r getting value in float */
				var d =pr*t; /* float value and actual value multiply */
				var fi=pr-d; /* original price sub with discount we get total amount */
				document.getElementById("total").value=fi;
			}
		}
		
		function terms_changed(check) {
			if(check.checked) {
				document.getElementById("submit_button").disable = false;
			}
			else{
				document.getElementById("submit_button").disable = true;
			}
		}
	</script>

	<nav class="navbar navbar-expand-sm bg-dark"
		style="background-color: black;">
		<div>
			<img height="50px"
				src="https://img.freepik.com/free-vector/parking_24908-54061.jpg?size=626&ext=jpg&ga=GA1.1.1163619451.1684595486&semt=ais">
		</div>

		<div class="nav navbar-nav navbar-right">
			<div style="position: absolute; margin-left: 190vh">
				<a href="userlogin.jsp"><button type="button"
						class="btn btn-primary button">LogOut</button></a>
			</div>
			<p class="navbar-text"
				style="color: white; font-size: 20px; font-family: serif;">User:
				${userDto.userName}</p>
		</div>
	</nav>
	<h3 align="center">User Parking Information Form</h3>

	<c:forEach items="${errors}" var="error">
		<span style="color: red;">${error.defaultMessage}</span>
		</br>
	</c:forEach>


	<form action="onSave" method="post" enctype="multipart/form-data">

		Location:<select name="location" id="location"><br>
			<option value="0">Select</option>
			<br>

			<option>Rajajinagar</option>
			<option>Vijaynagar</option>
			<option>Shivajinagar</option>
			<option>Basaweshwarnagar</option>
			<option>kamalanagar</option>

		</select>

		<div class="form-group">
			Vehicle Type: <select name="vtype" class="form-control" id="vtype"
				required>
				<option value="">---Select---</option>
				<option>2 Wheeler</option>
				<option>4 Wheeler</option>
				<option>Ev</option>
			</select>
		</div>

		<div class="form-group">
			Vehicle Classification: <select name="vclassification"
				id="vclassification" class="form-control" required>
				<option value="">---Select---</option>
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
		Term:<select name="term" id="term" onchange="findPrice()" required><br>
			<option value="0">Select</option>
			<br>

			<option>1 DAYS</option>
			<option>7 DAYS</option>
			<option>15 DAYS</option>
			<option>30 DAYS</option>
			<option>60 DAYS</option>
			<option>90 DAYS</option>
			<option>180 DAYS</option>
			<option>365 DAYS</option>


		</select> Price:<input type="text" name="price" id="price" readonly="readonly">
		Discount:<input type="text" name="discount" id="discount"
			readonly="readonly"> Total Amount:<input type="number"
			name="totalAmount" id="total" readonly="readonly">
		<div class="form-group">
			Upload Vehicle Image <input type="file" name="file"
				class="form-control" required="required">
		</div>


		<input type="checkbox" required>I Agree

		<button type="submit" class="btn btn-primary">Save</button>

	</form>

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