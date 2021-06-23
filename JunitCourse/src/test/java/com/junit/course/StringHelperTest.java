package com.junit.course;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringHelperTest {
	StringHelper sh = new StringHelper();

	@Test
	public void testTruncateAInFirstTwoPositions_AInFirstTwo() {
		assertEquals("", sh.truncateAInFirstTwoPositions("AA"));
		assertEquals("CD", sh.truncateAInFirstTwoPositions("AACD"));
	}

	@Test
	public void testTruncateAInFirstTwoPositions_AInFirstOne() {
		assertEquals("CD", sh.truncateAInFirstTwoPositions("ACD"));
	}

	@Test
	public void testAreFirstAndLastTwoCharsSame_lengthTwo() {
		assertTrue(sh.areFirstAndLastTwoCharactersTheSame("AB"));
	}

	@Test
	public void testAreFirstAndLastTwoCharsSame_lengthOne() {
		assertFalse(sh.areFirstAndLastTwoCharactersTheSame("A"));
	}

	@Test
	public void testAreFirstAndLastTwoCharsSame_lengthGreaterThantwo() {
		assertTrue(sh.areFirstAndLastTwoCharactersTheSame("malayma"));
	}

	@Test
	public void testAreFirstAndLastTwoCharsSame_lengthGreaterThantwo_negative() {
		assertFalse(sh.areFirstAndLastTwoCharactersTheSame("malayam"));
	}

}
