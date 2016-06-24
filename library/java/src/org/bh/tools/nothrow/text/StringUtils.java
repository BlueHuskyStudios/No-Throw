package org.bh.tools.nothrow.text;

import static org.bh.tools.nothrow.math.NumberConversion.clampLongToInt;

/**
 * Copyright BHStudios ©2016 BH-1-PS. Made for No Throw.
 *
 * Utilities for handling strings.
 *
 * @author Ben Leggiero
 * @since 2016-06-19
 */
@SuppressWarnings("WeakerAccess")
public class StringUtils {
    /**
     * Returns a subsequence of the given character sequence.
     *
     * @param fullSequence The full-length sequence. If this is {@code null}, all logic is skipped and {@code null} is
     *                     returned.
     * @param anchor       The index of first character to get (or the last if {@code maxLength} is negative). If this
     *                     is negative, it is measured from the end, so {@code -1} is the last character ({@code length
     *                     - 1}), {@code -2} is {@code length - 2}, etc. (Note that this is character position, not
     *                     index). If this is positive and larger than the length of {@code fullSequence}, it is
     *                     clamped to {@code length - 1}. If it is negative and larger than the negated length, it is
     *                     clamped to {@code 0}.
     * @param maxLength    The maximum length of the resulting character sequence. If this is {@code 0}, all logic in
     *                     this method is skipped, and the empty string is returned. If it is negative, {@code anchor}
     *                     is treated as an end. If it is positive and would overflow the string's length, all
     *                     characters after {@code anchor}, inclusive, are returned. If it is negative and would
     *                     overflow, all characters before {@code anchor}, inclusive, are returned.
     * @return The subsequence of the given full sequence, as defined by the given anchor and maximum length.
     */
    public static CharSequence subSequence(CharSequence fullSequence, int anchor, int maxLength) {
        // Get the easy shortcuts out of the way

        if (null == fullSequence) {
            return null;
        }
        final int fullSequenceLength = fullSequence.length();
        if (0 == maxLength || 0 == fullSequenceLength) {
            return "";
        }

        // Find the index of the anchor character

        long anchorIndex;
        int actualStart, actualEnd;
        if (anchor >= 0) {
            anchorIndex = clampLongToInt(anchor);
        } else {
            anchorIndex = clampLongToInt(fullSequenceLength + anchor);
        }

        if (maxLength >= 0) {
            actualEnd = clampLongToInt(anchorIndex + (long)maxLength);
            actualStart = clampLongToInt(anchorIndex);
        } else {
            actualEnd = clampLongToInt(anchorIndex + 1L); // +1 because end is exclusive
            actualStart = clampLongToInt(anchorIndex + (long)maxLength + 1L);
        }

        if (actualEnd > fullSequenceLength) {
            actualEnd = fullSequenceLength;
        } else if (actualEnd < 0) {
            actualEnd = 0;
        }
        if (actualStart > fullSequenceLength) {
            actualStart = fullSequenceLength;
        } else if (actualStart < 0) {
            actualStart = 0;
        }

        return fullSequence.subSequence(actualStart, actualEnd);
    }
}
