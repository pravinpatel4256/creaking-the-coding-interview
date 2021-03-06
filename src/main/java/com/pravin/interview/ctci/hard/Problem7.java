package com.pravin.interview.ctci.hard;

import sun.text.normalizer.CharTrie;
import sun.text.normalizer.Trie;

import java.util.PriorityQueue;

public class Problem7 {
    public static int count2sInRangeAtDigit(int number, int d) {
        int powerOf10 = (int) Math.pow(10, d);
        int nextPowerOf10 = powerOf10 * 10;
        int right = number % powerOf10;

        int roundDown = number - number % nextPowerOf10;
        int roundUp = roundDown + nextPowerOf10;

        int digit = (number / powerOf10) % 10;
        if (digit < 2) { // if the digit in spot digit is
            return roundDown / 10;
        } else if (digit == 2) {
            return roundDown / 10 + right + 1;
        } else {
            return roundUp / 10;
        }
    }

    public static int count2sInRange(int number) {
        int count = 0;
        int len = String.valueOf(number).length();
        for (int digit = 0; digit < len; digit++) {
            count += count2sInRangeAtDigit(number, digit);
        }
        return count;
    }

    public static int count2sR(int n) {
        /* Alternate, messier, solution */

        // Example: n = 513

        // Base case
        if (n == 0) {
            return 0;
        }

        // Split apart 513 into 5 * 100 + 13.
        // [Power = 100; First = 5; Remainder = 13]
        int power = 1;
        while (10 * power < n) {
            power *= 10;
        }
        int first = n / power;
        int remainder = n % power;

        // Counts 2s from first digit
        int nTwosFirst = 0;
        if (first > 2) {
            nTwosFirst += power;
        } else if (first == 2) {
            nTwosFirst += remainder + 1;
        }

        // Count 2s from all other digits
        int nTwosOther = first * count2sR(power - 1) + count2sR(remainder);

        return nTwosFirst + nTwosOther;
    }

    public static int numberOf2s(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 10 == 2) {
                System.out.println(n);
                count++;
            }
            n = n / 10;
        }
        return count;
    }

    public static int numberOf2sInRange(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) { // Might as well start at 2
            count += numberOf2s(i);
        }
        return count;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int v1 = count2sR(i);
            int v2 = count2sInRange(i);
            System.out.println("Between 0 and " + i + ": " + v1 + " " + v2);
        }

        int v1 = count2sR(37);
      //  System.out.println(v1);

        v1 = numberOf2sInRange(23);

        System.out.println("-----");
        System.out.println(v1);

        PriorityQueue<Integer> heap  = new PriorityQueue<>(10, null);
    }

}
