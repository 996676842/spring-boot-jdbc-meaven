package com.bonc.tender.dao;

import java.util.List;

import com.bonc.tender.entity.Student;

public interface StudentDao {
	public List<Student> getList();

	public int create(Student student);

	public int deleteByName(String name);

	public int update(Student student);

	public List getStudentBy(String choice, String str);

	public List getPages(int currentPage, int pageSize);

	public List<Student> getPagesBy(int currentPage, int pageSize,String choice, String str);
}
