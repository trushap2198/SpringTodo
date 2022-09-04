package com.todo.firstwebapp.todo;

import java.time.LocalDate;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

//Store in Database
//list of todos => database (h2,mysql)

@Entity //allow mapping bean to a db table entity(name="dfs") gives mapping to table dfs (crete in db if not existing 
public class Todo {
	
	private String username;
	
	@Size(min = 4, message = "enter >4 vaules")
	private String des;
	private LocalDate target;
	private boolean done;
	
	@Id
	@GeneratedValue
	private int id;
	
	public Todo() {}
	public Todo(int id, String username, String des, LocalDate target, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.des = des;
		this.target = target;
		this.done = done;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public LocalDate getTarget() {
		return target;
	}
	public void setTarget(LocalDate target) {
		this.target = target;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todo [username=" + username + ", des=" + des + ", target=" + target + ", done=" + done + ", id=" + id
				+ "]";
	}
	

}
