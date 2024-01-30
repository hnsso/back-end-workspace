package com.kh.stream.terminal;

import java.util.Arrays;
import java.util.List;

import com.kh.stream.model.Student;

/*
 * 매칭
 * - 최종 처리 단계에서 요소들이 특정 조건에 만족하는지 조사하는 역할
 * - allMatch : 모든 요소들이 매개 값으로 주어진 조건을 만족하는지 조사
 * - anyMatch : 최소한 한 개의 요소가 매개 값으로 주어진 조건을 만족하는지 조사
 * - noneMatch : 모든 요소들이 매개 값으로 주어진 조건을 만족하지 않는지 조사 
 * */

public class A_Match {

	public static void main(String[] args) {
		A_Match a = new A_Match();
//		a.method1();
		a.method2();
	}

	public void method1() {
		int[] values = {2, 4, 6};
		boolean result = Arrays.stream(values).allMatch(value -> value % 2 == 0);
		
		System.out.println("짝수만 가지고 있는가 ? " + result);
		
		// stream은 일회성이여서 쓸려면 다시 작성해야한다
		result = Arrays.stream(values).anyMatch(value -> value % 3 == 0);
		
		System.out.println("3의 배수 값이 하나라도 있는가 ? " + result);
		
	 	result = Arrays.stream(values).noneMatch(value -> value % 5 == 0);
	
	 	System.out.println("모두 다 5의 배수가 아닌가 ? " + result);
	}
	
	public void method2() {
		List<Student> students = Arrays.asList(
				new Student("이상현", 25, "남자", 50, 80),
				new Student("정동준", 28, "남자", 90, 90),
				new Student("이상호", 26, "남자", 80, 70),
				new Student("권예빈", 27, "여자", 75, 80),
				new Student("조세미", 24, "여자", 85, 65));
		//나이가 25살 이상인 학생들이 모두 남자인지 확인 (allMatch)
		
		// 
		
		boolean result = students.stream()
//				.allMatch(student -> student.getGender().equals("남자") && student.getAge() >= 25);
				.filter(student -> student.getAge() >= 25) // filter로 한번 중간정리후 
				.allMatch(student -> student.getGender().equals("남자")); // allMatch
		
		
		System.out.println("나이가 25살 이상인 학생들이 모두 남자인가 ? " + result);
	
		// 남학생들 중에 평균이 70점 이상인 학생이 한명이라도 존재 하는지 (anyMatch)
		
		result = students.stream()
				.filter(student -> student.getGender().equals("남자"))
				.anyMatch(student -> (student.getMath() + student.getEnglish())/2 >= 70);
		
		
		System.out.println("남학생들 중에 평균이 70점 이상인 학생이 한명이라도 존재 하는지 " + result);
	}



}
