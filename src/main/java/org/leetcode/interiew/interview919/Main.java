package org.leetcode.interiew.interview919;

import java.util.Scanner;

public class Main {

    private static int getCount(int n) {
        if (n == 1) {
            return 1;
        }
        return n * getCount(n - 1);
    }

    private static int getI(int m) {
        int k = 1;
        int temp = 1;
        while (temp < m) {
            temp = (int) Math.pow(2, k++);
        }
        return k - 1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = getI((int) Math.pow(2, n) - 1);
        System.out.println(i);
        System.out.println(getCount(i) % ((int) Math.pow(10, 6) + 1));
    }
}
