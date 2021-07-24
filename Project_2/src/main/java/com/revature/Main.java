package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.daos.GenreDAO;
import com.revature.daos.UserDAO;
import com.revature.daos.VideoDAO;
import com.revature.daos.WatchedDAO;
import com.revature.models.Genre;
import com.revature.models.User;
import com.revature.models.Video;
import com.revature.models.Watched;

public class Main 
{
	private static GenreDAO genreDao = new GenreDAO();
	private static UserDAO userDao = new UserDAO();
	private static VideoDAO videoDao = new VideoDAO();
	private static WatchedDAO watchedDao = new WatchedDAO();
	
	public static void main(String[] args) 
	{
		createDB();

	}
	
	public static void createDB()
	{
		testUsers();

		testGenres();
		
		testVideos();
		
		testWatched();
		
		
	}



	private static void testUsers()
	{
		User user1 = new User("merk", "123", "mark", "ratib", "somewhere@something.com", null);
		
		userDao.addUser(user1);
		
		List<User> userList = userDao.getAllUsers();
		System.out.println("**************** TESTING USERS: ****************");
		System.out.println("getAllUsers check...");
		System.out.println(userList.toString());
		
		//checking if getUserByUsername works correctly
		//THIS WORKS
//		User user2 = userDao.getUserByUsername(user1.getUsername());
		
		//testing if getUserByUsername works with a username that is not present in the DB
		//THIS WORKS, RETURNS NULL AS EXPECTED
		User user2 = userDao.getUserByUsername("IAMNOTPRESENTLOL");
		System.out.println("Checking if \"IAMNOTPRESENTLOL\" is in the DB...");
		if(user2 != null)
		{
			System.out.println(user2.toString());
		}
		else//user2 is null
		{
			System.out.println("user2 is null!");
		}
		
	}
	
	private static void testGenres() 
	{
		System.out.println("**************** TESTING GENRES: ****************");
		//creating new genres
		Genre genre1 = new Genre("Action");
		Genre genre2 = new Genre("Romance");
		Genre genre3 = new Genre("Comedy");
		//Testing inserts for Genre
		genreDao.addGenre(genre1);
		genreDao.addGenre(genre2);
		genreDao.addGenre(genre3);
		
		List<Genre> genreList = genreDao.getAllGenres();
		//Works as expected
		System.out.println("Testing getAllGenres...\n" + genreList.toString());
		
	}
	
	private static void testVideos() 
	{
		System.out.println("**************** TESTING VIDEOS: ****************");
		User user1 = userDao.getUserByUsername("merk");
		//create an empty list of genres
		List<Genre> video1Genres = new ArrayList<Genre>();
		//get all genres
		List<Genre> genreList = genreDao.getAllGenres();
		//add action to the list of genres
		for(Genre g : genreList)
		{
			if(g.getName().compareTo("Action") == 0)
			{
				video1Genres.add(g);
			}
		}
		//create a new video
		Video video1 = new Video("Action", "This is a test", null, null, "somewhere", user1, video1Genres);
		Video video2 = new Video("Mashup", "This is also a test", null, null, "Somehwere else", user1, genreList);
		//testing inserts for Video
		videoDao.addVideo(video1);
		videoDao.addVideo(video2);
		
		List<Video> videoList = videoDao.getAllVideos();
		
		System.out.println("All videos:\n" 
				+ videoList.get(0).toString()
				+ "\n" + videoList.get(1).toString());
//		this was dumb and would work no matter what, im not pulling these from the DB
		System.out.println("video1.getGenre_list: " + video1.getGenre_list());
		System.out.println("video2.getGenre_list: " + video2.getGenre_list());
		System.out.println("videoList.get(0).getGenre_list: " + videoList.get(0).getGenre_list());
		System.out.println("videoList.get(0).getGenre_list: " + videoList.get(1).getGenre_list());
		
	}
	
	private static void testWatched()
	{
		
		System.out.println("**************** TESTING WATCHED LISTS: ****************");
		User user1 = userDao.getUserByUsername("merk");
		Video video1 = videoDao.getVideoById(1);
		Video video2 = videoDao.getVideoById(2);
		
		Watched watchedList1 = new Watched(user1, new ArrayList<Video>());
		watchedDao.addWatched(watchedList1);
		
		watchedList1.getVideos().add(video1);
		watchedList1.getVideos().add(video2);
		watchedDao.updateWatched(watchedList1);
		
		Watched returnList = watchedDao.getWatchedByUserId(1);
		
		System.out.println("returnList: " + returnList.toString());
	}
}
