package com.todo.firstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SayHelloController {
	@RequestMapping("/hello")
	@ResponseBody
	public String sayHello() {
		return "Heool";
	}

	@RequestMapping("/say-hello")
	public String sayHello2() {
		return "say"; //same as the jsp file name
	}
	
	
}
