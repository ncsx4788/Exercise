package com.excercise.demo.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private LocalDateTime time;
	
	protected Reservation() {
	}
	
	public Reservation( String name, LocalDateTime time) {
		super();
		this.name = name;
		this.time = time;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
}
