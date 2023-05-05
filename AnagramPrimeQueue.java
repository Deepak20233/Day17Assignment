package com.java;

import java.util.*;

public class AnagramPrimeQueue {
    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 2; i < 1000; i++) {
            if (isPrime(i)) {
                for (int j = i + 1; j < 1000; j++) {
                    if (isPrime(j) && areAnagrams(i, j)) {
                        queue.add(i);
                        queue.add(j);
                    }
                }
            }
        }
        System.out.println("Anagram prime numbers:");
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean areAnagrams(int n1, int n2) {
        char[] digits1 = String.valueOf(n1).toCharArray();
        char[] digits2 = String.valueOf(n2).toCharArray();
        Arrays.sort(digits1);
        Arrays.sort(digits2);
        return Arrays.equals(digits1, digits2);
    }
}