package com.matchers;

import org.hamcrest.*;
import org.junit.Assert;
import org.junit.Test;

public class FooTest {

    @Test
    public void numberIs42() throws Exception {
        final Foo foo = new Foo();

        Assert.assertThat(
            foo,
            hasNumberUsingFeature(Matchers.equalTo(42))
        );

    }

    private Matcher<? super Foo> hasNumberUsingFeature(Matcher<Integer> i) {
        return new FeatureMatcher<Foo, Integer>(i, "number", "number") {
            @Override
            protected Integer featureValueOf(Foo actual) {
                return actual.getNumber();
            }
        };
    }

    private Matcher<? super Foo> hasNumberUsingType(int i) {
        return new TypeSafeMatcher<Foo>() {
            @Override
            protected boolean matchesSafely(Foo item) {
                return i == item.getNumber();
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("get number should return ").appendValue(i);
            }
        };
    }

    private Matcher<? super Foo> hasNumber(final int i) {
        return new BaseMatcher<Foo>() {
            @Override
            public boolean matches(Object item) {
                final Foo foo = (Foo) item;
                return i == foo.getNumber();
            }
            @Override
            public void describeTo(Description description) {
                description.appendText("get number should return ").appendValue(i);
            }
        };
    }
}