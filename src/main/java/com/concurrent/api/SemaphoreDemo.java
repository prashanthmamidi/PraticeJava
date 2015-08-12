package com.concurrent.api;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class SemaphoreDemo {

    public static void main(String[] args) {
        BoundedHasSet boundedHasSet = new BoundedHasSet(4);

        Thread addElement = new AddElement(boundedHasSet);
        addElement.start();

        Thread removeElement = new RemoveElement(boundedHasSet);
        removeElement.start();

    }

    private static class AddElement extends Thread {
        private BoundedHasSet boundedHasSet;

        public AddElement(BoundedHasSet boundedHasSet) {
            this.boundedHasSet = boundedHasSet;
        }

        @Override
        public void run() {
            IntStream.rangeClosed(1, 20)
                .forEach(i -> {
                    try {
                        System.out.println("Adding Element: " + i);
                        /*
                        While it is easy to construct a fixed-sized pool that fails if you request a resource from an empty pool,
                        what you really want is to block if the pool is empty and unblock when it becomes nonempty again.
                         */
                        System.out.println("Added Element: " + boundedHasSet.add(i));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                });
        }
    }

    private static class RemoveElement extends Thread {
        private BoundedHasSet boundedHasSet;

        public RemoveElement(BoundedHasSet boundedHasSet) {
            this.boundedHasSet = boundedHasSet;
        }

        @Override
        public void run() {
            IntStream.rangeClosed(1, 20).forEach(i -> {
                try {
                    System.out.println("Removing Element... " + i);
                    Thread.sleep(5000);
                    boundedHasSet.remove(i);
                    System.out.println("Removed Element = " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            });


        }
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
