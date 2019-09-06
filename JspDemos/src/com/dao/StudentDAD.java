package com.dao;

import java.util.List;
import com.pojo.Student;
public interface StudentDAD {
	int addStudent(Student student);
	boolean updateStudent(int rollNo, String name);
	List<Student> findAllStudents();
	Student findStudentByrollNo(int rollNo);
	List<Student> findStudents(int total);
	Student deleteStudent(int rollNo);
	
}
