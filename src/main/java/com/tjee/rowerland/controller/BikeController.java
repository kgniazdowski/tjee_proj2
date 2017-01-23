package com.tjee.rowerland.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.tjee.rowerland.model.Bike;

@Stateless
public class BikeController {
	
	@PersistenceContext
	EntityManager entityManager;
	
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
}
