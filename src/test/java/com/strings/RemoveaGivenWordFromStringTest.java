package com.strings;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class RemoveaGivenWordFromStringTest {

    private RemoveaGivenWordFromString obj = new RemoveaGivenWordFromString();

    @Test
    public void removeAWord() {
        String input = "this is pandemic";
        Assert.assertThat(obj.removeWord(input, "is"), Is.is("this pandemic"));
    }
}
