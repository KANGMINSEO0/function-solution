package com.kms.section04;

import java.util.HashSet;

public class Practice2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 8};
        int target = 6;

        System.out.println(solution(arr, target));
    }

    // 문18 두 개의 수로 특정값 만들기

    public static boolean solution(int[] arr, int target) {
        HashSet<Integer> hashMap = new HashSet<>();

        for (int i : arr) {
            // target에서 현재 원소를 뺀 값이 해시셋 있는지 확인
            if (hashMap.contains(target - i)) {
                return true;
            }
            // 해시셋 현재 값 저장
            hashMap.add(i);
        }
        return false;
    }

}
