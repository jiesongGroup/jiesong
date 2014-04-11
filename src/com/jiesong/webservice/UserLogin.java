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
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import com.jiesong.model.*;
import com.jiesong.jdbc.*;
import com.jiesong.util.Gender;

/*
 * The Login function is in the class UserResources
 * This class is useless
 * */


@Path("/login")
public class UserLogin {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	
	public Response UserLogin(
			@FormParam("username") String username,
			@FormParam("password") String password,
			@Context HttpServletResponse servletResponse
			) {
		// TODO Auto-generated constructor stub
		List<User> userList = new ArrayList<User>(); 
		Response rsp;
		ResponseBuilder rspbdr = null;
		String message="";
		JieSongDAO dao = new JieSongMysqlIpml();
		int result = dao.loginCheck(username, password);	
		
		if(result == 0){
			
			//success
			
			
			rspbdr = Response.status(200);
		}else if(result == 1){
			
			//no user or password error
			rspbdr=Response.status(201);
		}else if(result == 2){
			
			//e-mail is not verified
			rspbdr = Response.status(202);
		}
		
		rsp = rspbdr.build();
		/*User user = JieSongMysqlIpml.;
		if(user!=null){
			message="User with login name: "+uname+" exists";
			rspbdr=Response.status(201);
			rspbdr=rspbdr.entity(message);
			rsp=rspbdr.build();
			return rsp;
		}
		
		User newUser = new User(uname,password,authority,name,birthday,email,address);
		
		int result = UsersDao.instance.insertUser(newUser);
		
		
		if(result ==1){
			rspbdr=Response.status(200);
			message="create user successfully!";
			rspbdr=rspbdr.entity(message);
			
		}else{
			message="create user fail!";
			rspbdr=Response.status(201);
			rspbdr=rspbdr.entity(message);		
		}	
		rspbdr=Response.status(200);
		rspbdr=rspbdr.entity("HelloWorld");
		rsp=rspbdr.build();*/
		
		return rsp;
		
	}

}
