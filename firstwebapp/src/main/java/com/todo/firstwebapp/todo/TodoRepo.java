package com.todo.firstwebapp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<Todo, Integer >{

	public List<Todo> findByUsername(String username);
}
