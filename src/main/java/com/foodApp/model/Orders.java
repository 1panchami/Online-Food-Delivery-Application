package com.foodApp.model;

public class Orders 
{
	private int orderid;
	private int uid;
	private int restaurantid;
	private int menuid;
	private int quantity;
	private int total_amount;
	private String payment_mode;
	private String status;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
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
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}
	public String getPayment_mode() {
		return payment_mode;
	}
	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Orders(int orderid, int uid, int restaurantid, int menuid, int quantity, int total_amount,
			String payment_mode, String status) {
		super();
		this.orderid = orderid;
		this.uid = uid;
		this.restaurantid = restaurantid;
		this.menuid = menuid;
		this.quantity = quantity;
		this.total_amount = total_amount;
		this.payment_mode = payment_mode;
		this.status = status;
	}
	public Orders() {
		super();
	}
	public Orders(int uid, int restaurantid, int menuid, int quantity, int total_amount, String payment_mode,
			String status) {
		super();
		this.uid = uid;
		this.restaurantid = restaurantid;
		this.menuid = menuid;
		this.quantity = quantity;
		this.total_amount = total_amount;
		this.payment_mode = payment_mode;
		this.status = status;
	}
	public Orders(int orderid, int quantity) 
	{
		this.orderid=orderid;
		this.quantity=quantity;
	}
	@Override
	public String toString() {
		return orderid+"  "+uid+"   "+restaurantid+"   "+menuid+"   "+quantity+"   "+total_amount+"  "+payment_mode+"  "+status;
	}
	
	
		
}



