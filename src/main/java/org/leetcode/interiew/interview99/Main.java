package org.leetcode.interiew.interview99;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 奇安信
 */
public class Main {

    public static int get(int[] nums, int l, int r, int k) {
        if ((nums[k] - l) * (nums[k] - r) <= 0) {
            return nums[k];
        } else if (l > nums[k]) {
            return get(nums, l, r, (k + 1) * 2);
        } else {
            return get(nums, l, r, (k + 1) * 2 - 1);
        }
    }
    //
    // public static void main(String[] args) {
    //
    //
    //     Scanner sc = new Scanner(System.in);
    //     String s = sc.nextLine();
    //     String[] s1 = s.split(" ");
    //
    //     String s2 = sc.nextLine();
    //     String[] s3 = s2.split(" ");
    //
    //     int kill = sc.nextInt();
    //
    //     int[] temp1 = new int[s1.length];
    //     int k = 0;
    //     for (String s11 : s1) {
    //         temp1[k++] = Integer.parseInt(s11);
    //     }
    //     int[] temp2 = new int[s1.length];
    //     k = 0;
    //     for (String s22 : s3) {
    //         temp2[k++] = Integer.parseInt(s22);
    //     }
    //
    //     Set<Integer> set = new HashSet<>();
    //     while (true) {
    //         for (int i = 0; i < temp2.length; i++) {
    //             if (temp2[i] == kill) {
    //
    //             }
    //         }
    //     }
    //     System.out.println(count);

        // Scanner sc = new Scanner(System.in);
        // int m = sc.nextInt();
        // int i1 = (int) Math.pow(2, m) - 1;
        // int[] nums = new int[i1];
        // for (int i = 0; i < i1; i++) {
        //     nums[i] = sc.nextInt();
        // }
        // int l = sc.nextInt();
        // int r = sc.nextInt();
        //
        // int count1 = 0;
        // int count2 = 0;
        // for (int num : nums) {
        //     if (num == l) {
        //         count1++;
        //     }
        //     if (num == r) {
        //         count2++;
        //     }
        // }
        // if (count1 == 0 || count2 == 0) {
        //     System.out.println(-1);
        //     return;
        // }
        // System.out.println(get(nums, l, r, 0));
    // }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s1 = in.nextLine().split(" ");
        String[] s2 = in.nextLine().split(" ");
        String str = in.nextLine();
        List<String> list = new ArrayList<>();
        GetCount(list, s1, s2, str);
        System.out.println(list.size());
    }

    private static void GetCount(List<String> list, String[] s1, String[] s2, String mark) {
        for (String value : s1) {
            if (value.equals(mark)) {
                list.add(value);
            }
        }
        for (int i = 0; i < s2.length; i++) {
            if (s2[i].equals(mark)) {
                String s = s1[i];
                GetCount(list, s1, s2, s);
            }
        }
    }
}
