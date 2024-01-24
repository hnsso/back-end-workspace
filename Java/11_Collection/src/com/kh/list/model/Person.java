package com.kh.list.model;

public class Person {

	private String name;
	private String addr;
	private int age;

	public Person() {
	}

	public Person(String name, String addr, int age) {
		super();
		this.name = name;
		this.addr = addr;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", address=" + addr + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return addr;
	}

	public void setAddress(String address) {
		this.addr = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
