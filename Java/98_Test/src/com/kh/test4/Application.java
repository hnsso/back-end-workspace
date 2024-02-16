package com.kh.test4;

import java.util.Scanner;

import kh.com.test4.model.Person;

public class Application {

	Application app = new Application();

	public static void main(String[] args) {
		// Person객체를 생성해야지만 에러 발생하지 않는다 !!
		Person [] pArr = new Person[3];
		pArr[0] = new Person("가");
		pArr[1] = new Person("나");
		pArr[2] = new Person("다");
		
		for(int i=0; i < pArr.length; i++) {
			System.out.println(pArr[i].getName());
		//	                   지금 반복 for문에서 배열안에 null 아무것도 없기 때문에
		}
		
	}

}
