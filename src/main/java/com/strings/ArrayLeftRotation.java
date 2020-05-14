package com.strings;

public class ArrayLeftRotation {
//https://stackoverflow.com/questions/31128751/how-can-we-rotate-an-array-to-the-left

    public static void main(String[] args) {
        int[] array = {33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60, 87, 97};
        int d = 13;  // 87 97 33 47 70 37 8 53 13 93 71 72 51 100 60
        int[] output = leftRotation(array, d);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
        }
        System.out.println();
        int[] array1 = {2, 3, 4, 5, 6, 7, 8};
        int d1 = 4; // {6, 7, 8, 2, 3, 4, 5}
        int[] output1 = leftRotation(array1, d1);
        for (int i = 0; i < output1.length; i++) {
            System.out.print(output1[i] + " ");
        }
        System.out.println("\nRight Rotation...");
        int[] array2 = {2, 3, 4, 5, 6, 7, 8};
        int[] output2 = rightRotation(array2, d1);
        for (int i = 0; i < output2.length; i++) {
            System.out.print(output2[i] + " ");
        }
    }

    static int[] leftRotation(int[] a, int d) {
        int len = a.length;
        int[] output = new int[len];
        for (int i = 0; i < len; i++) {
            output[(i + len - d) % len ] = a[i];
        }
        return output;
    }

    static int[] rightRotation(int[] a, int d) {
        int len = a.length;
        int[] output = new int[len];
        for (int i=0; i < len; i++) {
            output[(i+d) % len] = a[i];
        }
        return output;
    }
}
