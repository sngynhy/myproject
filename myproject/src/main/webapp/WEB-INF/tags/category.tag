<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${b_type eq 'info'}">
		<h3>정보 공유 게시판</h3>
		<form method="post" action="getBoardList.do">
			<select name="cate_id">
			<c:forEach var="v" items="${sidebarData.cateData}">
				<option value="${v.cate_id}">${v.category}</option>
			</c:forEach>
			</select>
		</form>
	</c:when>
	<c:when test="${b_type eq 'ask'}">
		<h3>자유 질문 게시판</h3>
	</c:when>
	<c:when test="${b_type eq 'review'}">
		<h3>여행 후기 게시판</h3>
		<form method="post" action="getBoardList.do">
			<select name="n_id">
			<c:forEach var="v" items="${sidebarData.nationData}">
				<option value="${v.n_id}">${v.nation}</option>
			</c:forEach>
			</select>
		</form>
	</c:when>
</c:choose>