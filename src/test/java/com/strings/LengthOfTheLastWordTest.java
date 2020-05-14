package com.strings;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;


public class LengthOfTheLastWordTest {

    private LengthOfTheLastWord lengthOfTheLastWord = new LengthOfTheLastWord();

    @Test
    public void lengthOfTheLastWord() {
        String input = "Start Coding    Here";
        int result = lengthOfTheLastWord.lengthOfTheLastWord(input);

        Assert.assertThat(result, Is.is(4));
    }
}
