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
		<script src="https://cdn.ckeditor.com/ckeditor5/30.0.0/classic/ckeditor.js"></script>
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
								
								<!-- 게시글 입력 폼 -->
								<form method="post" action="updateBoard.do">
									<input type="hidden" name="id" value="${sessionID}">
									<input type="hidden" name="b_type" value="ask">
									<input type="hidden" name="b_id" value="${data.b_id}">
										<!-- <h2>제목 : </h2> -->
										<div class="row gtr-uniform">
											<div class="col-12">
												<input type="text" name="title" id="title" value="${data.title}" required="required" />
											</div>
										</div>
									<textarea name="content" id="editor">${data.content}</textarea>
									<input type="submit" value="등록" class="button" style="float: right;">
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
	<script>
    // 3. CKEditor5를 생성할 textarea 지정
    ClassicEditor
	.create( document.querySelector('#editor') )
	.then( editor => { 

        console.log( editor ); 

    } )
	.catch( error => {
		console.error( error );
	} );
    </script>
</html>