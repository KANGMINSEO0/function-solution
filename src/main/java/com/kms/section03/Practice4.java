package com.kms.section03;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Practice4 {

    // 문제 17 카드 뭉치
    /* 다음과 같은 규칙으로 카드에 적힌 단어들을 사용해 원하는 순서의 단어 배열을 만들 수 있는지 알고 싶음
    *
    *  원하는 카드 뭉치에서 카드를 순서대로 한 장씩 사용
    *  한 번 사용한 카드는 다시 사용할 수 없음
    *  카드를 사용하지 않고 다음 카드로 넘어갈 수 없음
    *  기존에 주어진 카드 뭉치의 단어 순서는 바꿀 수 없음
    *
    * */
    public static void main(String[] args) {
        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        String result = solution(cards1, cards2, goal);

        System.out.println("result = " + result);
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {

        // cards와 goal을 deque로 변환
        ArrayDeque<String> cardsDeque1 = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> cardsDeque2 = new ArrayDeque<>(Arrays.asList(cards2));
        ArrayDeque<String> goalDeque = new ArrayDeque<>(Arrays.asList(goal));

        // goalDeque에 문자열이 남아 있으면 계속 반복
        while (!goalDeque.isEmpty()) {
            if (!cardsDeque1.isEmpty() && cardsDeque1.peekFirst().equals(goalDeque.peekFirst())) {
                cardsDeque1.pollFirst();
                goalDeque.pollFirst();
            }
            // cardsDeque2의 front와 일치하는 경우
            else if (!cardsDeque2.isEmpty() && cardsDeque2.peekFirst().equals(goalDeque.peekFirst())) {
                cardsDeque2.pollFirst();
                goalDeque.pollFirst();
            }
            else {
                break;
            }
        }

        // goal이 비었으면 "Yes" 아니면 "No"를 반환
        return goalDeque.isEmpty() ? "YES" : "NO";
    }
}
