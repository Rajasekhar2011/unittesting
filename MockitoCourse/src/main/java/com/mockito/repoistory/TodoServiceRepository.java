package com.mockito.repoistory;

import java.util.List;

public interface TodoServiceRepository {
	public List<String> retrieveTodos(String user);
	public void deleteTodo(String todo);
}
