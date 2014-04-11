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



@Path("/cars")
public class CarResources {

	public CarResources() {
		// TODO Auto-generated constructor stub
	}
	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;
	
	@POST
	@Path("add")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response addCars(//@Context HttpServletRequest request,
			//@Context HttpServletResponse response,
			@FormParam("maxSeats") String maxSeats,
			@FormParam("maxLuggages") String maxLuggages,
			@FormParam("userid") String userid
			) throws IOException{	

		
		PropertiesUtil pu = new PropertiesUtil();
		String aid = pu.getValue("AdministratorID");
		
		JieSongDAO dao = new JieSongMysqlIpml();
		Car newCar = new Car();
		User newUser = dao.getUserByID(Integer.parseInt(aid));
		
		newCar.setActive(true);
		newCar.setCreateTime(new Timestamp(System.currentTimeMillis()));
		newCar.setMaxLuggages(Integer.parseInt(maxLuggages));
		newCar.setMaxSeats(Integer.parseInt(maxSeats));
		newCar.setUserId(Integer.parseInt(userid));
		newCar.setCreateBy(Integer.parseInt(aid));
		newCar.setModifyBy(Integer.parseInt(aid));
		newCar.setModifyTime(new Timestamp(System.currentTimeMillis()));
		newCar.setImageURI("");
		
		Response rsp = null;
		return rsp;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Car> GetAllDetails(){
		List<Car> carList = new ArrayList<Car>();
		
		//
		
		return carList;
	}
	
	@PUT	
	@Path("Update")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response CarUpdate(
			@QueryParam("carid") String cid,
			@FormParam("seats") String seats
			
			
			){
		Response rsp = null;
		
		//Update the information of car
		
		return rsp;
	}
	
	@GET
	@Path("user")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Car> GetCarsByUserID(
			@QueryParam("userid") String uid){
		List<Car> CarList = new ArrayList<Car>();
		
		//
		
		
		return CarList;
	}
	
	
	//Operation of Picture of Cars
	@Path("pic")
	public CarPicResource CarPic(
			@QueryParam("uid") String uid,
			@QueryParam("cid") String cid){
		
		return new CarPicResource(uriInfo, request, uid, cid);
	}
	
	
	
	
}
