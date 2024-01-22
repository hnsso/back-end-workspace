package com.kh.polymorphism.model.parent;

// 부모 

public class Employee {
	private String name;
	private int salary;
	
//	=============================================================================
	
	public Employee() {}
	
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
//	 =============================================================================
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

//	================================================================================
//	문자열로 반환해서 view 나온다 !!
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary="
										+ salary + "]";
	}
	
}
