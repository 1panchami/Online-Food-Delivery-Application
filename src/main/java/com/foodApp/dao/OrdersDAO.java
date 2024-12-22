package com.foodApp.dao;




import java.util.List;

import com.foodApp.model.Orders;

public interface OrdersDAO {

	public void insert(Orders r);

	 List<Orders> fetchAll();

	 Orders fetchSpecific(int id);

	 int update(Orders o);

	 int delete(int id);

}