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
										<h3><a href="getBoardList.do?b_type=ask">자유 질문 게시판</a></h3>
									</header>
									
									<!-- 데이터 출력 -->
 									<header class="main">
										<h2>${data.title}</h2>
										<p>
											<span style="padding-right: 22px;">${data.id}</span>
											<span style="padding-right: 22px;">${data.b_date}</span>
										</p>
										<%-- <c:choose>
											<c:when test="${!empty sessionID && data.id != sessionID}">
												<h2>♡</h2>
											</c:when>
										</c:choose> --%>
									</header>
									
									<hr class="major" />
																		
									${data.content}
									
									<hr class="major" />
									<c:choose>
										<c:when test="${data.id == sessionID}">
											<ul class="actions">
												<li><input type="button" value="수정" class="button small" onclick="location.href='updateboardtry.do?b_id=${data.b_id}'"/></li>
												<li><input type="button" value="삭제" class="button small" onclick="location.href='deleteBoard.do?b_id=${data.b_id}'" /></li>
											</ul>
										</c:when>
										<c:when test="${!empty sessionID && data.id != sessionID}">
											<a href="insertBoard.jsp" class="button" style="float: right;">글쓰기</a>
										</c:when>
									</c:choose>
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