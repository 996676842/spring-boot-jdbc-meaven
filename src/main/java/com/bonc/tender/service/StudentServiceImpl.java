package com.bonc.tender.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bonc.tender.dao.StudentDaoImpl;
import com.bonc.tender.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDaoImpl sd;
	 public List<Student> searchList(){
		 System.out.println("---service start---");
		 return sd.getList();
	 }
	 public int create(Student student){
		 return sd.create(student);
	 }
	 public int deleteByName(String name) {
		 return sd.deleteByName(name);
	 }
	@Override
	public int update(Student student) {
		return sd.update(student);
	}
	
	@Override
	public List<Student> getPages(int currentPage, int pageSize) {
		return sd.getPages(currentPage, pageSize);
	}
	@Override
	public List<Student> getStudentBy(String choice, String str) {
		return sd.getStudentBy(choice, str);
	}
	@Override
	public List<Student> getPagesBy(int currentPage, int pageSize, String choice, String str) {
		// TODO Auto-generated method stub
		return sd.getPagesBy(currentPage, pageSize, choice, str);
	}
	


	

}
