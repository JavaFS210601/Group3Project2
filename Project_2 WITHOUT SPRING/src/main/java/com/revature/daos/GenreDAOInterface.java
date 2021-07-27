package com.revature.daos;

import java.util.List;

import com.revature.models.Genre;

public interface GenreDAOInterface 
{
	//create
	public void addGenre(Genre newGenre);
	//read all
	public List<Genre> getAllGenres();
	//Get Genre based on ID
	public Genre getGenreById(int id);
	//Get Genre based on name
	public Genre getGenreByName(String name);
	//update a Genre
	public void updateGenre(Genre updatedGenre);
	//remove a Genre
	public boolean removeGenre(Genre targetGenre);
	//check if a Genre is present
	public boolean isPresent(String genreName);
}
