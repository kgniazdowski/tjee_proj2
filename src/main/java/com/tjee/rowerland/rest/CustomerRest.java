package com.tjee.rowerland.rest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tjee.rowerland.model.Bike;
import com.tjee.rowerland.model.Customer;
import com.tjee.rowerland.service.CustomerService;

@Stateless
@Path("customer")
public class CustomerRest {
	
	@EJB
	CustomerService customerService;
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Customer AddCustomer(Customer customer)
	{
		customerService.AddCustomer(customer);
		return customer;
	}
}
