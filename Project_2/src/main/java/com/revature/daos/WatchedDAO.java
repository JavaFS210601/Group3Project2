package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Video;
import com.revature.models.Watched;
import com.revature.utils.HibernateUtil;

public class WatchedDAO implements WatchedDAOInterface {

	public void addWatched(Watched newList) 
	{
		{
			Session ses = HibernateUtil.getSession();
			Transaction tx = HibernateUtil.startTransaction();

			ses.save(newList);
			//ACTUALLY ****ING COMMIT IT
			tx.commit();
			
			HibernateUtil.closeSession();
		}


	}

	public Watched getWatchedByUserId(int id) 
	{
		Session ses = HibernateUtil.getSession();
		
		Watched targetList = ses.get(Watched.class, id);
		
		return targetList;
	}
	
	//Check if a list is empty using a user ID
	public boolean isEmpty(int id) 
	{
		boolean isEmpty = false;
		
		Watched targetList = getWatchedByUserId(id);
		//check if the list is empty
		if(targetList.getVideos() == null)
		{
			//the list is empty, set the boolean to true
			isEmpty = true;
		}
		
		return isEmpty;
	}

	public void updateWatched(Watched list) 
	{
		Session ses = HibernateUtil.getSession();
		Transaction tx = HibernateUtil.startTransaction();
		
		ses.update(list);
		
		tx.commit();
		HibernateUtil.closeSession();
		
	}

	public boolean isPresent(int user_id, int video_id) 
	{
		boolean isPresent = false;
		Session ses = HibernateUtil.getSession();
		//get the single list into a list of lists
		List<Watched> list = ses.createQuery("from Watched where user_id = '" + user_id + "'").list();
		//if we got something back... (list size would be 0 if we didn't)
		if(list.size() > 0)
		{
			//loop through every video in the watched list
			for(Video v : list.get(0).getVideos())
			{
				//if an id in the list is equivalent to the supplied ID...
				if(v.getId() == video_id)
				{
					//the video is in the list
					isPresent = true;
					break;
				}
			}
		}
		
		return isPresent;
	}
	
	
}
