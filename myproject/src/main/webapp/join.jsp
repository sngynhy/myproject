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
									<ul class="icons">
										<li><a href="login.jsp" class="button">LOGIN</a></li>
									</ul>
								</header>

							<!-- Banner -->
								<section>
									<header class="main">
									<div>
										<h1>Join Us</h1>
									</div>
									</header>
									<form method="post" action="insertMember.do" name="form1">
										<div class="row gtr-uniform" style="width: 600px;">
											<div class="col-6 col-12-xsmall">
												<input type="text" name="id" id="id" placeholder="아이디 입력" required="required" />
												<button type="button" onclick="checkID()">중복확인</button>
											</div>
											<div class="col-6 col-12-xsmall">
												<input type="password" name="pw" id="pw" placeholder="비밀번호 입력" required="required" />
											</div>
											<!-- <div class="col-6 col-12-xsmall">
												<input type="password" id="pw" placeholder="비밀번호 확인" required="required" />
											</div> -->
											<div class="col-6 col-12-xsmall">
												<input type="email" name="email" id="email" placeholder="이메일 입력" required="required" />
											</div>
											<div class="col-6 col-12-xsmall">
												<input type="text" name="phone" id="phone" placeholder="휴대폰 번호 입력" required="required" />
											</div>

											<!-- Break -->
											<div class="col-4 col-12-small">
												<input type="radio" id="demo-priority-high" name="demo-priority">
												<label for="demo-priority-high">약관 동의</label>
											</div>
											<!-- Break -->
											<div class="col-12">
												<textarea name="demo-message" id="demo-message" placeholder="Enter your message" rows="6" readonly="readonly">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
												</textarea>
											</div>
											<!-- Break -->
											<div class="col-12">
												<ul class="actions">
													<li><input type="submit" value="JOIN" class="primary" /></li>
													<li><input type="button" value="CANCLE" onclick="location.href='main.jsp'"/></li>
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
	<script type="text/javascript">
		function checkID() {
			
			if($("#id").val() == '') {
				alert("ID를 입력해주세요.");
				return;
			}
			
			$.ajax({ 
				type: "GET",
				url: "checkID.do",
				data: {
					id : $("#id").val() // $().val() : 값 가져오기
				},
				success: function(data) { 
					if (data.trim() == "false") {  // 중복 데이터가 없을 때
						alert("사용 가능한 ID입니다.");
					} else {
						alert("ID가 이미 존재합니다. 다시 입력하세요.");
					}
				},
				error: function(xhr) {
					console.log(xhr.status + " : " + xhr.errorText);
					alert("에러발생!");
				}
			});
		}
	</script>
</html>