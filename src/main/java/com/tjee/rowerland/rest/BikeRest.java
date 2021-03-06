package com.tjee.rowerland.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tjee.rowerland.controller.BikeController;
import com.tjee.rowerland.model.Bike;
import com.tjee.rowerland.service.BikeService;

@Stateless
@Path("bike")
public class BikeRest {
	
	@EJB
	BikeController bikeController;

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Bike AddBike(Bike bike)
	{
		Bike newBike = new Bike();
		newBike.setName(bike.getName());
		newBike.setPrice(bike.getPrice());
		newBike.setWheelSize(bike.getWheelSize());
		bikeController.AddBike(newBike);
		return newBike;
	}
	
	@PUT
	@Path("/edit/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Bike UpdateBike(@PathParam("id") int id, Bike bike)
	{
		Bike oldBike = bikeController.GetBikeById(id);
		oldBike.setName(bike.getName());
		oldBike.setPrice(bike.getPrice());
		oldBike.setWheelSize(bike.getWheelSize());
		oldBike.setCustomer(bike.getCustomer());
		bikeController.UpdateBike(oldBike);
		return oldBike;
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String DeleteBike(@PathParam("id") int id)
	{
		bikeController.DeleteBike(id);
		return "Usunieto rower o id " + id;
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Bike GetBikeById(@PathParam("id") int id)
	{
		return bikeController.GetBikeById(id);
	}
	
	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bike> GetAllBikes()
	{
		return bikeController.GetAllBikes();
	}
}
