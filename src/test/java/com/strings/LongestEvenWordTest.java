package com.strings;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class LongestEvenWordTest {

    LongestEvenWord obj = new LongestEvenWord();

    @Test
    public void longestEvenWord() {
        String result = obj.longestEvenWord("hello how do you will climb mount everest");

        Assert.assertThat(result, Is.is("will"));
    }
}
