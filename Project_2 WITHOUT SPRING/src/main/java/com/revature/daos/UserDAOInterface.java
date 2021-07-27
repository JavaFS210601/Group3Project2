package com.revature.daos;

import java.util.List;

import com.revature.models.User;

public interface UserDAOInterface 
{
	//add a User to the table
	public void addUser(User newUser);
	//get all Users from the table
	public List<User> getAllUsers();
	//get a single User based on ID
	public User getUserById(int id);
	//get a single User base on username
	public User getUserByUsername(String username);
	//update a single User
	public void updateUser(User updatedUser);
	//remove a User
	public boolean removeUser(User targetUser);
	//check if a User is in the table
	public boolean isPresent(String username);
	
	
}
