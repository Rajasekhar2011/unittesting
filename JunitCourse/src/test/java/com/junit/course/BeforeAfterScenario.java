package com.junit.course;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BeforeAfterScenario {
	
	@BeforeClass
	public static void setUpBeforeAllTests() {
		System.out.println("Before all Tests");
	}

	@Before
	public void setupBeforeEachTest() {
		System.out.println("Before each test");
	}

	@Test
	public void test1() {
		System.out.println("Test1 executed");
	}

	@Test
	public void test2() {
		System.out.println("Test2 executed");
	}

	@After
	public void cleanUpAfterEachTest() {
		System.out.println("After each test");
	}
	

	@AfterClass
	public static void cleanUpAfterAllTests() {
		System.out.println("After all Tests");
	}

}
