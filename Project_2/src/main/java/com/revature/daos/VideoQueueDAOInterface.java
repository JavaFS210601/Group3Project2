package com.revature.daos;

import java.util.List;

import com.revature.models.VideoQueue;
import com.revature.models.User;
import com.revature.models.Video;

public interface VideoQueueDAOInterface 
{
	//This will create a new queue
	public void addQueue(VideoQueue newQeueue);
	//This will add a video to a queue
	public void addToQueue(String name, Video video);
	//This will remove a video from a queue
	public void removeFromQueue(String name, Video video);
	//This will return all queues
	public List<VideoQueue> getAllQueues();
	//This will return a queue based on queue ID
	public VideoQueue getQueueById(int id);
	//This will return a queue based on queue name
	public VideoQueue getQueueByName(String name);
	//This will return all queues associated to a user
	public List<VideoQueue> getQueuesByUser(User user);
	//This will update a queue
	public void updateQueue(VideoQueue queue);
	//This will delete a queue
	public void removeQueue(VideoQueue queue);
}
