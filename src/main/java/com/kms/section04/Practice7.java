package com.kms.section04;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Practice7 {

    // 문제 23 신고결과 받기
    // 게시판 불량 이용자를 신고하고 처리 결과를 메일로 발송하는 시스템
    /* 각 유저는 한 번에 한 명의 유저를 신고할 수 있음
    *  - 신고 횟수에 제한은 없음. 서로 다른 유저를 계속해서 신고 가능
    *  - 한 유저를 여러 번 신고할 수도 있지만 동일한 유저에 대한 신고 횟수는 1회로 처리
    *  k번 이상 신고된 유저는 게시판 이용이 정지되며 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송
    *  - 유저가 신고한 모든 내용을 취합해 마지막에 한거번에 게시판 이용 정지를 시키면서 정지 메일을 발송
    * */

    public static void main(String[] args) {
        String[] idList = {"muzi", "frodo", "apeach", "nao"};
        String[] report = {"muzi frodo", "apeach frodo","frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        // result = {2, 1, 1, 0}
        int[] result = solution(idList, report, k);
        System.out.print("{");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("}");
    }

    public static int[] solution(String[] idList, String[] report, int k) {

        // 신고당한 유저 - 신고 유저 집합을 저장할 해시맵
        HashMap<String, HashSet<String>> reportedUser = new HashMap<>();
        // 처리 결과 메일을 받은 유저 - 받은 횟수를 저장할 해시맵
        HashMap<String, Integer> count = new HashMap<>();

        // 신고 기록 순회
        for (String r : report) {
            String[] s = r.split(" ");
            String userId = s[0];
            String reportedId = s[1];

            if (!reportedUser.containsKey(reportedId)) {
                // 신고당한 기록이 없다면
                reportedUser.put(reportedId, new HashSet<>());
            }
            // 신고한 사람의 아이디를 해시맵의 value인 해시셋에 추가
            reportedUser.get(reportedId).add(userId);
        }
        for (Map.Entry<String, HashSet<String>> entry : reportedUser.entrySet()) {
            if (entry.getValue().size() >= k) {
                // 정지 기준에 만족하는지 확인
                for (String uid : entry.getValue()) {
                    // 해시셋을 순회하며 count 계산
                    count.put(uid, count.getOrDefault(uid, 0) + 1);
                }
            }
        }

        int[] answer = new int[idList.length];

        // 각 아이디별 메일을 받은 횟수를 순서대로 정리
        for (int i = 0; i < idList.length; i++) {
            answer[i] = count.getOrDefault(idList[i], 0);
        }
        return answer;
    }
}
