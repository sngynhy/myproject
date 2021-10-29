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
										<h3>자유 질문 게시판</h3>
									</header>
									<div class="table-wrapper">
											<table>
												<thead>
													<tr>
														<th style="text-align: center;">No.</th>
														<th style="width: 50%; text-align: center;">제목</th>
														<th style="text-align: center;">작성자</th>
														<th style="text-align: center;">작성날짜</th>
														<th style="width: 10%; text-align: center;">♡</th>
													</tr>
												</thead>
												<tbody>
												<c:choose>
													<c:when test="${empty datas}">
														<tr>
															<td colspan="5" align="center">등록된 게시글이 없습니다.</td>
														</tr>
													</c:when>
													<c:otherwise>
														<c:forEach var="v" items="${datas}">
															<tr>
																<td style="text-align: center;">${v.b_id}</td>
																<td style="width: 50%; text-align: center;"><a href="getBoard.do?b_id=${v.b_id}">${v.title}</a> [${v.r_cnt}]</td>
																<td style="text-align: center;">${v.id}</td>
																<td style="text-align: center;">${v.b_date}</td>
																<td style="width: 10%; text-align: center;">${v.like_cnt}</td>
															</tr>
														</c:forEach>
													</c:otherwise>
												</c:choose>
												</tbody>
												<c:choose>
													<c:when test="${!empty sessionID}">
														<tfoot>
															<tr align="right">
																<td colspan="4"></td>
																<td><a href="insertBoard.jsp" class="button">글쓰기</a></td>
															</tr>
														</tfoot>
													</c:when>
												</c:choose>
											</table>
									</div>
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