package com.mkyong.common.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mami01 on 20/02/14.
 */
public class Test {

    public void setVal(Object val) {
        System.out.println("In Object..");
    }

    public void setVal(String val) {
        System.out.println("In String..");
    }
/*    public void setVal(Integer val) {
        System.out.println("In Integer..");
    }*/
    public static void main(String[] args) {
        Test test = new Test();
       test.setVal(null);
       Map<String,String> map = new HashMap<String,String>();



    }
}
