package com.strings;

public class Fibonaccii {

    public static void main(String[] args) {
        if (Fibonaccii.isFibonacci(5l, 0l, 1l)) {
            System.out.println("IsFibo");
        } else {
            System.out.println("IsNotFibo");
        }

        usingForLoopSeries();

    }

    static int returnNthNumber(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return returnNthNumber(n - 1) + returnNthNumber(n - 2);
    }

    static boolean isFibonacci(long N) {
        if (N == 0 || N == 1) {
            return true;
        }

        long prev = 0;
        long curr = 1;
        while (curr < N) {
            long next = prev + curr;

            prev = curr;
            curr = next;
        }
        return curr == N;
    }

    static boolean isFibonacci(long N, long prev, long curr) {
        if (N == 0 || N == 1) {
            return true;
        }
        while (curr < N) {
            long next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr == N;
    }

    public static void usingForLoopSeries() {
        int n = 10, prev = 0, curr = 1;
        System.out.print("First " + n + " terms: ");

        for (int i = 1; i <= n; ++i)
        {
            System.out.print(prev + " ");

            int next = prev + curr;
            prev = curr;
            curr = next;
        }
    }
}
