package com.pojo;

public class Student {

	private String name;
	private int rollNo;
	private int total;
	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNo=" + rollNo + ", total=" + total + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Student(String name, int rollNo, int total) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		this.total = total;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
