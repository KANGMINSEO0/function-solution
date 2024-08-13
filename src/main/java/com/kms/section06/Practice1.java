package com.kms.section06;

import java.util.ArrayList;
import java.util.Arrays;

public class Practice1 {

    // 문30 간단한 유니온-파인드 알고리즘 구현하기
    /*
    * union(x, y) : x와 y가 속한 두 집합을 합침
    * find(x) : x가 속한 집합의 대표 원소를 찾음
    *
    * operations : 수행할 연산을 의미 (연산 종류는 2개)
    * 1. [0, 1, 2]는 노드 1과 노드 2에 대해 union 연산 수행
    * 2. [1, 1, 3] 노드 1과 3이 같은 집합에 속해 있으면 true 아니면 false를 반환하는 equals 연산
    *
    * 0은 union 연산, union 연산 뒤로는 두 개의 정수 x, y가 나옴
    * 1은 equals 연산, equals 연산 뒤로는 두 개의 정수 x, y가 나옴
    *
    * */
    public static void main(String[] args) {

//        int k = 3;
        int k = 4;
//        int[][] operations = {{0, 0, 1}, {0, 1, 2}, {1, 1, 2}};
        int[][] operations = {{0, 0, 1}, {1, 1, 2}, {0, 1, 2}, {1, 0, 2}};
        Boolean[] result = solution(k, operations);

        System.out.println(Arrays.toString(result));
    }

    private static int[] parent;    // 부모 저장을 위한 배열

    // 루트 노드를 찾는 메서드
    private  static int find(int x) {
        // 만약 x의 부모가 자기 자신이면, 즉 x가 루트 노드라면 x를 반환
        if (parent[x] == x)
            return x;
        // 그렇지 않다면 x의 부모를 찾아서 parent[x]에 저장
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int x, int y) {
        int root1 = find(x);    // x가 속한 집합의 루트 노드 찾기
        int root2 = find(y);    // y가 속한 집합의 루트 노드 찾기
        parent[root2] = root1;  // y가 속한 집합을 x가 속한 집합에 합침
    }

    private static Boolean[] solution(int k, int[][] operations) {
        // 노드의 수 만큼 배열 생성
        parent = new int[k];
        // 처음에는 각 노드가 자기 자신을 부모로 가지도록 초기화
        for (int i = 0; i < k; i++) {
            parent[i] = i;
        }

        ArrayList<Boolean> answer = new ArrayList<>();

        for (int[] op : operations) {
            if (op[0] == 0) {
                // 0 연산이면
                union(op[1], op[2]);
            } else {
                // 1 연산이면
                answer.add(find(op[1]) == find(op[2]));
                System.out.println(answer.toString());
            }
        }
        return answer.toArray(new Boolean[0]);
    }
}
