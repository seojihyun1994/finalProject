<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath() ;

%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="author" content="Untree.co">
	<link rel="shortcut icon" href="favicon.png">

	<meta name="description" content="" />
	<meta name="keywords" content="bootstrap, bootstrap4" />

	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;700&family=Source+Serif+Pro:wght@400;700&display=swap" rel="stylesheet">

	<link rel="stylesheet" href="<%=contextPath%>/bootstrap/tour/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=contextPath%>/bootstrap/tour/css/owl.carousel.min.css">
	<link rel="stylesheet" href="<%=contextPath%>/bootstrap/tour/css/owl.theme.default.min.css">
	<link rel="stylesheet" href="<%=contextPath%>/bootstrap/tour/css/jquery.fancybox.min.css">
	<link rel="stylesheet" href="<%=contextPath%>/bootstrap/tour/fonts/icomoon/style.css">
	<link rel="stylesheet" href="<%=contextPath%>/bootstrap/tour/fonts/flaticon/font/flaticon.css">
	<link rel="stylesheet" href="<%=contextPath%>/bootstrap/tour/css/daterangepicker.css">
	<link rel="stylesheet" href="<%=contextPath%>/bootstrap/tour/css/aos.css">
	<link rel="stylesheet" href="<%=contextPath%>/bootstrap/tour/css/style.css">

	<title>Tour Free Bootstrap Template for Travel Agency by Untree.co</title>
</head>

<body>


	<div class="site-mobile-menu site-navbar-target">
		<div class="site-mobile-menu-header">
			<div class="site-mobile-menu-close">
				<span class="icofont-close js-menu-toggle"></span>
			</div>
		</div>
		<div class="site-mobile-menu-body"></div>
	</div>

	<nav class="site-nav">
		<div class="container">
			<div class="site-navigation">
				<a href="index.html" class="logo m-0">Tour <span class="text-primary">.</span></a>

				<ul class="js-clone-nav d-none d-lg-inline-block text-left site-menu float-right">
					<li class="active"><a href="index.html">Home</a></li>
					<li class="has-children">
						<a href="#">Dropdown</a>
						<ul class="dropdown">
							<li><a href="elements.html">Elements</a></li>
							<li><a href="#">Menu One</a></li>
							<li class="has-children">
								<a href="#">Menu Two</a>
								<ul class="dropdown">
									<li><a href="#">Sub Menu One</a></li>
									<li><a href="#">Sub Menu Two</a></li>
									<li><a href="#">Sub Menu Three</a></li>
								</ul>
							</li>
							<li><a href="#">Menu Three</a></li>
						</ul>
					</li>
					<li><a href="services.html">Services</a></li>
					<li><a href="about.html">About</a></li>
					<li><a href="contact.html">Contact Us</a></li>
				</ul>

				<a href="#" class="burger ml-auto float-right site-menu-toggle js-menu-toggle d-inline-block d-lg-none light" data-toggle="collapse" data-target="#main-navbar">
					<span></span>
				</a>

			</div>
		</div>
	</nav>


	

	<script src="<%=contextPath%>/bootstrap/tour/js/jquery-3.4.1.min.js"></script>
	<script src="<%=contextPath%>/bootstrap/tour/js/popper.min.js"></script>
	<script src="<%=contextPath%>/bootstrap/tour/js/bootstrap.min.js"></script>
	<script src="<%=contextPath%>/bootstrap/tour/js/owl.carousel.min.js"></script>
	<script src="<%=contextPath%>/bootstrap/tour/js/jquery.animateNumber.min.js"></script>
	<script src="<%=contextPath%>/bootstrap/tour/js/jquery.waypoints.min.js"></script>
	<script src="<%=contextPath%>/bootstrap/tour/js/jquery.fancybox.min.js"></script>
	<script src="<%=contextPath%>/bootstrap/tour/js/aos.js"></script>
	<script src="<%=contextPath%>/bootstrap/tour/js/moment.min.js"></script>
	<script src="<%=contextPath%>/bootstrap/tour/js/daterangepicker.js"></script>

	<script src="<%=contextPath%>/bootstrap/tour/js/typed.js"></script>
	<script>
		$(function() {
			var slides = $('.slides'),
			images = slides.find('img');

			images.each(function(i) {
				$(this).attr('data-id', i + 1);
			})

			var typed = new Typed('.typed-words', {
				strings: ["San Francisco."," Paris."," New Zealand.", " Maui.", " London."],
				typeSpeed: 80,
				backSpeed: 80,
				backDelay: 4000,
				startDelay: 1000,
				loop: true,
				showCursor: true,
				preStringTyped: (arrayPos, self) => {
					arrayPos++;
					console.log(arrayPos);
					$('.slides img').removeClass('active');
					$('.slides img[data-id="'+arrayPos+'"]').addClass('active');
				}

			});
		})
	</script>

	<script src="<%=contextPath%>/bootstrap/tour/js/custom.js"></script>

</body>

</html>
