package com.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mamidi on 17/07/2015.
 */
public class GenericWildCards {

    public static void main(String[] args) {
        List<A> listA = new ArrayList<A>();
        List<B> listB = new ArrayList<B>();
        List<C> listC = new ArrayList<C>();

        listA.add(new A());
        listA.add(new B());
        listA.add(new C());


     //   listB = listA; // Error - List A may other types[it's subclasses as well]
        /*
        to solve this, we use Generic Wildcard operator
        1. Read from a generic collection
        2. Inserting into a generic collection
         */


     List<?> listUnknown = new ArrayList<A>();
        processElements(listUnknown);



     List<? extends A> listUnknownExtends = new ArrayList<A>();

        System.out.println("printing elements of listA : ");
        processElementsExtends(listA);

        System.out.println("printing elements of listB : ");
        processElementsExtends(listB);

        System.out.println("printing elements of listC : ");
        processElementsExtends(listC);



     List<? super A> listUnknownSuper = new ArrayList<A>();

        insertElementsSuper(new ArrayList<A>());
        insertElementsSuper(new ArrayList<Object>());
        insertElementsSuper(listA);
    }

    public static void processElements(List<?> elements) {
        for (Object element : elements)
            System.out.println(element);
    }

    public static void processElementsExtends(List<? extends A> elements) {
        // means a List of objects that are instances of Class A, or subclasses of A [e.g., B, C]
        for (A element : elements)
            System.out.println(element);
    }

    public static void insertElementsSuper(List<? super A> elements) {
        // means the list is typed to either A, or superclass of A
      elements.add(new A());
      elements.add(new A());
      elements.add(new B());
      elements.add(new C());

        //all the elements inserted here are either A instances, or instances of A's superclass.
        //Since both B and C extend A, If A had a superclass, B and C would also be instances of that superclass.

    }


}
