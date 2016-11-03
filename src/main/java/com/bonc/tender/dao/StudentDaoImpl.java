package com.bonc.tender.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bonc.tender.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 分页查询
	public List<Student> getPages(int currentPage, int pageSize) {
		String sql = "select * from student limit ?,?";
		return (List<Student>) jdbcTemplate.query(sql, new Object[] { (currentPage * pageSize - pageSize), pageSize },
				new RowMapper<Student>() {
					public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
						Student stu = new Student();
						stu.setId(rs.getInt("id"));
						stu.setName(rs.getString("name"));
						stu.setClasses(rs.getString("class"));
						stu.setGrade(rs.getInt("grade"));

						return stu;
					}
				});

	}

	// 分页查询
	public List<Student> getPagesBy(int currentPage, int pageSize,String choice, String str) {
		String sql = "select * from student where "+choice+" = ? limit ?,?";
		
		return (List<Student>) jdbcTemplate.query(sql, new Object[] {str, (currentPage * pageSize - pageSize), pageSize },
				new RowMapper<Student>() {
					public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
						Student stu = new Student();
						stu.setId(rs.getInt("id"));
						stu.setName(rs.getString("name"));
						stu.setClasses(rs.getString("class"));
						stu.setGrade(rs.getInt("grade"));
						return stu;
					}
				});

	}
	
	// 无条件查询
	public List<Student> getList() {
		System.out.println("-----Dao start------");
		String sql = "select * from student ";
		System.out.println("-----Dao getList final-----");
		return (List<Student>) jdbcTemplate.query(sql, new RowMapper<Student>() {
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setClasses(rs.getString("class"));
				stu.setGrade(rs.getInt("grade"));

				return stu;
			}
		});
	}

	// 单一条件查询
	public List getStudentBy(String choice, String str) {
		String sql = "select * from student where "+choice+"=?";
		return (List<Student>) jdbcTemplate.query(sql, new Object[] {  str },
				new RowMapper<Student>() {
					public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
						Student stu = new Student();
						stu.setId(rs.getInt("id"));
						stu.setName(rs.getString("name"));
						stu.setClasses(rs.getString("class"));
						stu.setGrade(rs.getInt("grade"));

						return stu;
					}
				});

	}

	// 创建
	public int create(Student student) {
		return jdbcTemplate.update("insert into student( name,class,grade) values(?,?,?)",
				new Object[] { student.getName(), student.getClasses(), student.getGrade() });
	}

	// 删除
	public int deleteByName(String name) {
		return jdbcTemplate.update("delete from student where name = ?", name);
	}

	// 更新
	public int update(Student student) {

		return jdbcTemplate.update("update student set name=?,class=?,grade=? where id=?",
				new Object[] { student.getName(), student.getClasses(), student.getGrade(), student.getId() });

	}

}
