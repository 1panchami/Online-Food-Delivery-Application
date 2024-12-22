package com.foodApp.dao;

import java.util.List;

import com.foodApp.model.Restaurant;



public interface RestaurantDAO
{
	public void insert(Restaurant r);

	List<Restaurant> fetchAll();

	
	Restaurant fetchSpecific(int id);

	 int update(Restaurant r);

	 int delete(int id);
}
