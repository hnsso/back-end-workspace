package com.kh.test8;

public class Application {

	public static void main(String[] args) {
		
		Person[] pArr = new Person[3];
		pArr[0] = Person{"가"};
		pArr[1] = Person{"나"};
		pArr[2] = Person{"다"};
								
		
		for(int i=0; i < pArr.length; i++) {
		System.out.println(pArr[i].getName());
		}
	}

}
