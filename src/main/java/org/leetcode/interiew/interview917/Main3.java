package org.leetcode.interiew.interview917;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int[] mark = new int[8];
        int sum1 = 0;
        int sum2 = 0;
        if (a > 255 || a < 128) {
            System.out.println("error");
            return;
        }

        for (int i = 7; i >= 0; i--) {
            mark[i] = a % 2;
            a /= 2;
        }
        for (int i = 0; i < 8; i++) {
            if (mark[i] == 1) {
                sum1 = sum1 + b;
                sum2 = sum2 + 130;
            }
            if (mark[i] == 0) {
                sum2 = sum2 + 90;
                sum1 = sum1 + c;
            }
        }
        if (sum1 > sum2) {
            System.out.println("win");
            return;
        }
        if (sum1 < sum2) {
            System.out.println("lose");
            return;
        }
        System.out.println("deuce");
    }
}
