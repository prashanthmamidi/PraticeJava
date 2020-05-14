package com.strings;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class LargestPossibleNumberTest {
    private LargestPossibleNumber obj = new LargestPossibleNumber();

    @Test
    public void largestPossibleNumber() {

        String result = obj.largestPossibleNumber(new Integer[] {9, 1, 95, 17, 5});

        Assert.assertThat(result, Is.is("9955171"));

    }
}
