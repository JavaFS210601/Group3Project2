package com.revature.models;

import java.util.List;
import java.util.Objects;

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
@Table(name="watch_Later")
public class Watch_Later 
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
	@Column(name="movie_id")
	private int movie_id;

	public Watch_Later() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Watch_Later(User user, int movie_id) {
		super();
		this.user = user;
		this.movie_id = movie_id;
	}

	public Watch_Later(int watched_id, User user, int movie_id) {
		super();
		this.watched_id = watched_id;
		this.user = user;
		this.movie_id = movie_id;
	}

	@Override
	public String toString() {
		return "Watched [watched_id=" + watched_id + ", user=" + user + ", movie_id=" + movie_id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(movie_id, user, watched_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Watch_Later other = (Watch_Later) obj;
		return movie_id == other.movie_id && Objects.equals(user, other.user) && watched_id == other.watched_id;
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

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	
	

	
	
}