package org.leetcode.interiew;

import java.util.*;

public class Main {

    private int count;

    public int combinationSum(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        combinationSum(0, nums, target);
        return count;
    }

    private void combinationSum(int cur, int[] nums, int target) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            count++;
            return;
        }
        for (int i = cur; i < nums.length; i++) {
            if (target < nums[i]) {
                break;
            }
            combinationSum(i, nums, target - nums[i]);
            target += nums[i];
        }
    }

    public String reverseWords(String s) {

        char[] chars = s.toCharArray();

        int len = chars.length - 1;
        reverse(chars, 0, len);

        int start = 0;
        int end = 0;
        for (char c : chars) {
            if (c == ' ') {
                reverse(chars, start, end - 1);
                start = end + 1;
                end++;
            } else if (end == len) {
                reverse(chars, start, end);
                break;
            } else {
                end++;
            }
        }
        return new String(chars);
    }

    private void reverse(char[] arr, int start, int end) {
        int mid = (end - start) >> 1;
        for (int i = 0; i <= mid; i++) {
            char temp = arr[start + i];
            arr[start + i] = arr[end - i];
            arr[end - i] = temp;
        }
    }

    private void count(int[] arrs) {

        // int length = arrs.length;
        // if (length == 1) {
        //     System.out.print(arrs[0] + " " + 1);
        //     return;
        // }
        // int[][] dp = new int[length][length + 1];
        // dp[0][1] = arrs[0];
        // dp[1][1] = Math.max(arrs[1], arrs[0]);
        // for (int i = 2; i < length; i++) {
        //     dp[i] = Math.max(dp[i - 2] + arrs[i], dp[i - 1]);
        // }
    }


    private static int maxValue = Integer.MIN_VALUE;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int length = split.length;
        for (int i = length - 1; i >= 0; i--) {
            sb.append(split[i]).append(" ");
        }
        System.out.println(sb.toString().substring(0, sb.toString().length() - 1));




        // reverser(chars, 0, length - 1);
        // int start = 0;
        // int end = 0;
        // for (char c : chars) {
        //     if (c == ' ') {
        //         reverser(chars, start, end - 1);
        //         start = end + 1;
        //         end++;
        //     } else if (end == length) {
        //         reverser(chars, start, end);
        //         break;
        //     } else {
        //         end++;
        //     }
        // }
        // System.out.println(String.valueOf(chars));

        // Scanner scanner = new Scanner(System.in);
        // String s = scanner.nextLine();
        // String[] split = s.split(",");
        // List<String> list = new ArrayList<>();
        // for (String s1 : split) {
        //     list.add(s1);
        // }
        // Collections.sort(list, new Comparator<String>() {
        //     @Override
        //     public int compare(String o1, String o2) {
        //         return (o1 + o2).compareTo(o2 + o1);
        //     }
        // });
        // for (String s1 : list) {
        //     System.out.print(s1);
        // }

        // Scanner scanner = new Scanner(System.in);
        // int n = scanner.nextInt();
        // int m = scanner.nextInt();
        // int[] w = new int[n];
        // int[] v = new int[n];
        // for (int i = 0; i < n; i++) {
        //     w[i] = scanner.nextInt();
        // }
        // for (int i = 0; i < n; i++) {
        //     v[i] = scanner.nextInt();
        // }
        // getValue(w, v, n, m, 0, 0, 0);
        // System.out.println(maxValue);
    }

    private static void getValue(int[] w, int[] v, int n, int m, int i, int sum, int valueSum) {
        if (sum >= m || i >= n) {
            if (valueSum > maxValue) {
                maxValue = valueSum;
            }
            return;
        }
        getValue(w, v, n, m, i + 1, sum, valueSum);
        if (sum + w[i] <= m) {
            getValue(w, v, n, m, i + 1, sum + w[i], valueSum + v[i]);
        }
    }

    private static void reverser(char[] chs, int start, int end) {
        int mid = (end - start) >> 1;
        for (int i = 0; i <= mid; i++) {
            char temp = chs[start + i];
            chs[start + i] = chs[end - i];
            chs[end - i] = temp;
        }
    }
}

class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1(int x) {
        val = x;
    }
}
