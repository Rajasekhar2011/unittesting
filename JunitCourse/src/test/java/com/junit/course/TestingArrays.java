package com.junit.course;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TestingArrays {

	@Test
	public void testArraysSort() {
		int[] numbers = {12,3,14,1};
		int[] expectedArray = {1,3,12,14};
		Arrays.sort(numbers);
		
		assertArrayEquals(expectedArray, numbers);
	}

}
