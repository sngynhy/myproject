<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
					<ul>
						<c:forEach var="v" items="${sidebarData.cateData}">
						<li><a href="getBoardList.do?b_type=info&cate_id=${v.cate_id}">${v.category}</a></li>
						</c:forEach>
					</ul>
				</li>
				<li><a href="getBoardList.do?b_type=ask">자유 질문 게시판</a></li>
				<li><span class="opener">여행 후기 게시판</span>
					<ul>
						<c:forEach var="v" items="${sidebarData.nationData}">
						<li><a href="getBoardList.do?b_type=review&n_id=${v.n_id}">${v.nation}</a></li>
						</c:forEach>
					</ul>
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