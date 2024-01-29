package com.kh.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.kh.map.model.Snack;

/*
 * Map
 * - key-value 쌍으로 저장
 * - 순서 없음
 * - 중복 : 키(key) x, 값(value) o
 * 
 * HashMap
 * - Map 인터페이스를 구현한 대표적인 컬렉션 클래스
 * 
 * */

public class A_HashMap {

	public static void main(String[] args) {
		A_HashMap a = new A_HashMap();
		a.method1();
		a.method2();
	}
	
	public void method1() {
//			키나   변수명
		Map<String, Integer> map = new HashMap<>();
		
		map.put("웨하스", 250);
		map.put("고래밥", 180);
		map.put("칸쵸", 800);
		map.put("나쵸", 450);
		
		System.out.println(map);
		
		// 1, 키만 가져오기 
		Set<String> key = map.keySet();
		System.out.println(key);
		
		// 2. 값만 가져오기
		// collection으로 가져온다 
		Collection<Integer> col = map.values();
		System.out.println(col);
		
		// 3. 키에 해당하는 value 값 가져오기
		Iterator<String> it = key.iterator();
		while(it.hasNext()) {
			String name = it.next();
			System.out.println(name + " : " +  map.get(name));
	}
		System.out.println("---------------------------------------");
//		 객체		   배열 
	for(String s : key) {
		System.out.println(s + " : " +  map.get(s));
		}
	
	/*
	 * 4. entrySet
	 * 	  - Map 컬렉션에 있는 Entry 객체(key, value 쌍으로 이루어진)를
	 * 		Set 컬렉션에 담아서 반환 
	 * 	  - 반환된 Set 컬렉션에서 반복자를 얻어서 반복 처리
	 *  
	 * */
//	entry 도 객체이다  >>>> entry 객체 들에 담겨져 있는 Set 
//	Set<Entry<String, Integer>> 데이터 타입은 Entry<String, Integer>
	Set<Entry<String, Integer>> entrySet = map.entrySet();
	System.out.println(entrySet);
	for(Entry<String, Integer> entry : entrySet) {
		System.out.println(entry.getKey() + " : " + entry.getValue());
	}
	
}
	public void method2() {
		
//	 	객체 생성
		Map<String, Snack> map = new HashMap<>();
		
//		키와 값을 저장 !!
		map.put("웨하스", new Snack("치즈", 240));
		map.put("웨하스", new Snack("딸기", 255));
		map.put("고래밥", new Snack("양념치킨", 173));
		map.put("자유시간", new Snack("아몬드", 232));
		map.put("칸쵸", new Snack("딸기 요거트", 880));
		map.put("홈런볼", new Snack("초코", 270));
		map.put("스윙칩", new Snack("볶음고추", 347));
		map.put("나쵸", new Snack("치즈", 486));
		map.put("꼬깔콘", new Snack("매콤달콤", 175));
		map.put("후렌치파이", new Snack("딸기", 990));
		
		// 9개인 이유는 키는 중복이 안된다 !!
		System.out.println("과자의 개수 : " + map.size());
		
		
		//  웨하스에는 뭐가 들어 있을까요 >>> 딸기인 이유는 put은 add 다르게 넣으면서 수정도 가능 !!
		System.out.println(map.get("웨하스"));
	
		
		// 키 값으로 삭제하기 - 꼬깔콘
		map.remove("꼬깔콘");
		System.out.println("과자의 개수 : " + map.size());    // > 개수 확인은 사이즈로 접근하자 !!
		
		
		// 1. 홈런볼에 해당하는 과자 정보 출력
		System.out.println("홈런볼 과자 정보 > " + map.get("홀런볼"));
		
		
		// 2 . 후렌치파이의 맛 정보 출력
		System.out.println("홈런볼 과자 정보 > " + map.get("후렌치파이").getFlavor());
		
		
		// 3 . 모든 과자의 칼로리의 총합과 평균 출력
		
		int sum = 0;
		
		/* entry 방식
		Set<Entry<String, Snack>> entrySet = map.entrySet();
		for(Entry<String, Snack> entry : entrySet) {
			Snack snack = entry.getValue();
			sum += snack.getCalorie();
		}*/
		
		for(String key : map.keySet()) {
			Snack snack = map.get(key);
			sum += snack.getCalorie();
		}
			
	System.out.println("칼로리 총합 : " + sum);
	System.out.println("칼로리 평균 : " + (sum / map.size()));
	
	
	
	// 모든 Entry 객체 삭제
	map.clear();
	System.out.println("비어있는지 : " + map.isEmpty());
	System.out.println(map);
	
	}
	
}
