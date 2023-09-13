<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
</head>

<script>
    var mins=5;
    var secs=mins*60;
    function countdown() {
        setTimeout('Decrement()',60);
    }
    function Decrement() {
        if(document.getElementById) {
            minutes=document.getElementById("minutes");
            seconds=document.getElementById("seconds");
            if(seconds<59) {
                seconds.value=secs;
            }
            else {
                minutes.value=getminutes();
                seconds.value=getseconds();
            }
            if(mins<1) {
                minutes.style.color="red";
                seconds.style.color="red";
            }
            if(mins<0) {
                alert('time up');
                minutes.value=0;
                seconds.value=0;
            }
            else {
                secs--;
                setTimeout('Decrement()',1000);
            }
        }
    }
 
    function getminutes() {
        mins=Math.floor(secs/60);
        return mins;
    }
 
    function getseconds() {
        return secs-Math.round(mins*60);
    }
</script>


<body>
<nav class="navbar navbar-expand-sm bg-dark" style="background-color: black;">
        
            <img height="50px"
                src="https://img.freepik.com/free-vector/parking_24908-54061.jpg?size=626&ext=jpg&ga=GA1.1.1163619451.1684595486&semt=ais">
            <div class="buttons">
  			<a href="home.jsp"><button type="button" class="btn btn-primary button">Home</button></a>
  		</div>
	</nav>
	
	<h3 align="center">User SingIn</h3>
	
<div class="container">
<div class="card border-0 shadow">
<div class="card-body">
		
		<span style="color: green;">${successMsg}</span>
		
		<form action="sendotp" method="post">
			
			
			<div class="mb-3">
    			<input type="email" name="userEmail" value="${emailId}" placeholder="Enter Email Id">
    			<input type="submit" name="generateOtp" value="generateOtp" onclick="countdown();" >
    		</div>
    		
    		<div class="mb-3">
    			<input type="text" name="otp" placeholder="Enter your otp">
    			 <input type="submit" name="login" value="Login"> <!-- onclick="passwordValidation()" -->
    			<span style="color: red;">${error}</span>
    		</div>
    		
    	<div id="some_div"></div>
    		<div style="display: flex; width:80%;
                		justify-content:center; padding-top: 0%;">
        		Time Left ::
    	</div>
    	<div style="display: flex; width:80%;
                		justify-content:center; padding-top: 0%;">
        	<input id="minutes" type="text" style="width: 8%; border: none; font-size: 16px;
                      font-weight: bold; color: black;">
        	<font size="5">
            	:
       	 	</font>
        	<input id="seconds" type="text" style="width: 8%; border: none; font-size: 16px;
                      font-weight: bold; color: black;">
    	</div>
    	
<!--     			<input type="submit" value="Submit">
 -->    	
    		
		</form>
</div>
</div>
</div>
		
	<footer>
		<div class="footer-bottom">

			<small>@ 2023 Copyright &copy; xworkz.com</small>
		

		</div>
	</footer>

</body>
</html>