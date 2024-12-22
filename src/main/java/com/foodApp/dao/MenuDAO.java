package com.foodApp.dao;

import java.util.List;

import com.foodApp.model.Menu;



public interface MenuDAO 
{
	public void insert(Menu m);

	List<Menu> fetchAll();

	 Menu fetchSpecific(int id);

	 int update(Menu m);

	 int delete(int id);
}
