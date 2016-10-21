package com.mockito;

import org.hamcrest.CoreMatchers;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.*;

/**
 * Created by pupsprashu on 28/02/2016.
 */
public class MockTest {

    @Test
    public void test_verify_some_behaviour() throws Exception {
        //mock creation
        List mockedList = Mockito.mock(List.class);

        //using mock object
        mockedList.add("ele");
        mockedList.clear();

        //verification
        Mockito.verify(mockedList).add("ele");
        Mockito.verify(mockedList).clear();
    }

    @Test
    public void test_How_about_some_stubbing() throws Exception {
        //You can mock concrete classes, not only interfaces
        LinkedList linkedList = Mockito.mock(LinkedList.class);

        //stubbing
        when(linkedList.get(0)).thenReturn("first");
        when(linkedList.get(1)).thenThrow(new RuntimeException());

        assertThat(linkedList.get(0), is("first"));
        try {
            linkedList.get(1);
        } catch (Exception ex) {
            assertTrue(ex instanceof RuntimeException);
        }
    }

    @Test
    public void test_Argument_Matchers() throws Exception {
        LinkedList linkedList = Mockito.mock(LinkedList.class);

        //stubbing using built-in anyInt() argument matcher
        when(linkedList.get(anyInt())).thenReturn("any element");

        assertThat(linkedList.get(10), is("any element"));
        //you can also verify using an argument matcher
        verify(linkedList).get(anyInt());
    }

    @Test
    public void test_verifying_exact_number_of_invocations_at_least_x_or_never() throws Exception {
        LinkedList mockedList = Mockito.mock(LinkedList.class);

        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        verify(mockedList).add("once"); // times(1) is used by default
        verify(mockedList, times(1)).add("once");

        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        verify(mockedList, never()).add("never"); // never() is an alias to times(0)

        //verification using atLeast()/atMost()
        verify(mockedList, atLeastOnce()).add("twice");
        verify(mockedList, atLeast(2)).add("twice");
        verify(mockedList, atMost(2)).add("twice");
    }

    @Test
    public void test_stubbing_void_methods_with_exceptions() throws Exception {
        LinkedList mockedList = Mockito.mock(LinkedList.class);

        doThrow(new RuntimeException()).when(mockedList).clear();

        try {
            mockedList.clear();
        } catch (Exception ex) {
            assertTrue(ex instanceof RuntimeException);
        }
    }

    @Test
    public void test_making_sure_interactions_never_happened_on_mock() throws Exception {
        LinkedList mockedList = Mockito.mock(LinkedList.class);
        LinkedList mockedList1 = Mockito.mock(LinkedList.class);
        LinkedList mockedList2 = Mockito.mock(LinkedList.class);
        mockedList.add("one");

        verify(mockedList).add("one");
        verify(mockedList, never()).add("two");

        verifyZeroInteractions(mockedList1, mockedList2);
    }

    @Test
    public void test_finding_redundant_invocations() throws Exception {
        LinkedList mockedList = Mockito.mock(LinkedList.class);

        mockedList.add("one");
        mockedList.add("two");

        verify(mockedList).add("one");

        verifyNoMoreInteractions(mockedList);
    }

}
