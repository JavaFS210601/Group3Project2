package com.revature.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Watch_Later;

@Repository
public interface WatchedDAO extends JpaRepository<Watch_Later, Integer>
{
	/*These are here for easy copy/paste
	Session ses = HibernateUtil.getSession();
	Transaction tx = HibernateUtil.startTransaction();
	*/

	
//	public void addWatched(Watch_Later newList) 
//	{
//		Session ses = HibernateUtil.getSession();
//		Transaction tx = HibernateUtil.startTransaction();
//
//		ses.save(newList);
//		//ACTUALLY ****ING COMMIT IT
//		tx.commit();
//		
//		HibernateUtil.closeSession();
//	}
//
//	public Watch_Later getWatchedByUserId(int id) 
//	{
//		Session ses = HibernateUtil.getSession();
//		
//		List<Watch_Later> totalList = getAllWatched();
//		
//		Watch_Later targetList = new Watch_Later();
//		
//		for(Watch_Later w : totalList)
//		{
//			if(w.getUser().getId() == id)
//			{
//				targetList = w;
//				break;
//			}
//		}
//		
//		return targetList;
//	}
//	
//	//Check if a list is empty using a user ID
//	public boolean isEmpty(int id) 
//	{
//		boolean isEmpty = false;
//		
//		Watch_Later targetList = getWatchedByUserId(id);
//		//check if the list is empty
//		if(targetList.getVideos().size() == 0)
//		{
//			//the list is empty, set the boolean to true
//			isEmpty = true;
//		}
//		
//		return isEmpty;
//	}
//
//	public void updateWatched(Watch_Later list) 
//	{
//		Session ses = HibernateUtil.getSession();
//		Transaction tx = HibernateUtil.startTransaction();
//		
//		ses.update(list);
//		
//		tx.commit();
//		HibernateUtil.closeSession();
//		
//	}
//
//	public boolean isPresent(int user_id, int video_id) 
//	{
//		boolean isPresent = false;
//		Session ses = HibernateUtil.getSession();
//		//get the single list into a list of lists
//		List<Watch_Later> list = ses.createQuery("from Watched where user_id = '" + user_id + "'").list();
//		//if we got something back... (list size would be 0 if we didn't)
//		if(list.size() > 0)
//		{
//			//loop through every video in the watched list
//			for(Video v : list.get(0).getVideos())
//			{
//				//if an id in the list is equivalent to the supplied ID...
//				if(v.getId() == video_id)
//				{
//					//the video is in the list
//					isPresent = true;
//					break;
//				}
//			}
//		}
//		
//		return isPresent;
//	}
//
//	public void appendVideo(User user, Video video) 
//	{
//		Session ses = HibernateUtil.getSession();
//		Transaction tx = HibernateUtil.startTransaction();
//		String sql = "from Watched where user_id = '" + user.getId() + "'";
//		List<Watch_Later> list = ses.createQuery(sql).list();
//		//if the list is not empty (We got something back)
//		if(list.size() > 0)
//		{
//			//access the first item in the list, access the video list,append the video
//			list.get(0).getVideos().add(video);
//			//update the entry in the DB
//			ses.merge(list.get(0));
//			//commit the transaction
//			tx.commit();
//		}
//		HibernateUtil.closeSession();
//	}
//
//	public List<Watch_Later> getAllWatched() 
//	{
//		Session ses = HibernateUtil.getSession();
//		List<Watch_Later> list = ses.createQuery("from Watched").list();
//		return list;
//	}
//
//	public boolean removeWatched(Watch_Later list) 
//	{
//		Session ses = HibernateUtil.getSession();
//		Transaction tx = HibernateUtil.startTransaction();
//		ses.delete(list);
//
//		return false;
//	}
	
	
}
