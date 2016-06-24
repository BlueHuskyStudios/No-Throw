package org.bh.tools.nothrow.text;

import static org.junit.Assert.*;

/**
 * Copyright BHStudios ©2016 BH-1-PS. Made for No Throw
 *
 * @author Ben Leggiero
 * @since 2016-06-20
 */
public class StringUtilsTest {
	@org.junit.Before
	public void setUp() throws Exception {

	}

	@org.junit.After
	public void tearDown() throws Exception {

	}

	@org.junit.Test
	public void subSequence() throws Exception {
		// Basic functionality
		assertEquals("Start sequence", "Hello", StringUtils.subSequence("Hello, world!", 0, 5));
		assertEquals("Middle sequence", "lo, wo", StringUtils.subSequence("Hello, world!", 3, 6));
		assertEquals("End sequence", "world!", StringUtils.subSequence("Hello, world!", 7, 6));
		assertEquals("Full sequence", "Hello, world!", StringUtils.subSequence("Hello, world!", 0, 13));
		assertEquals("Empty sequence", "", StringUtils.subSequence("Hello, world!", 6, 0));

		// Going out of bounds
		assertEquals("Start to just after end", "Ex terminis", StringUtils.subSequence("Ex terminis", 0, 12));
		assertEquals("Start to far after end", "Ex terminis", StringUtils.subSequence("Ex terminis", 0, 12000));
		assertEquals("Start to int max", "Ex terminis", StringUtils.subSequence("Ex terminis", 0, Integer.MAX_VALUE));
		assertEquals("Middle to just after end", "minis", StringUtils.subSequence("Ex terminis", 6, 6));
		assertEquals("Middle to far after end", "minis", StringUtils.subSequence("Ex terminis", 6, 6000));
		assertEquals("Middle to int max", "minis", StringUtils.subSequence("Ex terminis", 6, Integer.MAX_VALUE));
		assertEquals("Just before end to just after end", "s", StringUtils.subSequence("Ex terminis", 10, 1));
		assertEquals("Just before end to far after end", "s", StringUtils.subSequence("Ex terminis", 10, 1000));
		assertEquals("Just before end to int max", "s", StringUtils.subSequence("Ex terminis", 10, Integer.MAX_VALUE));
		assertEquals("Just after End to just after end", "", StringUtils.subSequence("Ex terminis", 11, -1));
		assertEquals("Just after End to far after end", "", StringUtils.subSequence("Ex terminis", 11, 12000));
		assertEquals("Just after End to int max", "", StringUtils.subSequence("Ex terminis", 11, Integer.MAX_VALUE));
		assertEquals("Far after End to just after end", "", StringUtils.subSequence("Ex terminis", 12000, -11989));
		assertEquals("Far after End to far after end", "", StringUtils.subSequence("Ex terminis", 12000, 12000000));
		assertEquals("Far after End to int max", "", StringUtils.subSequence("Ex terminis", 12000, Integer.MAX_VALUE));
		assertEquals("Int max to int max", "", StringUtils.subSequence("Ex terminis", Integer.MAX_VALUE, Integer.MAX_VALUE));

		// Going backwards
		assertEquals("Start sequence", "Hello", StringUtils.subSequence("Hello, world!", 4, -5));
		assertEquals("Middle sequence", "lo, wo", StringUtils.subSequence("Hello, world!", 8, -6));
		assertEquals("End sequence", "world!", StringUtils.subSequence("Hello, world!", 12, -6));
		assertEquals("Full sequence", "Hello, world!", StringUtils.subSequence("Hello, world!", 12, -13));
		assertEquals("Empty sequence", "", StringUtils.subSequence("Hello, world!", 6, -0));

		// Starting from end
		assertEquals("End sequence", "world!", StringUtils.subSequence("Hello, world!", -6, 6));
		assertEquals("Middle sequence", "lo, wo", StringUtils.subSequence("Hello, world!", -10, 6));
		assertEquals("Start sequence", "Hello", StringUtils.subSequence("Hello, world!", -13, 5));
		assertEquals("Full sequence", "Hello, world!", StringUtils.subSequence("Hello, world!", -13, 13));
		assertEquals("Empty sequence", "", StringUtils.subSequence("Hello, world!", -6, 0));

		// Going out of bounds backwards
		assertEquals("End to just before start", "Ex terminis", StringUtils.subSequence("Ex terminis", 11, -12));
		assertEquals("End to far before start", "Ex terminis", StringUtils.subSequence("Ex terminis", 11, -12000));
		assertEquals("End to int min", "Ex terminis", StringUtils.subSequence("Ex terminis", 11, Integer.MIN_VALUE));
		assertEquals("Middle to just before start", "Ex term", StringUtils.subSequence("Ex terminis", 6, -8));
		assertEquals("Middle to far before start", "Ex term", StringUtils.subSequence("Ex terminis", 6, -8000));
		assertEquals("Middle to int min", "Ex term", StringUtils.subSequence("Ex terminis", 6, Integer.MIN_VALUE));
		assertEquals("Start to just before start", "E", StringUtils.subSequence("Ex terminis", 0, -1));
		assertEquals("Start to far before start", "E", StringUtils.subSequence("Ex terminis", 0, -1000));
		assertEquals("Start to int min", "E", StringUtils.subSequence("Ex terminis", 0, Integer.MIN_VALUE));
		assertEquals("Just After End to just before start", "Ex terminis", StringUtils.subSequence("Ex terminis", 12, -14));
		assertEquals("Just After End to far before start", "Ex terminis", StringUtils.subSequence("Ex terminis", 12, -14000));
		assertEquals("Just After End to int min", "Ex terminis", StringUtils.subSequence("Ex terminis", 12, Integer.MIN_VALUE));
		assertEquals("Far After End to just before start", "Ex terminis", StringUtils.subSequence("Ex terminis", 12000, -12012));
		assertEquals("Far After End to far before start", "Ex terminis", StringUtils.subSequence("Ex terminis", 12000, -120000));
		assertEquals("Far After End to int min", "Ex terminis", StringUtils.subSequence("Ex terminis", 12000, Integer.MIN_VALUE));
		assertEquals("Int max to int min", "Ex terminis", StringUtils.subSequence("Ex terminis", Integer.MAX_VALUE, Integer.MIN_VALUE));

		// Starting from end, going backwards
		assertEquals("End sequence", "world!", StringUtils.subSequence("Hello, world!", -1, -6));
		assertEquals("Middle sequence", "lo, wo", StringUtils.subSequence("Hello, world!", -5, -6));
		assertEquals("Start sequence", "Hello", StringUtils.subSequence("Hello, world!", -9, -5));
		assertEquals("Full sequence", "Hello, world!", StringUtils.subSequence("Hello, world!", -1, -13));
		assertEquals("Empty sequence", "", StringUtils.subSequence("Hello, world!", -6, -0));

		// Starting from end, going out of bounds backwards
		assertEquals("End to just before start", "Ex terminis", StringUtils.subSequence("Ex terminis", -1, -12));
		assertEquals("End to far before start", "Ex terminis", StringUtils.subSequence("Ex terminis", -1, -12000));
		assertEquals("End to int min", "Ex terminis", StringUtils.subSequence("Ex terminis", -1, Integer.MIN_VALUE));
		assertEquals("Middle to just before start", "Ex ter", StringUtils.subSequence("Ex terminis", -6, -6));
		assertEquals("Middle to far before start", "Ex ter", StringUtils.subSequence("Ex terminis", -6, -4000));
		assertEquals("Middle to int min", "Ex ter", StringUtils.subSequence("Ex terminis", -6, Integer.MIN_VALUE));
		assertEquals("Start to just before start", "E", StringUtils.subSequence("Ex terminis", -11, -1));
		assertEquals("Start to far before start", "E", StringUtils.subSequence("Ex terminis", -11, -1000));
		assertEquals("Start to int min", "E", StringUtils.subSequence("Ex terminis", -11, Integer.MIN_VALUE));
		assertEquals("Just before start to just before start", "", StringUtils.subSequence("Ex terminis", -14, 2));
		assertEquals("Just before start to far before start", "", StringUtils.subSequence("Ex terminis", -12, -14000));
		assertEquals("Just before start to int min", "", StringUtils.subSequence("Ex terminis", -12, Integer.MIN_VALUE));
		assertEquals("Far before start to just before start", "", StringUtils.subSequence("Ex terminis", -12000, 11988));
		assertEquals("Far before start to far before start", "", StringUtils.subSequence("Ex terminis", -12000, -14000000));
		assertEquals("Far before start to int min", "", StringUtils.subSequence("Ex terminis", -12000, Integer.MIN_VALUE));
		assertEquals("Int min to int min", "", StringUtils.subSequence("Ex terminis", Integer.MIN_VALUE, Integer.MIN_VALUE));
	}
}
