package org.leetcode.interiew.interview916;

import java.util.Scanner;

public class Main {

    public static int[] printArr(int[][] nums) {

        int rows = nums.length;
        if (rows == 0) {
            return new int[]{};
        }
        int cols = nums[0].length;

        int len = rows * cols;
        int[] temp = new int[len];
        int n = 0;

        int row = 0;
        int col = 0;

        int crow = 0;
        int ccol = 0;

        int c = rows / 2 + 1;

        for (int i = 0; i < c && n < len; i++) {

            while (row != rows && n < len) {
                temp[n++] = nums[row++][col];
            }
            col++;
            while (col != cols && n < len) {
                temp[n++] = nums[row - 1][col++];
            }
            row = rows - 2;
            while (row > crow && n < len) {
                temp[n++] = nums[row--][col - 1];
            }
            col--;
            while (col > ccol && n < len) {
                temp[n++] = nums[row][col--];
            }

            crow++;
            ccol++;
            col = ccol;
            row = crow;

            cols--;
            rows--;
        }
        return temp;
    }

    public static int maxCount(int[] nums, int k) {

        int length = nums.length;
        if (length < 2) {
            return 1;
        }

        int preSum = nums[0];
        int count = 0;
        int preCount = 0;
        for (int i = 1; i < length; i++) {
            if (preSum < k) {
                if (preSum + nums[i] <= k) {
                    preSum = preSum + nums[i];
                    preCount = preCount + 1;
                } else {
                    preSum = nums[i];
                    preCount = 1;
                }
            } else {
                preSum = nums[i];
                preCount = 1;
            }
            count = Math.max(count, preCount);
        }
        return count == 0 ? count : count + 1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        // for (int i = 0; i < n; i++) {
        //     for (int i1 = 0; i1 < m; i1++) {
        //         arr[i][i1] = sc.nextInt();
        //     }
        // }
        // int[] ints = printArr(arr);
        // for (int i : ints) {
        //     System.out.printf("%d ", i);
        // }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(maxCount(nums, m));

    }
}
