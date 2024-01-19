package com.kh.array.practice1;

import java.util.Arrays;

import com.kh.array.practice1.model.Student;

public class Application {
	
	public static void main(String[] args) {
		
//		배열선언과 초기화 : 데이터타입 [] 배열명 = new 데이터타입[]
//		객체배열도 같다 !! 데이터타입에 객체가 들어가면 된다.
		Student[] stuArr = new Student[5];
		
		stuArr[0] = new Student("김길동", "자바", 100);
		stuArr[1] = new Student("박길동", "디비", 50);
		stuArr[2] = new Student("이길동", "화면", 85);
		stuArr[3] = new Student("정길동", "서면", 60);
		stuArr[4] = new Student("홍길동", "자면", 20);
		
		System.out.println(stuArr); // 주소값이 나온다 !!
		System.out.println(Arrays.toString(stuArr));
	
		
		for(int i=0; i<stuArr.length; i++) {
			System.out.println(stuArr[i]);
		}
		
		System.out.println();
		// 위랑 같은것이 출력된다 !!
		// 항상된 for문 = 배열과 조건이 있을때 사용한다 !!
		for(Student student : stuArr) {
			System.out.println(student);
		}
	}

}


