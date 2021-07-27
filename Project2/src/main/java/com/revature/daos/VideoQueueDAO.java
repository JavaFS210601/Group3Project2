package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Favorite;
import com.revature.models.User;
import com.revature.models.Video;
import com.revature.models.VideoQueue;
import com.revature.utils.HibernateUtil;

public class VideoQueueDAO
{
	/*These are here for easy copy/paste
	Session ses = HibernateUtil.getSession();
	Transaction tx = HibernateUtil.startTransaction();
	*/
	
	public void addQueue(VideoQueue newQueue)
	{
		Session ses = HibernateUtil.getSession();
		Transaction tx = HibernateUtil.startTransaction();		
		ses.save(newQueue);
		//ACTUALLY ****ING COMMIT IT
		tx.commit();
		
		HibernateUtil.closeSession();
	}

	//TODO: UPDATE THIS METHOD TO USE THE USERNAME, AND NOT ALLOW USERS TO HAVE 2 QUEUES OF THE SAME NAME
	public void addToQueue(VideoQueue queue, Video video)
	{
		Session ses = HibernateUtil.getSession();
		Transaction tx = HibernateUtil.startTransaction();
		
		String sql = "from VideoQueue where queue_id = '" + queue.getQueue_id() + "'";
		List<VideoQueue> list = ses.createQuery(sql).list();
		//if the list is not empty (We got something back)
		if(list.size() > 0)
		{
			//access the first item in the list, access the video list,append the video
			list.get(0).getVideos().add(video);
			//update the entry in the DB
			ses.merge(list.get(0));
			//commit the transaction
			tx.commit();
		}
		HibernateUtil.closeSession();
	}
	
	// TODO: UPDATE THIS METHOD TO USE THE USERNAME
	public void removeFromQueue(String name, User user, Video video)//add User to parameters
	{
		Session ses = HibernateUtil.getSession();
		Transaction tx = HibernateUtil.startTransaction();
		VideoQueue queue = getQueueByName(name);
		
		queue.getVideos().remove(video);
		
		ses.merge(queue);
		
		tx.commit();
		HibernateUtil.closeSession();
	}

	public List<VideoQueue> getAllQueues() 
	{
		Session ses = HibernateUtil.getSession();
		List<VideoQueue> list = ses.createQuery("from VideoQueue").list();
		return list;
	}

	public VideoQueue getQueueById(int id)
	{
		Session ses = HibernateUtil.getSession();
		
		VideoQueue target = ses.get(VideoQueue.class, id);
		
		HibernateUtil.closeSession();
		
		return target;
	}

	public VideoQueue getQueueByName(String name)//add User to parameters
	{
		Session ses = HibernateUtil.getSession();
		
		List<VideoQueue> list = getAllQueues();
		VideoQueue returnList = new VideoQueue();
		
		for(VideoQueue q : list)
		{
			if(q.getQueue_name().compareTo(name) == 0)
			{
				returnList = q;
				break;
			}
		}
		
		HibernateUtil.closeSession();
		return returnList;
		
	}

	public List<VideoQueue> getQueuesByUser(User user)
	{
		Session ses = HibernateUtil.getSession();
		
		List<VideoQueue> totalList = getAllQueues();
		
		List<VideoQueue> targetList = new ArrayList<VideoQueue>();
		
		for(VideoQueue q : totalList)
		{
			if(q.getUser().equals(user))
			{
				targetList.add(q);
			}
		}
		
		return targetList;
	}

	public void updateQueue(VideoQueue queue)
	{
		Session ses = HibernateUtil.getSession();
		Transaction tx = HibernateUtil.startTransaction();
		
		ses.update(queue);
		
		tx.commit();
		HibernateUtil.closeSession();

	}

	public void removeQueue(VideoQueue queue) 
	{
		Session ses = HibernateUtil.getSession();
		Transaction tx = HibernateUtil.startTransaction();
		
		ses.delete(queue);
		
		tx.commit();
		HibernateUtil.closeSession();

	}

	public void addToQueue(String name, Video video) {
		// TODO Auto-generated method stub
		
	}

	public void removeFromQueue(String name, Video video) {
		// TODO Auto-generated method stub
		
	}


}
