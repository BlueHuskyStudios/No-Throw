package org.bh.tools.nothrow.math;

/**
 * Copyright BHStudios ©2016 BH-1-PS. Made for No Throw.
 *
 * Utilities that convert numbers into other numbers.
 *
 * @author Ben Leggiero
 * @since 2016-06-20
 */
public class NumberConversion {
    /**
     * If the given number {@code n} is larger than {@link Integer#MAX_VALUE}, then {@link Integer#MAX_VALUE} is
     * returned. If it's less than {@link Integer#MIN_VALUE}, then {@link Integer#MIN_VALUE} is returned. Otherwise,
     * the same value is returned.
     *
     * @param n The number
     * @return {@code n} converted to an int, without overflow.
     */
    public static int clampLongToInt(long n) {
        if (Integer.MAX_VALUE < n) {
            return Integer.MAX_VALUE;
        } else if (Integer.MIN_VALUE > n) {
            return Integer.MIN_VALUE;
        }
        return (int) n;
    }
}
