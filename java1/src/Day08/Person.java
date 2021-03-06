package Day08;

public class Person {
	
	// static + final : 객체 없이프로그램 전반적으로 사용되는 상수
	static final double pi = 3.14;
	// static : 객체없이 프로그램 전반적으로 사용되는 변수
	static double pi2 = 3.14;
	// final : 객체 내에서 사용되는 상수
	final double pi3 = 3.14;
	
	// 1. 필드
	final String nation = "Korea";	// final 고정값(수정불가능)
	final String ssn;				// final 고정값
	String name;

	
	// 2. 생성자[객체 초기화]
	public Person(String ssn, String name) {
		this.ssn = ssn;
		this.name = name;
	}
	
	// 3. 메소드
	
	
	
}
