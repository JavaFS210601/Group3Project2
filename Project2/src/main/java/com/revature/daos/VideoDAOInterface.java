package com.revature.daos;

import java.util.List;

import com.revature.models.Video;

public interface VideoDAOInterface 
{
	//add a single Video to the table
	public void addVideo(Video newVideo);
	//get all Videos from the table
	public List<Video> getAllVideos();
	//get a Video base on ID
	public Video getVideoById(int id);
	//get a Video by it's anme
	public Video getVideoByName(String name);
	//update a Video in the database
	public void updateVideo(Video updatedVideo);
	//remove a Video from the DB
	public boolean removeVideo(Video targetVideo);
	
}
