package com.revature.daos;

import java.util.List;

import com.revature.models.User;
import com.revature.models.Video;
import com.revature.models.Watched;

public interface WatchedDAOInterface 
{
	//add a video to the Table, this should be called once, when a user is created in the user table
	public void addWatched(Watched newList);
	//Get a Watched Object base on User ID
	public Watched getWatchedByUserId(int id);
	//check if a Watched list is empty, based on ID. Returns true if the list is empty
	public boolean isEmpty(int id);
	//updates a Watched list
	public void updateWatched(Watched list);
	//Checks if a video is present in a User's Watched list
	//This might not be necessary. If a user watches a video multiple times, we can 
	//dont have to append it if it was the last thing watched, or we can
	public boolean isPresent(int user_id, int video_id);
	//append a new video to a users Watched list.
	//THIS MAY NEED REVISION
	public void appendVideo(User user, Video video, Watched list);
	//Get all entries
	public List<Watched> getAllWatched();
	//remove an entry, should be called when a user is removed from the users table
	public boolean removeWatched(Watched target);
}
