package com.kh.step4;

public class InThread3 extends Thread {

	public void run() {

		// 2. 카운팅 작업
		for (int i = 10; i > 0; i--) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}

	}
}
