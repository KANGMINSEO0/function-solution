package com.kms.section04;

import java.util.HashMap;

public class Practice3 {

    // 문19 완주하지 못한 선수

    public static String solution(String[] participant, String[] completion) {

        // 해시맵 생성
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        // 완주한 선두들의 이름을 해시맵에 저장
        for (String string : completion) {
            hashMap.put(string, hashMap.getOrDefault(string, 0) + 1);
        }

        return "";
    }

}
