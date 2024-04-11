package com.kms.section01;

import java.util.Arrays;
import java.util.Collections;

public class Practice2 {

    public static void main(String[] args) {
        /* 정수 배열 하나 받음. 배열의 중복값을 제거하고 배열 데이터를 내림차순으로 정렬해서 반환 */
        // 배열 길이는 2이상 1,000 이하
        // 각 배열의 데이터 값 => -100,000이상 100,000 이하
        int[] arr1 = {4, 2, 2, 1, 3, 4};
        int[] arr2 = {2, 1, 1, 3, 2, 5, 4};

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

    private static int[] solution(int[] arr) {
        // 중복값 제거
        /* Arrays 클래스의 stream() 메서드를 통해서 sstream으로 변환
        *
        *  해당 stream의 프리미티브 타입인 IntStream의 데이터를 boxed()를 통해
        *  레퍼런스 타입인 Inteager로 변환하고, distinct() 메서드를 통해 중복을 제거
        *
        *  Integer형 배열로 중복 제거된 데이터 반환
        * */
        Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);
        // 내림차순 정렬
        /* Collections.reverseOrder() : 인수가 없으면 기본값은 오름차순*/
        Arrays.sort(result, Collections.reverseOrder());

        /* Integer[] 형태의 배열을 int[] 형태로 변환하여 반환*/
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }
}
