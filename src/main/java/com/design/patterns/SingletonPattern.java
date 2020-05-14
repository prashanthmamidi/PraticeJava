package com.design.patterns;

import javax.inject.Singleton;
@Singleton
public class SingletonPattern {
    private SingletonPattern() {

    }

    public void print() {
        System.out.println("Singleton Pattern");
    }

    public static void main(String[] args) {
        SingletonPattern sp = new SingletonPattern();

        sp.print();
    }
}
