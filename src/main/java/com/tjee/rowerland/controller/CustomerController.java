package com.tjee.rowerland.controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.tjee.rowerland.model.Customer;

@Stateless
public class CustomerController {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public void AddCustomer(Customer customer)
	{
		entityManager.persist(customer);
	}
}
