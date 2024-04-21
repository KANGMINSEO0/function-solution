package com.kms.section02;

import java.util.Stack;

public class Practice2 {
    // 문제09 10진수를 2진수로 변환하기
    // 10진수를 입력받아 2진수로 변환해 반환하는 solution()

    public static void main(String[] args) {
        // num은 1이상 10억 미만의 자연수
        int num1 = 10;
        int num2 = 27;
        int num3 = 12345;

        System.out.println(solution(num1));
        System.out.println(solution(num2));
        System.out.println(solution(num3));
    }

    public static String solution(int decimal) {

        Stack<Integer> stack = new Stack<>();
        while (decimal > 0) {
            int remainder = decimal % 2;
            stack.push(remainder);
            decimal /= 2;
        }
        // String의 + 연산은 시간 복잡도 측면에서 성능이 좋지 않음
        // 따라서 StringBuilder를 사용
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println("sb = " + sb);
        return sb.toString();
    }

}
