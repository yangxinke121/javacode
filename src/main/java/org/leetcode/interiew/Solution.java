package org.leetcode.interiew;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public List<String> split(String s, char ch) {
        char[] chars = s.toCharArray();
        List<String> list = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ch && start != i) {
                list.add(s.substring(start, i));
                start = i + 1;
            } else if (chars[i] == ch) {
                start = i + 1;
            }
            if (i == chars.length - 1 && start != chars.length) {
                list.add(s.substring(start, i + 1));
            }
        }
        return list;
    }

    public int atoi(String str) {
        // str = str.trim();
        // boolean flag = false;
        // if (str.charAt(0) == '-') {
        //     flag = true;
        //     str = str.substring(1);
        // } else if (str.charAt(0) == '+') {
        //     str = str.substring(1);
        // }
        //
        // if (str.charAt(0) < '1' || str.charAt(0) > '9') {
        //     return 0;
        // }
        // int temp = 0;
        // int res = 0;
        // char[] chars = str.toCharArray();
        // for (int i = 0; i < chars.length; i++) {
        //     if (chars[i] >= '0' && chars[i] <= '9') {
        //         int t1 = chars[i] - '0';
        //         temp = temp * 10 + t1;
        //         if (!flag) {
        //             if (temp < res) {
        //                 return Integer.MAX_VALUE;
        //             } else {
        //                 res = temp;
        //             }
        //         } else {
        //             if (-temp > res) {
        //                 return Integer.MIN_VALUE;
        //             } else {
        //                 res = -temp;
        //             }
        //         }
        //     }
        // }
        // return res;

        str = str.trim();
        int result = 0;
        int symbol = 1;
        char[] array = str.toCharArray();
        if (array.length <= 0) {
            return 0;
        }
        if (array[0] == '-') {
            symbol = -1;
        }
        for (int i = (array[0] == '+' || array[0] == '-') ? 1 : 0; i < array.length; i++) {
            if (!('0' <= array[i] && array[i] <= '9')) {
                return result * symbol;
            }
            int result1 = result * 10 + symbol * (array[i] - '0');
            if (symbol == 1) {
                if (result1 > result) {
                    result = result1;
                } else {
                    return Integer.MAX_VALUE;
                }
            } else {
                if (result1 < result) {
                    result = result1;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
        }
        return result;
    }


    public ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy;
            dummy = head;
            head = next;
        }
        return dummy;
    }

    /**
     * 区间覆盖问题
     */
    public void interval() {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int T = scanner.nextInt();
        Job[] jobs = new Job[N];
        for (int i = 0; i < N; i++) {
            jobs[i] = new Job(scanner.nextInt(), scanner.nextInt());
        }
        Arrays.sort(jobs);
        // 区间起始位置
        int start = 0;
        int end = 1;
        int ans = 1;
        for (int i = 0; i < N; i++) {
            int s = jobs[i].s;
            int t = jobs[i].t;
            if (i == 0 && s > 1) {
                break;
            }
            if (s <= start) {
                end = Math.max(t, end);
            } else {
                ans++;
                start = end;
                if (s <= start) {
                    end = Math.max(t, end);
                } else {
                    break;
                }
            }
            if (end >= T) {
                break;
            }
        }
        if (end < T) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    public void print_subset(int n, int s) {
        for (int i = 0; i < n; i++) {
            if ((s & (1 << i)) > 0) {
                System.out.printf("%d ", i);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        for (int i = 0; i < (1 << 3); i++) {
            solution.print_subset(3, i);
        }

        // List<String> split = solution.split(":7642::323:", ':');
        // for (String s : split) {
        //     System.out.println(s);
        // }
        //
        //
        // System.out.println(solution.atoi("+23"));
        // System.out.println(solution.atoi("-123"));
        // System.out.println(solution.atoi("2147483649"));
        // System.out.println(solution.atoi("10000"));
        // System.out.println(solution.atoi("11a"));
        //
        //
        // ListNode head = new ListNode(1);
        // head.next = new ListNode(2);
        // head.next.next = new ListNode(3);
        // head.next.next.next = new ListNode(4);
        // ListNode reverse = solution.reverse(head);
        // while (reverse != null) {
        //     System.out.printf("%d ", reverse.val);
        //     reverse = reverse.next;
        // }
    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Job implements Comparable<Job> {

    public int s;

    public int t;

    public Job(int s, int t) {
        this.s = s;
        this.t = t;
    }

    @Override
    public int compareTo(Job o) {
        int x = this.s - o.s;
        if (x == 0) {
            return this.t - o.t;
        }
        return x;
    }
}