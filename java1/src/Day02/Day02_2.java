package Day02;

public class Day02_2 { // c s

	public static void main(String[] args) { // m s
		
		// ; : 실행 단위 구분
		// 동일한 변수명은 사용할 수 없다. [이름이 중복되면 오류(구분불가)]
		
		// p.40 byte : 1바이트 +-128
		byte var1 = -128;	System.out.println(var1);
		byte var2 = - 30;	System.out.println(var2);
		byte var3 = 30;		System.out.println(var3);
		// byte var4 = 300;	System.out.println(var4); -> 오류
			// 오류 발생 : 128 이상은 저장할 수 없다.
		byte var4 = 'j';	System.out.println(var4);
			// 문자 입력 -> 정수로 변환시킴[아스키 코드]
		
		// p.43 char : 2바이트[1문자 저장가능] : 유니코드(2바이트 : 전세계모든문자/java) vs 아스키코드(
		char c1 = 'a';		System.out.println(c1);
		char c2 = 97;		System.out.println(c2);		// 10진수 표현 : 0~9
			// 정수 -> 문자 변환
		char c3 = '\u0041';	System.out.println(c3); 	// 16진수 표현 
		char c4 = '가';		System.out.println(c4);
		char c5 = 44032;	System.out.println(c5);
		char c6 = '\uac00';	System.out.println(c6);
		// 진법[왜 ?? 컴퓨터가 2진수만 사용하면 표현단위 적다 ---> 표현단위 다양성
			// 2진수 : 0, 1 / 기계어(2진코드) / 용량(1비트)
			// 8진수 : 0 ~ 7
			// 10진수 : 0 ~ 9
			// 16진수 : 0 ~ 9 a b c d e f
		
		// p.44 short : 2바이트 정수 +-3만정도
		short num1 = 30000;	System.out.println(num1);
		//short num2 = 40000; System.out.println(num2); // 오류 발생
		
		// p.45 int : 4바이트 정수 +-20억정도(정수의 기본타입)
		int num2 = 10;	System.out.println(num2);	// 10진수
		int num3 = 012;	System.out.println(num3);	// 8진수는 앞에 0 붙이기
		int num4 = 0xA;	System.out.println(num4); 	// 16진수는 앞에 0x 붙이기

		// p.46 long : 8바이트 정수 +-20억정도[데이터 뒤에 L]
		long num5 = 10000000000L;		System.out.println(num5);
				// INT형 -> long형
		
		// p.47~48 float[데이터 뒤에 f] : 4바이트(소수점 8자리까지 표현) / double(실수 기본타입) : 8바이트(소수점 17자리까지 표현)
		double num6 = 3.14; System.out.println(num6);
		float num7 = 3.14f;	System.out.println(num7);
		
		double num8 = 0.1234567890123456789111111111;	System.out.println(num8);
		float num9 = 0.123456789012345678911111111f;	System.out.println(num9);
		
		// p.48 boolean : 1비트[true 혹은 false]
			// 스위치 : on, off
		boolean bo1 = true;	System.out.println(bo1);
		
		// p.49 :  타입변환
			//            ------------>>>>------------ 자동형변환 방향------->>
			// * 크기순서 : byte -> short -> int -> long -> float -> double
			//			  ------------<<<<------------ 강제형변환 방향-------<<
			// 1. 자동 형변환 :
				// 작은상자에서 큰상자로 이동 가능
				// 큰상자에서 작은상자로 이동 불가
			byte 바이트 = 10;
			int 인트 = 바이트; // 자동 형변환 O
			// short 쇼트 = 인트;	// 자동 형변환 X -> 오류 발생
		
			// 2. 강제 형변환(캐스트 or 캐스팅)
				// 큰상자에서 작은상자로 이동 가능인데.. 단 데이터 손실됨
				// (변경할자료형)변수명
			short 쇼트 = (short)인트; // int형 변수를 short로 변환하는데 데이터 잘림
		
	} // m e
} // c e
