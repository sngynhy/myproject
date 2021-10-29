<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맵 API</title>
<style type="text/css">
	* {
		margin: 0px;
		padding: 0px;
	}
	#map {
		border: 2px solid blue;
		width: 800px;
		height: 500px;
	}
</style>
<script src="http://maps.google.com/maps/api/js?key=AIzaSyDTqCPFibwMdZmoT1o42y55-xrzQ-x0oV4&region=kr"></script>
</head>
<body>

	<div id="map"></div>
	<button id="btn1">지도 변경1</button>
	<button id="btn2">지도 변경2</button>
	<button id="btn3">지도 변경3</button>

	<script type="text/javascript">
		var btn1 = document.getElementById("btn1");
		var btn2 = document.getElementById("btn2");
		var btn3 = document.getElementById("btn3");
		btn1.addEventListener("click", changeMap1);
		btn2.addEventListener("click", changeMap2);
		btn3.addEventListener("click", changeMap3);
		
		var map;
		function initMap() { // map 생성 메소드
			var ll = {lat:37.500636 , lng:127.036427}; // lat: 위도, lng: 경도
			map = new google.maps.Map(  // Map(위치, 출력 값) 어디에 무엇을 보여줄 것인지 파라미터로 작성
						document.getElementById("map"),  // 위치
						{zoom:17, center:ll} // 출력 값 - ll를 center값으로 설정
					);
			new google.maps.Marker( // 지도상에 마커 띄우기
				{position:ll, // 마커 위치
					map: map, // 지도
					label: "현재위치"} // 설명
			);
				  
		}
		initMap(); // 선언과 함께 맵 생성
		
		function changeMap1() { // 지도의 중심(위치)을 변경
			var ll = {lat:33.393605, lng:126.563359};
			map.panTo(ll);
			map.setZoom(9);
		}
		function changeMap2() { // 새로운 지도를 로드
			var ll = {lat:-40.339098, lng:175.609729};
			map = new google.maps.Map(
					document.getElementById("map"),
					{zoom:13, center:ll}
					);
		}
		
		function changeMap3() {
			var ll = {lat:37.5354045618112 , lng:126.90226053549485}; // lat: 위도, lng: 경도
			map = new google.maps.Map(  // Map(위치, 출력 값) 어디에 무엇을 보여줄 것인지 파라미터로 작성
						document.getElementById("map"),  // 위치
						{zoom:15, center:ll} // 출력 값 - ll를 center값으로 설정
					);
			var marker = new google.maps.Marker( // 지도상에 마커 띄우기
				{position: ll, // 마커 위치
					map: map, // 지도
					title: "곱창맛집 옛날곱창"} // 마커에 마우스오버 시 보여지는 말풍선
				);
			
			marker.addListener('click', function() {
				map.setZoom(19);
				//map.setCenter(marker.getPosition());
				map.setCenter(ll);
				window.setTimeout(() => {
					open('https://www.google.com/maps/place/%EB%8B%B9%EC%82%B0%EC%98%9B%EB%82%A0%EA%B3%B1%EC%B0%BD/@37.5346142,126.8992023,17z/data=!4m9!1m2!2m1!1z64u57IKwIOyYm-uCoOqzseywvQ!3m5!1s0x357c9f7e3711fbcb:0xe7af5fb1d6addc18!8m2!3d37.5353365!4d126.9022659!15sChPri7nsgrAg7Jib64Kg6rOx7LC9WhYiFOuLueyCsCDsmJvrgqAg6rOx7LC9kgEKcmVzdGF1cmFudJoBI0NoWkRTVWhOTUc5blMwVkpRMEZuU1VOeGFVMXRNRk5SRUFF?hl=ko','_blank');
				    }, 2500);
			});
		
		}
	</script>
	
	
</body>
</html>