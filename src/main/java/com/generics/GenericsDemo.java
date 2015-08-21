package com.generics;

//http://www.javacodegeeks.com/2011/04/java-generics-quick-tutorial.html

import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {

    public static void main(String[] args) {

        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple());
        apples.add((Apple) new Fruit());
        List<? extends Fruit> fruits = apples;

/*
        Narrowing a reference (covariance) ? extends
? extends reintroduces covariant subtyping for generics types: Apple is a subtype of Fruit and List<Apple> is a subtype of List<? extends Fruit>.
 */
        // fruits.add(new Strawberry()); // the code won’t compile!
        //fruits.add(new Fruit()); // the code won’t compile!
        //fruits.add(new Apple());



//Widening a reference (contravariance) ? super
        List<Fruit> fruitList = new ArrayList<>();
        fruitList.add(new Apple());
        fruitList.add(new Strawberry());

        List<? super Apple> appleList = fruitList;
        appleList.add(new Apple());

        appleList.forEach(
            item -> System.out.println("item = " + item)
        );

    }
}




class Fruit {

    }

class Apple extends Fruit {

}
class Strawberry extends Fruit {

}
