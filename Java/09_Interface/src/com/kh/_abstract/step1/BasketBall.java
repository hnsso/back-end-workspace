package com.kh._abstract.step1;

public class BasketBall extends Sports {

	public BasketBall(int numberOfPlayers) {
		super(numberOfPlayers);
	}
	public void rule() {
		System.out.println("BasketBall의 선수의 수는 " + this.numberOfPlayers 
												+ "명, Sports 규칙을 성명한다.");
	}
}
