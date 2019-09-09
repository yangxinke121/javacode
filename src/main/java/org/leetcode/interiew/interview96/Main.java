package org.leetcode.interiew.interview96;

import java.util.Stack;

public class Main {


    static int solution(int[] prices, int budget) {
        int length = prices.length;

        if (length == 0) {
            return -1;
        }
        int[] dp = new int[budget + 1];
        int result = budget + 1;
        for (int i = 1; i <= budget; i++) {
            dp[i] = result;
        }
        for (int i = 1; i <= budget; i++) {
            for (int p : prices) {
                if (p <= i) {
                    dp[i] = Math.min(dp[i], dp[i - p] + 1);
                }
            }
        }
        return dp[budget] > budget ? -1 : dp[budget];
    }


    static StringBuilder sb = new StringBuilder();
    static String solution(String input) {

        TreeNode treeNode = str2Tree(input);
        inOrder(treeNode);
        return sb.toString();
    }

    private static void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.left);
        sb.append(treeNode.val);
        inOrder(treeNode.right);
    }

    private int index = 0;

    private static TreeNode str2Tree(String str) {

        // int len = str.length();
        // if (len < 1 || index >= len) {
        //     return null;
        // }
        // int val = 0;
        // int ch;
        // int sign = 1;
        // if (str.charAt(index) == '-') {
        //     sign = -1;
        //     index++;
        // }
        // while (index < len && (ch = str.charAt(index)) <= '9' && ch >= '0') {
        //     val *= 10;
        //     val += ch - '0';
        //     index++;
        // }
        // TreeNode root = new TreeNode(sign * val);
        // if (index >= len || str.charAt(index) == ')') {
        //     index++;
        //     return root;//have no child
        // }//here now index is pointing to a '('
        // index++;//now pointing to a number
        // root.left = str2Tree(str);
        // if (index >= len || str.charAt(index) == ')') {
        //     index++;
        //     return root;
        // }//here it means index is pointing to '('
        // index++;
        // root.right = str2Tree(str);
        // if (index >= len || str.charAt(index) == ')') {
        //     index++;
        // }
        // return root;

        //corner case

        if (str == null || str.length() == 0) {
            return null;
        }


        str = str.replaceAll(",", "(");
        //initialization: stack
        Stack<TreeNode> stack = new Stack<>();

        //for loop: new node, get substring and append
        for (int i = 0, j = i; i < str.length(); i++, j = i) {
            //get c
            char c = str.charAt(i);

            //if c is )
            if (c == ')'){ stack.pop();}

            else if ((c >= '0' && c <= '9') || (c == ',')) {
                //continue
                while (i + 1 < str.length() && str.charAt(i + 1) >= '0' && str.charAt(i + 1) <= '9') i++;
                //build new node
                TreeNode node = new TreeNode(Integer.parseInt(str.substring(j, i + 1)));
                if (!stack.isEmpty()) {
                    TreeNode parent = stack.peek();
                    //get left and append
                    if (parent.left != null) {
                        parent.right = node;
                    } else parent.left = node;
                }
                stack.push(node);
            }

        }

        //return the last root
        return stack.peek() == null ? null : stack.pop();
    }


    public static void main(String[] args) {


        // System.out.println(solution(new int[]{500, 1}, 1000));

        System.out.println(solution("1(2(3,4(,5)),6(7,))"));
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
