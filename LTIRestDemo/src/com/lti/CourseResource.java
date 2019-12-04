package com.lti;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("courses")
public class CourseResource {
	CourseRepository repo=new CourseRepository();
	
	
	@GET
	@Path("/course/{id}")
	public Response findCourseName(@PathParam("id") int courseId) {
		Course course=repo.getCourseName(courseId);
		if(course.getCourseName()==null) {
			throw new CourseNotFound("this course is not available");
		}
		String cName=course.getCourseName();
		return Response.status(200).entity(cName).build();
	}
	
	
	@POST
	@Path("/course")
	public Response createCourse(Course course) {
		int rec=repo.addCourse(course);
		
		if(rec>0) {
		/*	return Response
					.status(Response.Status.OK)
					.header("Content-type","application/json")
					.type(MediaType.APPLICATION_JSON)
					.entity(course)
					.build();
					*/
		}
		return Response
				.status(Response.Status.INTERNAL_SERVER_ERROR)
				.entity("Error ocurred while adding new course")
				.build();
		
	}
}
