package com.kms.section02;

import java.util.Arrays;
import java.util.Stack;

public class Practice7 {
    // 문제14 표편집
    // 최종 표의 상태와 처음 표의 상태를 비교해 삭제되지 않은 행은 "O", 삭제된 행은  "X"
    public static void main(String[] args) {

        int n = 8;
        int k = 2;

        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "U 2", "Z", "Z"};

        System.out.println("result = { " + solution(n, k, cmd) + " }");

        String[] cmd2 = {"D 2", "C", "U 3", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};

        System.out.println("result = { " + solution(n, k, cmd2) + " }");

    }

    public static String solution(int n, int k, String[] cmd) {

        // 삭제된 행의 인덱스를 저장하는 스택
        Stack<Integer> delete = new Stack<>();
        // 각 행을 기준으로 연산에 따른 위치를 표시하기 위한 배열
        int[] up = new int[n + 2];
        int[] down = new int[n + 2];

        for (int i = 0; i < n + 2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }

        // 현재 위치를 나타내는 인덱스
        k++;

        // 주어진 명령어(cmd) 배열을 하나씩 처리
        for (String c : cmd) {
            // 현재 위치를 삭제하고 그 다음 위치로 이동
            if (c.startsWith("C")) {
                delete.push(k);
                up[down[k]] = up[k];
                down[up[k]] = down[k];
                k = n < down[k]? up[k]: down[k];
            }
            // 가장 최근에 삭제된 행을 복원
            else if (c.startsWith("Z")) {
                int restore = delete.pop();
                down[up[restore]] = restore;
                up[down[restore]] = restore;
            }
            // U 또는 D를 사용해 현재 위치를 위, 아래로 이동
            else {
                String[] s = c.split(" ");
                int x = Integer.parseInt(s[1]);
                for (int i = 0; i < x; i++) {
                    k = s[0].equals("U")? up[k]: down[k];
                }
            }
        }
        // 삭제된 행의 위치에 "X"를, 그렇지 않은 행 위치에는 "O"를 저장한 문자열 반환
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');

        for (int i : delete) {
            answer[i - 1] = 'X';
        }

        return new String(answer);
    }
}
