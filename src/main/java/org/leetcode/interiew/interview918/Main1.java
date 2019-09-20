package org.leetcode.interiew.interview918;

import java.util.Scanner;

public class Main1 {

    private static int getCount(int[] nums) {

        int sum = 0;
        for (int i : nums) {
            sum ^= i;
        }
        return sum;
    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(getCount(arr));

    }
}
