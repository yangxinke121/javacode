package org.learn;

import java.util.*;

public class ShortDistance {

    private int[][] matrix = {
            {1,3,5,9},
            {2,1,3,4},
            {5,2,6,7},
            {6,8,4,3}
    };

    // private int n = 4;
    // private int[][] mem = new int[4][4];
    //
    // public int minDist(int i, int j) {
    //     if (i == 0 && j == 0) {
    //         return matrix[0][0];
    //     }
    //     if (mem[i][j] > 0) {
    //         return mem[i][j];
    //     }
    //     int minLeft = Integer.MAX_VALUE;
    //     if (j - 1 >= 0) {
    //         minLeft = minDist(i, j-1);
    //     }
    //     int minUp = Integer.MAX_VALUE;
    //     if (i - 1 >= 0) {
    //         minUp = minDist(i-1, j);
    //     }
    //
    //     int currMinDist = matrix[i][j] + Math.min(minLeft, minUp);
    //     mem[i][j] = currMinDist;
    //     return currMinDist;
    // }

    private int minDist = Integer.MAX_VALUE;

    public void minDistBT(int i, int j, int dist, int[][] arr, int n) {
        if (i == n && j == n) {
            if (dist < minDist) {
                minDist = dist;
            }
            return;
        }

        if (i < n) {
            minDistBT(i + 1, j, dist + arr[i][j], arr, n);
        }

        if (j < n) {
            minDistBT(i, j + 1, dist + arr[i][j], arr, n);
        }
    }

    public static void main(String[] args) {
        ShortDistance s = new ShortDistance();
        // System.out.println(s.minDist(3, 3));
        s.minDistBT(0, 0, 0, s.matrix, 3);
        System.out.println(s.minDist);
    }

    public static int knapsack3(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w+1];
        for (int i = 0; i < n; ++i) { // 初始化 states
            for (int j = 0; j < w+1; ++j) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        states[0][weight[0]] = value[0];
        for (int i = 1; i < n; ++i) { // 动态规划，状态转移
            for (int j = 0; j <= w; ++j) { // 不选择第 i 个物品
                if (states[i-1][j] >= 0) states[i][j] = states[i-1][j];
            }
            for (int j = 0; j <= w-weight[i]; ++j) { // 选择第 i 个物品
                if (states[i-1][j] >= 0) {
                    int v = states[i-1][j] + value[i];
                    if (v > states[i][j+weight[i]]) {
                        states[i][j+weight[i]] = v;
                    }
                }
            }
        }
        // 找出最大值
        int maxvalue = -1;
        for (int j = 0; j <= w; ++j) {
            if (states[n-1][j] > maxvalue) maxvalue = states[n-1][j];
        }
        return maxvalue;
    }


}
