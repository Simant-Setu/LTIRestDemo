package com.lti;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tilsy {
	private int rollNo;
	private String studentName;
	private String coureName;

	
	
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getCoureName() {
		return coureName;
	}
	public void setCoureName(String coureName) {
		this.coureName = coureName;
	}
	
	
}
