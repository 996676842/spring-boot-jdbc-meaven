package com.bonc.tender.service;

import java.util.List;

import com.bonc.tender.entity.Student;

public interface StudentService {
	public List<Student> searchList();

	public int create(Student student);

	public int deleteByName(String name);
	
	public int update(Student student);
	
    public List<Student> getPages(int currentPage,int pageSize);
    
    public List<Student> getStudentBy(String choice, String str);
    
    public List<Student> getPagesBy(int currentPage, int pageSize,String choice, String str);
}
