package com.kms.section05;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Practice4 {

    // 문28 양과 늑대
    public static void main(String[] args) {
        int[] info = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        int[][] edges = {{0, 1,}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}};
        int result = solution(info, edges);
        System.out.println("result = " + result);

    }
    // 현재 위치, 양의 수, 늑대의 수 방문한 노드 저장을 위한 클래스
    private static class Info {
        int node, sheep, wolf;
        HashSet<Integer> visited;

        public Info(int node, int sheep, int wolf, HashSet<Integer> visited) {
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.visited = visited;
        }
    }

    private static ArrayList<Integer>[] tree;   // 트리 정보를 저장할 인접 리스트

    // 트리 구축 메서드
    private static void buildTree(int[] info, int[][] edges) {
        tree = new ArrayList[info.length];
        System.out.println("====tree====");
        System.out.println("tree length = " + tree.length);
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
            System.out.println(tree[i]);
        }
        System.out.println("====트리 구축====");
        for (int[] edge : edges) {
            System.out.println(tree[edge[0]]);
            tree[edge[0]].add(edge[1]);
            System.out.println(Arrays.toString(tree));
        }
    }

    public static int solution(int[] info, int[][] edges) {
        buildTree(info, edges); // 트리 생성
        int answer = 0; // 최대 양의 수를 저장할 변수

        // BFS를 위한 큐 생성 및 초기 상태 설정
        ArrayDeque<Info> queue = new ArrayDeque<>();
        queue.add(new Info(0,1, 0, new HashSet<>()));

        int k = 0;

        // BFS(너비 우선 탐색) 시작
        while (!queue.isEmpty()) {
            System.out.println("k = " + k);
            // 큐에서 현재 상태를 꺼냄
            Info now = queue.poll();
            if (now != null) {
                System.out.println("now.node = " + now.node);
                System.out.println("now.sheep = " + now.sheep);
                System.out.println("now.wolf = " + now.wolf);
                System.out.println("now.visited = " + now.visited);
            }
            // 최대 양의 수 업데이트
            answer = Math.max(answer, now.sheep);
            System.out.println("answer = " + answer);
            // 방문한 노드 집합에 현재 노드의 이웃 노드 추가
            now.visited.addAll(tree[now.node]);

            // 인접한 노드들에 대해 탐색
            for (int next : now.visited) {
                // 기존 해시셋의 데이터를 복사하고 현재 방문한 정점을 해시셋에서 제거
                HashSet<Integer> set = new HashSet<>(now.visited);
                set.remove(next);

                if (info[next] == 1) {
                    // 늑대일 경우
                    if (now.sheep != now.wolf + 1) {
                        queue.add(new Info(next, now.sheep, now.wolf + 1, set));
                    }
                }
                else {
                    // 양일 경우
                    queue.add(new Info(next, now.sheep + 1, now.wolf, set));
                }
            }
            k++;
        }
        return answer;
    }
}
