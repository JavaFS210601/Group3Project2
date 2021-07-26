package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.daos.FavoriteDAO;
import com.revature.daos.GenreDAO;
import com.revature.daos.UserDAO;
import com.revature.daos.VideoDAO;
import com.revature.daos.VideoQueueDAO;
import com.revature.daos.WatchedDAO;
import com.revature.models.Favorite;
import com.revature.models.Genre;
import com.revature.models.User;
import com.revature.models.Video;
import com.revature.models.VideoQueue;
import com.revature.models.Watched;

public class Main 
{
	private static FavoriteDAO favDao = new FavoriteDAO();
	private static GenreDAO genreDao = new GenreDAO();
	private static UserDAO userDao = new UserDAO();
	private static VideoDAO videoDao = new VideoDAO();
	private static VideoQueueDAO queueDao = new VideoQueueDAO();
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
//		//This works, it jsut prints a lot of stuff
//		testWatched();
//		//This works, it just prints a lot of stuff
//		testFavorite();
		//STILL TESTING
		testQueue();
	}



	private static void testUsers()
	{
		User user1 = new User("merk", "123", "", "", "somewhere@something.com", null);
		User user2 = new User("user2", "123", "", "", "somewhere@something.com", null);
		
		userDao.addUser(user1);
		userDao.addUser(user2);
		
		List<User> userList = userDao.getAllUsers();
		System.out.println("**************** TESTING USERS: ****************");
		System.out.println("getAllUsers check...");
		System.out.println(userList.toString());
		
		//checking if getUserByUsername works correctly
		//THIS WORKS
//		User user2 = userDao.getUserByUsername(user1.getUsername());
		
		//testing if getUserByUsername works with a username that is not present in the DB
		//THIS WORKS, RETURNS NULL AS EXPECTED
		User user3 = userDao.getUserByUsername("IAMNOTPRESENTLOL");
		System.out.println("Checking if \"IAMNOTPRESENTLOL\" is in the DB...");
		if(user3 != null)
		{
			System.out.println(user2.toString());
		}
		else//user2 is null
		{
			System.out.println("user3 is null!");
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
		User user2 = userDao.getUserById(2);
		Video video1 = videoDao.getVideoById(1);
		Video video2 = videoDao.getVideoById(2);
		
		Watched watchedList1 = new Watched(user1, new ArrayList<Video>());
		Watched watchedList2 = new Watched(user2, new ArrayList<Video>());
		watchedDao.addWatched(watchedList1);
		watchedDao.addWatched(watchedList2);
		
//		watchedList1.getVideos().add(video1);
//		watchedList1.getVideos().add(video2);
//		watchedDao.updateWatched(watchedList1);
		//The 3 above lines work as intended
		watchedDao.appendVideo(user1, video1);
		watchedDao.appendVideo(user1, video2);
		
		Watched returnList = watchedDao.getWatchedByUserId(1);
		//For some reason I am getting back 3 copies of one item 
//		System.out.println("returnList: " + returnList.toString());
		for(Video v : returnList.getVideos())
		{
			System.out.println(v.toString());
		}
		System.out.println("returnlist size = " + returnList.getVideos().size());
		
		if(watchedDao.isPresent(user1.getId(), video1.getId()))
		{
			System.out.println("The video is present in the user's list :)");
		}
		else
		{
			System.out.println("The video is not present :(");
		}
		if(watchedDao.isEmpty(user2.getId()))
		{
			System.out.println("The user's list is empty :(");
		}
		else
		{
			System.out.println("The user's list is not empty :)");
		}
		List<Watched> allLists = watchedDao.getAllWatched();
		
		System.out.println("ALL LISTS: " + allLists.toString());
	}

	private static void testFavorite()
	{
		System.out.println("**************** TESTING FAVORITE LISTS: ****************");
		User user1 = userDao.getUserByUsername("merk");
		User user2 = userDao.getUserById(2);
		Video video1 = videoDao.getVideoById(1);
		Video video2 = videoDao.getVideoById(2);
		
		Favorite fav1 = new Favorite(user1, new ArrayList<Video>());
		Favorite fav2 = new Favorite(user2, new ArrayList<Video>());
		
		fav1.getVideos().add(video1);
		fav1.getVideos().add(video2);
		
		System.out.println("fav1: " + fav1.toString());
		
		favDao.addFavorite(fav1);
		System.out.println("\nfav2: " + fav2.toString());
		System.out.println("Getting a list by user id...");
		fav2 = favDao.getFavoriteByUserid(1);
		System.out.println("\nfav2: " + fav2.toString());
		System.out.println("Getting a list by list id...");
		fav2 = favDao.getFavoriteById(1);
		System.out.println("\nfav2: " + fav2.toString());
		System.out.println("Reseting fav2...");
		fav2 = new Favorite(user2, new ArrayList<Video>());
		System.out.println("Saving fav2...");
		favDao.addFavorite(fav2);
		System.out.println("Adding videos to the DB entry...");
		favDao.appendVideo(user2, video1);
		favDao.appendVideo(user2, video2);
		//THIS PRINTS OUT TWO EXTRA ENTRIES AND I DON"T KNOW WHY
		System.out.println("Printing list from DB...\n" + favDao.getFavoriteById(2).toString());
	}

	private static void testQueue()
	{
		System.out.println("**************** TESTING QUEUES: ****************");
		User user1 = userDao.getUserByUsername("merk");
		User user2 = userDao.getUserById(2);
		Video video1 = videoDao.getVideoById(1);
		Video video2 = videoDao.getVideoById(2);
		
		VideoQueue queue1 = new VideoQueue("newqueue", user1, new ArrayList<Video>());
		VideoQueue queue2 = new VideoQueue("newqueue", user1, new ArrayList<Video>());
		
		System.out.println("queue1: " + queue1.toString());
		System.out.println("Adding queue1 and queue2 to the DB...");
		queueDao.addQueue(queue1);
		queueDao.addQueue(queue2);
		System.out.println("Retrieving all queues...");
		List<VideoQueue> queueList = queueDao.getAllQueues();
		System.out.println("queueList: " + queueList.toString());
		
//		VideoQueue queue3 = new VideoQueue("newqueue", user1, new ArrayList<Video>());
	}






}
