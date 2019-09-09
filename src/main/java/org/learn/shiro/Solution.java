package org.learn.shiro;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: yxk
 * @date: 2019-03-25 16:39
 */
public class Solution {


    // [1,8,6,2,5,4,8,3,7]
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int sum = (end - start) * Math.min(height[start], height[end]);
        while (start < end) {
            if (height[start] <= height[end]) {
                start++;
            } else {
                end--;
            }
            sum = Math.max(sum, (end - start) * Math.min(height[start], height[end]));
        }
        return sum;
    }


    /**
     *
     给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。

     示例:

     输入: s = 7, nums = [2,3,1,2,4,3]
     输出: 2
     解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
     */

    public int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int end = nums.length;
        int sum = 0;
        int sub = end + 1;
        for (int i = 0; i < end; i++) {
            sum += nums[i];
            while (sum >= s) {
                sub = Math.min(sub, i - start + 1);
                sum -= nums[start++];
            }
        }
        return sub == end + 1 ? 0 : sub;
    }


    public int subArrayLen(int[] arr) {
        int preSum = arr[0];
        int curSum = preSum;
        for (int i = 1; i < arr.length; i++) {
            preSum = preSum > 0 ? preSum + arr[i] : arr[i];
            curSum = Math.max(preSum, curSum);
        }
        return curSum;
    }


    public int climbStairs(int n) {


        if (n == 1) return 1;
        if (n == 2) return 2;

        int ret = 0;
        int pre = 2;
        int prepre = 1;
        for (int i = 3; i <= n; ++i) {
            ret = pre + prepre;
            prepre = pre;
            pre = ret;
        }
        return ret;

    }


    // 输入: [1,2,3,4,5,6,7] 和 k = 3
    // 输出: [5,6,7,1,2,3,4]
    public void rotate(int[] nums, int k) {

    }

    // 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    //
    // 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
    //
    // 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    //
    // 示例 1:
    //
    // 输入: [7,1,5,3,6,4]
    // 输出: 7
    // 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
    //      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
    // 示例 2:
    //
    // 输入: [1,2,3,4,5]
    // 输出: 4
    // 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
    //      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
    //      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
    // 示例 3:
    //
    // 输入: [7,6,4,3,1]
    // 输出: 0
    // 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
    // [3,3,5,0,0,3,1,4]
    public int maxProfit(int[] prices) {
        int sum = 0;
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        for (int i = 0; i < length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                sum += prices[i + 1] - prices[i];
            }
        }
        return sum;
    }

    public void testRead() {
        try {
            StringBuilder sb = new StringBuilder();
            char[] buf = new char[1024];
            FileReader file = new FileReader("file");
            while (file.read(buf) > 0) {
                sb.append(buf);
            }
            String s = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));


        System.out.println(solution.subArrayLen(new int[]{1,2,3,-5,7,8}));


        System.out.println(solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));


        System.out.println(solution.climbStairs(24));


        System.out.println(solution.maxProfit(new int[]{8,6,4,3,3,2,3,5,8,3,8,2,6}));


    }



}
