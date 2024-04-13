package com.kms.section01;

import java.util.ArrayList;
import java.util.Arrays;

public class Practice4 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 1, 2, 5, 3};
//        int[] arr2 = {1, 3, 2, 4, 2};

        int[] sortedArr1 = solution(arr1);
        int[] sortedArr2 = solution(arr2);

        for (int i = 0; i < sortedArr1.length; i++) {
            System.out.print(sortedArr1[i]);
        }
        System.out.println();
        for (int i = 0; i < sortedArr2.length; i++) {
            System.out.print(sortedArr2[i]);
        }
    }

    public static int[] solution(int[] answers) {
        System.out.println("solution 메소드 호출...");
        // 수포자들의 패턴
        int[][] pattern = {
                {1, 2, 3, 4, 5},
                {2, 1, 3, 4, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        // 수포자들의 점수를 저장할 배열
        int[] scores = new int[3];

        // 각 수포자의 패턴과 정답이 얼마나 일치하는지 확인
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < pattern.length; j++) {
                if (answers[i] == pattern[j][i % pattern[j].length]) {
                    scores[j]++;
                }
            }
        }
        System.out.println("scores 출력");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i]+ " ");
        }
        System.out.println();
        System.out.println("====================");
        // 가장 높은 점수 저장
        int maxScore = Arrays.stream(scores).max().getAsInt();
            System.out.println("maxScore : " + maxScore+ " ");
        // 가장 높은 점수를 가진 수포자들의 번호를 찾아서 리스트에 담음
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
