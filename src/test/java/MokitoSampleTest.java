import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;


import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * Created by mami01 on 07/04/14.
 *
 * http://docs.mockito.googlecode.com/hg/latest/org/mockito/Mockito.html
 */
@RunWith(MockitoJUnitRunner.class)
public class MokitoSampleTest {

    @Mock
    List mockedList1; // mock creation with annotation- need to use @RunWith

    @Test
    public void testVerifySomeBehaviour() {

        //mock creation
        List mockedList = mock(List.class);

        // using mock object
        mockedList.add("one");
        mockedList.clear();

        mockedList1.add("one1");
        mockedList1.clear();

        //verification
        verify(mockedList).add("one");
        verify(mockedList).clear();

        verify(mockedList1).add("one1");
        verify(mockedList1).clear();

    }

    @Test
    public void testSomeStubbing() {
        //You can mock concrete classes, not only interfaces
        LinkedList mockedList = mock(LinkedList.class);

        //stubbing
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        //following prints "first"
        System.out.println(mockedList.get(0));

        //following prints "null" because get(999) was not stubbed
        System.out.println(mockedList.get(999));

        //following throws runtime exception
/*        System.out.println(mockedList.get(1));
        verify(mockedList).get(0);*/
    }

    @Test
    public void testArgumentMatchers() {

        //stubbing using built-in anyInt() argument matcher
        when(mockedList1.get(anyInt())).thenReturn("element");

        //stubbing using hamcrest (let's say isValid() returns your own hamcrest matcher)://
       // when(mockedList1.contains(argThat(isValid()))).thenReturn("element");

        //following prints "element"
        System.out.println(mockedList1.get(999));
        //you can also verify using an argument matcher
        verify(mockedList1).get(anyInt());
    }

    @Test
    public void verifyExactNumberOfInvocations() {
        mockedList1.add("once");
        mockedList1.add("twice"); mockedList1.add("twice");
        mockedList1.add("three times"); mockedList1.add("three times"); mockedList1.add("three times");
      //following two verifications work exactly the same - times(1) is used by default
        verify(mockedList1).add("once");
        verify(mockedList1, times(1)).add("once");

        //exact number of invocations verification
        verify(mockedList1, times(2)).add("twice");
        verify(mockedList1, times(3)).add("three times");

        //verification using never(). never() is an alias to times(0)
        verify(mockedList1, never()).add("never happened");

        //verification using atLeast()/atMost()
        verify(mockedList1, atLeastOnce()).add("three times");
        verify(mockedList1, atLeast(2)).add("three times"); // min number of invocations
        verify(mockedList1, atMost(7)).add("three times1"); // max number of invocations

    }

    @Test
    public void testStubbingVoidMethods() {
        doThrow(new RuntimeException()).when(mockedList1).clear();
        //following throws RuntimeException:
       // mockedList1.clear();
        /*
        Initially, stubVoid(Object) was used for stubbing voids. Currently stubVoid() is deprecated in favor of doThrow(Throwable). This is because of improved readability and consistency with the family of doAnswer(Answer) methods.
         */
    }

    @Test
    public void testVerificationInOrder() {

    }





}

