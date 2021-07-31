package com.revature.models;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JoinColumn(name="user_id", nullable = false, unique = true)
	private User user;
	//this is the relation for Favorite to Video
	@Column(name="movie_id")
	private int movie_id;

	public Favorite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Favorite(User user, int movie_id) {
		super();
		this.user = user;
		this.movie_id = movie_id;
	}

	public Favorite(int favorite_id, User user, int movie_id) {
		super();
		this.favorite_id = favorite_id;
		this.user = user;
		this.movie_id = movie_id;
	}

	@Override
	public String toString() {
		return "Favorite [favorite_id=" + favorite_id + ", user=" + user + ", movie_id=" + movie_id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(favorite_id, movie_id, user);
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
		return favorite_id == other.favorite_id && movie_id == other.movie_id && Objects.equals(user, other.user);
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

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	

	
	
	
}
