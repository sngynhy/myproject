<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<script src="http://maps.google.com/maps/api/js?key=AIzaSyDTqCPFibwMdZmoT1o42y55-xrzQ-x0oV4&region=kr"></script>
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
									<mytag:login />
								</header>

							<!-- Section -->
								<section style="padding-top: 35px;">
									<header class="major">
										<h3>나의 정보 수정</h3>
									</header>
									
									<form method="post" action="updateMember.do" name="form1">
										<div class="row gtr-uniform" style="width: 600px;">
											<div class="col-6 col-12-xsmall">
												아이디<input type="text" name="id" id="id" value="${data.id}" readonly="readonly" />
											</div>
											<div class="col-6 col-12-xsmall">
												이메일<input type="email" name="email" id="email" value="${data.email}" required="required" />
											</div>
											<div class="col-6 col-12-xsmall">
												휴대폰 번호<input type="text" name="phone" id="phone" value="${data.phone}" required="required" />
											</div>

											<div class="col-6 col-12-xsmall">
												비밀번호<br><input type="button" name="pw" id="pw" onclick="" value="비밀번호 변경하기" />
											</div>
											
											<!-- Break -->
											<div class="col-12">
												<ul class="actions">
													<li><input type="submit" value="수정" class="primary" /></li>
													<li><input type="button" value="탈퇴" id="del" onclick="location.href='deleteMember.do'" /></li>
													<li><input type="button" value="취소" onclick="location.href='main.jsp'"/></li>
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
			<script src="jquery-3.6.0.min.js"></script>
	</body>

</html>