package com.foodApp.model;

public class Restaurant 
{
	private int restaurantid;
	private String name;
	private String cusineType;
	private String address;
	private int ratings;
	private String image; // corresponds to the 'image' column in the database

	public String getImage() {
	    return image;
	}

	public void setImage(String image) {
	    this.image = image;
	}
	public int getRestaurantid() {
		return restaurantid;
	}
	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCusineType() {
		return cusineType;
	}
	public void setCusineType(String cusineType) {
		this.cusineType = cusineType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	
	
	
	public Restaurant() {
		super();
	}

	public Restaurant(String name, String cusineType, String address, int ratings, String image) {
		super();
		this.name = name;
		this.cusineType = cusineType;
		this.address = address;
		this.ratings = ratings;
		this.image = image;
	}

	public Restaurant(int restaurantid, String name, String cusineType, String address, int ratings, String image) {
		super();
		this.restaurantid = restaurantid;
		this.name = name;
		this.cusineType = cusineType;
		this.address = address;
		this.ratings = ratings;
		this.image = image;
	}

	public Restaurant(int restaurantid, String cusineType) {
		this.restaurantid=restaurantid;
		this.cusineType=cusineType;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantid=" + restaurantid + ", name=" + name + ", cusineType=" + cusineType
				+ ", address=" + address + ", ratings=" + ratings + ", image=" + image + "]";
	}
	
	
	
	
}

