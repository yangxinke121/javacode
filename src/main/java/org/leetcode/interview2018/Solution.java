package org.leetcode.interview2018;

import java.util.*;

public class Solution {

    /**
     * 求众数
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int temp = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                temp = nums[i];
                count = 1;
            } else if (temp == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return temp;
    }

    /**
     * 子集
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        int n = (1 << length) - 1;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = n; i >= 1; i--) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < length; j++) {
                if (((i >> j) & 1) == 1) {
                    list.add(nums[j]);
                }
            }
            result.add(list);
        }
        result.add(new ArrayList<>());
        return result;
    }

    /**
     * 子集Ⅱ
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDup(0, nums, lists, list);
        return lists;
    }

    private void subsetsWithDup(int i, int[] nums, List<List<Integer>> lists, List<Integer> list) {

        lists.add(new ArrayList<>(list));
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            list.add(nums[j]);
            subsetsWithDup(j + 1, nums, lists, list);
            list.remove(list.size() - 1);
        }
    }

    /**
     * 39 组合总和
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationSum(0, candidates, target, list, lists);
        return lists;
    }

    private void combinationSum(int cur, int[] candidates, int target, List<Integer> list, List<List<Integer>> lists) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = cur; i < candidates.length; i++) {
            if (target < candidates[i]) {
                break;
            }
            list.add(candidates[i]);
            combinationSum(i, candidates, target - candidates[i], list, lists);
            list.remove(list.size() - 1);
        }
    }

    /**
     * 最小差值Ⅰ
     *
     * @param A
     * @param K
     * @return
     */
    public int smallestRangeI(int[] A, int K) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : A) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        return Math.max(0, max - min - 2 * K);
    }

    /**
     * 三数之和
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 2) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSum(nums, 0 - nums[i], i + 1, i, lists);
            }
        }
        return lists;
    }

    private void twoSum(int[] nums, int k, int start, int cur, List<List<Integer>> lists) {
        int end = nums.length - 1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum > k) {
                end--;
            } else if (sum < k) {
                start++;
            } else {
                if (start == cur + 1 || nums[start] != nums[start - 1]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[start]);
                    list.add(nums[end]);
                    list.add(nums[cur]);
                    lists.add(list);
                }
                start++;
                end--;
            }
        }
    }

    /**
     * 3 无重复字符的最长子串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        // int n = s.length();
        // int max = 0;
        // int[] temp = new int[128];
        // for (int i = 0, j = 0; i < n; i++) {
        //     // 最开始的起始位置
        //     j = Math.max(temp[s.charAt(i)], j);
        //     max = Math.max(max, i - j + 1);
        //     temp[s.charAt(i)] = i + 1;
        // }
        // return max;

        int n = s.length();
        int max = 0;
        int[] temp = new int[128];
        for (int i = 0, j = 0; i < n; i++) {
            j = Math.max(temp[s.charAt(i)], j);
            max = Math.max(max, i - j + 1);
            temp[s.charAt(i)] = i + 1;
        }
        return max;
    }

    /**
     * 9 回文数
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        // if (x < 0) {
        //     return false;
        // }
        // String s = String.valueOf(x);
        // int len = s.length();
        // int mid = len >> 1;
        // for (int i = 0; i <= mid; i++) {
        //     if (s.charAt(i) != s.charAt(len - 1 - i)) {
        //         return false;
        //     }
        // }
        // return true;

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }

        return x == reverse || x == reverse / 10;
    }

    /**
     * 有效的括号
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        {
            map.put(')', '(');
            map.put('}', '{');
            map.put(']', '[');
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || !stack.pop().equals(map.get(ch))) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    /**
     * 相交链表
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }

    /**
     * 2的幂
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    /**
     * 292 Nim游戏
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        return (n & 3) != 0;
    }

    /**
     * 557. 反转字符串中的单词 III
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        char[] chars = s.toCharArray();
        int length = chars.length;
        int n = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ' || i == length - 1) {
                for (int j = 0; j < (i - n + 1) / 2; j++) {
                    char temp = chars[n + j];
                    if (i == length - 1) {
                        chars[n + j] = chars[i - j];
                        chars[i - j] = temp;
                    } else {
                        chars[n + j] = chars[i - 1 - j];
                        chars[i - 1 - j] = temp;
                    }
                }
                n = i + 1;
            }
        }
        return new String(chars);
    }

    /**
     * 727 最小窗口子序列
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int m = t.length();
        int n = s.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        int start = 0;
        int len = n + 1;
        for (int i = 1; i <= n; i++) {
            if (dp[m][i] != 0) {
                if (i - dp[m][i] < len) {
                    start = dp[m][i];
                    len = i - dp[m][i];
                }
            }
        }
        return len == n + 1 ? "" : s.substring(start, start + len);
    }

    public String minWindows1(String S, String T) {
        int m = S.length();
        int n = T.length();
        int start = -1;
        int minLen = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (i < m) {
            if (S.charAt(i) == T.charAt(j)) {
                if (++j == n) {
                    int end = i + 1;
                    while (--j >= 0) {
                        while (S.charAt(i--) != T.charAt(j));
                    }
                    ++i;
                    ++j;
                    if (end - i < minLen) {
                        minLen = end - i;
                        start = i;
                    }
                }
            }
            i++;
        }
        return (start != -1) ? S.substring(start, minLen) : "";
    }

    /**
     * 全排列
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] book = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, 0, list, lists, book);
        return lists;
    }

    private void dfs(int[] nums, int n, List<Integer> list, List<List<Integer>> lists, boolean[] book) {

        if (n == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (book[i] || i > 0 && nums[i] == nums[i - 1] && !book[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            book[i] = true;
            dfs(nums, n + 1, list, lists, book);
            book[i] = false;
            list.remove(list.size() - 1);

        }
    }

    /**
     * 31 下一个排列
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] < nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 寻找数组的中心索引
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int leftSum = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    /**
     * 至少是其他数字两倍的最大数
     * @param nums
     * @return
     */
    public int dominantIndex(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int mid = sum / 2 + 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > mid) {
                return i;
            }
        }
        return -1;
    }

    public void sushu(int n) {
        for (int i = 1; i <= n; i++) {
            if (m(i)) {
                System.out.print(i + " ");
            }
        }
    }

    private boolean m(int i) {
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        // List<List<Integer>> subsets = solution.subsetsWithDup(new int[]{1, 2, 3});
        // for (List<Integer> list : subsets) {
        //     for (Integer i : list) {
        //         System.out.printf("%d ", i);
        //     }
        //     System.out.println();
        // }

        System.out.println(solution.smallestRangeI(new int[]{0, 10}, 2));


        List<List<Integer>> lists = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.printf("%d ", i);
            }
            System.out.println();
        }
        //
        // ListNode p1 = new ListNode(1);
        // p1.next = new ListNode(3);
        // p1.next.next = new ListNode(5);
        // p1.next.next.next = new ListNode(7);
        // p1.next.next.next.next = new ListNode(9);
        // p1.next.next.next.next.next = new ListNode(11);
        //
        // ListNode p2 = new ListNode(2);
        // p2.next = new ListNode(4);
        // p2.next.next = new ListNode(6);
        // p2.next.next.next = new ListNode(8);
        // solution.getIntersectionNode(p1, p2);

        System.out.println(solution.canWinNim(4));

        System.out.println(solution.reverseWords("Let's take LeetCode contest"));

        List<List<Integer>> lists1 = solution.combinationSum(new int[]{2, 3, 5}, 10);
        for (List<Integer> list : lists1) {
            for (Integer i : list) {
                System.out.printf("%d ", i);
            }
            System.out.println();
        }

        // System.out.println(solution.minWindow("abaacxbcbbbbacc", "cbc"));
        //
        List<List<Integer>> permute = solution.permute(new int[]{1, 2, 2});
        for (List<Integer> l : permute) {
            for (Integer i : l) {
                System.out.printf("%d ", i);
            }
            System.out.println();
        }
        //
        // System.out.println(solution.dominantIndex(new int[]{3,6,1,0}));
        //
        // System.out.println(Integer.toBinaryString(1000));
    }
}

class ListNode {
    private int val;

    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
