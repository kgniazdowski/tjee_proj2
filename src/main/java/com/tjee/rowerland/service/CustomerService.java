package com.tjee.rowerland.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tjee.rowerland.controller.CustomerController;
import com.tjee.rowerland.model.Customer;

@Stateless
public class CustomerService {
	
	@EJB
	CustomerController customerController;
	
	public void AddCustomer(Customer customer)
	{
		customerController.AddCustomer(customer);
	}

}
