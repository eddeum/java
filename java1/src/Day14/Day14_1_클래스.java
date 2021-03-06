package Day14;

public class Day14_1_클래스 {
	public static void main(String[] args) {
		
		// 클래스
			// 클래스 사용하는 이유
			// 1. 여러개의 변수[메모리] 묶음 관리
			// 2. 클래스(설계도 : 목적) 기반으로 많은 (서로다른)객체를 생성할수 있음
				// * 주차관리 설계
					// 차량번호, 입차시간, 출차시간, 금액, 필드에 배열도 가능..!
				// * 차량 객체 
					// 변수4개 * 차량수   vs   차량수 * 객체수[관리가 편함]
			// 3. API(라이브러리) : 미리 만들어진 클래스
				// * String 클래스
				// * Scanner 클래스
				// 만들어진 클래스를 이용한 빠른 개발 가능
			// 4.  1. 필드[기록=저장=메모리]  2.생성자[객체생성시초기값]  3.메소드
				// 필드 : 변수, 매열, 객체, 인터페이스 등
				// 생성자 : 선택
					// 붕어빨틀[클래스]
						// 필드 : 내용물[팥, 크림]
					// 붕어빵틀[클래스] -> 빈 생성자			-> 내용물 없는 붕어빵[객체] -> 추후에 내용물 추가가능
					// 붕어빵틀[클래스] -> 풀 생성자			-> 내용물 있는 붕어빵[객체]
				// 메소드 : 코드 묶음처리
		// 예1) 회원
			// 회원가입 할때 필요한 기록[메모리]
		// * 객체화가 아닐경우 -> 변수
			// 1. 회원이 생성될때마다 변수의 수 회원수*변수 = 변수가 많아서 관리가 어려움
			// 2. 변수가 동일하면 배열을 사용가능 / 하지만 서로 다른 변수간 배열 x( 서로 다른 자료형x)
			// 회원1
			String id = "qweqwe";
			String password = "qweqwe";
			String name = "qweqwe";
			int point = 10;		
			// 회원2
			String id2 = "asdasd";
			String password2 = "asdasd";
			String name2 = "asdasd";	
			int point2 = 10;
			
		// * 객체화
			// 회원1
			회원 회원1 = new 회원();
			회원1.id = "qweqwe";
			회원1.password = "qweqwe";
			회원1.name = "qweqwe";
			회원1.point = 10;
			// 회원2
			회원 회원2 = new 회원();
			회원2.id = "asdasd";
			회원2.password = "asdasd";
			회원2.name = "asdasd";
			회원2.point = 10;			
		
		
	} // me

} // ce
