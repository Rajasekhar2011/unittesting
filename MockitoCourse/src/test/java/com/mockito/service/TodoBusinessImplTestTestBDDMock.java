package com.mockito.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.mockito.repoistory.TodoServiceRepository;

public class TodoBusinessImplTestTestBDDMock {

	@Test
	public void testRetrieveTodosRelatedToSpring_usingBDDMock() {

		// Given
		TodoServiceRepository tsrMock = mock(TodoServiceRepository.class);
		given(tsrMock.retrieveTodos("Rajasekhar")).willReturn(Arrays.asList("Spring boot", "Spring MVC", "Hibernate"));
		TodoBusinessImpl tbimpl = new TodoBusinessImpl(tsrMock);

		// when
		List<String> filteredTodos = tbimpl.retrieveTodosRelatedToSpring("Rajasekhar");

		// then
		assertThat(filteredTodos.size(), is(2));
	}
	
	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDDMock_verifyCalls() {
		
		// Given
		TodoServiceRepository tsr= mock(TodoServiceRepository.class);
		given(tsr.retrieveTodos("Rajasekhar")).willReturn(Arrays.asList("Spring boot","Spring mvc","Hibernate"));
		TodoBusinessImpl tbimpl = new TodoBusinessImpl(tsr);
		
		//when
		tbimpl.deleteTodosNottRelatedToSpring("Rajasekhar");
		
		//then
		verify(tsr, times(1)).deleteTodo("Hibernate");


	}
	
	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDDMock_arguementCaptures() {
		
		//Declare arguement captor
		//Define Arguement captor on sepcific method call
		ArgumentCaptor<String> stringArguementCaptor = ArgumentCaptor.forClass(String.class);
		
		// Given
		TodoServiceRepository tsr= mock(TodoServiceRepository.class);
		given(tsr.retrieveTodos("Rajasekhar")).willReturn(Arrays.asList("Spring boot","Spring mvc","Hibernate","Docker"));
		TodoBusinessImpl tbimpl = new TodoBusinessImpl(tsr);
		
		//when
		tbimpl.deleteTodosNottRelatedToSpring("Rajasekhar");
		
		//then
		verify(tsr,times(2)).deleteTodo(stringArguementCaptor.capture());
		assertThat(stringArguementCaptor.getAllValues().size(), is(2));


	}


}
