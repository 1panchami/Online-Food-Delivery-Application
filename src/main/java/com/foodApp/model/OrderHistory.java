package com.foodApp.model;

import java.sql.Timestamp;

public class OrderHistory
{
	private int orderhistoryid;
	private int orderid;
	private int uid;
	private int restaurantid;
	private String restaurantname;
	private int total;
	private String status;
	private String orderDate;
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public int getOrderhistoryid() {
		return orderhistoryid;
	}
	public void setOrderhistoryid(int orderhistoryid) {
		this.orderhistoryid = orderhistoryid;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getRestaurantname() {
		return restaurantname;
	}
	public void setRestaurantname(String restaurantname) {
		this.restaurantname = restaurantname;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getRestaurantid() {
		return restaurantid;
	}
	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public OrderHistory(int orderhistoryid, int orderid, int uid, int restaurantid, int total, String status) {
		super();
		this.orderhistoryid = orderhistoryid;
		this.orderid = orderid;
		this.uid = uid;
		this.restaurantid = restaurantid;
		this.total = total;
		this.status = status;
	}
	public OrderHistory(int orderid, int uid, int restaurantid, int total, String status) {
		super();
		this.orderid = orderid;
		this.uid = uid;
		this.restaurantid = restaurantid;
		this.total = total;
		this.status = status;
	}
	public OrderHistory() {
		super();
	}
	public OrderHistory(int orderhistoryid, int total)
	{
		this.orderhistoryid=orderhistoryid;
		this.total=total;
	}
	@Override
	public String toString() {
		return orderhistoryid+" "+orderid+" "+uid+" "+restaurantid+" "+total+" "+status;
	}
	
	
}














