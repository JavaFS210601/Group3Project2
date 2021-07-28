package com.revature.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.UserDAO;
import com.revature.models.User;

@Service
public class UserService 
{
	private UserDAO userDao;
	@Autowired
	public UserService(UserDAO userDao) {
		super();
		this.userDao = userDao;
	}
	
	public void userCreation(User user)
	{
		userDao.save(user);
	}
	
	public boolean userUpdate(User user)
	{
		boolean ok = false;
		//check that the user exists
		if(userDao.existsById(user.getId()))
		{
			//save the user information, and set boolean to true
			userDao.save(user);
			ok = true;
		}
		
		return ok;
	}
	
	public User getFullUser(User user)
	{
		Optional<User> rtnUser = null;
		
		rtnUser = userDao.findByUsername(user.getUsername());
		if(rtnUser.isPresent())
		{
			return rtnUser.get();
		}
		return null;
	}
}
