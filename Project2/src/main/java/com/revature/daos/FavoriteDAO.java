package com.revature.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Favorite;

@Repository
public interface FavoriteDAO extends JpaRepository<Favorite, Integer>
{
	/*These are here for easy copy/paste
	Session ses = HibernateUtil.getSession();
	Transaction tx = HibernateUtil.startTransaction();
	*/
	
//	public void addFavorite(Favorite newFavorite) 
//	{
//		Session ses = HibernateUtil.getSession();
//		Transaction tx = HibernateUtil.startTransaction();
//
//		ses.save(newFavorite);
//		//ACTUALLY ****ING COMMIT IT
//		tx.commit();
//		
//		HibernateUtil.closeSession();
//
//	}
//
//	public List<Favorite> getAllFavorites() 
//	{
//		Session ses = HibernateUtil.getSession();
//		List<Favorite> list = ses.createQuery("from Favorite").list();
//		return list;
//	}
//
//	public Favorite getFavoriteById(int id) 
//	{
//		Session ses = HibernateUtil.getSession();
//		
//		Favorite target = ses.get(Favorite.class, id);
//		
//		HibernateUtil.closeSession();
//		
//		return target;
//	}
//
//	public Favorite getFavoriteByUserid(int id) 
//	{
//		Session ses = HibernateUtil.getSession();
//		
//		List<Favorite> totalList = getAllFavorites();
//		
//		Favorite targetList = new Favorite();
//		
//		for(Favorite f : totalList)
//		{
//			if(f.getUser().getId() == id)
//			{
//				targetList = f;
//				break;
//			}
//		}
//		
//		return targetList;
//	}
//
//	public void updateFavorite(Favorite list) 
//	{
//		Session ses = HibernateUtil.getSession();
//		Transaction tx = HibernateUtil.startTransaction();
//		
//		ses.update(list);
//		
//		tx.commit();
//		HibernateUtil.closeSession();
//	}
//
//	public boolean removeFavorite(Favorite list) 
//	{
//		Session ses = HibernateUtil.getSession();
//		Transaction tx = HibernateUtil.startTransaction();
//		ses.delete(list);
//		
//		return false;
//	}
//
//	public void appendVideo(User user, Video video) 
//	{
//		Session ses = HibernateUtil.getSession();
//		Transaction tx = HibernateUtil.startTransaction();
//		String sql = "from Favorite where user_id = '" + user.getId() + "'";
//		List<Favorite> list = ses.createQuery(sql).list();
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
//
//	}
//
//	public boolean isEmpty(int id) 
//	{
//		boolean isEmpty = false;
//		
//		Favorite targetList = getFavoriteById(id);
//		//check if the list is empty
//		if(targetList.getVideos().size() == 0)
//		{
//			//the list is empty, set the boolean to true
//			isEmpty = true;
//		}
//		
//		return isEmpty;
//	}

}
