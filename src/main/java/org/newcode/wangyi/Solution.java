package org.newcode.wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    /**
     * 独立的小易
     * @return
     */
    public int alive(int x, int f, int d, int p) {
        int day = 0;
        while (f > 0 && d >= x) {
            d -= x;
            f--;
            day++;
        }
        int cost = x + p;
        int i = d / cost;
        return day + i;
    }

    public static void main(String[] args) {

        // Solution solution = new Solution();
        //
        // Scanner scanner = new Scanner(System.in);
        // int x = scanner.nextInt();
        // int f = scanner.nextInt();
        // int d = scanner.nextInt();
        // int p = scanner.nextInt();
        // System.out.println(d);
        // System.out.println(solution.alive(x, f, d, p));


        Scanner sc = new Scanner(System.in);
        // n 个点
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            y[i] = sc.nextInt();
        }
        sc.close();
        int[] dis = new int[n];
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dis[k] = Math.abs(x[k] - x[i]) + Math.abs(y[k] - y[j]);
                }
                Arrays.sort(dis);
                int temp = 0;
                for (int r = 0; r < n; r++) {
                    temp += dis[r];
                    result[r] = Math.min(temp, result[r]);
                }
            }
        }
        for (int i = 0; i < n - 1; i++) {
            System.out.print(result[i] + " ");
            System.out.println(result[n - 1]);
        }
    }
}
