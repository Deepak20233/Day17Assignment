package com.java;
import java.util.*;
public class PrimeNumberRange {
	 public static void main(String[] args) {
	        int[][] primeRanges = new int[10][];
	        int rangeStart = 0;
	        int rangeEnd = 100;
	        for (int i = 0; i < 10; i++) {
	        	 primeRanges[i] = getPrimesInRange(rangeStart, rangeEnd);
	            rangeStart += 100;
	            rangeEnd += 100;
	        }
	        for (int i = 0; i < 10; i++) {
	            System.out.print("Range " + (i + 1) + " ("
	                    + ((i * 100) + 1) + "-" + ((i + 1) * 100) + "): ");
	            for (int j = 0; j < primeRanges[i].length; j++) {
	                System.out.print(primeRanges[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }

	    public static int[] getPrimesInRange(int rangeStart, int rangeEnd) {
	        List<Integer> primeList = new ArrayList<>();
	        for (int i = rangeStart; i < rangeEnd; i++) {
	            if (isPrime(i)) {
	                primeList.add(i);
	            }
	        }
	        int[] primes = new int[primeList.size()];
	        for (int i = 0; i < primeList.size(); i++) {
	            primes[i] = primeList.get(i);
	        }
	        return primes;
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
	}

