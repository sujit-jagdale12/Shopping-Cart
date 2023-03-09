package com.user;

public class UserDb {

	public static final int NO_MORE_SPACE = 890;
	public static final int USER_CREATED = 990;
	public static final int ALREADY_EXISTS = 1001;

	public static final Users[] users = new Users[5];

	public static int addUser(int id, String name) {

		int emtPos = getEmptyPosition();
		if (emtPos == -1) {
			return NO_MORE_SPACE;
		}

		int pos = isExists(id);
		if (pos == -1) {
			return ALREADY_EXISTS;
		}

		Users user = new Users(id, name);

		users[emtPos] = user;
		return USER_CREATED;
	}

	public static Users[] listUsers() {

		return users;
	}

	public static Users selectUser(int id) {

		Users user = new Users();

		
		int idPresent = isExists(id);
		if (idPresent == 1) {
			return null;
		}
		
		for (int i = 0; i < users.length; i++) {
			if (users[i].getId() == id) {
				user.setId(users[i].getId());
				user.setName(users[i].getName());
				break;
			}
		}
		return user;
	}



	private static int isExists(int id) {
		for (int i = 0; i < users.length; i++) {
			Users user = users[i];
			if (user != null)
				if (users[i].getId() == id) {
					return -1;
				}
		}
		return 1;
	}

	private static int getEmptyPosition() {

		for (int i = 0; i < users.length; i++) {
			if (users[i] == null) {
				return i;
			}
		}
		return -1;
	}
}
