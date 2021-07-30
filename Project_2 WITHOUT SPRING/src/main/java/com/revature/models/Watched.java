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
@Table(name="watched")
public class Watched 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="watched_id")
	private int watched_id;
	//this is the relation for Watched to User
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)//, cascade = CascadeType.ALL <-causes errors
	@JoinColumn(name="user_id", nullable = false, unique = true)
	private User user;
	//This is the relation for Watched to Video
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JoinTable(
			name="watched_videos_list",
			joinColumns = @JoinColumn(name="watched_id"),
			inverseJoinColumns = @JoinColumn(name="video_id"))
	private List<Video> watched_videos_list;

	public Watched() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Watched(User user, List<Video> watched_videos_list) {
		super();
		this.user = user;
		this.watched_videos_list = watched_videos_list;
	}

	public Watched(int watched_id, User user, List<Video> watched_videos_list) {
		super();
		this.watched_id = watched_id;
		this.user = user;
		this.watched_videos_list = watched_videos_list;
	}

	@Override
	public String toString() {
		return "Watched [watched_id=" + watched_id + ", \nuser=" + user + ", \nwatched_videos_list=" + watched_videos_list + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((watched_videos_list == null) ? 0 : watched_videos_list.hashCode());
		result = prime * result + watched_id;
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
		Watched other = (Watched) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (watched_videos_list == null) {
			if (other.watched_videos_list != null)
				return false;
		} else if (!watched_videos_list.equals(other.watched_videos_list))
			return false;
		if (watched_id != other.watched_id)
			return false;
		return true;
	}

	public int getWatched_id() {
		return watched_id;
	}

	public void setWatched_id(int watched_id) {
		this.watched_id = watched_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Video> getVideos() {
		return watched_videos_list;
	}

	public void setVideos(List<Video> watched_videos_list) {
		this.watched_videos_list = watched_videos_list;
	}
	
	
}