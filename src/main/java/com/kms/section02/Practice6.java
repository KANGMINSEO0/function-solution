package com.kms.section02;

import java.util.Stack;

public class Practice6 {
    // 문제 13 크레인 인형 뽑기 게임
    // board는 2차원 배열, 크기는 5x5 이상 30x30 이하
    // board의 각 칸에는 0이상 100이하인 정수가 담겨져 있음
    // 0은 빈칸을 나타냄
    // 1~100의 각 숫자는 각기 다른 인형의 모양을 의미하며 같은 숫자는 같은 모양의 인형을 나타냄
    // moves 배열의 크기는 1이사 1,000이하
    // moves 배열 각 원소들의 값은 1 이상이며 board 배열의 가로 크기 이하인 자연수

    // 격자의 가장 아래 칸부터 차곡차곡 쌓여 있고 가장 위에 있는 인형을 집어올릴 수 있다
    // 집어올린 인형은 바구니에 쌓이는데, 바구니의 가장 아래 칸부터 인형이 순서대로 쌓인다.

    public static void main(String[] args) {

        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println("result = " + solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {

        // 각 열에 대한 스택을 생성
        Stack<Integer>[] lanes = new Stack[board.length];
        for (int i = 0; i < lanes.length; i++) {
            lanes[i] = new Stack<>();
        }

        // board를 역순으로 탐색하며, 각 열의 인형을 lanes에 추가
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 0) {
                    lanes[j].push(board[i][j]);
                }
            }
        }

        // 인형을 담을 bucket을 생성
        Stack<Integer> bucket = new Stack<>();
        // 사라진 인형의 총 개수를 저장할 변수를 초기화
        int answer = 0;

        // moves를 순회하며, 각 열에서 인형을 뽑아 bucket에 추가
        for (int move : moves) {
            if (!lanes[move - 1].isEmpty()) { // 해당 열에 인형이 있는 경우
                int doll = lanes[move - 1].pop();
                // 바구니에 인형이 있고, 가장 위에 있는 인형과 같은 경우
                if (!bucket.isEmpty() && bucket.peek() == doll) {
                    bucket.pop();
                    answer += 2;
                } else { //  바구니에 인형이 없거나, 가장 위에 있는 인형과 다른 경우
                    bucket.push(doll);
                }
            }
        }

        return answer;
    }

}
