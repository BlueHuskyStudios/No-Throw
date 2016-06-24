package org.bh.tools.nothrow.math;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.bh.tools.nothrow.math.NumberConversion.clampLongToInt;
import static org.junit.Assert.assertEquals;

/**
 * Copyright BHStudios ©2016 BH-1-PS. Made for No Throw.
 *
 * Tests for {@link NumberConversion}
 *
 * @author Ben Leggiero
 * @since 2016-06-20
 */
public class NumberConversionTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testClampLongToInt() throws Exception {
        assertEquals("Zero test", 0, clampLongToInt(0));
        assertEquals("Small positive", 100, clampLongToInt(100));
        assertEquals("Small negative", -100, clampLongToInt(-100));
        assertEquals("Large positive", 100_000, clampLongToInt(100_000));
        assertEquals("Large negative", -100_000, clampLongToInt(-100_000));
        assertEquals("Huge positive", Integer.MAX_VALUE, clampLongToInt(100_000_000_000L));
        assertEquals("Huge negative", Integer.MIN_VALUE, clampLongToInt(-100_000_000_000L));
    }
}
