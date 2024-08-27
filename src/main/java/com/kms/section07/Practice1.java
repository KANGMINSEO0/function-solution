package com.kms.section07;

import java.util.ArrayList;
import java.util.Arrays;

public class Practice1 {

    // 문34 깊이 우선 탐색 순회
    /*
    * 시작 노드는 start
    * graph는 [출발노드, 도착노드]쌍들이 들어 있는 리스트
    * 반환값은 그래프의 시작 노드부터 모든 노드를 깊이 우선 탐색으로 진행한 순서대로 노드가 저장된 리스트
    *
    * 노드의 최대 개수는 100개를 넘지 않음
    * 시작 노드부터 시작해서 모든 노드를 방문할 수 있는 경로가 항상 있음
    * 그래프의 노드는 문자열
    * */

    public static void main(String[] args) {

        int[][] graph = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int start = 1;
        int n = 5;
        int[] result = solution(graph, start, n);
        System.out.println(Arrays.toString(result));
    }

    // 인접 리스트 저장할 ArrayList 배열
    private static ArrayList<Integer>[] adjList;

    // 방문 여부를 저장할 boolean 배열
    private static boolean[] visited;
    private static ArrayList<Integer> answer;

    private static int[] solution(int[][] graph, int start, int n) {

        // 인접 리스트 초기화
        adjList = new ArrayList[n + 1];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 그래프를 인접 리스트로 변환
        for (int[] edge : graph) {
            adjList[edge[0]].add(edge[1]);
        }

        // DFS를 순회한 결과를 반환
        visited = new boolean[n + 1];
        answer = new ArrayList<>();
        dfs(start); // 시작 노드에서 깊이 우선 탐색 시작

        // DFS 탐색 결과 반환
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void dfs(int now) {
        visited[now] = true;    // 현재 노드를 방문했음을 저장
        answer.add(now);    // 현재 노드를 결과 리스트에 추가
        // 현재 노드와 인접한 노드 순회
        for (int next : adjList[now]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
