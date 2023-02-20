package com.spring.boot.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDo1Repository1 extends JpaRepository<ToDo1, Integer>{
	
	public List<ToDo1> findByUsername(String username);

}
