<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<!DOCTYPE HTML>
<!--
	Editorial by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>WANDERIZM</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body class="is-preload">

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="main">
						<div class="inner">

							<!-- Header -->
								<header id="header">
									<a href="main.jsp" class="logo"><strong>WANDERIZM</strong></a>
								</header>

							<!-- Banner -->
								<section>
									<header class="main">
									<div>
										<h1>Login</h1>
									</div>
									</header>
									<form method="post" action="login.do">
										<div class="row gtr-uniform">
											<div class="col-6 col-12-xsmall" style="width: 200px;">
												<input type="text" name="id" id="demo-name" placeholder="ID" required="required" />
											</div>
											<div class="col-6 col-12-xsmall" style="width: 200px;">
												<input type="password" name="pw" id="demo-email" placeholder="PASSWORD" required="required" />
											</div>
											
											<!-- Break -->
											<div class="col-12">
												<ul class="actions">
													<li><input type="submit" value="Login" class="primary" /></li>
													<li><input type="button" value="Join" onclick="location.href='join.jsp'"/></li>
												</ul>
											</div>
										</div>
									</form>
								</section>
						</div>
					</div>

				<!-- Sidebar -->
					<mytag:sidebar />

			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>