package com.junit.course;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TestingPerformance {

	@Test(timeout = 10)
	public void test_perfomance() {
		int[] numbers = {12,76,4};
		for(int i=0;i<1000000;i++) {
			numbers[0]=i;
			Arrays.sort(numbers);
		}
		/*
		 * int[] expectedArray = {4,76,999999}; Arrays.sort(numbers);
		 */
		
	}

}
