package com.lti;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.glassfish.jersey.process.internal.RequestScoped;

import javax.ws.rs.core.Response;

@Path("students")
public class StudentService {
	StudentRepository repo=new StudentRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Student> viewAllStudents(){
		return repo.findAllStudents();
	}
	
	@GET
	@Path("/student/{rno}")
	public Student viewAStudent(@PathParam("rno") int rollNo) {
		return repo.findAStudent(rollNo);
	}
	
	/*
	 * @POST
	 * 
	 * @Path("/student")
	 * 
	 * @Consumes(MediaType.APPLICATION_JSON)
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public Student createStudent(Student
	 * student) { System.out.println(student.getRollNo()); return
	 * repo.addStudent(student); }
	 */
	
	@POST
	@Path("/student")
	public Response createStudent(Student student) {
		System.out.println(student.getRollNo());
		Student st=repo.addStudent(student);
		if(st!=null) {
			return Response.
status(Response.Status.OK).entity(st).header("Content-Type", "application/json").build();
		}
		return Response.status(Response.Status.NOT_FOUND).entity("Failed to add student").build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@PUT
	@Path("/student")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateStudent(Student student) {
		return repo.updateStudent(student);
	}
	
	/*
	 * @Path("/student")
	 * 
	 * @Consumes(MediaType.APPLICATION_JSON)
	 * 
	 * @Produces(MediaType.TEXT_PLAIN) public String deleteStudent(Student student)
	 * { return repo.updateStudent(student); }
	 */
	
	@GET
	@Path("/hello")
	public Response sayHello() {
		Response response=Response.status(200).entity("Welcome").build();
		
		ResponseBuilder builder=Response.ok("Hello REST");
		
		Response res=builder.entity("").build();
		//Response.status(Response.Status.OK).entity("Hello Everyone").build();
		
		//return Response.status(200).entity("Hello World").build();
		return Response.status(Response.Status.OK).entity("Hello World").build();
	}
}










