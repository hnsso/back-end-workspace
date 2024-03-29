package com.kh.step2;

/*
 * 스레드 생성하는 방법 ==========> 무조건 나중에 사용할수 밖에 없다
 * 
 * 2 . Runnable 인터페이스를 구현하는 방법
 * - Runnable 인터페스의 run()메서드를 오버라이딩한다.
 * - Thread 객체 생성 시 생성자의 Runnable 인터페이스를 구현한 객체를
 * 	 매개값으로 전달 후 start() 메서드 호출한다.
 * */
public class ComeThread implements Runnable {

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
