package org.leetcode.interiew.interview94;

import java.util.*;

public class Main {

    // public static class ListNode {
    //
    //     int val;
    //     ListNode next;
    //
    //     ListNode(int x) {
    //         val = x;
    //         next = null;
    //     }
    // }
    //
    // /*请完成下面这个函数，实现题目要求的功能
    //  ******************************开始写代码******************************/
    // static ListNode partition(ListNode head, int m) {
    //
    //     ListNode temp = null;
    //     Queue<Integer> queue = new LinkedList<>();
    //     Queue<Integer> queue1 = new LinkedList<>();
    //     while (head != null) {
    //         if (head.val <= m) {
    //             queue.offer(head.val);
    //         } else {
    //             queue1.offer(head.val);
    //         }
    //         head = head.next;
    //     }
    //     ListNode tep = null;
    //     for (Integer i : queue) {
    //         if (temp == null) {
    //             tep = new ListNode(i);
    //             temp = tep;
    //         } else {
    //             tep.next = new ListNode(i);
    //             tep = tep.next;
    //         }
    //     }
    //
    //     for (Integer i : queue1) {
    //         if (temp == null) {
    //             tep = new ListNode(i);
    //             temp = tep;
    //         } else {
    //             tep.next = new ListNode(i);
    //             tep = tep.next;
    //         }
    //     }
    //     return temp;
    // }
    //
    // public static void main(String[] args) {
    //     Scanner in = new Scanner(System.in);
    //     ListNode head = null;
    //     ListNode node = null;
    //     int m = in.nextInt();
    //     while (in.hasNextInt()) {
    //         int v = in.nextInt();
    //         if (head == null) {
    //             node = new ListNode(v);
    //             head = node;
    //         } else {
    //             node.next = new ListNode(v);
    //             node = node.next;
    //         }
    //     }
    //     head = partition(head, m);
    //     if (head != null) {
    //         System.out.print(head.val);
    //         head = head.next;
    //         while (head != null) {
    //             System.out.print(",");
    //             System.out.print(head.val);
    //             head = head.next;
    //         }
    //     }
    //     System.out.println();
    // }


    static String resolve(String expr) {

        // Stack<Character> stack = new Stack<>();
        // int len = expr.length();
        // for (int i = 0; i < len; i++) {
        //     if (expr.charAt(i) == '(' || expr.charAt(i) == ')') {
        //         if (expr.charAt(i) == '(') {
        //             stack.push(expr.charAt(i));
        //         } else {
        //             if (!stack.isEmpty()) {
        //                 return "";
        //             } else {
        //                 stack.pop();
        //             }
        //         }
        //     }
        // }
        //
        // StringBuilder sb = new StringBuilder(expr);
        // boolean[] flag = new boolean[len];
        // int pre = 0;
        // int then = 0;
        // for (int i = 0; i < len; i++) {
        //     if (sb.toString().charAt(i) == '(' && !flag[i]) {
        //         pre = i;
        //         flag[i] = true;
        //     } else if (sb.toString().charAt(i) == ')' && !flag[i]) {
        //         then = i;
        //         flag[i] = true;
        //         if (then - pre > 0) {
        //             int mid = (then - pre - 2) / 2;
        //             for (int j = 0; j <= mid; j++) {
        //
        //             }
        //         }
        //     }
        // }


        char[] arr = expr.toCharArray();
        StringBuilder result = new StringBuilder();
        List<Character> list = new ArrayList<>();
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < expr.length(); i++) {
            if (arr[i] == ')') {
                while (!(stack2.peek() == '(')) {
                    stack1.push(stack2.pop());
                }
                stack2.pop();
                while (!stack1.empty()) {
                    list.add(stack1.pop());
                }
                for (int j = list.size() - 1; j >= 0; j--) {
                    stack2.push(list.get(j));
                }
                list.clear();
            } else {
                stack2.push(arr[i]);
            }
        }
        while (!stack2.empty()) {
            result.insert(0, stack2.pop());
        }
        return result.toString();

        // char[] arr = expr.toCharArray();
        // String result = "";
        // List<Character> list = new ArrayList<>();
        //
        // for (int i = 0; i < expr.length(); i++) {
        //     if (arr[i] == ')') {
        //         while (!(stack2.peek() == '(')) {
        //             stack1.push(stack2.pop());
        //         }
        //         stack2.pop();
        //         while (!stack1.empty()) {
        //             list.add(stack1.pop());
        //         }
        //         for (int j = list.size() - 1; j >= 0; j--) {
        //             stack2.push(list.get(j));
        //         }
        //         list.clear();
        //     } else {
        //         stack2.push(arr[i]);
        //     }
        // }
        // while (!stack2.empty()) {
        //     result = result + stack2.pop();
        // }
        // return result;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}
