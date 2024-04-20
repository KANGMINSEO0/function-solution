package com.kms.section02;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Practice1 {

    public static void main(String[] args) {
        String s1 = ")()(";
        String s2 = "(()(";

        boolean isS1 = solution(s1);
        boolean isS2 = solution(s2);

        System.out.println("isS1 = " + isS1);
        System.out.println("isS2 = " + isS2);
    }

    private static boolean solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        char[] a = s.toCharArray();
        for (char c : a) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() == c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
