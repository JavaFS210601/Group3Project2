package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="genres")
public class Genre 
{
	@Id
	@Column(name="genre_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int genre_id;
	
	@Column(name="genre_name")
	private String name;
	//This is the relation for Video and Genre
	@ManyToMany(mappedBy = "genre_list")//this compiles, but is not the desired behavior
	private List<Video> videos;
	//default constructor
	public Genre() {
		super();
		// TODO Auto-generated constructor stub
	}
	//another constructor
	public Genre(String name) {
		super();
		this.name = name;
	}
	//all args constructor
	public Genre(int genre_id, String name) {
		super();
		this.genre_id = genre_id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Genre [genre_id=" + genre_id + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + genre_id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Genre other = (Genre) obj;
		if (genre_id != other.genre_id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public int getId() {
		return genre_id;
	}
	public void setId(int genre_id) {
		this.genre_id = genre_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
