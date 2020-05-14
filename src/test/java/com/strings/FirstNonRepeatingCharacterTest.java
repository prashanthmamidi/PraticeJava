package com.strings;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class FirstNonRepeatingCharacterTest {

    private FirstNonRepeatingCharacter obj = new FirstNonRepeatingCharacter();

    @Test
    public void firstNonRepeatingCharacter() {

        Assert.assertThat(obj.firstNonRepeatingCharacter("gibblegabbler"), Is.is('i'));
        Assert.assertThat(obj.firstNonRepeatingCharacterOld("gibblegabbler"), Is.is('i'));

        Assert.assertThat(obj.firstNonRepeatingCharacter("GeeksForGeeks"), Is.is('F'));
        Assert.assertThat(obj.firstNonRepeatingCharacterOld("GeeksForGeeks"), Is.is('F'));

    }
}
