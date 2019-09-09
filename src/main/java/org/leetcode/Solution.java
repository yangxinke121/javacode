package org.leetcode;

import java.util.*;

public class Solution {

    private Map<Character, Character> map;

    public Solution() {
        map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }


    // public boolean valid(String s) {
    //     Stack<Character> stack = new Stack<>();
    //
    //     for (int i = 0; i < s.length(); i++) {
    //         char c = s.charAt(i);
    //         if (map.containsKey(c)) {
    //             char top = stack.empty() ? '#' : stack.pop();
    //
    //             if (top != map.get(c)) {
    //                 return false;
    //             }
    //         }else {
    //             stack.push(c);
    //         }
    //     }
    //     return stack.isEmpty();
    // }
































    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                char c1 = stack.empty() ? '$' : stack.pop();
                if (c1 != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }


    public String convert(String s, int numRows) {
        // LEETCODEISHIRING
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int row = 0;
        boolean down = true;

        for (char c : s.toCharArray()) {
            rows.get(row).append(c);
            if (row == 0 || row == numRows - 1) {
                down = !down;
            }
            row += down ? -1 : 1;
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder s1 : rows) {
            sb.append(s1);
        }
        return sb.toString();
    }

    /**
     * 行 0 中的字符位于索引 k(2⋅numRows−2) 处;
     * 行 numRows−1 中的字符位于索引 k(2⋅numRows−2)+numRows−1 处;
     * 内部的 行i中的字符位于索引k(2⋅numRows−2)+i 以及(k+1)(2⋅numRows−2)−i 处;
     * @param s
     * @param num
     * @return
     */
    public String convert1(String s, int num) {
        if (num == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int cycNumber = 2 * num - 2;

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < s.length(); j += cycNumber) {
                sb.append(s.charAt(j + i));
                if (i != 0 && i != num - 1 && j + cycNumber - i < s.length()) {
                    sb.append(s.charAt(j + cycNumber - i));
                }
            }
        }
        return sb.toString();
    }


    /**
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     *
     * 输出: [1,2,2,3,5,6]
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }


    public void bubbleSort(int[] arr, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }


    public void insertSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int value = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > value) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = value;
        }
    }

    public void insertSort1(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int value = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > value) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = value;
        }
    }

    public void selectSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int k = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[k]) {
                    k = j;
                }
            }
            if (k != i) {
                int temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public int f(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return f(n - 1) + f(n - 2);
    }

    public ListNode reverse(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode listNode = null;
        while (head != null) {
            ListNode second = head.next;
            head.next = listNode;
            listNode = head;
            head = second;
        }
        return listNode;
    }

    /**
     * 670. 最大交换
     * @param num
     * @return
     */
    public int maximumSwap(int num) {
        String str = String.valueOf(num);
        char[] chars = str.toCharArray();
        int len = str.length();
        for (int i = 0; i < len - 1; i++) {
            int maxF = i + 1;
            int max = i + 1;
            for (int j = i + 1; j < len; j++) {
                if (chars[max] <= chars[j]) {
                    max = j;
                }
            }
            if (max != i + 1) {
                maxF = max;
            }
            if (chars[i] < chars[maxF]) {
                char temp = chars[i];
                chars[i] = chars[maxF];
                chars[maxF] = temp;
                break;
            }
        }
        return Integer.parseInt(String.valueOf(chars));
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("(()){}[[(())]]"));

        int[] num1 = new int[]{1,2,3,0,0,0};

        solution.merge(num1, 3, new int[]{2,5,6}, 3);

        for (int i : num1) {
            System.out.printf("%d ", i);
        }

        System.out.println(solution.convert("LEETCODEISHIRING", 5));
        System.out.println(solution.convert1("LEETCODEISHIRING", 5));

        int[] ints = new int[]{1,3,1,8,5,3};
        solution.selectSort(ints, 6);

        for (int i : ints) {
            System.out.printf("%d ", i);
        }


        System.out.println();
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);

        ListNode listNode1 = new ListNode(5);
        listNode1.next = new ListNode(6);
        listNode1.next.next = new ListNode(4);


        System.out.println(solution.maximumSwap(0));

        System.out.println(Integer.toBinaryString(16383));
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
