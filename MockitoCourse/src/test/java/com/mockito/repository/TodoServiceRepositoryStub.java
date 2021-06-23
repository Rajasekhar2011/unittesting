package com.mockito.repository;

import java.util.Arrays;
import java.util.List;

import com.mockito.repoistory.TodoServiceRepository;

public class TodoServiceRepositoryStub implements TodoServiceRepository {

	@Override
	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Spring boot","Spring MVC","Hibernate");
	}

	@Override
	public void deleteTodo(String todo) {
		// TODO Auto-generated method stub
		
	}

}
