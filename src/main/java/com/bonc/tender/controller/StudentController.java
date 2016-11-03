package com.bonc.tender.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bonc.tender.entity.Student;
import com.bonc.tender.service.StudentServiceImpl;

@Controller
public class StudentController {

	@Autowired
	StudentServiceImpl ss;

	@RequestMapping("/remove")
	public String removeKey(HttpSession session) {

		session.removeAttribute("choice");
		session.removeAttribute("str");
		return "redirect:/showAll";
	}

	@RequestMapping("/savekey")
	public String saveKey(String choice, String str, HttpSession session) {
		session.setAttribute("choice", choice);
		session.setAttribute("str", str);
		return "redirect:/showAll";
	}

	// 展示学生的全部信息
	@RequestMapping("/showAll")
	public String showAllStudent(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("----controller showAll start---");
		String choice = (String) session.getAttribute("choice");
		String str = (String) session.getAttribute("str");
		int pageSize = 3;
		int totalPages = 1;
		int allRecoreds = 1;
		List<Student> studentList = new ArrayList<Student>();
		if (str == null) {
			// 获得总的学生记录数
			allRecoreds = ss.searchList().size();
		} else {

			allRecoreds = ss.getStudentBy(choice, str).size();

		}
		// 获得总的页数
		if (allRecoreds > pageSize)
			totalPages = (allRecoreds / pageSize == 0) ? (allRecoreds / pageSize) : (allRecoreds / pageSize + 1);
		// 获得当前页数
		int currentPage = 1;
		String pageIndex = request.getParameter("p");
		if (pageIndex != null) {
			currentPage = Integer.parseInt(pageIndex);
		}
		// 上一页 下一页
		int prePage = currentPage > 1 ? currentPage - 1 : currentPage;
		int nextPage = currentPage < totalPages ? currentPage + 1 : currentPage;
		if (str == null) {
			studentList = ss.getPages(currentPage, pageSize);
		} else {
			studentList = ss.getPagesBy(currentPage, pageSize, choice, str);
		}
		model.addAttribute("studentList", studentList);
		System.out.println(studentList);
		model.addAttribute("prePage", prePage);
		model.addAttribute("nextPage", nextPage);

		return "index";

	}

	// 新增或者修改学生信息
	@RequestMapping("/update")
	public String addStudent(Student student, Model model) {

		if (student.getId() > 0) {
			// 修改学生信息
			int ret = ss.update(student);
			System.out.println("更新的数据条数是" + ret);
			System.out.println();
			System.out.println("----controller update  final---");

		} else {
			// 新增学生信息
			System.out.println("----controller create start---");
			// int ret = ss.create1(name, classes,Integer.valueOf(grade));
			int ret = ss.create(student);
			System.out.println("----controller create  final---");
		}

		return "redirect:/remove";

	}

	// 删除学生
	@RequestMapping("/delete")
	public String deleteStudent(String name, Model model) {
		System.out.println("----controller delete start---");
		System.out.println(name);
		int ret = ss.deleteByName(name);
		System.out.println(ret);
		List<Student> studentList = ss.searchList();
		model.addAttribute("studentList", studentList);
		return "index";
	}

	@RequestMapping("/get")
	@ResponseBody
	public String index() {
		return "Index Page";
	}

}
