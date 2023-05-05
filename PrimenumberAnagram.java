package com.java;
import java.util.*;
public class PrimenumberAnagram {
	public static void main(String[] args) {
        int[][] anagramRanges = new int[10][];
        int[][] nonAnagramRanges = new int[10][];
        int rangeStart = 0;
        int rangeEnd = 100;
        for (int i = 0; i < 10; i++) {
            List<Integer> primes = getPrimesInRange(rangeStart, rangeEnd);
            List<Integer> anagrams = getAnagrams(primes);
            List<Integer> nonAnagrams = new ArrayList<>(primes);
            nonAnagrams.removeAll(anagrams);
            anagramRanges[i] = convertListToArray(anagrams);
            nonAnagramRanges[i] = convertListToArray(nonAnagrams);
            rangeStart += 100;
            rangeEnd += 100;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Range " + (i + 1) + " ("
                    + ((i * 100) + 1) + "-" + ((i + 1) * 100) + "):");
            System.out.print("Anagrams: ");
            for (int j = 0; j < anagramRanges[i].length; j++) {
                System.out.print(anagramRanges[i][j] + " ");
            }
            System.out.println();
            System.out.print("Non-Anagrams: ");
            for (int j = 0; j < nonAnagramRanges[i].length; j++) {
                System.out.print(nonAnagramRanges[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

    public static List<Integer> getPrimesInRange(int rangeStart, int rangeEnd) {
        List<Integer> primes = new ArrayList<>();
        for (int i = rangeStart; i < rangeEnd; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
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

    public static List<Integer> getAnagrams(List<Integer> numbers) {
        List<Integer> anagrams = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (areAnagrams(numbers.get(i), numbers.get(j))) {
                    anagrams.add(numbers.get(i));
                    anagrams.add(numbers.get(j));
                }
            }
        }
        return anagrams;
    }

    public static boolean areAnagrams(int n1, int n2) {
        char[] arr1 = String.valueOf(n1).toCharArray();
        char[] arr2 = String.valueOf(n2).toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public static int[] convertListToArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
}
}