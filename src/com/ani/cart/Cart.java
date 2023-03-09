package com.ani.cart;

import com.item.Items;
import com.user.Users;

public class Cart {
	private Users user;
	private Items[] items;
	private double totalPrice;

	public Cart(Users user, Items[] items, double totalPrice) {
		super();
		this.user = user;
		this.items = items;
		this.totalPrice = totalPrice;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Items[] getItems() {
		return items;
	}

	public void setItems(Items[] items) {
		this.items = items;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
