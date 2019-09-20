package org.leetcode.interiew.interview911;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {


    private int path = Integer.MAX_VALUE;

    public int getCount(int[][] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int rows = nums.length;
        int cols = nums[0].length;
        boolean[][] flag = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (nums[row][col] == 2) {
                    isOk(nums, row, col, 0, flag);
                }
            }
        }
        return path;
    }

    private boolean isOk(int[][] nums, int row, int col, int pathLength, boolean[][] flag) {

        if (nums[row][col] == 3) {
            if (pathLength < path) {
                path = pathLength;
            }
            return true;
        }
        int[] x = {0, 0, 1, -1};
        int[] y = {1, -1, 0, 0};
        flag[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int a = row + x[i];
            int b = col + y[i];
            if (a >= 0 && a < nums.length && b >= 0 && b < nums[row].length && !flag[a][b] && nums[a][b] != 1) {
                if (isOk(nums, a, b, pathLength + 1, flag)) {
                    return true;
                }
            }
        }
        flag[row][col] = false;
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();
        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }


        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = sc.nextInt();
            }
        }
        Main2 main2 = new Main2();
        System.out.println(main2.getCount(temp));
    }
}
