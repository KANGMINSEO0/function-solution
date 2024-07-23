package com.kms.section04;

import java.util.*;

public class Practice8 {

    // 문24 메뉴 리뉴얼
    /*
    * 기존에 단품으로만 제공하던 메뉴를 조합해서 코스 요리 형태로 재구성
    * 가장 많이 함께 주문한 단품 메뉴들로 코스요리 메뉴 구성
    * 코스 요리 메뉴는 최소 2가지 이상의 단품 메뉴로 구성
    * 최소 2명이상의 손님으로부터 주문된 단품 메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함
    * 손님은 단품 메뉴를 2개 이상 주문해야 하며, 각 단품 메뉴는 A~Z의 알파벳
    * */

//    private static ArrayList<String> resultList = new ArrayList<>();
    // 만들 수 있는 메뉴 구성과 총 주문 수를 저장할 해시맵
    private static HashMap<Integer, HashMap<String, Integer>> courseMap;

    public static void main(String[] args) {

        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

//        String x = "ABC";
//        combinations(0, x.toCharArray(), "");
//        System.out.println(resultList);

        System.out.println(Arrays.toString(solution(orders, course)));
    }

    // 만들 수 있는 모든 조합을 재귀 함수를 이용해서 구현
    public static void combinations(int idx, char[] order, String result) {
        // 필요한 코스 메뉴의 수와 일치하는 것만 저장
        if (courseMap.containsKey(result.length())) {
            HashMap<String, Integer> map = courseMap.get(result.length());
            // 해당 코스의 수를 1증가
            map.put(result, map.getOrDefault(result, 0) + 1);
        }

        for (int i = idx; i < order.length; i++) {
            combinations(i + 1, order, result + order[i]);
        }
    }

    public static String[] solution(String[] orders, int[] course) {

        // 해시맵 초기화
        courseMap = new HashMap<>();
        for (int i : course) {
            courseMap.put(i, new HashMap<>());
        }

        // 코스를 배열로 만들고 오름차순 정렬해서 가능한 모든 메뉴 구성을 구함
        for (String order :  orders) {
            char[] orderArr = order.toCharArray();
            combinations(0, orderArr, "");
        }

        ArrayList<String> answer = new ArrayList<>();

        // 모든 코스 후보에 대해서
        for (HashMap<String, Integer> count : courseMap.values()) {
            count.values()
                    .stream()
                    .max(Comparator.comparingInt(o -> o))   // 가장 빈도수가 높은 코스를 찾음
                    .ifPresent(cnt -> count.entrySet()  // 코스에 대한 메뉴 수가 가능할 때만
                            .stream()
                            // 최소 2명 이상의 손님으로부터 주문된 단품 메뉴 조합에 대해서만
                            .filter(entry -> cnt.equals(entry.getValue()) && cnt > 1)
                            // 코스 메뉴만 answer 리스트에 추가
                            .forEach(entry -> answer.add(entry.getKey())));
        }
        Collections.sort(answer);   // 오름차순 정렬
        return answer.toArray(new String[0]);
    }



}
