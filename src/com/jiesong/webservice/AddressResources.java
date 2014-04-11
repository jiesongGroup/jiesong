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


@Path("address")
public class AddressResources {

	public AddressResources() {
		// TODO Auto-generated constructor stub
	}
	
	@Context
	UriInfo uriInfo;	
	@Context
	Request request;
	
	@Path("get")
	@GET	
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Address> GetAddressList(
			@QueryParam("userid") String userid
			){
		List<Address> newList = new ArrayList<Address>();
		JieSongDAO dao = new JieSongMysqlIpml();
		//newList = dao.searchAddress(a)
		
		
		return newList;		
	}
	
	@Path("update")
	@PUT
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response UpdateAddress(
			@QueryParam("userid") String userid,
			@FormParam("addressid") String addressid,
			@FormParam("street") String street,
			@FormParam("suburb") String suburb,
			@FormParam("province") String province,
			@FormParam("nation") String nation,
			@FormParam("postcode") String postcode
			){
		Response rsp = null;
		
		//DAO
		
		return rsp;
	}
	
	@Path("add")
	@PUT
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response AddAddress(
			@QueryParam("userid") String userid,
			@FormParam("addressid") String addressid,
			@FormParam("street") String street,
			@FormParam("suburb") String suburb,
			@FormParam("province") String province,
			@FormParam("nation") String nation,
			@FormParam("postcode") String postcode
			){
		Response rsp = null;
		
		//DAO
		
		return rsp;
	}
}
