package com.spring.boot.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
@Service
public class TodoService1 {
	
	private static List<ToDo1> todos=new ArrayList<>();
	private static int count=0;
	static {
		todos.add(new ToDo1(++count,"akhil","testing",LocalDate.now().plusYears(1),false));
		todos.add(new ToDo1(++count,"akhil","development",LocalDate.now().plusYears(2),false));
		todos.add(new ToDo1(++count,"akhil","full stack",LocalDate.now().plusYears(3),false));
	}
	public List<ToDo1> findUser(String username){
		Predicate<? super ToDo1> predicate=todo ->todo.getName().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
    }
	public void addTodo(String username,String description,LocalDate lastdate,boolean done) {
		ToDo1 todo=new ToDo1(++count,username,description,lastdate,done);
		todos.add(todo);
	}
	public void deleteById(int id) {
		Predicate<? super ToDo1> predicate=todo ->todo.getId()==id;
		todos.removeIf(predicate);
		
	}
	public ToDo1 findById(int id) {
		Predicate<? super ToDo1> predicate=todo ->todo.getId()==id;
		ToDo1 todo=todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
	public void toUpdateTodo(@Valid ToDo1 todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}

}
