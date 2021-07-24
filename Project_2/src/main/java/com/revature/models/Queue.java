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
public class Queue 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="queue_id")
	private int queue_id;
	
	@Column(name="queue_name")
	private int queue_name;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="user_id_fk")
	private User user;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name="queue_videos_list",
			joinColumns = @JoinColumn(name="queue_id"),
			inverseJoinColumns = @JoinColumn(name="video_id"))
	private List<Video> queue_videos_list;
	
	
	
	
	
	
	
	
}
