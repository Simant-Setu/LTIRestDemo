package com.lti;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

public class StudentRepository {
	List<Student> students=new ArrayList<Student>();
	
	public StudentRepository() {

		/*
		 * Student st1=new Student(); st1.setRollNo(1); st1.setCoureName("Java");
		 * st1.setStudentName("John");
		 * 
		 * Student st2=new Student(); st2.setRollNo(2); st2.setCoureName("Python");
		 * st2.setStudentName("Mark");
		 * 
		 * Student st3=new Student(); st3.setRollNo(3); st3.setCoureName("PHP");
		 * st3.setStudentName("Jack");
		 * 
		 * 
		 * students.add(st1); students.add(st2); students.add(st3);
		 */
		
	}
	
	public List<Student> findAllStudents() {
		try{ 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@192.168.101.28:1521:xe","hr","hr");
		Statement stmt=con.createStatement(); 
		ResultSet rs=stmt.executeQuery("select * from student");
		
		
		
		while(rs.next()) {
			Student st=new Student();
			st.setRollNo(rs.getInt(1));
			st.setStudentName(rs.getString(2));
			st.setCoureName(rs.getString(3));
			students.add(st);
			System.out.println("test");
		}
		System.out.println(students.size());
		
		}catch(Exception e){ System.out.println(e);}  
		
		
		
		
		
		return students;
	}
	
	public Student findAStudent(int rollNo) {
		try{ 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@192.168.101.28:1521:xe","hr","hr");
			
			String qry="select * from student where rollNo=?";
			
			PreparedStatement stmt=con.prepareStatement(qry); 
			stmt.setInt(1, rollNo);
			ResultSet rs=stmt.executeQuery();
			
			
			Student st;
			if(rs.next()) {
				st=new Student();
				st.setRollNo(rs.getInt(1));
				st.setStudentName(rs.getString(2));
				st.setCoureName(rs.getString(3));
				return st;
			}
			}catch(Exception e){ System.out.println(e);}  
			return null;
	}
	
	
	public Student addStudent(Student student) {
		try{ 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@192.168.101.28:1521:xe","hr","hr");
			
			String qry="insert into student values(?,?,?)";
			
			PreparedStatement stmt=con.prepareStatement(qry); 
			stmt.setInt(1,student.getRollNo());
			stmt.setString(2, student.getStudentName());
			stmt.setString(3, student.getCoureName());
			
			stmt.executeUpdate();
			
			
			}catch(Exception e){ System.out.println(e);}  
			return student;
	}
	
	public String updateStudent(Student student) {
		try{ 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@192.168.101.28:1521:xe","hr","hr");
			
			String qry="update student set name=?,coursename=? where "
					+ "rollno=?";
			
			PreparedStatement stmt=con.prepareStatement(qry); 
			stmt.setInt(3,student.getRollNo());
			stmt.setString(1, student.getStudentName());
			stmt.setString(2, student.getCoureName());
			
			int res=stmt.executeUpdate();
			if(res>0) {
				return res+" row(s) updated.";
			}
			
			}catch(Exception e){ System.out.println(e);}  
			return "No record found";
	}
	
	
}
