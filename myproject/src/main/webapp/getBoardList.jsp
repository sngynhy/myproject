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
										<mytag:category />
									</header>
									<div class="table-wrapper"> <!-- style="height: 487.36px;" -->
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
															<c:if test="${b_type eq 'info'}">
																<td><a href="insertBoardTry.do?b_type=info&cate_id=${cate_id}" class="button">글쓰기</a></td>
															</c:if>
															<c:if test="${b_type eq 'ask'}">
																<td><a href="insertBoardTry.do?b_type=ask" class="button">글쓰기</a></td>
															</c:if>
															<c:if test="${b_type eq 'review'}">
																<td><a href="insertBoardTry.do?b_type=review&a_id=${a_id}&n_id=${n_id}" class="button">글쓰기</a></td>
															</c:if>
														</tr>
													</tfoot>
												</c:when>
											</c:choose>
										</table>
									</div>
									
									<!-- 페이징 -->
									<ul class="pagination" style="text-align: center;">
										<li><span class="button disabled">Prev</span></li>
										<li><a href="#" class="page active">1</a></li>
										<li><a href="#" class="page">2</a></li>
										<li><a href="#" class="page">3</a></li>
										<li><span>&hellip;</span></li>
										<li><a href="#" class="page">8</a></li>
										<li><a href="#" class="page">9</a></li>
										<li><a href="#" class="page">10</a></li>
										<li><a href="#" class="button">Next</a></li>
									</ul>
									
									<!-- 검색 -->
									<section id="search" class="alt">
									<form method="get" action="getBoardList.do">
										<select name="condition" id="condition" style="width: 12%;">
											<option value="title">제목</option>
											<option value="content">내용</option>
											<option value="id">작성자</option>
										</select>
										<input type="hidden" name="b_type" value="${b_type}">
										<input type="hidden" name="cate_id" value="${cate_id}">
										<input type="hidden" name="n_id" value="${n_id}">
										<input type="text" name="keyword" id="keyword" placeholder="Search" />
									</form>
									</section>
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
	<script>
		function changeCateId(obj) {
			var selectValue = obj.value;
			/* console.log(selectValue); */
			window.location.href="getBoardList.do?b_type=info&cate_id=" + selectValue;
		}
		function changeN_Id(obj) {
			var selectValue = obj.value;
			/* console.log(selectValue); */
			window.location.href="getBoardList.do?b_type=review&n_id=" + selectValue;
		}
	</script>
</html>