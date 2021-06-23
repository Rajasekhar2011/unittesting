package com.mockito.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mockito.repoistory.TodoServiceRepository;
import com.mockito.repository.TodoServiceRepositoryStub;

public class TodoBusinessImplTest {

	TodoServiceRepository tsr = new TodoServiceRepositoryStub();

	@Test
	public void testRetreiveTodosRelatedToSpring() {
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(tsr);
		assertEquals(2, todoBusinessImpl.retrieveTodosRelatedToSpring("rajasekhar").size());
	}

}
