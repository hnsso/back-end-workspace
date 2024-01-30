package com.kh.object.model;

import java.io.Serializable;

// 객체를 직렬화로 통과하려면 반드시 implements Serializable 를 객체에 표기하자 !
public class Person implements Serializable{

	private String name;
	private int age;
	private String id;

	public Person() {
	}

	public Person(String name, int age, String id) {
		this.name = name;
		this.age = age;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", id=" + id + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
