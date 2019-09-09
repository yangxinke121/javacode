package org.leetcode.array;

import java.util.*;

public class Solution {

    /**
     * 56 合并区间
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {

        // 方法一

        // int row = intervals.length;
        //
        // int[] start = new int[row];
        // int[] end = new int[row];
        // for (int i = 0, j = 0; i < row; i++) {
        //     start[j] = intervals[i][0];
        //     end[j] = intervals[i][1];
        //     j++;
        // }
        //
        // Arrays.sort(start);
        // Arrays.sort(end);
        //
        // List<int[]> list = new ArrayList<>();
        // for (int i = 0, j = 0; i < row; i++) {
        //     if (i == row - 1 || start[i + 1] > end[i]) {
        //         list.add(new int[]{start[j], end[i]});
        //         j = i + 1;
        //     }
        // }
        // return list.toArray(new int[list.size()][2]);

        // 方法二

        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int[] temp = intervals[0];
        list.add(temp);

        for (int[] i : intervals) {
            if (i[0] <= temp[1]) {
                temp[1] = Math.max(i[1], temp[1]);
            } else {
                temp = i;
                list.add(temp);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    /**
     * 202 快乐数
     * @param n
     * @return
     */
    public boolean isHappy(int n) {

        int sum = n;
        while (sum != 1) {
            sum = getNum(sum);
            if (sum == 4) {
                return false;
            }
        }
        return true;
    }

    private int getNum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }

    /**
     * 34  在排序数组中查找元素的第一个和最后一个位置
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        return new int[]{searchFirst(nums, target), searchLast(nums, target)};
    }

    private int searchFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == 0 || nums[mid] != nums[mid - 1]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    private int searchLast(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == nums.length - 1 || nums[mid] != nums[mid + 1]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 40 组合总和 Ⅱ
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(0, candidates, target, new ArrayList<>(), lists);
        return lists;
    }

    private void combinationSum2(int cur, int[] candidates, int target, List<Integer> list, List<List<Integer>> lists) {
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
            // if (i > cur && candidates[i] == candidates[i - 1]) {
            //     continue;
            // }
            list.add(candidates[i]);
            combinationSum2(i + 1, candidates, target - candidates[i], list, lists);
            list.remove(list.size() - 1);
        }
    }

    /**
     * 150 逆波兰表达式求值
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("*")) {
                Integer cur = stack.pop();
                cur = stack.pop() * cur;
                stack.push(cur);
                continue;
            }
            if (token.equals("/")) {
                Integer cur = stack.pop();
                cur = stack.pop() / cur;
                stack.push(cur);
                continue;
            }
            if (token.equals("+")) {
                Integer cur = stack.pop();
                cur = stack.pop() + cur;
                stack.push(cur);
                continue;
            }
            if (token.equals("-")) {
                Integer cur = stack.pop();
                cur = stack.pop() - cur;
                stack.push(cur);
                continue;
            }
            stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        List<List<Integer>> lists = solution.combinationSum2(new int[]{2,5,2,1,2}, 5);
        for (List<Integer> list : lists) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        System.out.println();

        Set<List<Integer>> set = new HashSet<>(lists);
        for (List<Integer> list : set) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }


        String[] s = new String[10];
        System.out.println(s[1]);

        List<Integer> list = new ArrayList<>();

        int pre = 0;
        int then = 5;
        int temp = 5;
        for (int i = 0; i < 10000; i++) {
            for (int j = 1; j <= then - pre; j++) {
                list.add(j);
                i++;
            }
            pre = then;
            temp *= 2;
            then += temp;
        }


        System.out.println(solution.Count(10));
        System.out.println(list.get(99));
    }

    public int Count(int i){
        int mark = 5;
        int sum=0;

        while (true){
            sum = sum+mark;
            if (sum>=i){
                break;
            }
            mark=mark*2;
        }
        return i-(sum-mark);
    }
}
