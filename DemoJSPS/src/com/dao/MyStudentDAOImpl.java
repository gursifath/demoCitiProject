package com.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import com.threads.Student;

public class MyStudentDAOImpl implements StudentDAO {

	
	private Connection openConnection() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded successfully");
			
	//		jdbc:data_base:install_server:port/database
			
	//		2. Get the connection
			
			connection = 
					DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"system", "abcd123");
			System.out.println("Connection obtained");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	
	@Override
	public int addStudent(Student student) {
		// TODO Auto-generated method stub
		
		int rows_inserted = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "abcd123");
		
			String INSERT_STUDENT = "insert into student values (?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT);
				
			int rollNo = 99;
			String name = "Ashish";
			int total = 58;
			
			preparedStatement.setInt(1, student.getRollNo());
			preparedStatement.setString(2, student.getStuName());
			preparedStatement.setInt(3, student.getTotal());
			
			
			rows_inserted = preparedStatement.executeUpdate();
			System.out.println("rows: " + rows_inserted);
			
		}	
		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return rows_inserted;
	}

	@Override
	public boolean updateStudent(int rollNo, String name) {
		// TODO Auto-generated method stub
		
		boolean isUpdated = false;
		
		String STUDENT_UPDATE = "update student set name=? where rollNo=?";

		try {
			
			PreparedStatement preparedStatement = openConnection().prepareStatement(STUDENT_UPDATE);
			preparedStatement.setString(1,name);
			preparedStatement.setInt(2, rollNo);
			
			int rows = preparedStatement.executeUpdate();
			
			if(rows > 0)
			{
				isUpdated = true;
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return isUpdated;
	}

	@Override
	public List<Student> findAllStudents() {
		// TODO Auto-generated method stub
		
		List<Student> students = new ArrayList<Student>();
		String FIND_ALL_STUDENTS = "select * from Student";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded successfully");
			
	//		jdbc:data_base:install_server:port/database
			
	//		2. Get the connection
			
			Connection connection = 
					DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"system", "abcd123");
			System.out.println("Connection obtained");
			
			Statement st = connection.createStatement();
			ResultSet set = st.executeQuery(FIND_ALL_STUDENTS);
			
			while(set.next()) {
				int rollNo = set.getInt("rollNo");
				String name = set.getString("name");
				int total = set.getInt("total");
				
				Student student = new Student(name,rollNo, total);
				students.add(student);
			}
			
			System.out.println("list size:-"+students.size());
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public Student findStudentByRollNo(int rollNo) {
		// TODO Auto-generated method stub
		Student student = null;
		
		String findStudentByRoll = "Select * from Student where rollNo=?";
		
		try {
				PreparedStatement preparedStatement = openConnection().prepareStatement(findStudentByRoll);
				preparedStatement.setInt(1,rollNo);
				ResultSet set = preparedStatement.executeQuery();
				
				while(set.next()) {
						int rollNo1 = set.getInt("rollNo");
						String name = set.getString("name");
						int total = set.getInt("total");
						student = new Student(name,rollNo1,total);
				}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return student;
	}

	@Override
	public List<Student> findStudents(int total) {
		// TODO Auto-generated method stub
		List<Student> studentsList = new ArrayList<Student>();
		
		String findStudentWithTotal = "Select * from Student where total=?";
		
		try {
			PreparedStatement preparedStatement = openConnection().prepareStatement(findStudentWithTotal);
			preparedStatement.setInt(1,total);
			ResultSet set = preparedStatement.executeQuery();
			
			while(set.next()) {
					int rollNo1 = set.getInt("rollNo");
					String name = set.getString("name");
					int total1 = set.getInt("total");
					Student student = new Student(name,rollNo1,total1);
					studentsList.add(student);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return studentsList;
	}

	@Override
	public Student deleteStudent(int rollNo) {
		// TODO Auto-generated method stub
		
		Student student = null;
		String deleteStudentQuery = "delete from student where rollNo=?";
		
		try {
			
			//find if that record exists
			//if yes, then delete
			//otherwise, show no record
			PreparedStatement preparedStatement = openConnection().prepareStatement(deleteStudentQuery);
			preparedStatement.setInt(1,rollNo);
			ResultSet set = preparedStatement.executeQuery();
			
			while(set.next()) {
				int rollNo1 = set.getInt("rollNo");
				String name = set.getString("name");
				int total1 = set.getInt("total");
				student = new Student(name,rollNo1,total1);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

}
