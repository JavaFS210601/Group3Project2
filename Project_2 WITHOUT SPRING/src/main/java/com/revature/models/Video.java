package com.revature.models;

import java.util.Date;
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
@Table(name="videos")
public class Video 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="video_id")//set the yservideo_id column name
	private int video_id;
	
	@Column(name="video_name", nullable = false)
	private String name;
	
	@Column(name="description")
	private String desc;
	
	@Column(name="upload_date")
	private Date upload_date;
	
	@Column(name="release_date")
	private Date release_date;
	
	@Column(name="video_url")
	private String url;
	
	//Relation to User
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="uploader_id_fk")
	private User uploader;
	
	//This is the relation for Video and Genre
	@ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "video_genres",
			joinColumns = @JoinColumn(name="video_id"),
			inverseJoinColumns = @JoinColumn(name="genre_id"))
	private List<Genre> genre_list;
	//This is the relation for Queue and Video
	@ManyToMany(mappedBy="queue_videos_list")
	private List<VideoQueue> queue_list;
	//This is the relation for Favorite to Video
	@ManyToMany(mappedBy="favorite_videos_list")
	private List<Favorite> favorite_list;
	//This is the relation for Watched to Video
	@ManyToMany(mappedBy="watched_videos_list")
	private List<Watched> watched_list;
	/***************************************************************
	 ***************END OF CLASS VARIABLE DECLARATION***************
	 **************************************************************/
	
	//default constructor
	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}
	//all args minusvideo_id constructor
	public Video(String name, String desc, Date upload_date, Date release_date, String url, User uploader,
			List<Genre> genre_list) {
		super();
		this.name = name;
		this.desc = desc;
		this.upload_date = upload_date;
		this.release_date = release_date;
		this.url = url;
		this.uploader = uploader;
		this.genre_list = genre_list;
	}
	//all args constructor
	public Video(int video_id, String name, String desc, Date upload_date, Date release_date, String url, User uploader,
			List<Genre> genre_list) {
		super();
		this.video_id =video_id;
		this.name = name;
		this.desc = desc;
		this.upload_date = upload_date;
		this.release_date = release_date;
		this.url = url;
		this.uploader = uploader;
		this.genre_list = genre_list;
	}

	@Override
	public String toString() {
		return "Video [id=" +video_id + ", name=" + name + ", desc=" + desc + ", upload_date=" + upload_date
				+ ", release_date=" + release_date + ", url=" + url + ", uploader=" + uploader + ", genre_list="
				+ genre_list.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((genre_list == null) ? 0 : genre_list.hashCode());
		result = prime * result +video_id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((release_date == null) ? 0 : release_date.hashCode());
		result = prime * result + ((upload_date == null) ? 0 : upload_date.hashCode());
		result = prime * result + ((uploader == null) ? 0 : uploader.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		Video other = (Video) obj;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (genre_list == null) {
			if (other.genre_list != null)
				return false;
		} else if (!genre_list.equals(other.genre_list))
			return false;
		if (video_id != other.video_id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (release_date == null) {
			if (other.release_date != null)
				return false;
		} else if (!release_date.equals(other.release_date))
			return false;
		if (upload_date == null) {
			if (other.upload_date != null)
				return false;
		} else if (!upload_date.equals(other.upload_date))
			return false;
		if (uploader == null) {
			if (other.uploader != null)
				return false;
		} else if (!uploader.equals(other.uploader))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	public int getId() {
		return video_id;
	}

	public void setId(int video_id) {
		this.video_id =video_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getUpload_date() {
		return upload_date;
	}

	public void setUpload_date(Date upload_date) {
		this.upload_date = upload_date;
	}

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public User getUploader() {
		return uploader;
	}

	public void setUploader(User uploader) {
		this.uploader = uploader;
	}

	public List<Genre> getGenre_list() {
		return genre_list;
	}

	public void setGenre_list(List<Genre> genre_list) {
		this.genre_list = genre_list;
	}
	
	
	
}
