package com.dhruv.user;

import java.util.ArrayList;
import java.util.List;

public class UserManager {

	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();

		for (int i = 0; i < 10; i++) {

			User user = new User();
			user.setId(i);
			user.setEmail("email_" + i + "@gmai.com");
			user.setFirstName("firstName_" + i);
			user.setLastName("LiastName_" + i);
			users.add(user);
		}
		return users;
	}

}
