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
									<c:choose>
										<c:when test="${data.b_type eq 'info'}">
											<h3>정보 공유 게시판</h3>
											<c:forEach var="v" items="${sidebarData.cateData}">
												<c:if test="${data.cate_id eq v.cate_id}">
													<h4 style="color: gray;">${v.category}</h4>
												</c:if>
											</c:forEach>
										</c:when>
										<c:when test="${data.b_type eq 'ask'}">
											<h3>자유 질문 게시판</h3>
										</c:when>
										<c:when test="${data.b_type eq 'review'}">
											<h3>여행 후기 게시판</h3>
											<c:forEach var="v" items="${sidebarData.nationData}">
												<c:if test="${data.n_id eq v.n_id}">
													<h4 style="color: gray;">${v.nation}</h4>
												</c:if>
											</c:forEach>
										</c:when>
									</c:choose>
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
											<ul class="actions" style="float: right;">
												<li><input type="button" value="수정" class="button small" onclick="location.href='updateboardtry.do?b_id=${data.b_id}'"/></li>
												<li><input type="button" value="삭제" class="button small" onclick="deleteBoard('${data.b_id}', '${data.b_type}', '${data.cate_id}', '${data.a_id}', '${data.n_id}')" /></li>
											</ul>
										</c:when>
										<c:when test="${!empty sessionID && data.id != sessionID}">
										<ul class="actions" style="float: right;">
											<c:if test="${data.b_type eq 'info'}">
											<li><a href="insertBoardTry.do?b_type=info&cate_id=${cate_id}" class="button small" style="float: right;">글쓰기</a></li>
											</c:if>
											<c:if test="${data.b_type eq 'ask'}">
												<td><a href="insertBoardTry.do?b_type=ask" class="button small" style="float: right;">글쓰기</a></td>
											</c:if>
											<c:if test="${data.b_type eq 'review'}">
												<td><a href="insertBoardTry.do?b_type=review&a_id=${a_id}&n_id=${n_id}" class="button small" style="float: right;">글쓰기</a></td>
											</c:if>
											<li><a href="javascript:window.history.go(-1)" class="button small" style="float: right;">전체 목록</a></li>
										</ul>
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
	<script type="text/javascript">
		function deleteBoard(b_id, b_type, cate_id, a_id, n_id) {
			window.location.href="deleteBoard.do?b_id="+b_id+"&b_type="+b_type+"&cate_id="+cate_id+"&a_id="+a_id+"&n_id="+n_id;
		}
	</script>
</html>