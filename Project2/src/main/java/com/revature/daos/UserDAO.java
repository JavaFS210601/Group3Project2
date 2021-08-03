package com.revature.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer>
{
	public Optional<User> findByUsername(String username);
//	ALL OF THE BELOW CODE IS OLD AND CAN BE IGNORED :)
//	/*These are here for easy copy/paste
//	Session ses = HibernateUtil.getSession();
//	Transaction tx = HibernateUtil.startTransaction();
//	*/
//	
//	public void addUser(User newUser) 
//	{
//		Session ses = HibernateUtil.getSession();
//		
//		ses.save(newUser);
//		
//		HibernateUtil.closeSession();
//		
//	}
//
//	public List<User> getAllUsers() 
//	{
//		Session ses = HibernateUtil.getSession();
//		
//		List<User> userList = ses.createQuery("from User").list();
//		
//		HibernateUtil.closeSession();
//		
//		return userList;
//	}
//
//	public boolean isPresent(String username) 
//	{
//		Session ses = HibernateUtil.getSession();
//		boolean isPresent = false;
//		List<User> userList = getAllUsers();
//		
//		//loop through the list of users looking for the username
//		for(User u : userList)
//		{
//			//if the strings are equivalent...
//			if(u.getUsername().compareTo(username) == 0)
//			{
//				//return true
//				isPresent = true;
//				//break out of the loop
//				break;
//			}
//		}
//		
//		return isPresent;
//	}
//
//	public User getUserByUsername(String username) 
//	{
//		Session ses = HibernateUtil.getSession();
//		User targetUser = null;
//		//We should get back a Single user in this list
//		List<User> temp = ses.createQuery("from User where username = '" + username + "'").list();
//		//check if we recieved anything back
//		if(temp.size() > 0)
//		{
//			//put all te information in targetUser
//			targetUser = new User(temp.get(0).getId(),
//					temp.get(0).getUsername(),
//					temp.get(0).getPassword(),
//					temp.get(0).getFirst_name(),
//					temp.get(0).getLast_name(),
//					temp.get(0).getEmail(),
//					temp.get(0).getJoin_date());
//	//		temp.get(0).getId();
//	//		temp.get(0).getUsername();
//	//		temp.get(0).getPassword();
//	//		temp.get(0).getEmail();
//	//		temp.get(0).getFirst_name();
//	//		temp.get(0).getLast_name();
//	//		temp.get(0).getJoin_date();
//		}
////		else//nothing needs to go in the else block
//		
//		//return the user, if none was found we return null
//		return targetUser;
//	}
//
//	public User getUserById(int id) 
//	{
//		Session ses = HibernateUtil.getSession();
//		User list = ses.get(User.class, id);
//		
//		HibernateUtil.closeSession();
//		return list;
//	}
//
//	public void updateUser(User updatedUser) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public boolean removeUser(User targetUser) {
//		// TODO Auto-generated method stub
//		return false;
//	}
	
}
