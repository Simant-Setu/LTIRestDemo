package com.lti;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider

public class CourseNotFoundMapper implements ExceptionMapper<CourseNotFound> {

	@Override
	public Response toResponse(CourseNotFound arg0) {
		// TODO Auto-generated method stub
		
		CourseNotFoundXml error=new CourseNotFoundXml();
		error.setStatus("400");
		error.setMsg("Course not available");
		return Response
				.status(Status.INTERNAL_SERVER_ERROR)
				//.entity("Course is not available")
				.entity(error)
				.build();
	}

}
