package com.foodApp.dao;






import java.util.List;

import com.foodApp.model.OrderHistory;


public interface OrderHistoryDAO {

	public void insert(OrderHistory ohi);

	 List<OrderHistory> fetchAll();

	 OrderHistory fetchSpecific(int id);

	 int update(OrderHistory ohi);

	 int delete(int id);

}