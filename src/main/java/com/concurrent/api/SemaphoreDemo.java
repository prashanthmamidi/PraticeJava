package com.concurrent.api;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class SemaphoreDemo {

    public static void main(String[] args) {
        BoundedHasSet boundedHasSet = new BoundedHasSet(4);
        IntStream.rangeClosed(1, 20)
            .forEach(i -> {
                try {
                    System.out.println(boundedHasSet.add(i));
                    boundedHasSet.remove(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

    }
}
/*
The semaphore is initialized to the desired maximum size of the collection.
The add operation acquires a permit before adding the item into the underlying collection.
If the underlying add operation does not actually add anything, it releases the permit immediately.
Similarly, a successful remove operation releases a permit, enabling more elements to be added.
The underlying Set implementation knows nothing about the bound; this is handled by BoundedHashSet .
 */
class BoundedHasSet<T> {
    private final Set set;
    private final Semaphore semaphore;

    public BoundedHasSet(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<T>());
        this.semaphore = new Semaphore(bound);
    }

    public boolean add(T o) throws InterruptedException {
        semaphore.acquire();
        boolean wasAdded = false;
        try {
            wasAdded = set.add(o);
            return wasAdded;
        } finally {
            if (!wasAdded)
                semaphore.release();
        }
    }

    public boolean remove(T o) throws InterruptedException {
        boolean wasRemoved = set.remove(o);
        if (wasRemoved)
            semaphore.release();
        return wasRemoved;
    }

}
