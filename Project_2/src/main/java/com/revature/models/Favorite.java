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
@Table(name="favorites")
public class Favorite 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="favorite_id")
	private int favorite_id;
	//this is the relation for Favorite to User
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="user_id", nullable = false, unique = true)
	private User user;
	//this is the relation for Favorite to Video
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name="favorite_videos_list",
			joinColumns = @JoinColumn(name="favorite_id"),
			inverseJoinColumns = @JoinColumn(name="video_id"))
	private List<Video>favorite_videos_list;

	public Favorite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Favorite(User user, List<Video> favorite_videos_list) {
		super();
		this.user = user;
		this.favorite_videos_list = favorite_videos_list;
	}

	public Favorite(int favorite_id, User user, List<Video> favorite_videos_list) {
		super();
		this.favorite_id = favorite_id;
		this.user = user;
		this.favorite_videos_list = favorite_videos_list;
	}

	@Override
	public String toString() {
		return "Favorite [favorite_id=" + favorite_id + ", user=" + user + ", favorite_videos_list="
				+ favorite_videos_list + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + favorite_id;
		result = prime * result + ((favorite_videos_list == null) ? 0 : favorite_videos_list.hashCode());
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
		Favorite other = (Favorite) obj;
		if (favorite_id != other.favorite_id)
			return false;
		if (favorite_videos_list == null) {
			if (other.favorite_videos_list != null)
				return false;
		} else if (!favorite_videos_list.equals(other.favorite_videos_list))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public int getFavorite_id() {
		return favorite_id;
	}

	public void setFavorite_id(int favorite_id) {
		this.favorite_id = favorite_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Video> getFavorite_videos_list() {
		return favorite_videos_list;
	}

	public void setFavorite_videos_list(List<Video> favorite_videos_list) {
		this.favorite_videos_list = favorite_videos_list;
	}

	
	
	
}
