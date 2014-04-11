package com.jiesong.webservice;
import java.sql.Timestamp;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import com.jiesong.model.*;
import com.jiesong.jdbc.*;
import com.jiesong.util.Gender;
import com.jiesong.util.Utility;



@Path("/users")
public class UserResources{
	
	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;
	
	//Create User
	@Path("add")
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)	
	public Response NewUser(
			@FormParam("username") String username,
			@FormParam("password") String password,
			@FormParam("confirmPassword") String confirmPassword,
			@FormParam("email") String email,
			@FormParam("dob") String dob,
			@FormParam("nickname") String nickname,
			@FormParam("gender") String gender
			
			){
		
		JieSongDAO dao = new JieSongMysqlIpml();
		
		Response rsp = null;
		ResponseBuilder rspbdr = null;
		
		//Check Email
		int isEmail = dao.checkEmail(email);
		if(isEmail !=0){
			rspbdr.status(200);
			String message = "10001";//Error code, email is existed.
			rspbdr.entity(message);
			rsp = rspbdr.build();
			return rsp;
		}
		
		//Check Password		
		if(!password.equals(confirmPassword)){
			rspbdr.status(200);
			String message = "10002"; //Error code, passwords are different.
			rspbdr.entity(message);
			rsp = rspbdr.build();
			return rsp;
		}
		
		//parse Date of Birth
		Timestamp ts_dob = new Timestamp(System.currentTimeMillis());
		ts_dob = Utility.parseStringtoTimestamp(dob);
		
		String securePassword = Utility.getSecurePassword(password);
		
		User creator = new User();
		creator = dao.getUserByID(1);
		
		User newUser = new User();
		newUser.setActive(false);
		newUser.setActiveness(0);
		newUser.setDOB(ts_dob);
		newUser.setEmail(email);
		newUser.setEmailVerified(false);
		if(gender.equals("male"))
			newUser.setGender(Gender.male);
		else
			newUser.setGender(Gender.female);
		newUser.setLastSignInTime(new Timestamp(System.currentTimeMillis()));
		newUser.setNickname(nickname);
		newUser.setPassword(securePassword);
		newUser.setUsername(username);
		
		//
		dao.createUser(creator, newUser);
		int result = dao.checkEmail(email);
		if(result != 1){
			rspbdr.status(200);
			String message = "10003"; //Error code, user creation fails.
			rspbdr.entity(message);
			rsp = rspbdr.build();
			return rsp;
		}else{
			
			//insert verify code to database
			
			//send email to new user
			rspbdr.status(200);
			String message = "10000"; //Error code, user creation success.
			rspbdr.entity(message);
			rsp = rspbdr.build();
			return rsp;
		}
	}
	
	
	//Login Check
	@Path("login")
	@GET	
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response LoginCheck(
			@FormParam("username") String username,
			@FormParam("password") String password,
			@Context HttpServletResponse servletResponse
			){
		List<User> userList = new ArrayList<User>(); 
		Response rsp;
		ResponseBuilder rspbdr = null;
		String message="";
		JieSongDAO dao = new JieSongMysqlIpml();
		int result = dao.loginCheck(username, password);	

		if(result == 0){
			//success
			message = "10010";
			rspbdr = Response.status(200);
						
		}else if(result == 1){
			
			//no user or password error
			message = "10011";
			rspbdr=Response.status(201);
		}else if(result == 2){
			
			//e-mail is not verified
			message = "10012";
			rspbdr = Response.status(201);
		}
		rspbdr.entity(message);
		rsp = rspbdr.build();
		return rsp;
		
	}
	
	//Search User by ID
	@Path("search")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public User GetUserByID(
			@QueryParam("uid") String uid
			){
			
		User user = new User();
		JieSongDAO dao = new JieSongMysqlIpml();
		user = dao.getUserByID(Integer.parseInt(uid));
				
		return user;
	}
	
	
	//Update User Information
	@Path("update")
	@PUT
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response UpdateUser(
			@QueryParam("uid") String uid,
			@FormParam("username") String username,
			@FormParam("nickname") String nickname,
			@FormParam("email") String email,
			@FormParam("gender") String gender,
			@FormParam("dob") String dob
			){
	
		Response rsp = null;
		
		//Operation and validation of updating user information	
		
		return rsp;
	}
	
	
	//Suspend User Information
	//@Path("suspend")
	//@PUT

}