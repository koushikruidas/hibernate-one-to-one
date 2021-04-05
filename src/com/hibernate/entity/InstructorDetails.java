package com.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetails {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="youtube_channel")
	private String channel;
	@Column(name="hobby")
	private String hobby;
	
	@OneToOne(mappedBy="instructorDetail", cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST
			,CascadeType.REFRESH})
	private Instructor instructor;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getChannel() {
		return channel;
	}
	
	public void setChannel(String channel) {
		this.channel = channel;
	}
	
	public String getHobby() {
		return hobby;
	}
	
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	public Instructor getInstructor() {
		return instructor;
	}
	
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	public InstructorDetails(String channel, String hobby) {
		this.channel = channel;
		this.hobby = hobby;
	}
	
	public InstructorDetails() {
	}
	
	@Override
	public String toString() {
		return "InstructorDetails [id=" + id + ", channel=" + channel + ", hobby=" + hobby + "]";
	}
	
}
