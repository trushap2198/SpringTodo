package com.todo.firstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.ui.ModelMapExtensionsKt;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class TodoController {
	private TodoService service;
	
	//to autowire
	public TodoController(TodoService service) {
		super();
		this.service = service;
	}

	@RequestMapping("list-todos")
	public String listAll(ModelMap model){
		
		List<Todo> todos = service.findByUser(getLoggerUser());
		model.put("todos", todos);
		return "listtodo";
	}

	
	
	@RequestMapping(value  = "add-todo", method = RequestMethod.GET) //same as href in listtodo jsp
	public String showTodo(ModelMap model){
		Todo todo = new Todo(0,getLoggerUser(),"default vaue sent when in get (frist time)",LocalDate.now(),false);
		model.put("todo", todo);
		return "todo";
	}
	
	
	//this will be removed when server restarts
//	@RequestMapping(value  = "add-todo", method = RequestMethod.POST) //same as href in listtodo jsp
//	public String addnewTodo(@RequestParam String des, ModelMap model ){
//		String user = (String) model.get("name");
//		service.addTodo(user, des, LocalDate.now(), false);
//		return "redirect:list-todos"; //name of the url
//	}
	
	@RequestMapping(value  = "add-todo", method = RequestMethod.POST) //same as href in listtodo jsp
	public String addnewTodo(ModelMap model, @Valid Todo todo, BindingResult result ){ //todo needs to be valid before moving further
		
		if(result.hasErrors()) {
			return "todo";
		}
		String user = getLoggerUser();
		service.addTodo(user, todo.getDes(), todo.getTarget(), todo.isDone());
		return "redirect:list-todos"; //name of the url
	}
	
	@RequestMapping ("delete-todo")
	public String deleteTodo (@RequestParam int id) {
		service.deleteTodo(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String updateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = service.findById(id);
		model.addAttribute("todo",todo);
		return "todo";
	}
	
	@RequestMapping(value = "update-todo", method = RequestMethod.POST) //when we are done updating and now want to subit it
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result)
	{
		if(result.hasErrors()) {}
		String username = getLoggerUser();
		todo.setUsername(username);
		service.updateTodo(todo);
		return "redirect:list-todos";
	}
	
	private String getLoggerUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	
}
