package com.dao;


import java.io.Serializable;

public class Student implements Serializable, Comparable<Student> {
		
	private String stuName;
	private int rollNo;
	private int total;
	
	public Student() {
		
	}

	@Override
	public String toString() {
		return "Student [stuName=" + stuName + ", rollNo=" + rollNo + ", total=" + total + "]";
	}

	public Student(String stuName, int rollNo, int total) {
		super();
		this.stuName = stuName;
		this.rollNo = rollNo;
		this.total = total;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
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

	@Override
	public int compareTo(Student arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
