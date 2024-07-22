package com.kms.section04;

import java.util.ArrayList;

public class Practice8 {

    // 문24 메뉴 리뉴얼
    /*
    * 기존에 단품으로만 제공하던 메뉴를 조합해서 코스 요리 형태로 재구성
    * 가장 많이 함께 주문한 단품 메뉴들로 코스요리 메뉴 구성
    * 코스 요리 메뉴는 최소 2가지 이상의 단품 메뉴로 구성
    * 최소 2명이상의 손님으로부터 주문된 단품 메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함
    * 손님은 단품 메뉴를 2개 이상 주문해야 하며, 각 단품 메뉴는 A~Z의 알파벳
    * */

    private static ArrayList<String> resultList = new ArrayList<>();

    public static void main(String[] args) {

        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

        String x = "ABC";
        combinations(0, x.toCharArray(), "");
        System.out.println(resultList);
    }

    public static void combinations(int idx, char[] order, String result) {
        if (result.length() > 0) {
            resultList.add(result);
        }

        for (int i = idx; i < order.length; i++) {
            combinations(i + 1, order, result + order[i]);
        }
    }




}
