package com.tjee.rowerland.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.tjee.rowerland.model.Bike;
import com.tjee.rowerland.model.Customer;

@Stateless
public class BikeController {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@EJB
	CustomerController customerController;
	
	public void AddBike(Bike bike)
	{
		entityManager.persist(bike);
	}
	
	public void UpdateBike(Bike bike)
	{
		entityManager.merge(bike);
	}
	
	public void DeleteBike(int id)
	{
		entityManager.remove(entityManager.find(Bike.class, id));

	}
	
	public Bike GetBikeById(int id)
	{
		return entityManager.find(Bike.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Bike> GetAllBikes()
	{
		return entityManager.createNamedQuery("bike.all").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Bike> GetNotRentedBikes()
	{
		return entityManager.createNamedQuery("bike.notRented").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Bike> GetBikesOfCustomer(int customerId)
	{
		Customer customer = customerController.GetCustomerById(customerId);
		return entityManager.createNamedQuery("bike.byCustomer").setParameter("cust", customer).getResultList();
	}
}
