package com.kms.section05;

import java.util.Arrays;
import java.util.HashMap;

public class Practice3 {

    // 문27 다단계 칫솔 판매
    public static void main(String[] args) {

        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}; // 현재 판매원
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};   // 추천자
        String[] seller = {"young", "john", "tod", "emily", "mary"};    // 판매원
        int[] amount = {12, 4, 2, 5, 10};   // 판매한 칫솔 개수 (칫솔 한 개 : 100원)

        int[] answer = solution(enroll, referral, seller, amount);
        for (int a : answer) {
            System.out.print(a + " ");
        }

    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        // parent 해시맵, key는 enroll의 노드, value는 referral의 노드로 구성됨
        HashMap<String, String> parent = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
        }

        // total 해시맵 생성
        HashMap<String, Integer> total = new HashMap<>();

        // seller 배열과 amount 배열을 이용하여 이익 분배
        for (int i = 0; i < seller.length; i++) {
            String curName = seller[i];
            // 판매자가 판매한 총금액 계산
            int money = amount[i] * 100;
            // 판매자부터 차례대로 상위 노드로 이동하며 이익 분배
            while (money > 0 && !curName.equals("-")) {
                total.put(curName, total.getOrDefault(curName, 0) + money - (money / 10));
                curName = parent.get(curName);
                // 10% 를 제외한 금액 계산
                money /= 10;
            }
        }
        System.out.println(total);
        System.out.println(Arrays.toString(enroll));

        // enroll 배열의 모든 노드에 대해 해당하는 이익을 배열로 반환
        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = total.getOrDefault(enroll[i], 0);
        }
        return answer;
    }
}
