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


@Path("/searchService")
public class SearchService {
	
	@Context
	UriInfo uriInfo;	
	@Context
	Request request;
	
	
	public SearchService() {
		// TODO Auto-generated constructor stub
		
			
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public List<User> GetAvailableUser(
			@FormParam("date") String date,
			@FormParam("destination") String dest,
			@FormParam("airport") String airport
			){
		List<User> userList = new ArrayList<User>();
		
		//Dao
		
		return userList;
		
	}

}
