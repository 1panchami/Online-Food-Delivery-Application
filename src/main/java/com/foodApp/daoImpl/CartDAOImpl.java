package com.foodApp.daoImpl;

import java.util.HashMap;
import java.util.Map;

import com.foodApp.model.CartItem;

public class CartDAOImpl 
{

	private Map<Integer,CartItem> items;
	private int itemId;
	
	public CartDAOImpl()
	{
		this.items=new HashMap<>();
	}
	
	 public Map<Integer, CartItem> addItem(CartItem item, Map<Integer, CartItem> cart) {
	        int itemId = item.getItemId();

	        if (cart.containsKey(itemId)) {
	            CartItem existingItem = cart.get(itemId);
	            existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
	            System.out.println("Item updated");
	        } else {
	            cart.put(itemId, item);
	            System.out.println("New item added");
	        }
	        return cart;
	    }
	
	
	 public Map<Integer, CartItem> updateItem(Map<Integer, CartItem> cart, int itemId, int quantity) {
		    // Check if the item exists in the cart
		    if (cart.containsKey(itemId)) {
		        CartItem item = cart.get(itemId);

		        // If quantity is 0 or less, remove the item from the cart
		        if (quantity <= 0) {
		            cart.remove(itemId);
		        } else {
		            // Update the quantity of the item
		            item.setQuantity(quantity);
		        }
		    } else {
		        // Log or handle the case where the item is not found in the cart
		        System.out.println("Item with ID " + itemId + " not found in cart.");
		    }

		    // Return the updated cart
		    return cart;
		}


	
	 public Map<Integer, CartItem> removeItem(int cartItemId) {
		    
		    if (items.containsKey(cartItemId)) {
		        items.remove(cartItemId); 
		    }
		    return items; 
		}

	
	
	
	public Map<Integer, CartItem> getItems()
	{
		return items;
	}
	
	public void clear()
	{
		items.clear();
	}
	
	
	
	
}
