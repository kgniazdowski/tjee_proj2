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

import com.tjee.rowerland.controller.CustomerController;
import com.tjee.rowerland.model.Bike;
import com.tjee.rowerland.model.Customer;
import com.tjee.rowerland.service.CustomerService;

@Stateless
@Path("customer")
public class CustomerRest {
	
	@EJB
	CustomerController customerController;
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Customer AddCustomer(Customer customer)
	{
		customerController.AddCustomer(customer);
		return customer;
	}
	
	@PUT
	@Path("/edit/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Customer UpdateBike(@PathParam("id") int id, Customer customer)
	{
		Customer oldCustomer = customerController.GetCustomerById(id);
		oldCustomer.setName(customer.getName());
		oldCustomer.setSurname(customer.getSurname());
		customerController.UpdateCustomer(oldCustomer);
		return oldCustomer;
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String DeleteCustomer(@PathParam("id") int id)
	{
		customerController.DeleteCustomer(id);
		return "Usunieto rower o id " + id;
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer GetCustomerById(@PathParam("id") int id)
	{
		return customerController.GetCustomerById(id);
	}
	
	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> GetAllCustomers()
	{
		return customerController.GetAllCustomers();
	}
}
