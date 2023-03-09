package com.ani.cart;

import java.util.Scanner;

import com.item.ItemDb;
import com.item.ItemMenu;
import com.item.Items;
import com.user.UserMenu;
import com.user.Users;

public class CartManager {
	private Scanner sc;

	public CartManager() {
		sc = new Scanner(System.in);
	}

	private void displayMenu() {
		StringBuilder builder = new StringBuilder();
		builder.append("🔥 Cart Menu 🔥").append("\n").append("-------------------").append("\n")
				.append("Select Your Choice").append("\n").append("-------------------").append("\n")
				.append("1. Add to cart").append("\n").append("2. Remove from Cart").append("\n")
				.append("3. Total bill").append("\n").append("4. Exit").append("\n").append("\n")
				.append("👉 Enter your Choice : ");

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
					System.out.println("\n 👏 You selected Add Cart \n");
					System.out.println("Add User");
					UserMenu userMenu = new UserMenu();
					userMenu.performAction();

					
					System.out.println("Add Items");
					ItemMenu itemMenu = new ItemMenu();
					itemMenu.performAction();
					
				} else if (ch == 2) {
					System.out.println(" \n 👏 You selected Remove Cart \n ");

				} else if (ch == 3) {
					System.out.println(" \n 👏 Generate Total bill  \n ");
					Items[] items = ItemDb.getItems();

					double totalBill = CartDb.generateTotalBill(items);

					System.out.println("Total Bill: " + totalBill);
				} else {
					System.out.println("Enter following choice");
				}
			}
		}
	}
}
