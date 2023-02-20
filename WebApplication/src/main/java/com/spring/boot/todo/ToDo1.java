package com.spring.boot.todo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
@Entity(name="todo")
public class ToDo1 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	@Size(min=5,message="atleast 5 characters")
	private String description;
	private LocalDate lastdate;
	private boolean done;
	
	public ToDo1() {
		
	}
	
	public ToDo1(int id, String username, String description, LocalDate lastdate, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.lastdate = lastdate;
		this.done = done;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return username;
	}
	public void setName(String username) {
		this.username = username;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getLastdate() {
		return lastdate;
	}
	public void setLastdate(LocalDate lastdate) {
		this.lastdate = lastdate;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	@Override
	public String toString() {
		return "ToDo1 [id=" + id + ", name=" + username + ", description=" + description + ", lastdate=" + lastdate
				+ ", done=" + done + "]";
	}
	

}
