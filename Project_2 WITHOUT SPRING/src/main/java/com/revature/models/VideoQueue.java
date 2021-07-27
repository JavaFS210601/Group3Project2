package com.revature.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="queues")
public class VideoQueue 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="queue_id")
	private int queue_id;
	
	@Column(name="queue_name")
	private String queue_name;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JoinColumn(name="user_id_fk")
	private User user;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JoinTable(
			name="queue_videos_list",
			joinColumns = @JoinColumn(name="queue_id"),
			inverseJoinColumns = @JoinColumn(name="video_id"))
	private List<Video> queue_videos_list;

	public VideoQueue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VideoQueue(String queue_name, User user, List<Video> queue_videos_list) {
		super();
		this.queue_name = queue_name;
		this.user = user;
		this.queue_videos_list = queue_videos_list;
	}

	public VideoQueue(int queue_id, String queue_name, User user, List<Video> queue_videos_list) {
		super();
		this.queue_id = queue_id;
		this.queue_name = queue_name;
		this.user = user;
		this.queue_videos_list = queue_videos_list;
	}

	@Override
	public String toString() {
		return "VideoQueue [queue_id=" + queue_id + ", queue_name=" + queue_name + ", user=" + user
				+ ", queue_videos_list=" + queue_videos_list + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + queue_id;
		result = prime * ((queue_name == null) ? 0 : queue_name.hashCode());
		result = prime * result + ((queue_videos_list == null) ? 0 : queue_videos_list.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VideoQueue other = (VideoQueue) obj;
		if (queue_id != other.queue_id)
			return false;
		if (queue_name != other.queue_name)
			return false;
		if (queue_videos_list == null) {
			if (other.queue_videos_list != null)
				return false;
		} else if (!queue_videos_list.equals(other.queue_videos_list))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public int getQueue_id() {
		return queue_id;
	}

	public void setQueue_id(int queue_id) {
		this.queue_id = queue_id;
	}

	public String getQueue_name() {
		return queue_name;
	}

	public void setQueue_name(String queue_name) {
		this.queue_name = queue_name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Video> getVideos() {
		return queue_videos_list;
	}

	public void setVideos(List<Video> queue_videos_list) {
		this.queue_videos_list = queue_videos_list;
	}
	
	
}
