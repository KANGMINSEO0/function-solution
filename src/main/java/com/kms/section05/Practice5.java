package com.kms.section05;

import java.util.ArrayList;
import java.util.Arrays;

public class Practice5 {

    // 문제 29 길 찾기 게임

    // nodeInfo는 이진 트리를 구성하는 각 노드의 좌표가 1번 노드부터 순서대로 들어있는 2차원 배열
    /*
    * 1이상 10,000 이하
    * nodeInfo[i]는 i + 1번 노드의 좌표, [x축 좌표, y축 좌표]
    * 모든 노드의 좌표 값은 0 이상 100,000이하인 정수
    * 트리의 깊이가 1,000이하인 경우만 입력으로 주어짐
    * 모든 노드의 좌표는 문제에 주어진 규칙을 따르며, 잘못된 노드 위치가 주어지는 경우는 없음
    * */

    // y좌표가 크면 무조건 우선순위가 높음
    // y좌표가 같다면, x좌표가 적은 게 우선순위가 높음

    public static void main(String[] args) {

        int[][] nodeInfo = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
        int[][] result = solution(nodeInfo);
        System.out.println(Arrays.deepToString(result));
    }

    private static class Node {
        int x, y, num;      // 노드의 좌표, 번호 저장
        Node left, right;   // 노드의 왼쪽, 오른쪽 자식 노드


        public Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    public static int[][] solution(int[][] nodeInfo) {
        Node root = makeBT(nodeInfo);   // 이진 트리 생성
        ArrayList<Integer> preOrderList = new ArrayList<>();    // 전위 순회 리스트
        preOrder(root, preOrderList);
        ArrayList<Integer> postOrderList = new ArrayList<>();   // 후위 순회 리스트
        postOrder(root, postOrderList);

        // 결과 생성
        int[][] answer = new int[2][nodeInfo[0].length];
        answer[0] = preOrderList.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = postOrderList.stream().mapToInt(Integer::intValue).toArray();

        // 결과 반환
        return answer;
    }

    // 이진 트리 생성 메서드
    private static Node makeBT(int[][] nodeInfo) {
        // 각 노드에 대한 좌표, 번호를 배열에 저장
        Node[] nodes = new Node[nodeInfo.length];
        for (int i = 0; i < nodeInfo.length; i++) {
            nodes[i] = new Node(i + 1, nodeInfo[i][0], nodeInfo[i][1]);
        }

        // y 기준으로 내림차순 정렬, y가 같다면 x를 기준으로 오름차순 정렬
        Arrays.sort(nodes, (o1, o2) -> {
            if (o1.y == o2.y)
                return Integer.compare(o1.x, o2.x);
            return Integer.compare(o2.y, o1.y);
        });

        Node root = nodes[0];

        for (int i = 1; i < nodes.length; i++) {
            Node parent = root;
            while (true) {
                // 부모 노드의 x 좌표가 더 크다면 왼쪽으로
                if (nodes[i].x < parent.x) {
                    if (parent.left == null) {
                        parent.left = nodes[i];
                        break;
                    } else {
                        parent = parent.left;
                    }
                } else {
                    if (parent.right == null) {
                        parent.right = nodes[i];
                        break;
                    } else {
                        parent = parent.right;
                    }
                }
            }
        }
        return nodes[0];
    }

    // 전위 순회 메서드
    private static void preOrder(Node curr, ArrayList<Integer> answer) {
        if (curr == null) {
            return;
        }
        answer.add(curr.num);
        preOrder(curr.left, answer);
        preOrder(curr.right, answer);
    }

    // 후위 순회 메서드
    private static void postOrder(Node curr, ArrayList<Integer> answer) {
        if (curr == null) {
            return;
        }
        postOrder(curr.left, answer);
        postOrder(curr.right, answer);
        answer.add(curr.num);
    }
}
