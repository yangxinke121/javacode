package org.leetcode.interiew.interview917;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");

        int n;
        int m;
        try {
            n = Integer.parseInt(s1[0]);
            m = Integer.parseInt(s1[1]);
        } catch (Exception e) {
            System.out.println("error");
            return;
        }
        boolean flag = false;
        if (n < 0) {
            n = -n;
            flag = true;
        }
        if (n > 9999999 && n < 100000000) {
            if (m == 0) {
                if (flag) {
                    System.out.println("-" + n);
                } else {
                    System.out.println(n);
                }
                return;
            }
            if (m > 0 && m < 9) {
                StringBuilder sb = new StringBuilder(String.valueOf(n));
                StringBuilder str = sb.deleteCharAt(m - 1);
                char[] chars = str.toString().toCharArray();

                Arrays.sort(chars);
                sb = new StringBuilder();
                for (int i = chars.length - 1; i >= 0; i--) {
                    sb.append(chars[i]);
                }
                if (flag) {
                    System.out.println("-" + sb.toString());
                } else {
                    System.out.println(sb.toString());
                }
            } else {
                System.out.println("error");
            }
        } else {
            System.out.println("error");
        }
    }
}
