package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Genre;
import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class GenreDAO implements GenreDAOInterface 
{

	public void addGenre(Genre newGenre) 
	{
		Session ses = HibernateUtil.getSession();
		
		ses.save(newGenre);
		
		HibernateUtil.closeSession();
		
	}

	public List<Genre> getAllGenres() 
	{
		Session ses = HibernateUtil.getSession();
		
		List<Genre> genreList = ses.createQuery("from Genre").list();
		
		HibernateUtil.closeSession();
		
		return genreList;
	}

	public boolean isPresent(String genreName) 
	{
		Session ses = HibernateUtil.getSession();
		boolean isPresent = false;
		List<Genre> genreList = getAllGenres();
		
		//loop through the list of genres looking for the genre name
		for(Genre g : genreList)
		{
			//if the strings are equivalent...
			if(g.getName().compareTo(genreName) == 0)
			{
				//return true
				isPresent = true;
				//break out of the loop
				break;
			}
		}
		
		return isPresent;
	}

	public Genre getGenreById(int id) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	public Genre getGenreByName(String name) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	public void updateGenre(Genre updatedGenre) 
	{
		// TODO Auto-generated method stub
		
	}

	public boolean removeGenre(Genre targetGenre) 
	{
		// TODO Auto-generated method stub
		return false;
	}
	
}
