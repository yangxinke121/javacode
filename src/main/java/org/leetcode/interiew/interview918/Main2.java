package org.leetcode.interiew.interview918;

import java.util.Scanner;

public class Main2 {

    private static int getCount(int[] nums) {

        if (nums.length < 2) {
            return nums[0];
        }

        int preSum = nums[0];
        int sum = preSum;
        for (int i = 1; i < nums.length; i++) {
            preSum = preSum > 0 ? preSum + nums[i] : nums[i];
            sum = Math.max(sum, preSum);
        }
        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String substring = str.substring(1, str.length() - 1);
        if (substring.equals("")) {
            System.out.println(0);
            return;
        }
        String[] split = substring.split(",");
        int[] nums = new int[split.length];
        int k = 0;
        for (String s1 : split) {
            nums[k++] = Integer.parseInt(s1.trim());
        }
        System.out.println(getCount(nums));
    }
}
