package com.revature.daos;

import java.util.List;

import com.revature.models.Favorite;
import com.revature.models.User;
import com.revature.models.Video;

public interface FavoritesDAOInterface 
{
	//create a new entry. Should only be called when a user is created
	public void addFavorite(Favorite newFavorite);
	//Get all entries
	public List<Favorite> getAllFavorites();
	//get an entry by it's ID
	public Favorite getFavoriteById(int id);
	//get an entry by the username
	public Favorite getFavoriteByUsername(String username);
	//update an entry
	public void updateFavorite(Favorite updatedFavorite);
	//delete an entry
	public boolean removeFavorite(Favorite target);
	//append a video to a list
	//THIS MAY NEED REVISION
	public void appendVideo(User user, Video video, Favorite list);
}
