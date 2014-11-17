package com.test;

/**
 * Created by mami01 on 28/02/14.
 */
public class UpperClass {
    private int a = 5;
    public  int b = 10;
    public void test() {
         final int c = 15;
        new Runnable() {
             static final int x = 3;  // OK: compile-time constant
          //  static int y = 4;  // Compile-time error: an inner class
            @Override
            public void run() {
                System.out.println(a);
                System.out.println(b);
                System.out.println(c);
            }
        };
    }
}
