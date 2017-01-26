package com.tjee.rowerland.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tjee.rowerland.controller.BikeController;
import com.tjee.rowerland.controller.CustomerController;
import com.tjee.rowerland.model.Bike;
import com.tjee.rowerland.model.Customer;

@Stateless
@Path("rental")
public class RentalRest {
	
	@EJB
	CustomerController customerController;
	@EJB
	BikeController bikeController;

	@PUT
	@Path("/rent/{bikeId}/{customerId}")
	public String Rent(@PathParam("bikeId") int bikeId, @PathParam("customerId") int customerId)
	{
		Customer customer = customerController.GetCustomerById(customerId);
		
		if (customer != null)
		{
			Bike bike = bikeController.GetBikeById(bikeId);
			bike.setCustomer(customer);
			bikeController.UpdateBike(bike);
			return "Rower został wypozyczony";
		}
		else
		{
			return "Nie ma klienta o takim id";
		}
	}
	
	@GET
	@Path("/bike/notRented")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bike> GetNotRentedBikes()
	{
		return bikeController.GetNotRentedBikes();
	}
	
	@GET
	@Path("bike/byCustomer/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bike> GetBikesOfCustomer(@PathParam("id") int id)
	{
		return bikeController.GetBikesOfCustomer(id);
	}
}
