package com.kms.section03;

import java.util.ArrayDeque;

public class Practice2 {
    // 문제15 요세푸스 문제
    // N명의 사람이 원 형태로 서 있음.
    // 각 사람은 1부터 N까지 번호표를 갖고 있음.
    // 임의의 숫자 K가 주어짐
    // 1번 번호표를 가진 사람을 기준으로 K번째 사람을 없앰
    // 없앤 사람 다음 사람을 기준으로 하고 다시 K번째 사람을 없앰
    // N과 K가 주어질 때 마지막에 살아있는 사람의 번호를 반환하는 solution() 함수
    public static void main(String[] args) {
        int n = 5;
        int k = 2;

        System.out.println("return = " + solution(n, k));
    }

    public static int solution(int n, int k) {

        // 1부터 n까지의 번호를 deque에 추가
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }

        // deque에 하나의 요소가 남을 때까지 반복
        while (deque.size() > 1) {
            // k번째 요소를 찾기 위해 앞에서부터 제거하고 뒤에 추가
            for (int i = 0; i < k - 1; i++) {
                deque.addLast(deque.pollFirst());
            }
            deque.pollFirst();  // k번째 요소 제거
        }


        return deque.pollFirst();   // 마지막으로 남은 요소 반환
    }
}
