package com.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void testListSize() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);
		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());
	}

	@Test
	public void testListSizeMultipleTimes() {
		// given
		List listMock = mock(List.class);
		given(listMock.size()).willReturn(2).willReturn(3).willReturn(5);

		// when
		int fistMockedSize = listMock.size();
		// then
		assertThat(fistMockedSize, is(2));

		// when
		int secondMockedSize = listMock.size();
		// then
		assertThat(secondMockedSize, is(3));
		// when
		int thirdMockedSize = listMock.size();
		// then
		assertThat(thirdMockedSize, is(5));
	}

	@Test
	public void testListGetMethod() {
		List listMock = mock(List.class);
		when(listMock.get(0)).thenReturn(2);
		assertEquals(2, listMock.get(0));
		assertEquals(null, listMock.get(1));
	}

	@Test
	public void testListGetMethodArguementMatchers() {
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenReturn(2);
		assertEquals(2, listMock.get(0));
		assertEquals(null, listMock.get(1));
	}

	@Test(expected = NullPointerException.class)
	public void testListGetMethodArguementMatchersThrowException() {
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenThrow(NullPointerException.class);
		listMock.get(3);
	}

}
