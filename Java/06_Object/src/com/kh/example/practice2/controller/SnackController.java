package com.kh.example.practice2.controller;

import com.kh.example.practice2.model.Snack;

public class SnackController {

	private Snack s = new Snack();
	
	public String saveDate(String kind, String name, String flavor,
									int numOf, int price) {
		
		s.setKind(kind);
		s.setName(name);
		s.setFlavor(flavor);
		s.setNumOf(numOf);
		s.setPrice(price);
		
		return "저장 완료되었습니다. ";
		
		public String confirmDate() {
			return s.getKind() + "(" + s.getName() + "-" + s.getFlavor() + ")"
					+ s.getNumOf() + "개 " + s.getPrice() + "원";
		}
		System.out.println(kind + ", " + name 
							+ ", " + flavor + ", " + numOf + ", " + price);
			return null;
	}


public String confirmDate() {
	return null;

	}

}