package com.kms.section02;

import java.util.Stack;

public class Practice4 {
    // 문제11 짝지어 제거하기
    // 문자열 S가 주어졌을 때 짝지어 제거하기를 성공적으로 수행 할 수 있는지 반환하는 함수
    // 알파벳 소문자로 구성된 문자열에서 같은 알파벳이 2개 붙어 있는 짝을 찾음
    // 짝을 찾은 다음에는 그 둘을 제거한 뒤 앞뒤로 문자열을 이어 붙임
    // 이 과정을 반복해서 문자열을 문자열을 모두 제거 한다면 짝지어 제거하기가 종료된다.
    // 성공적으로 수행 가능 : 1, 아니면 0 반환

    public static void main(String[] args) {
        String s1 = "baabaa";
        String s2 = "cdcd";

        int result1 = solution(s1);
        int result2 = solution(s2);

        System.out.println("s1 => " + result1);
        System.out.println("s2 => " + result2);

    }
    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 스택이 비어있지 않고, 현재 문자와 스택의 맨 위 문자가 같으면
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();    // 스택의 맨 위 문자 제거
            }
            else {
                stack.push(c);  // 스택에 현재 문자 추가
            }
        }

        return stack.isEmpty()? 1 : 0; // 스택이 비어 있으면 1, 그렇지 않으면 0 반환
    }
}
