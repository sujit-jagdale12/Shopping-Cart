package com.item;

import java.util.Scanner;

public class ItemDb {

	public static final int ITEM_ADDED = 111;
	public static final int ITEM_LIST_IS_FULL = 1212;
	public static final int REMOVED_ITEM = 1234;

	public static final Items[] items = new Items[20];

	public static int addItem(int id, String name, double price) {

		int full = isFull();
		if (full == -1) {
			return ITEM_LIST_IS_FULL;
		}

		items[full] = new Items(id, name, price);

		return ITEM_ADDED;
	}

	public static Items[] getItems() {
		return items;
	}

	public static int removeItem(int id) {
		Items temp[] = new Items[items.length - 1];
		int j = 0;
		for (int i = 0; i < items.length; i++) {
			if (items[i] != null) {
				if (items[i].getId() != id) {
					temp[j++] = items[i];
				}
			}
		}
		int a = 0;
		for (Items it : temp) {
			items[a++] = it;
		}
		return REMOVED_ITEM;
	}

	private static int isFull() {
		for (int i = 0; i < items.length; i++) {
			if (items[i] == null) {
				return i;
			}
		}
		return -1;
	}
}
