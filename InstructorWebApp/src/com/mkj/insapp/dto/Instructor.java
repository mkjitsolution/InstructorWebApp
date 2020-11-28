package com.mkj.insapp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

// Component which we can plug and use 
// Normal Bean Class
public class Instructor {

	private int instructorCode;
	private String name;
	private int salary;
	private int jobStartYear;
	private String email;
	private String location;
	
	public Instructor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Instructor(int instructorCode, String name, int salary, int jobStartYear, String email, String location) {
		super();
		this.instructorCode = instructorCode;
		this.name = name;
		this.salary = salary;
		this.jobStartYear = jobStartYear;
		this.email = email;
		this.location = location;
	}
	public int getInstructorCode() {
		return instructorCode;
	}
	public void setInstructorCode(int instructorCode) {
		this.instructorCode = instructorCode;
	}
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
	public int getJobStartYear() {
		return jobStartYear;
	}
	public void setJobStartYear(int jobStartYear) {
		this.jobStartYear = jobStartYear;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Instructor [instructorCode=" + instructorCode + ", name=" + name + ", salary=" + salary
				+ ", jobStartYear=" + jobStartYear + ", email=" + email + ", location=" + location + "]";
	}
	
	
}
