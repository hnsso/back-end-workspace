package com.kh.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * URL(Uniform Resource Locator)
 * - 인터넷에 존재하는 서버들의 자원에 접근할 수 있는 주소
 * 
 * https :// www.youtube.com/results?search_query=여행
 * 프로토콜:// 호스트명: 포트번호 /경로명/파일명?쿼리스트링
 * - 프로토콜 : 자원에 접근하기 위해 서버와 통신하는데 사용되는 통신규약
 * - 호스트명 : 자원을 제공하는 서버의 이름
 * - 포트번호 : 통신에 사용되는 서버의 포트번호
 * - 경로명 : 접근하려는 자원이 저장된 서버상의 위치
 * - 쿼리(query) : ? 이후의 부분
 * */
public class URLTest {

	public static void main(String[] args) {
		URLTest u = new URLTest();
//		u.method1();
		u.method2();
	}

	public void method1() {
		try {
			URL url = new URL("https :// www.youtube.com/results?search_query=여행");
		System.out.println("프로토콜 : " + url.getProtocol() );
		System.out.println("호스트명 : " + url.getHost());
		System.out.println("포트번호 : " + url.getDefaultPort());
		System.out.println(" 경로 : " +  url.getPath());
		System.out.println(" 쿼리 : " + url.getQuery());
//		System.out.println("경로 + 쿼리 " + );
		
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	
	
		}

	public void method2(){
		
	
	try {
		URL url = new URL("http://iei.of.kr");
		BufferedReader input = 
				new BufferedReader(new InputStreamReader(url.openStream()));
		
		String line = "";
		while((line = input.readLine()) != null) {
			System.out.println();
		}
		
	}catch(IOException e){
	
		}
	
	/*
	 * 네트워크 7계층
	 * 
	 * 7계층 : 응용 계층
	 * 6계층 : 표현 계층
	 * 5계층 : 세션 계층
	 * 4계층 : 전송 계층
	 * 3계층 : 네트워크 계층
	 * 2계층 : 데이터링크 계층
	 * 1계층 : 물리 계층
	 * 
	 * */
	}
}
