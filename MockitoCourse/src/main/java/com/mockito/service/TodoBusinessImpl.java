package com.mockito.service;

import java.util.List;
import java.util.stream.Collectors;

import com.mockito.repoistory.TodoServiceRepository;

public class TodoBusinessImpl {
	
	private TodoServiceRepository tsr;

	public TodoBusinessImpl(TodoServiceRepository tsr) {
		this.tsr = tsr;
	}
	
	public List<String> retrieveTodosRelatedToSpring(String user){
		return tsr.retrieveTodos(user).stream().filter(todo -> todo.contains("Spring")).collect(Collectors.toList());
	}
	
	public void deleteTodosNottRelatedToSpring(String user) {
		List<String> todos = tsr.retrieveTodos(user);
		for(String todo : todos) {
			if(!todo.contains("Spring")) {
				tsr.deleteTodo(todo);
			}
		}
	}

}
