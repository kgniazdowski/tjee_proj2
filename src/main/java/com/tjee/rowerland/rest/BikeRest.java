package com.tjee.rowerland.rest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tjee.rowerland.controller.BikeController;
import com.tjee.rowerland.model.Bike;
import com.tjee.rowerland.service.BikeService;

@Stateless
@Path("bike")
public class BikeRest {
	
	@EJB
	BikeService bikeService;

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Bike AddBike(Bike bike)
	{
		Bike newBike = new Bike();
		newBike.setName(bike.getName());
		/*newBike.setPrice(bike.getPrice());
		newBike.setWheelSize(bike.getWheelSize());*/
		bikeService.AddBike(newBike);
		return newBike;
	}
}
