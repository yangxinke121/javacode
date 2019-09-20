package org.leetcode.interiew.interview917;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int length = str.length();
        if (length != 18) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                System.out.println(0);
                return;
            }
        }
        String substring = str.substring(14);
        String s = str.substring(6, 10);

        char[] chars = substring.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        for (int i = 3; i >= 0; i--) {
            sb.append(chars[i]);
        }
        System.out.println(Integer.parseInt(sb.toString()) + Integer.parseInt(s));
    }
}
