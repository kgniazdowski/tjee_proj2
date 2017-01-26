package com.tjee.rowerland.controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.tjee.rowerland.model.Bike;
import com.tjee.rowerland.model.Customer;

@Stateless
public class CustomerController {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public void AddCustomer(Customer customer)
	{
		entityManager.persist(customer);
	}
	
	public void UpdateCustomer(Customer customer)
	{
		entityManager.merge(customer);
	}
	
	public void DeleteCustomer(int id)
	{
		entityManager.remove(entityManager.find(Customer.class, id));
	}
	
	public Customer GetCustomerById(int id)
	{
		return entityManager.find(Customer.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> GetAllCustomers()
	{
		return entityManager.createNamedQuery("customer.all").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> GetCustomerBySurname(String surname)
	{
		return entityManager.createNamedQuery("customer.bySurname").setParameter("surname", surname).getResultList();
	}
}
