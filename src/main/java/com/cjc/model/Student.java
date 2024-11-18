package com.cjc.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	private int rollNo;
	private String name;
	private String address;
	private float marks;
	
	public Student() {
	   //
	}
	public Student(int rollNo, String name, String address,float marks) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.marks = marks;
		this.address=address;
	}
	public int getRollNo() {
		return rollNo;
	}
	public String getName() {
		return name;
	}
	public float getMarks() {
		return marks;
	}
	public String getAddress() {
		return address;
	}
	

	
}
