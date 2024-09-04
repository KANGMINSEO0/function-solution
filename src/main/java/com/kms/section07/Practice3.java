package com.kms.section07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Practice3 {

    // 문36 다익스트라 알고리즘

    public static void main(String[] args) {
        
    }

    // 노드의 정보(노드 번호와 거리)를 쌍으로 지정할 클래스 생성
    private static class Node {
        int dest, cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    public static int[] solution(int[][] graph, int start, int n) {
        // 인접 리스트를 저장할 ArrayList 배열 초기화
        ArrayList<Node>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        // graph정보를 인접 리스트로 저장
        for (int[] edge : graph) {
            adjList[edge[0]].add(new Node(edge[1], edge[2]));
        }

        int[] dist = new int[n];
        // 모든 노드의 거리 값을 무한대로 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 시작 노드의 거리 값은 0으로 초기화
        dist[start] = 0;

        // 우선순위 큐를 생성하고 시작 노드를 삽입
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            // 현재 가장 거리가 짧은 노드를 가져옴
            Node now = pq.poll();
        }
        return dist;
    }
}
