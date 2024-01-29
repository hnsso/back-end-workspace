package com.kh.stream;

import java.util.Arrays;

/*
 * 반복
 * - 요소 전체를 반복하는 역할
 * - peek : 중간 처리 단계에서 전체 요소를 반복하면서 추가적인 작업을 하기 위해 사용
 * - forEach : 최종 처리 단계에서 전체 요소를 반복하면서 추가적인 작업을 하기 위해 사용
 * 
 * */

public class D_Looping {

	public static void main(String[] args) {
		int[] values = { 1, 2, 3, 4, 5 };

		// peek
		int sum = Arrays.stream(values)
				.filter(i -> i % 2 == 0) // 짝수만 가져온다 !
				.peek(value -> System.out.println(value)) // 중간에 해당하는 peek은 마지막에 쓰면 실행이안된다.
				.sum(); // 이렇게 마지막으로 sum을 쓰기때문에 출력가능 // 그리고 sum의 반환 타입이 int여서

		System.out.println("1~5 중 짝수의 합계 : " + sum);

		// forEach
		Arrays.stream(values)
				.filter(i -> i % 2 == 0) // 짝수만 가져온다 !
				.forEach(value -> System.out.println(value)); // 최종처리에서 쓰이는 forEach는 sum이랑 같이 못 쓰인다.
//				.sum();

		int sum2 = Arrays.stream(values)
				.filter(i -> i % 2 == 0)
				.sum();
	
		System.out.println("1~5 중 짝수의 합계 : " + sum2);
	
	}

}

