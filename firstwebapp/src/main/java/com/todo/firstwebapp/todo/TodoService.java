package com.todo.firstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todos=new ArrayList<>();
	
	private static int count = 0;
	static {
		todos.add(new Todo(++count,"in28min","sda1",LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++count,"in28min","sda21",LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++count,"in28min","sda32",LocalDate.now().plusYears(1), false));
	}
	
	public List<Todo> findByUser(String name){
		
		
		return todos.stream().filter(todo -> todo.getUsername().equals(name)).toList();
	}
	public void addTodo(String username, String des, LocalDate target, boolean isdone) {
		Todo todo = new Todo(++count, username,des,target, isdone);
		todos.add(todo);
	}
	
	public void deleteTodo(int id) {
		todos.removeIf(todo -> todo.getId() == id);
	}
	public void updateTodo(@Valid Todo todo) {
		// TODO Auto-generated method stub
		Todo tobeUpdatetodo = todos.stream().filter(todo1 -> todo1.getId() == todo.getId()).findFirst().get();
		tobeUpdatetodo.setDes(todo.getDes());
		
		
	}
	public Todo findById(int id) {
		// TODO Auto-generated method stub
		
		return todos.stream().filter(todo -> todo.getId() == id).findFirst().get();
	
	}
}
