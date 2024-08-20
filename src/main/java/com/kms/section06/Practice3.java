package com.kms.section06;

import java.util.Arrays;
import java.util.HashSet;

public class Practice3 {

    // 문32 영어 끝말잇기
    /*
    * n명의 사람이 영어 끝말잇기를 함
    *
    * 1번부터 번호 순서대로 한 사람씩 단어를 말함
    * 마지막 사람이 단어를 말한 다음에는 다시 1번부터 시작
    * 앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 함
    * 이전에 등장했던 단어는 사용 불가
    * 한 글자인 단어는 인정되지 않음
    *
    * */

    public static void main(String[] args) {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        int[] result = solution(n, words);

        System.out.println("result = " + Arrays.toString(result));
    }

    public static int[] solution(int n, String[] words) {
        // 이미 사용한 단어를 저장하는 set
        HashSet<String> usedWords = new HashSet<>();    // 중복 단어 체크는 끝말잇기가 진행될 때 마다 집합에 이미 있는 단어인지를 확인 해야 하므로 HashSet 이용
        // 이전 단어의 마지막 글자, 최초 상태는 첫 번째 사람이 말하는 첫 번째 글자로 초기화
        char prevWord = words[0].charAt(0);

        for (int i = 0; i < words.length; i++) {
            // 이미 사용한 단어이거나 첫 글자가 이전 단어와 일치하지 않으면
            if (usedWords.contains(words[i]) || words[i].charAt(0) != prevWord) {
                // 일치하는 사람의 번호와 차례를 반환
                return new  int[]{(i % n) + 1, (i / n) + 1};
            }
            // 사용한 단어로 추가
            usedWords.add(words[i]);
            // 이전 단어의 마지막 글자 업데이트
            prevWord = words[i].charAt(words[i].length() - 1);
        }

        return new  int[]{0, 0};
    }

}
