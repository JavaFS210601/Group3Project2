package com.revature.models;

import java.util.Objects;

public class Video 
{
	private int id;

	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Video(int id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Video other = (Video) obj;
		return id == other.id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
