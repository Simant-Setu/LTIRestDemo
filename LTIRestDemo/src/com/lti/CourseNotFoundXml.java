package com.lti;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CourseNotFoundXml {
	private String status;
	private String msg;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
