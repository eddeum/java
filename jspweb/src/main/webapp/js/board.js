
// 문서 열렸을때 함수 무조건 실행
$(document).ready(function(){
	$('#summernote').summernote({
		placeholder: '내용 입력',
		tabsize: 2,
		minheight : 250, // 최소 높이
		maxheight : null, // 최대 높이
		lang : 'ko-KR'	// 메뉴 한글버전
	});
});
