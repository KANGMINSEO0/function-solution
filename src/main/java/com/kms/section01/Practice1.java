package com.kms.section01;

import java.util.Arrays;

public class Practice1 {
    public static void main(String[] args) {

        int[] org = {4, 2, 3, 1, 5};
        int[] sorted = solution(org);

        System.out.println(Arrays.toString(org));
        System.out.println(Arrays.toString(sorted));

        for (int i = 0; i < org.length; i++) {
            System.out.print(org[i]);
        }

    }

    private static int[] solution(int[] arr) {
//        Arrays.sort(arr);     // sort() 원본 배열 자체를 정렬시켜버림..
        /* 원본 배열의 상태를 유지하면서 원본 배열로부터 새로운 배열을 복사해서
           사용해야 되는 상황에서는 clone()메서드를 사용해야 한다.
        */
        int [] clone = arr.clone();
        Arrays.sort(clone);

        return clone;
    }
}
