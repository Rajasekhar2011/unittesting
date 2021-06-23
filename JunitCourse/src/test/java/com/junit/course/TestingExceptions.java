package com.junit.course;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestingExceptions {

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void test_Exceptions() {
		int[] numbers  = {1,2,3,4};
		int fifthNumber =  numbers[4];
		System.out.println(fifthNumber);
	}

}
