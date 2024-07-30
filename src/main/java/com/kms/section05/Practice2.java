package com.kms.section05;

public class Practice2 {
    public static void main(String[] args) {

        // 문26 예상 대진표
        int n = 8;
        int a = 4;
        int b = 7;

        System.out.println(solution(n, a, b));

    }
    public static int solution(int n, int a, int b) {
        int answer;

        for (answer = 0; a != b; answer++) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }

        return answer;
    }
}
