package com.collections;

/**
 * Created by mami01 on 20/03/14.
 */
class Dog {
    String color;

    Dog(String c) {
        color = c;
    }

    public boolean equals(Object o) {
        return ((Dog) o).color == this.color;
    }

    public int hashCode() {
        return color.length();
    }

    public String toString(){
        return color + " dog";
    }
}
