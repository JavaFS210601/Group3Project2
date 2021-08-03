package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.revature.daos.FavoriteDAO;
import com.revature.daos.WatchedDAO;
import com.revature.models.Favorite;
import com.revature.models.Watch_Later;

@Service
@SessionAttributes("Session")
public class VideoService 
{
	private FavoriteDAO favDao;
	private WatchedDAO watchDao;
	
	@Autowired
	public VideoService(FavoriteDAO favDao, WatchedDAO watchDao)
	{
		super();
		this.favDao = favDao;
		this.watchDao = watchDao;
	}
	
	public void addToWatchList(Watch_Later newItem)
	{
		watchDao.save(newItem);
	}
	
	public void addToFavoriteList(Favorite newItem)
	{
		favDao.save(newItem);
	}
}
