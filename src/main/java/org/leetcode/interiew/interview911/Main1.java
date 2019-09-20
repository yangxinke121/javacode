package org.leetcode.interiew.interview911;

import java.util.Scanner;

public class Main1 {

    public void get(int m, int n) {

        int getgcd = getgcd(m, n);
        int min = getMin(m, n);
        System.out.print(getgcd + " " + min);

    }

    private int getgcd(int m, int n) {

        int gcd = 0;
        if (m < n) {
            m = m + n;
            n = m - n;
            m = m - n;
        }
        if (m % n == 0) {
            gcd = n;
        }
        while (m % n > 0) {
            n = m % n;
            if (m < n) {
                m = m + n;
                n = m - n;
                m = m - n;
            }
            if (m % n == 0) {
                gcd = n;
            }
        }
        return gcd;
    }

    private int getMin(int m, int n) {
        return (m * n) / getgcd(m, n);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String trim = s.trim();
        String[] s1 = trim.split(" ");

        int[] temp = new int[2];
        temp[0] = Integer.parseInt(s1[0]);
        temp[1] = Integer.parseInt(s1[s1.length - 1]);
        if (s1.length == 1) {
            System.out.println(s1[0]);
            return;
        }
        Main1 main1 = new Main1();
        main1.get(temp[0], temp[1]);
    }
}
