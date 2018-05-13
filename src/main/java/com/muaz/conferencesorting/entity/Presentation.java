package com.muaz.conferencesorting.entity;


import javax.persistence.*;


@Entity
@Table(name="Presentation")
public class Presentation {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
	private int duration;
	private String time = "0";
	private boolean programmed;
	
	
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
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public boolean isProgrammed() {
		return programmed;
	}
	public void setProgrammed(boolean programmed) {
		this.programmed = programmed;
	}
	
	
    


    
}
