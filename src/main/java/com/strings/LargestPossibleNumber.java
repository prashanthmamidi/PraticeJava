package com.strings;

import java.util.Arrays;
import java.util.Comparator;

public class LargestPossibleNumber implements Comparator<Integer> {
    public String largestPossibleNumber(Integer[] nums) {
        Arrays.sort(nums, Comparator.comparing(Object::toString, (x, y) -> (y + x).compareTo(x + y)));

        StringBuilder sb = new StringBuilder("");
        for (Integer num : nums) {
            sb.append(num);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        LargestPossibleNumber ls = new LargestPossibleNumber();
        Integer[] nums = {54, 546, 548, 60};
        Arrays.sort(nums, ls);

       StringBuilder sb = new StringBuilder("");
        for (Integer num : nums) {
            sb.append(num);
        }

        System.out.println(sb);
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        String s1 = o1.toString();
        String s2 = o2.toString();
        return (s2+s1).compareTo(s1+s2);
    }
}
