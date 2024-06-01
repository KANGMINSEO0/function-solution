package com.kms.section04;

import java.util.HashMap;

public class Practice1 {
    public static void main(String[] args) {
        // HashMap<KeyType, ValueType> 입니다.
        HashMap<String, Integer> hashMap = new HashMap<>();

        // hashMap에 데이터 추가
        hashMap.put("ABC", 10);
        hashMap.put("BBB", 20);
        hashMap.put("AAA", 30);
        hashMap.put("ABC", 15);

        System.out.println(hashMap.isEmpty());  // false
        System.out.println(hashMap.get("ABC")); // 15
        System.out.println(hashMap.containsKey("ABC")); // true

        hashMap.remove("ABC");  // hashMap에서 키가 "ABC"인 데이터 제거
        System.out.println(hashMap.size()); // 2

        hashMap.clear();    // 해시맵의 모든 데이터 삭제
        System.out.println(hashMap.isEmpty());  // true
    }
}
