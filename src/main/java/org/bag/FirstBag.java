package org.bag;

public class FirstBag {

    public static int getMaxValue(int[] weight, int[] value, int w, int n){

        int[][] table = new int[n+1][w+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=w; j++) {
                if (weight[i] > j) {
                    // 当前物品i的重量比背包容量j大。
                    table[i][j] = table[i - 1][j];
                } else {
                    table[i][j] = Math.max(table[i-1][j], table[i-1][j-weight[i]] + value[i]);
                }
            }
        }
        return table[n][w];
    }

    public static void main(String[] args) {
        int n=5, w=10;
        int[] value = {0, 6, 3, 5, 4, 6};
        int[] weight = {0, 2, 2, 6, 5, 4};
        System.out.println(getMaxValue(weight, value, w, n));


        getMax(0, 0);
        System.out.println(FirstBag.max);

        Pascal pascal = new Pascal();
        Pascal pascal1 = new Pascal();
        System.out.println(pascal.toString());
        System.out.println(pascal1.toString());

    }

    private static int max = -1;
    private static int[] weight = {2, 2, 6, 5, 4};
    private static boolean[][] visited = new boolean[5][10];
    public static void getMax(int cn, int cw) {
        int n = 5, w = 10;
        if (cn == n || cw == w) {
            if (cw > max) {
                max = cw;
            }
            return;
        }
        if (visited[cn][cw]) {
            return;
        }
        visited[cn][cw] = true;
        getMax(cn + 1, cw);
        if (cw + weight[cn] <= w) {
            getMax(cn + 1, cw + weight[cn]);
        }
    }
}
