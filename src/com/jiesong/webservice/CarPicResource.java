package com.jiesong.webservice;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.fileupload.*;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.jiesong.jdbc.JieSongDAO;
import com.jiesong.jdbc.JieSongMysqlIpml;
import com.sun.mail.iap.Response;
import com.jiesong.model.*;
import com.jiesong.util.PropertiesUtil;
import com.jiesong.util.Utility;


public class CarPicResource {
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	String uid;
	String cid;
	public CarPicResource(
			UriInfo uriInfo,
			Request request,
			String uid,
			String cid
			) {
		// TODO Auto-generated constructor stub
	}
	
	@PUT
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response UpdatePicture(){
		Response rsp = null;
		ResponseBuilder rspbdr = null;
		//save picutre then update Car table 
		return rsp;
	}
	
	@DELETE
	public Response DeletePicture(){
		Response rsp = null;
		//delete picture
		
		//if success update Car table set pic = ""
		return rsp;
		
	}

}
