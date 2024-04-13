package com.kms.section01;

import java.util.HashSet;

public class Practice3 {
    public static void main(String[] args) {
        int[] arr1 = {2, 1, 3, 4, 1};
        int[] arr2 = {5, 0, 2, 7};

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

    public static int[] solution(int[] numbers) {
        // 중복값 제거를 위한 해시셋 생성
        HashSet<Integer> set = new HashSet<>();
        // 두 수를 선택하는 모든 경웅늬 수를 반복문으로 구함
        for (int i = 0; i < numbers.length -1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                // 두 수를 더한 결과를 해시셋에 추가
                set.add(numbers[i] + numbers[j]);
            }
        }
        // 해시셋의 값을 오름차순 정렬하고 int[] 형태의 배열로 변환하여 반환
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
