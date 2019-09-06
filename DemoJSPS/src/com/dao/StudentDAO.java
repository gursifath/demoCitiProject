package com.dao;

import java.util.List;

//import com.threads.Student;

public interface StudentDAO {
	
	int addStudent(Student student);
	boolean updateStudent(int rollNo, String name);
	List<Student> findAllStudents();
	Student findStudentByRollNo(int rollNo);
	List<Student> findStudents(int total);
	Student deleteStudent(int rollNo);

}
