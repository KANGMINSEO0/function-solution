package com.kms.section03;

import java.util.ArrayDeque;
import java.util.Queue;

public class Practice3 {
    // 문제16 기능개발

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
    }

    public static int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> answer = new ArrayDeque<>();

        int n = progresses.length;
        // 각 작업의 배포 가능일 계산
        int[] daysLeft = new int[n];
        for (int i = 0; i < n; i++) {
            daysLeft[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }
        int count = 0; // 배포될 작업의 수 카운트
        int maxDay = daysLeft[0];   // 현재 배폳괼 작업 중 가장 늦게 배포될 작업의 가능일

        return progresses;
    }
}
