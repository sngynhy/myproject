<%@ tag language="java" pageEncoding="UTF-8"%>
<div id="sidebar">
	<div class="inner">

		<!-- Search -->
		<section id="search" class="alt">
			<form method="post" action="#">
				<input type="text" name="query" id="query" placeholder="Search" />
			</form>
		</section>

		<!-- Menu -->
		<nav id="menu">
			<header class="major">
				<h2>Menu</h2>
			</header>
			<ul>
				<li><a href="index.jsp">FOR WANDERIER</a></li>
				<li><span class="opener">여행 정보 게시판</span>
					<!-- <ul>
						<li><a href="getBoardList.do?b_type=info&cate_id=tf">교통 정보</a></li>
						<li><a href="getBoardList.do?b_type=info&cate_id=rm">숙소 정보</a></li>
						<li><a href="getBoardList.do?b_type=info&cate_id=rt">맛집 정보</a></li>
					</ul> -->
				</li>
				<li><a href="getBoardList.do?b_type=ask">자유 질문 게시판</a></li>
				<li><span class="opener">여행 후기 게시판</span>
					<!-- <ul>
						<li><a href="getBoardList.do">프랑스</a></li>
						<li><a href="getBoardList.do">영국</a></li>
						<li><a href="getBoardList.do">이탈리아</a></li>
						<li><a href="getBoardList.do">독일</a></li>
						<li><a href="getBoardList.do">스페인</a></li>
					</ul> -->
				</li>
				<li><a href="generic.jsp">generic</a></li>
				<li><a href="elements.jsp">element</a></li>
			</ul>
		</nav>

		<!-- Section -->
		<section>
			<header class="major">
				<h2>Get in touch</h2>
			</header>
			<p>Sed varius enim lorem ullamcorper dolore aliquam aenean ornare
				velit lacus, ac varius enim lorem ullamcorper dolore. Proin sed
				aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus
				aliquam.</p>
			<ul class="contact">
				<li class="icon solid fa-envelope"><a href="#">information@untitled.tld</a></li>
				<li class="icon solid fa-phone">(000) 000-0000</li>
				<li class="icon solid fa-home">1234 Somewhere Road #8254<br />
					Nashville, TN 00000-0000
				</li>
			</ul>
		</section>

		<!-- Footer -->
		<footer id="footer">
			<p class="copyright">
				&copy; Untitled. All rights reserved. Demo Images: <a
					href="https://unsplash.com">Unsplash</a>. Design: <a
					href="https://html5up.net">HTML5 UP</a>.
			</p>
		</footer>

	</div>
</div>