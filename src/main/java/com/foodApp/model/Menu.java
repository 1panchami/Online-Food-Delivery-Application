package com.foodApp.model;


public class Menu 
{
	private int menuid;
	private int restaurantid;
	private String name;
	private String description;
	private int price;
	private int ratings;
	private String image; // corresponds to the 'image' column in the database

	public String getImage() {
	    return image;
	}

	public void setImage(String image) {
	    this.image = image;
	}
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	
	public Menu(int menuid, int restaurantid, String name, String description, int price, int ratings, String image) {
		super();
		this.menuid = menuid;
		this.restaurantid = restaurantid;
		this.name = name;
		this.description = description;
		this.price = price;
		this.ratings = ratings;
		this.image = image;
	}

	public Menu(int restaurantid, String name, String description, int price, int ratings, String image) {
		super();
		this.restaurantid = restaurantid;
		this.name = name;
		this.description = description;
		this.price = price;
		this.ratings = ratings;
		this.image = image;
	}
	

	public Menu() {
		super();
	}

	public Menu(int menuid, String name) {
		this.menuid=menuid;
		this.name=name;
	}

	@Override
	public String toString() {
		return "Menu [menuid=" + menuid + ", restaurantid=" + restaurantid + ", name=" + name + ", description="
				+ description + ", price=" + price + ", ratings=" + ratings + ", image=" + image + "]";
	}
	
	
	
}





















