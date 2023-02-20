package com.spring.boot.todo;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
	
	//private TodoService1 todoservice;
	private ToDo1Repository1 todorepository;
	public TodoControllerJpa(ToDo1Repository1 todorepository) {
		super();
	//	this.todoservice = todoservice;
		this.todorepository=todorepository;
	}


	@RequestMapping("login-todo")
	public String listTodos(ModelMap model) {
		String username=getLoggedIn(model);
		List<ToDo1> todos=todorepository.findByUsername(username);
		model.addAttribute("todos", todos);
		return "todo1";
	}

	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String newTodos(ModelMap model) {
		String username=getLoggedIn(model);
		ToDo1 todo=new ToDo1(0,username, "",LocalDate.now().plusYears(1), false);
		model.put("todo1", todo);
		return "newtodo1";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodos(ModelMap model,@Valid @ModelAttribute("todo1") ToDo1 todo,BindingResult result) {
		if(result.hasErrors()) {
			return "newtodo1";
		}
		
		String username=getLoggedIn(model);
		todo.setName(username);
		todorepository.save(todo);
		//todoservice.addTodo(username, todo.getDescription(),todo.getLastdate(), todo.isDone());
		return "redirect:login-todo";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todorepository.deleteById(id);
		return "redirect:login-todo";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String showUpdateTodo(@RequestParam int id,ModelMap model) {
	   ToDo1 todo=todorepository.findById(id).get();
	   model.addAttribute("todo1", todo);
		return "newtodo1";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodos(ModelMap model,@Valid @ModelAttribute("todo1") ToDo1 todo,BindingResult result) {
		if(result.hasErrors()) {
			return "newtodo1";
		}
		
		String username=getLoggedIn(model);
		todo.setName(username);
		todorepository.save(todo);
		return "redirect:login-todo";
	}
	
	private String getLoggedIn(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	

}
