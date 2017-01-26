package com.tjee.rowerland.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "bike.all", query = "select b from Bike b"),
	@NamedQuery(name = "bike.notRented", query = "select b from Bike b where b.customer IS NULL"),
	@NamedQuery(name = "bike.byCustomer", query = "select b from Bike b where b.customer = :cust")
})
public class Bike {
	
	int id;
    String name;
    double price;
    double wheelSize;
    Customer customer;
    
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
	public double getPrice() {
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
	}
	@ManyToOne
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
