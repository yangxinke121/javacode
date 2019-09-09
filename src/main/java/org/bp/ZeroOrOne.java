package org.bp;


public class ZeroOrOne {

    public int knapsack(int[] weight, int n, int w) {
        boolean[][] state = new boolean[n][w + 1];
        state[0][0] = true;
        state[0][weight[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                // 不把第i个物品放入背包
                if (state[i - 1][j]) {
                    state[i][j] = state[i - 1][j];
                }
            }

            for (int j = 0; j <= w - weight[i]; j++) {
                if (state[i - 1][j]) {
                    state[i][j +weight[i]] = true;
                }
            }
        }

        for (int i = w; i >= 0; i--) {
            if (state[n - 1][i]) {
                return i;
            }
        }
        return 0;
    }

    // 回溯
    private int max = -1;
    public void getMax(int[] weight, int cn, int cw) {
        int n = 6, w = 9;
        if (cn == n || cw == w) {
            if (cw > max) {
                max = cw;
            }
            return;
        }
        getMax(weight, cn + 1, cw);
        if (cw + weight[cn] <= w) {
            getMax(weight, cn + 1, cw + weight[cn]);
        }
    }


    public int getMaxValue(int[] weight, int[] value, int w, int n) {
        int[][] state = new int[n][w + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w + 1; j++) {
                state[i][j] = -1;
            }
        }

        state[0][0] = 0;
        state[0][weight[0]] = value[0];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= w; j++) {
                if (state[i - 1][j] >= 0) {
                    // 不放
                    state[i][j] = state[i - 1][j];
                }
            }

            for (int j = 1; j <= w - weight[i]; j++) {
                if (state[i - 1][j] >= 0) {
                    int v = state[i - 1][j] + value[i];
                    if (v > state[i][j + weight[i]]) {
                        state[i][j + weight[i]] = v;
                    }
                }
            }
        }

        int maxV = -1;
        for (int i = w; i >= 0; i--) {
            if (state[n - 1][i] > maxV) {
                maxV = state[n - 1][i];
            }
        }
        return maxV;
    }

    public static void main(String[] args) {
        ZeroOrOne zeroOrOne = new ZeroOrOne();
        // System.out.println(zeroOrOne.knapsack(new int[]{0, 2, 2, 6, 5, 4}, 6, 3));
        //
        // zeroOrOne.getMax(new int[]{0, 2, 2, 6, 5, 4}, 0, 0);
        // System.out.println(zeroOrOne.max);


        System.out.println(zeroOrOne.getMaxValue(new int[]{2, 2, 6, 5, 4}, new int[]{6, 3, 5, 4, 6}, 10, 5));
    }
}
