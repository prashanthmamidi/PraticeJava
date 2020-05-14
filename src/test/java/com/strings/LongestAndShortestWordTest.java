package com.strings;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LongestAndShortestWordTest {

    @Rule
    public ExpectedException exception = ExpectedException.none() ;

    private LongestAndShortestWord obj = new LongestAndShortestWord();
    @Test
    public void getLongestWord_for_a_given_sentence() {
        String input = "The cow jumped over the moon";
        Object[] result = obj.getLongestWord(input);

        assertEquals(2, result.length);
        assertThat(result[0], is("jumped"));
        assertThat(result[1], is(6));
    }

    @Test
    public void getLongestWord_for_a_given_sentence_has_Empty_Space() {
        String input = " ";
        Object[] result = obj.getLongestWord(input);

        assertEquals(2, result.length);
        assertThat(result[0], is(""));
        assertThat(result[1], is(0));
    }

    @Test
    public void getLongestWord_throwException_for_a_given_invalid_sentence() {
        exception.expect(InvalidInputException.class);
        String input = null;
        obj.getLongestWord(input);
    }

    @Test
    public void getShortestWord_for_a_given_sentence() {
        String input = "The cow jumped over the moon";
        Object[] result = obj.getShortestWord(input);

        assertEquals(2, result.length);
        assertThat(result[0], is("The"));
        assertThat(result[1], is(3));
    }

    @Test
    public void getShortestWord_for_a_given_sentence_has_Empty_Space() {
        String input = " ";
        Object[] result = obj.getShortestWord(input);

        assertEquals(2, result.length);
        assertThat(result[0], is(""));
        assertThat(result[1], is(0));
    }
}
