package com.junit.course;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedTests {
		
	private String input;
	private String expectedOutput;
	
	public ParameterizedTests(String input, String expectedOutput) {
		this.input = input;
		this.expectedOutput = expectedOutput;
	}

	StringHelper sh = new StringHelper();
	
	@Parameters
	public static Collection<String[]> testConditions(){
		String expectedOutputs[][] = {{"AACD","CD"},{"ACD","CD"},{"AA",""},{"CDFR","CDFR"}};
		return  Arrays.asList(expectedOutputs);
	}
	

	@Test
	public void testTruncateAInFirstTwoPositions() {
		assertEquals(expectedOutput, sh.truncateAInFirstTwoPositions(input));
	}

}
