package org.leetcode.recur;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    /**
     * 反转字符串
     *
     * @param s
     */
    public void reverseString(char[] s) {

        int length = s.length;
        if (length == 0) {
            return;
        }
        int low = 0;
        int high = length - 1;
        int mid = (high + low) / 2;
        for (int i = 0; i <= mid; i++) {
            char temp = s[i];
            s[i] = s[high - i];
            s[high - i] = temp;
        }
    }

    /**
     * 两两交换链表的节点
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        return swapNode(head);
    }

    private ListNode swapNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tempNode = head.next.next;
        ListNode next = head.next;
        next.next = head;
        head.next = swapNode(tempNode);
        return next;
    }

    /**
     * 杨辉三角
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        int[][] temp = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    temp[i][j] = 1;
                } else {
                    temp[i][j] = temp[i - 1][j - 1] + temp[i - 1][j];
                }
                list.add(temp[i][j]);
            }
            lists.add(list);
        }
        return lists;
    }

    /**
     * 杨辉三角Ⅱ
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        int[] arr = new int[rowIndex + 1];
        for (int i = 0; i < rowIndex + 1; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == 0 || j == i) {
                    arr[j] = 1;
                } else {
                    arr[j] = arr[j - 1] + arr[j];
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        return list;
    }

    /**
     * pow
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        long N = n;
        if (n == 0) {
            return 1;
        }
        boolean flag = false;
        if (n < 0) {
            n = -n;
            flag = true;
        }
        double ans = 1;
        double sum = x;
        for (int i = n; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans *= sum;
            }
            sum *= sum;
        }
        return flag ? 1.0 / ans : ans;
    }

    /**
     * 第K个语法符号
     *
     * @param N
     * @param K
     * @return
     */
    public int kthGrammar(int N, int K) {

        // if (N == 1) {
        //     return 0;
        // }
        // if (K <= 1 << N - 2) {
        //     return kthGrammar(N - 1, K);
        // }
        // return kthGrammar(N - 1, K - (1 << N - 2)) ^ 1;

        return Integer.bitCount(K - 1) % 2;
    }

    private String helpKthGrammar(int N, int index) {
        if (index >= N) {
            return "0";
        }
        String s = helpKthGrammar(N, index + 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                sb.append("01");
            } else {
                sb.append("10");
            }
        }
        return sb.toString();
    }

    /**
     * 不同的二叉搜索树 II
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generate_trees(1, n);
    }

    private LinkedList<TreeNode> generate_trees(int start, int end) {
        // LinkedList<TreeNode> all_trees = new LinkedList<>();
        // if (start > end) {
        //     return all_trees;
        // }
        //
        // // pick up a root
        // for (int i = start; i <= end; i++) {
        //     // all possible left subtrees if i is choosen to be a root
        //     LinkedList<TreeNode> left_trees = generate_trees(start, i - 1);
        //
        //     // all possible right subtrees if i is choosen to be a root
        //     LinkedList<TreeNode> right_trees = generate_trees(i + 1, end);
        //
        //     // connect left and right trees to the root i
        //     for (TreeNode l : left_trees) {
        //         for (TreeNode r : right_trees) {
        //             TreeNode current_tree = new TreeNode(i);
        //             current_tree.left = l;
        //             current_tree.right = r;
        //             all_trees.add(current_tree);
        //         }
        //     }
        // }
        // return all_trees;

        LinkedList<TreeNode> list = new LinkedList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i++) {

            LinkedList<TreeNode> left = generate_trees(start, i - 1);
            LinkedList<TreeNode> right = generate_trees(i + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list;
    }

    /**
     * 96 不同的二叉搜索树
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {

        // int[] temp = new int[n + 1];
        // temp[0] = 1;
        // temp[1] = 1;
        // for (int i = 2; i <= n; i++) {
        //     for (int j = 1; j < i + 1; j++) {
        //         temp[i] += temp[j - 1] * temp[i - j];
        //     }
        // }
        // return temp[n];

        long temp = 1;
        for (int i = 0; i < n; ++i) {
            temp = temp * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) temp;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        // List<Integer> row = solution.getRow(3);
        // row.forEach(System.out::println);

        System.out.println(solution.myPow(2.00000, -2147483648));

        System.out.println(solution.kthGrammar(4, 5));

        List<TreeNode> treeNodes = solution.generateTrees(3);
        System.out.println(treeNodes.size());

        System.out.println(solution.numTrees(19));

    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
