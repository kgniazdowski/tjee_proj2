package com.tjee.rowerland.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tjee.rowerland.controller.BikeController;
import com.tjee.rowerland.model.Bike;

@Stateless
public class BikeService {
	
	@EJB
	BikeController bikeController;
	
	public void AddBike(Bike bike)
	{
		bikeController.AddBike(bike);
	}
	
	public void DeleteBike(int id)
	{
		bikeController.DeleteBike(id);
	}
	
	public Bike GetBikeById(int id)
	{
		return bikeController.GetBikeById(id);
	}
	
	public List<Bike> GetAllBikes()
	{
		return bikeController.GetAllBikes();
	}
}
