package com.lti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CourseRepository {

	
	public Course getCourseName(int courseId) {
		Course course=new Course();
		
		try{ 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@192.168.101.28:1521:xe","hr","hr");
			
			String qry="select * from course where id=?";
			
			PreparedStatement stmt=con.prepareStatement(qry); 
			stmt.setInt(1, courseId);
			ResultSet rs=stmt.executeQuery();
			rs.next();
			
			//course.setCourseName(rs.getString(1));
			return course;

			
			
			}catch(Exception e){ System.out.println(e);}
		return course;
	}
	
	
	public int addCourse(Course course) {
		int res=0;
		try{ 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@192.168.101.28:1521:xe","hr","hr");
			
			String qry="insert into course values(?,?,?)";
			
			PreparedStatement stmt=con.prepareStatement(qry); 
			stmt.setInt(1,course.getCourseId());
			stmt.setString(2, course.getCourseName());
			stmt.setString(3, course.getStudentName());
			
			res=stmt.executeUpdate();
			
			
			}catch(Exception e){ System.out.println(e);}  
			return res;
	}
}
