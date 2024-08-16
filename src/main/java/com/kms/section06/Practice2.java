package com.kms.section06;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Practice2 {

    // 문제 31 포켓몬
    /*
    * 연구실에 있는 N마리의 포켓몬 중 N/2마리 가져 갈 수 있음
    * 포켓몬은 종류에 따라 번호를 붙여 구분
    * 가장 많은 종류의 포켓몬을 선택하는 방법을 찾아 포켓몬 종류 번호의 개수를 반환
    * 
    * */
    public static void main(String[] args) {

        int[] nums = {3, 1, 2, 3};
        int result = solution(nums);

        System.out.println("result = " + result);
    }

    public static int solution(int[] nums) {

        // nums 리스트에서 중복을 제거한 집합(set)을 구함
        HashSet<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        // 포켓몬의 총 수
        int n = nums.length;
        // 선택할 포켓몬의 수
        int k = n / 2;
        // 중복을 제거한 포켓몬의 종류 수와 선택할 포켓몬의 수 중 작은 값 반환
//        return Math.min(k, set.size());

        return Math.min((int) Arrays.stream(nums).distinct().count(), nums.length / 2);
    }
}
