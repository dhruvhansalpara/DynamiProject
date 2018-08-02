package com.dhruv.user;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dhruv.util.DBConnection;

public class UserManager {

	
   public static Map<String, User> map=new HashMap<String, User>();
	
	public void addUser(String fistName, String email, String password)
	{
		User user=new User();
		user.setEmail(email);
		user.setFirstName(fistName);
		user.setPassword(password.trim());
		map.put(email, user);
		
	}
	
	public boolean validateUser(String email, String password)
	{
		if(map.containsKey(email))
		{
			User user=map.get(email);
			return password.trim().equals(user.getPassword());
		}
		
		return false;
	}
	
	public String getFirstName(String email)
	{
		if(map.containsKey(email))
		{
			return map.get(email).getFirstName();
		}
		
		return null;
	}
	
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
	
	
	public List<User> getUsersMysql() {
		List<Map<String, String>> users=new ArrayList<Map<String,String>>();
		try {
			users = DBConnection.getResultByQuery("select * from users;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		List<User> readyUser=new ArrayList<User>();
		for(Map<String, String> row: users)
		{
			User user = new User();
			user.setId(Integer.valueOf(row.get("ID")));
			user.setFirstName(row.get("name"));
			user.setEmail("email_" + row.get("ID") + "@gmai.com");
			user.setLastName("LiastName_" + row.get("ID"));
			readyUser.add(user);
			
		}
		return readyUser;
		
	}

}
