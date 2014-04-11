package com.jiesong.webservice;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;



import com.jiesong.jdbc.JieSongDAO;
import com.jiesong.jdbc.JieSongMysqlIpml;
import com.sun.mail.iap.Response;
import com.jiesong.model.*;
import com.jiesong.util.PropertiesUtil;
import com.jiesong.util.Utility;

@Path("/atime")
public class AvailableTimeResources {

	public AvailableTimeResources() {
		// TODO Auto-generated constructor stub
	}
	@Context
	UriInfo uriInfo;	
	@Context
	Request request;
	
	
	@GET
	@Path("get")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<AvailableTime> GetTime(@QueryParam("userid") String uid){
		List<AvailableTime> timeList = new ArrayList<AvailableTime>();
		
		//
		
		
		return timeList;
		
	}
	
	@POST
	@Path("add")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response AddTime(@QueryParam("userid") String uid///
			
			
			
			){
		Response rsp = null;
		//
		return rsp;
		
	}
	
	@PUT
	@Path("Update")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response UpdateTime(
			@QueryParam("userid") String uid
			//@FormParam("") String ,
			){
		Response rsp = null;
		
		return rsp;
		
		
	}
	
	
	
}
