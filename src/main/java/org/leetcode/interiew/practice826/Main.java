package org.leetcode.interiew.practice826;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] score = new int[n];
            for (int i = 0; i < n; i++) {
                score[i] = scanner.nextInt();
            }

            int[][] ints = new int[m][3];
            int[] temp = new int[m];
            int k = 0;
            for (int i = 0; i < m; i++) {
                for (int i1 = 0; i1 < 3; i1++) {
                    if (i1 == 0) {
                        String next = scanner.next();
                        if ("Q".equals(next)) {
                            ints[i][i1] = 'Q' - 'A';
                        } else {
                            ints[i][i1] = 'U' - 'A';
                        }
                    } else {
                        ints[i][i1] = scanner.nextInt();
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                if (ints[i][0] == 'Q' - 'A') {
                    int f = ints[i][1];
                    int s = ints[i][2];
                    if (f > s) {
                        temp[k++] = getHigh(s - 1, f, score);
                    } else {
                        temp[k++] = getHigh(f - 1, s, score);
                    }
                } else {
                    int index = ints[i][1];
                    int sc = ints[i][2];
                    score[index - 1] = sc;
                }
            }

            for (int i = 0; i < k; i++) {
                System.out.println(temp[i]);
            }
        }
    }

    private static int getHigh(int m, int n, int[] arr) {
        int max = -1;
        for (int i = m; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
