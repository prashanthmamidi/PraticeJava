package com.functional.interfaces;

/**
 * Created by pupsprashu on 05/03/2016.
 */
@FunctionalInterface
public interface TriFunction<T, U, V, R> {

    R apply(T t, U u , V v);
}
