package com.FoodItem;

public class FoodItem {
	 private int id;
	    private String name;
	    private int quantity;

	    public FoodItem(String name, int quantity, int id) {
	        this.id = id;
	        this.name = name;
	        this.quantity = quantity;
	    }

	    public int getId() {
	        return id;
	    }

	    public String getName() {
	        return name;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }

}
