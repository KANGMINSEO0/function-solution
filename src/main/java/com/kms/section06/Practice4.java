package com.kms.section06;

public class Practice4 {

    // 문33 섬 연결하기
    /*
    * n개의 섬 사이에 다리를 건설하는 비용 costs가 주어질 때 최소 비용으로 모든 섬이 서로 통행
    * 다리를 여러 번 건너더라도 목표 지점에 도달할 수만 있으면 통행할 수 있다고 봄
    * ex) A, B 섬 사이에 다리가 있고, B, C 섬 사이에 다리가 있으면 A, C 섬은 서로 동행 가능
    * */

    public static void main(String[] args) {

    }

    private static int[] parent;

    private static int find(int x) {
        // x가 속한 집합의 루트 노드 찾기
        if (parent[x] == x)
            return x;
        // 경로 압축 :  x의 부모를 루트로 설정
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        // 두 집합을 하나의 집합으로 합치기
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1;
    }

    public static int solution(int n, int[][] costs) {

        return n;
    }
}
