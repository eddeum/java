<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<!-- 현재 위치에 다른 파일을 포함하기 -->
	<%@include file="header.jsp" %>
	
	<!-- 캐러셀 : 이미지 슬라이드 -->
	<div id="cs" class="carousel slide" data-bs-ride="carousel" data-bs-interval="1000">
														<!-- 슬라이드시간 : 밀리초(1/1000초) -->
		<!-- 슬라이드 위치 표시 : 인디케이터 -->
		<div class="carousel-indicators">
			<button data-bs-target="cs" data-bs-slide-to="0" class="active"></button>
			<button data-bs-target="cs" data-bs-slide-to="1" class=></button>
			<button data-bs-target="cs" data-bs-slide-to="2" class=></button>
			<button data-bs-target="cs" data-bs-slide-to="3" class=></button>
			<button data-bs-target="cs" data-bs-slide-to="4" class=></button>
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active"> <img alt="" src="img/2.jpg"> </div>
			<div class="carousel-item"> <img alt="" src="img/3.jpg"> </div>
			<div class="carousel-item"> <img alt="" src="img/4.jpg"> </div>
			<div class="carousel-item"> <img alt="" src="img/5.jpg"> </div>
			<div class="carousel-item"> <img alt="" src="img/6.jpg"> </div>
		</div>
		<!-- 이미지 이동버튼 -->
		<button class="carousel-control-prev" data-bs-target="#cs" data-bs-slide="prev">
			<span class="carousel-control-prev-icon"></span>
		</button>
		<button class="carousel-control-next" data-bs-target="#cs" data-bs-slide="next">
			<span class="carousel-control-next-icon"></span>
		</button>
	</div> <!-- 캐러셀 end -->
	<br><br>
	
	<div class="container text-center">
		<hr> <!-- 실선 태그 -->
			<h3>New ARRIVAL</h3>
			<p>신상품</p>
	</div>	
	<div class="container">
		<div class="row">
		
			<%for(int i=0; i<8; i++){ %>
			<div class="col-md-3 col-sm-6"> <!-- col-md : 760px 이상일경우 / col-sm : 570px 이상일 경우 -->
				<div class="card"> <!-- 카드형식 -->
					<img class="card-img-top" alt="" src="img/item1.jpg">
					<div class="card-body">
						<p class="item">
							<span class="title">[셀라업텐션 레깅스 마지막 1+1]</span>
							<br>
							<span class="content">누적 판매 500만장! 퍼펙트핏 퍼포먼스 레깅스
							본 1+1 최저가 이벤트는 사이즈별 품절 시 리오더 없이 이벤트가 종료됩니다.
							</span>
							<br>
							<span class="price">79,900원</span> 
							<span class="price2">39,900원</span>
							<br>
							<span class="badge bg-warning text-dark my-3">주문폭주</span>
							<span class="badge bg-danger text-dark my-3">품절임박</span>
						</p>
					</div>
				</div>
			</div>
			<%} %>
		</div>
	</div>
		
	<%@include file="footer.jsp" %>

</body>
</html>