package com.kh.example.practice1;

import java.util.Objects;

public class Number {
	private int num;
	
	
	@Override
	public String toString() {
		return "Number [num=" + num + "]";
	}

	public Number() {
	}

	public Number(int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public int hashCode() {
		return Objects.hash();
	}

	@Override // 중복제거 해야하고 
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Number other = (Number) obj;
		return num == other.num;
	}


	
}
