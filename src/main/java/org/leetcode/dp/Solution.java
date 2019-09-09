package org.leetcode.dp;

import java.util.*;

public class Solution {

    /**
     * 买卖股票的最佳时机
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }
        int minPrice = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > profit) {
                profit = prices[i] - minPrice;
            }
        }
        return profit;
    }

    /**
     * 最大子序列和
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        int length = nums.length;

        int preSum = nums[0];
        int sum = preSum;
        for (int i = 1; i < length; i++) {
            preSum = preSum > 0 ? preSum + nums[i] : nums[i];
            sum = Math.max(preSum, sum);
        }
        return sum;
    }

    /**
     * 最大子序列和  分治
     *
     * @param nums
     * @return
     */
    public int maxSubArrayDivi(int[] nums) {

        return find(nums, 0, nums.length - 1);
    }

    private int find(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }
        if (low > high) {
            return Integer.MIN_VALUE;
        }
        int mid = low + (high - low) / 2;

        int left = find(nums, low, mid - 1);
        int right = find(nums, mid + 1, high);

        int ml = 0;
        int mr = 0;
        // 获取中间值
        for (int i = mid - 1, sum = 0; i >= low; i--) {
            sum += nums[i];
            if (ml < sum) {
                ml = sum;
            }
        }

        for (int i = mid + 1, sum = 0; i <= high; i++) {
            sum += nums[i];
            if (mr < sum) {
                mr = sum;
            }
        }
        return Math.max(Math.max(left, right), ml + mr + nums[mid]);
    }

    /**
     * 打家劫舍
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {

        // if (nums.length == 0) {
        //     return 0;
        // }
        // if (nums.length == 1) {
        //     return nums[0];
        // }
        // int sum = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     sum = Math.max(findRob(nums, i, 0), sum);
        // }
        // return sum;

        // // 奇数
        // int odd = 0;
        // // 偶数
        // int even = 0;
        // int length = nums.length;
        // for (int i = 0; i < length; i++) {
        //     if (i % 2 == 0) {
        //         even += nums[i];
        //         even = Math.max(odd, even);
        //     } else {
        //         odd += nums[i];
        //         odd = Math.max(odd, even);
        //     }
        // }
        // return Math.max(odd, even);

        // if (nums.length == 0) {
        //     return 0;
        // }
        // if (nums.length == 1) {
        //     return nums[0];
        // }
        //
        // int preSum = 0;
        // int currSum = 0;
        // for (int num : nums) {
        //     int temp = currSum;
        //     currSum = Math.max(preSum + num, currSum);
        //     preSum = temp;
        // }
        // return currSum;

        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }

    private int findRob(int[] nums, int n, int sum) {
        if (n >= nums.length) {
            return sum;
        }
        return Math.max(findRob(nums, n + 1, sum), findRob(nums, n + 2, sum + nums[n]));
    }

    /**
     * 120.三角形最小路径和
     *
     * @param triangle
     * @return
     */
    public int miniumTotal(List<List<Integer>> triangle) {

        int[] mini = new int[triangle.get(triangle.size() - 1).size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                mini[j] = triangle.get(i).get(j) + Math.min(mini[j], mini[j + 1]);
            }
        }
        return mini[0];
    }

    /**
     * 152.乘积最大子序列
     *
     * @param nums
     * @return
     */
    public int maxProduct1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return findMaxProduct(nums, 0, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    private int findMaxProduct(int[] nums, int cur, int sum, int max) {
        if (cur == nums.length) {
            return sum;
        }
        if (sum >= 0 && sum > max) {
            max = sum;
        }
        int maxProduct = findMaxProduct(nums, cur + 1, nums[cur], max);

        int maxProduct1 = findMaxProduct(nums, cur + 1, nums[cur] * (sum == Integer.MIN_VALUE ? 1 : sum), max);
        return Math.max(Math.max(maxProduct, maxProduct1), max);
    }


    public int maxProduct(int[] nums) {
        // DP
        // if (nums.length == 0) {
        //     return 0;
        // }
        // int[][] dp = new int[2][2];
        // // max
        // dp[0][0] = nums[0];
        // dp[0][1] = nums[0];
        // int res = nums[0];
        //
        // for (int i = 1; i < nums.length; i++) {
        //     int x = i % 2;
        //     int y = (i -1) % 2;
        //     dp[x][0] = Math.max(Math.max(dp[y][0] * nums[i], dp[y][1] * nums[i]), nums[i]);
        //     dp[x][1] = Math.min(Math.min(dp[y][0] * nums[i], dp[y][1] * nums[i]), nums[i]);
        //     res = Math.max(res, dp[x][0]);
        // }
        // return res;

        int res = Integer.MIN_VALUE;
        int p1 = 1;
        int p2 = 1;
        for (int num : nums) {
            if (num != 0) {
                p1 *= num;
                res = Math.max(p1, res);
            } else {
                p1 = 1;
                res = Math.max(res, 0);
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != 0) {
                p2 *= nums[i];
                res = Math.max(p2, res);
            } else {
                p2 = 1;
                res = Math.max(res, 0);
            }
        }
        return res;
    }


    // 121 122 123 309 188 714 股票买卖系列

    /**
     * 188 买卖股票的最佳时机
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        // 状态转移方程
        int[][][] dp = new int[length][k + 1][2];
        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];

        for (int i = 1; i < length; i++) {
            for (int j = 1; j <= k; j++) {
                dp[0][j][0] = -prices[0];
                dp[0][j][1] = -prices[0];

                dp[i][0][0] = dp[i - 1][0][0];
                dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);

                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
            }
        }

        int temp = dp[length - 1][0][0];
        for (int i = 1; i <= k; i++) {
            if (dp[length - 1][i][0] > temp) {
                temp = dp[length - 1][i][0];
            }
        }
        return temp;
    }

    /**
     * 300 最长上升子序列
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 322 零钱兑换
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {

        int length = coins.length;
        if (length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        int res = amount + 1;
        for (int i = 1; i <= amount; i++) {
            dp[i] = res;
        }
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * 72 编辑距离
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {

        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int[][] dp = new int[chars1.length + 1][chars2.length + 1];

        for (int i = 0; i <= chars1.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= chars2.length; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }
        return dp[chars1.length][chars2.length];
    }

    /**
     * 编辑距离
     *
     * @param word1
     * @param word2
     * @return
     */
    public int lwstDP(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int[][] dp = new int[chars1.length][chars2.length];

        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] == chars2[0]) {
                dp[i][0] = i;
            } else if (i != 0) {
                dp[i][0] = dp[i - 1][0] + 1;
            } else {
                dp[i][0] = 1;
            }
        }

        for (int i = 0; i < chars2.length; i++) {
            if (chars1[0] == chars2[i]) {
                dp[0][i] = i;
            } else if (i != 0) {
                dp[0][i] = dp[0][i - 1] + 1;
            }
        }

        for (int i = 1; i < chars1.length; i++) {
            for (int j = 1; j < chars2.length; j++) {
                if (chars1[i] == chars2[j]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[chars1.length - 1][chars2.length - 1];
    }

    /**
     * 回溯 编辑距离
     *
     * @param i
     * @param j
     * @param dist
     * @param m 字符串A的长度
     * @param n 字符串B的长度
     */
    private int minDist = Integer.MAX_VALUE;

    public void lwstBT(int i, int j, int dist, int m, int n, char[] A, char[] B) {
        if (i == m || j == n) {
            if (i < m) {
                dist += m - i;
            }
            if (j < n) {
                dist += n - j;
            }
            if (dist < minDist) {
                minDist = dist;
            }
            return;
        }
        if (A[i] == B[j]) {
            lwstBT(i + 1, j + 1, dist, m, n, A, B);
        } else {
            lwstBT(i + 1, j, dist + 1, m, n, A, B);
            lwstBT(i, j + 1, dist + 1, m, n, A, B);
            lwstBT(i + 1, j + 1, dist + 1, m, n, A, B);
        }
    }

    /**
     * 395. 至少有K个重复字符的最长子串
     *
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        if (k < 2) {
            return s.length();
        }
        return helpLongestSubstring(s.toCharArray(), 0, s.length() - 1, k);
    }

    private int helpLongestSubstring(char[] nums, int start, int end, int k) {
        if (end - start + 1 < k) {
            return 0;
        }
        int[] temp = new int[26];
        for (int i = start; i <= end; i++) {
            temp[nums[i] - 'a']++;
        }

        while (end - start + 1 >= k && temp[nums[start] - 'a'] < k) {
            start++;
        }
        while (end - start + 1 >= k && temp[nums[end] - 'a'] < k) {
            end--;
        }

        for (int i = start; i <= end; i++) {
            if (temp[nums[i] - 'a'] < k) {
                return Math.max(helpLongestSubstring(nums, start, i - 1, k), helpLongestSubstring(nums, i + 1, end, k));
            }
        }
        return end - start + 1;
    }

    /**
     * 最长连续序列
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return 1;
        }
        Set<Integer> set = new TreeSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int count = 1;
        int max = 1;
        int[] temp = new int[set.size()];
        int i = 0;
        for (Integer integer : set) {
            temp[i++] = integer;
        }
        for (int j = 1; j < temp.length; j++) {
            if (temp[j] - 1 == temp[j - 1]) {
                count++;
            } else {
                count = 1;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    /**
     * 最长公共子序列
     *
     * @param str1
     * @param str2
     * @return
     */
    public String lcse(String str1, String str2) {
        if (str1 == null || str2 == null || "".equals(str1) || "".equals(str2)) {
            return "";
        }
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int[][] dp = getDp(ch1, ch2);
        int m = ch1.length - 1;
        int n = ch2.length - 1;
        char[] res = new char[dp[m][n]];
        int index = res.length - 1;
        while (index >= 0) {
            if (n > 0 && dp[m][n] == dp[m][n - 1]) {
                n--;
            } else if (m > 0 && dp[m][n] == dp[m - 1][n]) {
                m--;
            } else {
                res[index--] = ch1[m];
                m--;
                n--;
            }
        }
        return String.valueOf(res);
    }

    private int[][] getDp(char[] str1, char[] str2) {
        int[][] dp = new int[str1.length][str2.length];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        for (int i = 1; i < str1.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], str1[i] == str2[0] ? 1 : 0);
        }
        for (int i = 1; i < str2.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], str1[0] == str2[i] ? 1 : 0);
        }

        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (str1[i] == str2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp;
    }

    /**
     * 最长公共子串问题
     *
     * @param str1
     * @param str2
     * @return
     */
    public String lcts1(String str1, String str2) {
        if (str1 == null || str2 == null || "".equals(str1) || "".equals(str2)) {
            return "";
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[][] dp = getDp1(chs1, chs2);
        int end = 0;
        int max = 0;
        for (int i = 0; i < chs1.length; i++) {
            for (int j = 0; j < chs2.length; j++) {
                if (dp[i][j] > max) {
                    end = i;
                    max = dp[i][j];
                }
            }
        }
        return str1.substring(end - max + 1, end + 1);
    }

    private int[][] getDp1(char[] str1, char[] str2) {
        int[][] dp = new int[str1.length][str2.length];
        for (int i = 0; i < str1.length; i++) {
            if (str1[i] == str2[0]) {
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < str2.length; i++) {
            if (str1[0] == str2[i]) {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                if (str1[i] == str2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return dp;
    }

    /**
     * 不同路径
     * <p>
     * 初始化 第 0行， 第 0 列 为 1；
     * dp 方程为 上 和 左 相加
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    /**
     * leetcode 63 不同路径Ⅱ  有障碍物
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[][] dp = new int[rows][cols];

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        for (int i = 0; i < rows && obstacleGrid[i][0] != 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < cols && obstacleGrid[0][i] != 1; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }

    /**
     * 解码方法
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if ((s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '6'))) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }

    /**
     * leetcode  70
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * leetcode 64 最小路径和
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            sum += grid[i][0];
            dp[i][0] = sum;
        }
        sum = 0;
        for (int i = 0; i < cols; i++) {
            sum += grid[0][i];
            dp[0][i] = sum;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][cols - 1];
    }

    /**
     * 单词拆分
     * @param s
     * @param wordDict
     * @return
     */
    private boolean result = false;
    public boolean wordBreak(String s, List<String> wordDict) {
        // helperWordBreak(s, wordDict, "");
        // return result;

        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    private void helperWordBreak(String s, List<String> words, String tempString) {
        if (tempString.length() >= s.length()) {
            if (tempString.equals(s)) {
                System.out.println(tempString);
                result = true;
            }
            return;
        }
        StringBuilder tempStringBuilder = new StringBuilder(tempString);
        for (int j = 0; j < words.size(); j++) {
            tempStringBuilder.append(words.get(j));
            helperWordBreak(s, words, tempStringBuilder.toString());
            tempStringBuilder.delete(tempStringBuilder.toString().length() - words.get(j).length(), tempStringBuilder.toString().length());
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{6, 1, 3, 2, 4, 7}));

        System.out.println(solution.maxSubArrayDivi(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

        //System.out.println(solution.rob(new int[]{104,209,137,52,158,67,213,86,141,110,151,127,238,147,169,138,240,185,246,225,147,203,83,83,131,227,54,78,165,180,214,151,111,161,233,147,124,143}));

        // System.out.println(solution.maxProduct(new int[]{0,-1,4,-4,5,-2,-1,-1,-2,-3,0,-3,0,1,-1,-4,4,6,2,3,0,-5,2,1,-4,-2,-1,3,-4,-6,0,2,2,-1,-5,1,1,5,-6,2,1,-3,-6,-6,-3,4,0,-2,0,2}));

        System.out.println(solution.maxProfit(2, new int[]{1, 2, 4}));

        System.out.println(solution.lengthOfLIS(new int[]{10, 9}));

        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));

        System.out.println(solution.minDistance("horse", "ros"));

        System.out.println(solution.lwstDP("horse", "ros"));

        // System.out.println(solution.lcse("abaacxbcbbbbacc", "cbc"));

        System.out.println(solution.numDecodings("226"));

        System.out.println(solution.uniquePathsWithObstacles(new int[][]{
                {0, 1, 0, 0}
        }));

        System.out.println(solution.wordBreak("applepenapple", Arrays.asList("pen", "apple")));
    }
}
