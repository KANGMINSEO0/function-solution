package com.kms.section01;

public class Practice6 {
    // 행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하
    // 행렬 arr1, arr2의 데이터는 -10 이상 20 이하인 자연수
    // 곱할수 있는 배열만 주어짐
    public static void main(String[] args) {
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};
        int[][] arr3 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] arr4 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};

        int[][] answer1 = solution(arr1, arr2);
        int[][] answer2 = solution(arr3, arr4);

        for (int i = 0; i < answer1.length; i++) {
            for (int j = 0; j < answer1[0].length; j++) {
                System.out.print(answer1[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < answer2.length; i++) {
            for (int j = 0; j < answer2[0].length; j++) {
                System.out.print(answer2[i][j]);
            }
            System.out.println();
        }

    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        // 행렬 arr1과 arr2의 행과 열의 수
        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int r2 = arr2.length;
        int c2 = arr2[0].length;

        // 결과를 저장할 2차원 배열 초기화
        int[][] answer = new int[r1][c2];

        // 첫 번째 행렬 arr1의 각 행과 두 번째 행렬 arr2의 각 열에 대해
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                // 두 행렬의 데이터를 곱해 결과 리스트에 더함
                for (int k = 0; k < c1; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}
