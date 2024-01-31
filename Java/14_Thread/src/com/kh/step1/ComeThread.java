package com.kh.step1;

/*
 * 스레드 생성하는 방법 ==========> 무조건 나중에 사용할수 밖에 없다
 * 
 * 1.  Thread 클래스를 상속받는 방법
 * 		- Thread 클래스를 상속 후에 run() 메서드를 오버라이딩한다
 * 		- Thread 클래스를 상속한 자식 클래스의 객체 생성 후 start() 메서드 호출한다
 * 
 * */
public class ComeThread extends Thread {

	public ComeThread(String name) {
		super(name);
	}
	
	// (run 메서드가)스레드가 작동하는 부분 !! 이다
	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(1000); // 지정된 시간동안 스레드를 멈추게 한다 !
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String name = Thread.currentThread().getName();
			System.out.println("CurrentThread :: " + name + ", " + i);
		}
	}
}
