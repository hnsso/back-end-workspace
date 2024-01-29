package com.kh.lambda;

/*
 * 람다식(Lambda Expressions) => 자바스크립트의 화살표 함수 !
 * - 자바에서 함수적 프로그래밍을 위해서 자바 8부터 람다식을 지원
 * - 람다식은 매개변수를 가지는 함수와 같은 코드 블록이지만 런타임 시에는 인터페이스의 익명 구현 객체를 생성한다 .
 * - 람다식을 사용하면 코드가 간결해지고, 컬렉션 요소들을 필터링하거나 매핑해서
 * 	 원하는 결과를 쉽게 가져올수있다. 
 * 
 * */ 

public class Application {

	public static void main(String[] args) {

		int a = 10;
		int b = 3;

		Application app = new Application();
		// 객체 생성 => 우리는 static이니깐 밖에있는 기능을 쓸려면 객체를 생성해야한다
		System.out.println(app.plus(a, b));

		System.out.println(app.minus(a, b));

		System.out.println(app.multiple(a, b));

		System.out.println(app.divide(a, b));

		// 람다식으로 바꿔보기 !! -- > main 메서드에서 사용중이다
		MathInterface plusLambda = (int x, int y) -> {
			return x + y;
		};
		MathInterface minusLambda = (int x, int y) -> x - y;
		MathInterface multipleLambda = (int x , int y) -> x * y ;
		MathInterface divideLambda = (int x , int y) -> x / y ;
		
		System.out.println(plusLambda.calc(a, b));
		System.out.println(minusLambda.calc(a, b));
		System.out.println(multipleLambda.calc(a, b));
		System.out.println(divideLambda.calc(a, b));
	}

	// 기능을 뺴서 만드는 방식 !!!
	public int plus(int a, int b) {
		return a + b;
	}

	public int minus(int a, int b) {
		return a - b;
	}

	public int multiple(int a, int b) {
		return a * b;
	}

	public int divide(int a, int b) {
		return a / b;
	}

}
