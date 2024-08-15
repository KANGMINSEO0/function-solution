package com.kms.section06;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Practice2 {

    // 문제 31 포켓몬
    public static void main(String[] args) {

    }

    public static int solution(int[] nums) {

        // nums 리스트에서 중복을 제거한 집합(set)을 구함
        HashSet<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        return 0;
    }
}
