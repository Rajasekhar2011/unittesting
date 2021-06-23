package com.mockito.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.mockito.repoistory.TodoServiceRepository;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplTestMockAnnotations {
	
	@Mock
	TodoServiceRepository tsr;
	
	@InjectMocks
	TodoBusinessImpl tbimpl;
	
	@Captor
	ArgumentCaptor<String> stringArguementCaptor;

	@Test
	public void testRetriveTodosRelatedToSpring() {
		given(tsr.retrieveTodos("rajasekhar")).willReturn(Arrays.asList("Spring boot","Spring mvc","hibernate"));
		
		List<String> filteredTodos = tbimpl.retrieveTodosRelatedToSpring("rajasekhar");
		
		assertThat(filteredTodos.size(),is(2) );
	}
	
	@Test
	public void testDeletsTodosArguementCapture() {
		given(tsr.retrieveTodos("rajasekhar")).willReturn(Arrays.asList("Spring boot","Spring mvc","hibernate"));
		
		tbimpl.deleteTodosNottRelatedToSpring("rajasekhar");
		verify(tsr, times(1)).deleteTodo(stringArguementCaptor.capture());
		
		assertThat(1, is(stringArguementCaptor.getAllValues().size()));
	}

}
