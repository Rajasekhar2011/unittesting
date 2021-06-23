package com.mockito.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;

import com.mockito.repoistory.TodoServiceRepository;

public class TodoBusinessImplTestTestMock {

	@Test
	public void testRetrieveTodosRelatedToSpring() {
		TodoServiceRepository tsrMock = mock(TodoServiceRepository.class);
		when(tsrMock.retrieveTodos("Rajasekhar")).thenReturn(Arrays.asList("Spring boot", "Spring MVC", "Hibernate"));
		TodoBusinessImpl tbimpl = new TodoBusinessImpl(tsrMock);
		assertEquals(2, tbimpl.retrieveTodosRelatedToSpring("Rajasekhar").size());
	}

}
