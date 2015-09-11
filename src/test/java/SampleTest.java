import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.IntStream.rangeClosed;

public class SampleTest {

    @BeforeClass
    public static void setUp() {
        System.out.println("In Setup = " + true);
    }

    @Test(expected = NullPointerException.class)
    public void expectNPE() {
        final String s = null;
        s.length();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testFinal() {
        final List<String> listString = new ArrayList<>(10);
        List<String> strings = Collections.unmodifiableList(listString);
        //listString = new ArrayList<>(11); // compile error
        rangeClosed(1, 11)
            .forEach(element -> strings.add("value = " + element));
        Assert.assertEquals(11, strings.size());
    }
}
