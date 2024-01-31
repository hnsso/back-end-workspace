package com.kh.step4;

import javax.swing.JOptionPane;


public class InputThreadTest3 {

	boolean check = false;
	
	public static void main(String[] args) {
		
		InputThreadTest3 process = new InputThreadTest3();
		
		InThread3 it = new InThread3(process);
		it.start();
		
		CountThread3 count = new CountThread3(process);
		count.start();
	}
}

class InThread3 extends Thread {

	public void run() {
		// 1. 데이터 입력 작업
		String input = JOptionPane.showInputDialog("최종 로또 번호를 입력 하세요..");
		System.out.println("입력하신 숫자는 " + input + " 입니다.");
		
	}
}


class CountThread3 extends Thread {
	
	InputThreadTest3 process;
	
	 CountThread3(InputThreadTest3 process){
		
		this.process = process;
	}

	
	public void run() {
		// 2. 카운팅 작업
		for (int i = 10; i > 0; i--) {
			if(process.check) break;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}
		if(!process.check) {
			System.out.println("10초 경과! 값 입력 중지");
			System.exit(0); // 강제 종료
		}
	}
}
	





