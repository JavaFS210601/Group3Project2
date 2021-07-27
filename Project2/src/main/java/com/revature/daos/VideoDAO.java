package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Video;
import com.revature.utils.HibernateUtil;

public class VideoDAO implements VideoDAOInterface 
{
	/*
	 * REMINDER TO SELF: COMMIT ALL TRANSACTIONS, IT WILL PROBABLY SAVE YOU A LARGE AMOUNT
	 * OF HEADACHE IN THE FUTURE. I SOLVED MY JOIN TABLE PROBLEM WHEN ADDING VIDEOS WITH
	 * "Transaction.commit();". I DONT KNOW WHY THIS WAS A PROBLEM, BUT IT WAS AND I AM MAD.
	 */
	/*These are here for easy copy/paste
	Session ses = HibernateUtil.getSession();
	Transaction tx = HibernateUtil.startTransaction();
	*/
	
	public void addVideo(Video newVideo) 
	{
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		//check if a transaction is in progress
		if(!tx.isActive())
		{
			//if no transaction is in progress, begin one
			tx.begin();
		}

		ses.save(newVideo);
		//ACTUALLY ****ING COMMIT IT
		tx.commit();
		
		HibernateUtil.closeSession();
		
	}

	public List<Video> getAllVideos() 
	{
		Session ses = HibernateUtil.getSession();
		
		List<Video> videoList = ses.createQuery("from Video").list();
		
		HibernateUtil.closeSession();
		
		return videoList;
	}
	
	public Video getVideoById(int id)
	{
		Session ses = HibernateUtil.getSession();
		
		Video targetVideo = ses.get(Video.class, id);
		return targetVideo;
	}

	public Video getVideoByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateVideo(Video updatedVideo) {
		// TODO Auto-generated method stub
		
	}

	public boolean removeVideo(Video targetVideo) {
		// TODO Auto-generated method stub
		return false;
	}

}
