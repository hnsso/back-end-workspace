package com.kh.test4;

import java.util.Scanner;

public class Application {

	Application app = new Application();

	public static void main(String[] args) {

		Person [] pArr = new Person[3];
		
		for(int i=0; i <= pArr.length; i++) {
			System.out.println(pArr[i].getName());
		}
		
	}

}
