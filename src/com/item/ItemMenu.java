package com.item;

import java.util.Scanner;

import com.user.UserDb;
import com.user.Users;

public class ItemMenu {

	private Scanner sc;

	public ItemMenu() {
		sc = new Scanner(System.in);
	}

	private void displayMenu() {
		StringBuilder builder = new StringBuilder();
		builder.append("🔥 Items Menu 🔥").append("\n").append("-------------------").append("\n")
				.append("Select Your Choice").append("\n").append("-------------------").append("\n")
				.append("1. New Item").append("\n").append("2. List of Items").append("\n").append("3. Remove item").append("\n").append("4. Exit")
				.append("\n").append("\n").append("👉 Enter your Choice : ");

		System.out.println(builder.toString());
	}

	public void performAction() {

		while (true) {
			displayMenu();
			int ch = sc.nextInt();

			if (ch == 4) {
				System.out.println("\n 🙏 Thanks for using our services");
				break;
			} else {
				if (ch == 1) {
					System.out.println("\n 👏 You selected New Item \n");
					System.out.println("Enter Item ID: ");
					int id = sc.nextInt();

					System.out.println("Enter Item Name: ");
					String name = sc.next();

					System.out.println("Enter Item price: ");
					double price = sc.nextDouble();

					int res = ItemDb.addItem(id, name, price);
					if (res == ItemDb.ITEM_LIST_IS_FULL) {
						System.out.println("You have reached maximun limit");
					} else if (res == ItemDb.ITEM_ADDED) {
						System.out.println("Item added successfully.");
					}

				} else if (ch == 2) {
					System.out.println(" \n 👏 You selected List Items \n ");
					Items[] items = ItemDb.getItems();

					for (Items item : items) {
						if (item != null) {
							System.out.println("ItemId: " + item.getId());
							System.out.println("ItemName: " + item.getName());
							System.out.println("ItemPrice: " + item.getPrice());
							System.out.println("------------");
						}
					}

				} 
				else if(ch==3) {
					System.out.println(" \n 👏 You selected Remove Items \n ");
					System.out.println("Enter id to remove");
					int id=sc.nextInt();
					int removeItem = ItemDb.removeItem(id);
					
					if(removeItem==ItemDb.REMOVED_ITEM) {
						System.out.println("Item removed from list.");
					}
				}
				else {
					System.out.println("Enter following choice");
				}
			}
		}
	}
}
