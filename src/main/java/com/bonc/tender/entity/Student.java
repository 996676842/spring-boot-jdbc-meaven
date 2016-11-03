package com.bonc.tender.entity;

import org.springframework.stereotype.Component;

@Component
  public class Student {
	private int id;
	private String name;
	private String classes;
	private int grade;

	public Student() {
		super();
	}

	public Student(int id, String name, String classes, int grade) {
		super();
		this.id = id;
		this.name = name;
		this.classes = classes;
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", classes=" + classes + ", grade=" + grade + "]";
	}

}
