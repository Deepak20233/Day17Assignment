package com.java;
import java.util.*;

public class SimpleBalancedParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string of simple balanced parentheses:");
        String inputString = sc.nextLine();
        boolean isBalanced = checkBalanced(inputString);
        if (isBalanced) {
            System.out.println(inputString + " is a valid string of simple balanced parentheses.");
        } else {
            System.out.println(inputString + " is not a valid string of simple balanced parentheses.");
        }
    }

    public static boolean checkBalanced(String inputString) {
        Stack<Character> stack = new Stack<>();
        for (char c : inputString.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
