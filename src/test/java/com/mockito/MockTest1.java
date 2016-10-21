package com.mockito;

import com.sun.org.apache.xpath.internal.operations.String;
import com.test.mockito.Service;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by pupsprashu on 28/02/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class MockTest1 {
    @Mock
    private Service service;

    @Test
    public void test_stubbing_consecutive_calls() throws Exception {
        when(service.someMethod()).thenReturn("first", "second", "third");

        assertThat(service.someMethod(), is("first"));
        assertThat(service.someMethod(), is("second"));
        assertThat(service.someMethod(), is("third"));

    }

    @Test
    public void test_stubbing_with_callbacks() throws Exception {
        when(service.someMethod(anyString())).thenAnswer(new Answer() {
            public Object answer(InvocationOnMock invocation) {
                Object[] args = invocation.getArguments();
                Object mock = invocation.getMock();
                return "called with arguments: " + args;
            }
        });

        java.lang.String foo = service.someMethod("foo");
        System.out.println(foo);

    }
}
