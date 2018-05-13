package com.muaz.conferencesorting.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="NETWORK")
public class Network {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String time = "0";
	private int duration = 0;
	private boolean networking = false;

	

	public Network() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}



	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public boolean isNetworking() {
		return networking;
	}

	public void setNetworking(boolean networking) {
		this.networking = networking;
	}


}
