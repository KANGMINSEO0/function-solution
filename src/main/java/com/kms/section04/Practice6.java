package com.kms.section04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Practice6 {

    public static void main(String[] args) {

        // 문22 베스트 앨범
        /*
        * 속한 노래가 많이 재생된 장르를 먼저 수록
        * 장르 내에서 많이 재생된 노래를 먼저 수록
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

        System.out.println(Arrays.toString(solution(genres, plays)));

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

        ArrayList<Integer> answer = new ArrayList<>();

        // 총 재생 횟수가 많은 장르순으로 내림차순 정렬
        Stream<Map.Entry<String, Integer>> sortedGenre = playMap.entrySet().stream().sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));

        // 각 장르 내에서 노래를 재생 횟수 순으로 정렬해 최대 2곡까지 선택
        sortedGenre.forEach(entry -> {
            Stream<int[]> sortedSongs = genresMap.get(entry.getKey()).stream()
                    .sorted((o1, o2) -> Integer.compare(o2[1], o1[1]))
                    .limit(2);
            sortedSongs.forEach(song -> answer.add(song[0]));
        });

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }


}
