package com.foodApp.dao;
import java.util.List;

import com.foodApp.model.User;




public interface UserDAO 
{
	public void insert(User u);

	List<User> fetchAll();

	User fetchSpecific(int id);
	User getUser(String email);
	boolean registerUser(User user);
	int update(User s);

	int delete(int id);
}

