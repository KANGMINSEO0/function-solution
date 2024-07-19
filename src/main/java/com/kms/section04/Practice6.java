package com.kms.section04;

import java.util.ArrayList;
import java.util.HashMap;

public class Practice6 {

    public static void main(String[] args) {

        // 문22 베스트 앨범
        /*
        * 속한 노래가 많이 재생된 장르를 먼저 수록
        * 장르 내엣 많이 재생된 노래를 먼저 수록
        * 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록
        * */

        /*
        * genres[i]는 고유 번호가 i인 노래의 장르
        * plays[i]는 고유 번호가 i인 노래가 재생된 횟수
        * genres와 plays의 길이는 같으며, 이는 1이상 10,000이하
        * 장르 종류는 100가지 미만
        * 장르에 속한 곡이 하나라면, 하나의 곡만 선택
        * 모든 장르는 재생된 회수가 다름
        * */

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

    }

    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, ArrayList<int[]>> genresMap = new HashMap<>();
        HashMap<String, Integer> playMap = new HashMap<>();

        // 장르별 총 재생 횟수와 각 곡의 재생 횟수 저장
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            if (!genresMap.containsKey(genre)) {
                genresMap.put(genre, new ArrayList<>());
                playMap.put(genre, 0);
            }
            genresMap.get(genre).add(new int[]{i, play});
            playMap.put(genre, playMap.get(genre) + play);
        }
        return plays;
    }


}
