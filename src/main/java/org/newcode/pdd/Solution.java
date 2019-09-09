package org.newcode.pdd;

import java.util.Scanner;

public class Solution {

    /**
     * 三个数乘积最大
     *
     * @param nums
     * @return
     */
    public long maxProduct(int[] nums) {
        long max1 = 0;
        long max2 = 0;
        long max3 = 0;
        long min1 = 0;
        long min2 = 0;
        for (int num : nums) {
            if (num != 0) {
                if (num > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = num;
                } else if (num > max2) {
                    max3 = max2;
                    max2 = num;
                } else if (num > max3) {
                    max3 = num;
                } else if (num < min1) {
                    min2 = min1;
                    min1 = num;
                } else if (num > min1 && num < min2) {
                    min2 = num;
                }
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(nums));
    }
}
