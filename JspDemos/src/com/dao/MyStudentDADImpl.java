package com.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Student;

public class MyStudentDADImpl implements StudentDAD {
	private Connection openConnection() {
		Connection connection = null;
		try {
			System.out.println("bvhbj");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loadedd successfully");
//			jdbc:data_base:install_server:port/database
//hello
//			get connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "abcd123");
			System.out.println("Connection obtained");

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		return connection;
	}


	
	@Override
	public int addStudent(Student student) {
		// TODO Auto-generated method '
		int rows_inserted = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loadedd successfully");
//			jdbc:data_base:install_server:port/database

//			get connection
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "abcd123");
			System.out.println("Connection obtained");

			String INSERT_STUDENT = "insert into student values(?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(INSERT_STUDENT);

			ps.setInt(1, student.getRollNo());
			ps.setString(2, student.getName());
			ps.setInt(3, student.getTotal());

			rows_inserted = ps.executeUpdate();
			System.out.println("No of updated rows : " + rows_inserted);

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		return rows_inserted;
	}

	@Override
	public boolean updateStudent(int rollNo, String name) {
		// TODO Auto-generated method stub
		boolean is_updated = false;

		String STUDENT_UPDATE = "update student set name = ? where rollno = ?";

		try {
			PreparedStatement ps = openConnection().prepareStatement(STUDENT_UPDATE);
			ps.setString(1, name);
			ps.setInt(2, rollNo);

			int rows = ps.executeUpdate();
			if (rows > 0) {
				is_updated = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return is_updated;
	}


	public List<Student> findAllStudents() {
		// TODO Auto-generated method stub
		List<Student> students = new ArrayList<Student>();
		String FIND_ALL_STUDENTS = "select * from student";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loadedd successfully");
//			jdbc:data_base:install_server:port/database

//			get connection
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "abcd123");
			System.out.println("Connection obtained");

			Statement st = connection.createStatement();
			ResultSet set = st.executeQuery(FIND_ALL_STUDENTS);

			while (set.next()) {
				int RollNo = set.getInt("rollno");
				String Name = set.getString("name");
				int Total = set.getInt("total");

				Student student = new Student(Name, RollNo, Total);
				students.add(student);
			}

			System.out.println("List size = " + students.size());

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		return students;
	}


	@Override
	public Student findStudentByrollNo(int rollNo) {
		// TODO Auto-generated method stub
		Student student = new Student();

		String FIND_SPEC_STUDENTS = "select * from student where rollno=?";

		try {
			PreparedStatement ps = openConnection().prepareStatement(FIND_SPEC_STUDENTS);
			 ps.setInt(1, rollNo);
			ResultSet set = ps.executeQuery();

			while (set.next()) {
					String name = set.getString("name");
					int total = set.getInt("total");
					student.setRollNo(rollNo);
					student.setName(name);
					student.setTotal(total);
				}

		}
		catch(SQLException e){
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return student;
	}

		
	

	@Override
	public List<Student> findStudents(int total) {
		// TODO Auto-generated method stub
		List<Student> students = new ArrayList<Student>();
		String FIND_STUDENTS = "select * from student where total = ?";
		try {
			PreparedStatement ps = openConnection().prepareStatement(FIND_STUDENTS);
			 ps.setInt(1, total);
			ResultSet set = ps.executeQuery();

			while (set.next()) {
					String name = set.getString("name");
					int rollNo = set.getInt("rollno");

					Student student = new Student(name, rollNo, total);
					students.add(student);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return students;
	}

	@Override
	public Student deleteStudent(int rollNo) {
		// TODO Auto-generated method stub
		Student student = new Student();
		String DEL_SPEC_STUDENTS = "select * from student where rollno = ?";

		try {
			PreparedStatement ps = openConnection().prepareStatement(DEL_SPEC_STUDENTS);
			ps.setInt(1, rollNo);
			ResultSet set = ps.executeQuery();

			while (set.next()) {
					String name = set.getString("name");
					int total = set.getInt("total");
					student.setRollNo(rollNo);
					student.setName(name);
					student.setTotal(total);
					openConnection().prepareStatement("delete from student where rollno = ?");
				}
		}
		catch(SQLException e){
		e.printStackTrace();
	}
	return student;
	}
	

}
