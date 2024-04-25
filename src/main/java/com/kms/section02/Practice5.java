package com.kms.section02;

import java.util.Stack;

public class Practice5 {
    // 문제11 주식가격
    // 초 단위로 기록된 주식 가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은
    // 기간은 몇 초인지를 반환하도록 하는 함수 solution()
    /*
    * 1초 시점의 $1은 끝까지 가격이 떨어지지 않는다
    * 2초 시점의 $2은 끝까지 가격이 떨어지지 않는다
    * 3초 시점의 $3은 1초 뒤에 가격이 떨어진다 까라서 1초간 가격이 떨어지지 않은 것으로 봄
    * 4초 시점의 $2은 1초간 가격이 떨어지지 않는다
    * 5초 시점의 $3은 0초간 가격이 떨어지지 않는다
    * */

    public static void main(String[] args) {

        int[] prices = {1, 2, 3, 2, 3};
        int[] prices2 = {1, 6, 9, 5};

        int[] result = solution(prices);
        int[] result2 = solution(prices2);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }

        System.out.println();
        System.out.println("=====================");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i]);
        }
    }

    public static int[] solution(int[] prices) {

        int n = prices.length;
        int[] answer = new int[n];  // 가격이 떨어지지 않은 기간을 저장할 배열

        // 스택을 사용해 이전 가격과 현재 가격 비교
        Stack<Integer> stack = new Stack<>();   // 스택 생성
        stack.push(0);

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                // 가격이 떨어졌으므로 이전 가격의 기간 계산
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }

        // 스택에 남아 있는 가격들은 가격이 떨어지지 않은 경우
        while (!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = n - 1 - j;
        }

        return answer;
    }

}
