<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 1. CDN -->
<script src="https://cdn.ckeditor.com/ckeditor5/30.0.0/classic/ckeditor.js"></script>
</head>
<body>
	
	<!-- 2. TEXT 편집 툴을 사용할 textarea -->
	<textarea name="content" id="editor"></textarea>
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
<!-- CKEditor의 설정을 저장한 자바스크립트 파일을 호출 - textarea 아래에 작성 -->
<%-- <script src="${pageContext.request.contextPath}/resources/common/js/ckeditor.js"></script> --%>
</body>
</html>
