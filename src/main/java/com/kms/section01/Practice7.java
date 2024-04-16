package com.kms.section01;

import java.util.HashMap;
import java.util.Map;

public class Practice7 {

    public static void main(String[] args) {
        int N1 = 5;
        int N2 = 4;
        int[] stages1 = {2, 1, 3, 6, 2, 4, 3, 3};
        int[] stages2 = {4, 4, 4, 4, 4};
        int[] result1 = solution(N1, stages1);
        int[] result2 = solution(N2, stages2);

        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i]);
        }
        System.out.println();
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i]);
        }
    }
    // 문제06 실패율

    public static int[] solution(int N, int[] stages) {
        // 스테이지별 도전자 수를 구함
        int[] challenger = new int[N + 2];
        for (int i = 0; i < stages.length; i++) {
            challenger[stages[i]] += 1;
        }
        // 스테이지별 실패한 사용자 수 계산
        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length;

        // 각 스테이지를 순회하며, 실패율 계산
        for (int i = 1; i <= N; i++) {
            if (challenger[i] == 0) {
                // 도전한 사람이 없는 경우, 실패율은 0
                fails.put(i, 0.);
            } else {
                fails.put(i, challenger[i] / total);    // 실패율 구함
                total -= challenger[i];     // 다음 스테이지 실패율을 구하기 위해 현재 스테이지 인원을 뺌
            }
        }
        // 실패율이 높은 스테이지부터 내림차순으로 정렬
        return fails.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())).mapToInt(Map.Entry::getKey).toArray();
    }
}
