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
									<a href="#" class="logo"><strong>WANDERIZM</strong></a>
									<mytag:login />
								</header>

							<!-- Banner -->
								<section id="banner">
									<div class="content">
										<header>
											<h1>Hi, I'm Editorial<br />
											by HTML5 UP</h1>
											<p>A free and fully responsive site template</p>
										</header>
										<p>Aenean ornare velit lacus, ac varius enim ullamcorper eu. Proin aliquam facilisis ante interdum congue. Integer mollis, nisl amet convallis, porttitor magna ullamcorper, amet egestas mauris. Ut magna finibus nisi nec lacinia. Nam maximus erat id euismod egestas. Pellentesque sapien ac quam. Lorem ipsum dolor sit nullam.</p>
										<ul class="actions">
											<li><a href="#" class="button big">Learn More</a></li>
										</ul>
									</div>
									<span class="image object">
									<!-- 지도 출력 -->
										<!-- <img src="images/pic10.jpg" alt="" /> -->
										<div id="map" style="width: 100%; height: 100%;"></div>
									</span>
								</section>

							
							<!-- Section -->
								<section>
									<header class="major">
										<h2>Ipsum sed dolor</h2>
									</header>
									<div class="posts">
										
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
	
	<script type="text/javascript">
		var map;
		function initMap() { // map 생성 메소드
			var ll = {lat:47.585782536579124, lng:14.073004922524557}; // lat: 위도, lng: 경도
			map = new google.maps.Map(  // Map(위치, 출력 값) 어디에 무엇을 보여줄 것인지 파라미터로 작성
						document.getElementById("map"),  // 위치
						{zoom:5, center:ll} // 출력 값 - ll를 center값으로 설정
					);
			new google.maps.Marker( // 지도상에 마커 띄우기
				{position:ll, // 마커 위치
					map: map, // 지도
					label: "현재위치"} // 설명
			);
		}
		initMap(); // 선언과 함께 맵 생성
	</script>
</html>