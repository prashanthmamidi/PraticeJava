package com.collections;

/**
 * Created by mami01 on 20/03/14.
 */
public class DogForTreeMap /* implements Comparable */{
    String color;
    int size;

    DogForTreeMap(String c, int s) {
        color = c;
        size = s;
    }

    public String toString(){
        return color + " dog";
    }

  /*  @Override
    public int compareTo(Object o) {
        return  o.size - this.size;
    }*/
}
