package com.tjee.rowerland.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bike {
	
	int id;
    String name;
    //double price;
    //double wheelSize;
    //Producer producer;
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getWheelSize() {
		return wheelSize;
	}
	public void setWheelSize(double wheelSize) {
		this.wheelSize = wheelSize;
	}*/

}
