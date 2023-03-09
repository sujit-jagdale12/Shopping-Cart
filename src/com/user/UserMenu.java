package com.user;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserMenu {
	private Scanner scanner;
	private Scanner strScanner;

	public UserMenu() {
		scanner = new Scanner(System.in);
		strScanner = new Scanner(System.in);
	}

	private void displayMenu() {

		StringBuilder builder = new StringBuilder();
		builder.append("🔥 User Menu 🔥").append("\n").append("-------------------").append("\n")
				.append("Select Your Choice").append("\n").append("-------------------").append("\n")
				.append("1. New User").append("\n").append("2. List Users").append("\n").append("3. Select User")
				.append("\n").append("4. Exit").append("\n").append("\n").append("👉 Enter your Choice : ");

		System.out.println(builder.toString());
	}

	public void performAction() {

		while (true) {
			displayMenu();
			int ch=scanner.nextInt();
			

			if (ch == 4) {
				System.out.println("\n 🙏 Thanks for using our services");
				break;
			} else {
				if (ch == 1) {
					System.out.println("\n 👏 You selected New User \n");
					System.out.println("Enter Id: ");
					int id = scanner.nextInt();

					System.out.println("Enter Name: ");
					String name = strScanner.nextLine();

					int res = UserDb.addUser(id, name);

					if (res == UserDb.NO_MORE_SPACE) {
						System.out.println("There is no more space available!");
					} else if (res == UserDb.ALREADY_EXISTS) {
						System.out.println("Entered id is alreay available!");
					} else if (res == UserDb.USER_CREATED) {
						System.out.println("User succesfully created...");
					}
				} else if (ch == 2) {
					System.out.println(" \n 👏 You selected List users \n ");

					Users[] users = UserDb.listUsers();
					int a = 0;
					for (Users users2 : users) {
						if (users2 == null) {
							a++;
						}
					}
					if (a == UserDb.users.length) {
						System.out.println("List is empty please add some users.");
					} else {

						for (Users user : users) {
							if (user != null) {
								System.out.println("ID : " + user.getId());
								System.out.println("Name: " + user.getName());
								System.out.println("----------------");
							}
						}
					}

				} else if (ch == 3) {
					System.out.println("\n 👏 You selected Select User \n");
					System.out.println("Enter Id to get details: ");
					int id = scanner.nextInt();
					Users user = UserDb.selectUser(id);

					if (user == null) {
						System.out.println("Id is not present");
					} else {
						System.out.println("ID : " + user.getId());
						System.out.println("Name: " + user.getName());
						System.out.println("----------------");
					}
				} else {
					System.out.println("Enter following choice");
				}
			}

		}
	}
}
