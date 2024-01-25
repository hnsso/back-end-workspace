package com.kh.example.practice1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Application {

	public static void main(String[] args) {
		Application a = new Application();
		a.method1();
		
	}
	
	public void method1() {
		
		// generics 사용
		TreeSet<Integer> lotto = new TreeSet<>(); //set은 중복없이 순서 상관없이 treeset 정렬까지 해준다
		while(lotto.size() < 6) {
			int num = (int)(Math.random() * 45 + 1);  // 1~45까지의 랜덤번호 추출
			lotto.add(num);
			
		}
		
		int count = 0;
		while(true) {

			TreeSet<Integer> myLotto = new TreeSet<>();
			
			while(myLotto.size() < 6) {
				int num = (int)(Math.random() * 45 + 1);
				myLotto.add(num);
			
		}
			
			count ++;
			
			System.out.println("로또 번호 : " + lotto);
			System.out.println("내 번호 : " + myLotto);
			
			// 멈추는 조건 : 로또 번호와 내 번호가 정확히 일치!
			if(lotto.equals(myLotto)) {
				System.out.println("횟수 : " + count);
				break;
			}
			
		}
		
}
	}