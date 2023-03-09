package com.ani.cart;

import com.item.Items;
import com.user.Users;

public class CartDb {

	public static final int ADD_TO_CART = 101;
	public static final int CART_IS_FULL = 999;

	public static final Cart[] carts = new Cart[10];

	public static int addCart(Users user, Items[] items, double bill) {

		int index = getIndex();
		if (index == -1) {
			return CART_IS_FULL;
		}
		Cart cart = new Cart(user, items, bill);
		carts[index] = cart;
		return ADD_TO_CART;
	}

	public static double generateTotalBill(Items[] items) {
		double bill=0;
		for (Items items2 : items) {
			bill+=items2.getPrice();
		}
		return bill;
	}
	private static int getIndex() {
		for (int i = 0; i < carts.length; i++) {
			if (carts[i] == null) {
				return i;
			}
		}
		return -1;
	}

}
