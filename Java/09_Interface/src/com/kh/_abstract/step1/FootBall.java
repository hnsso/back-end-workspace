package com.kh._abstract.step1;

public class FootBall extends Sports {
	
	// protected로 접근하면 자식에게 접근가능
	protected int numberOfPlayers; 
	
	public FootBall(int numberOfPlayers) {
		super(numberOfPlayers);
		// 오버라이딩
	}
	
	public void rule() {
		System.out.println("FootBall의 선수의 수는 " + this.numberOfPlayers 
												+ "명, 손이 아닌 발로 공을 차야한다");
	}


}
