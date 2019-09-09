package org.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.data);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return list;
    }

    public static void pre_order(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.printf("%d ", root.data);
        pre_order(root.left);
        pre_order(root.right);
    }

    public static void mid_order(TreeNode root) {
        if (root == null) {
            return;
        }
        mid_order(root.left);
        System.out.printf("%d ", root.data);
        mid_order(root.right);
    }

    public static void last_order(TreeNode root) {
        if (root == null) {
            return;
        }
        last_order(root.left);
        last_order(root.right);
        System.out.printf("%d ", root.data);
    }

    public static List<Integer> middleTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                list.add(root.data);
                root = root.right;
            }
        }
        return list;
    }


    public float avg(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        } else {
            return (arr[i] + (j - i) * avg(arr, i + 1, j)) / (j - i + 1);
        }
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(6);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(5);
        treeNode.right.right = new TreeNode(7);

        // List<Integer> list = preorderTraversal(treeNode);
        // list.forEach(item -> System.out.printf("%d ", item));
        //
        // System.out.println();
        // pre_order(treeNode);
        // System.out.println();
        // preOrder(treeNode).forEach(item -> System.out.printf("%d ", item));
        //
        // System.out.println();

        // System.out.println(first(treeNode).data);
        //
        //
        // middleTraversal(treeNode).forEach(item -> System.out.printf("%d ", item));
        // System.out.println();
        //
        // pre_order(treeNode);
        // System.out.println();
        //
        // mid_order(treeNode);
        // System.out.println();
        // midOrder(treeNode).forEach(item -> System.out.printf("%d ", item));
        //
        // System.out.println();

        //
        TreeNode tree = createTree("5312867", "1325687");
        // last_order(tree);
        //
        // System.out.println();
        System.out.println(postOrder("5312867", "1325687"));

        last_order(treeNode);
        System.out.println();

        System.out.println(judge(new int[]{1,2,3,4,5}));

    }

    /**
     * preString   5312867
     * inString    1325687
     * @param preOrder
     * @param inOrder
     * @return
     */
    public static TreeNode createTree(String preOrder, String inOrder) {
        if (preOrder.isEmpty()) {
            return null;
        }
        int node = preOrder.charAt(0) - '0';
        int nodeIndex = inOrder.indexOf(node + '0');

        TreeNode treeNode = new TreeNode(node);
        treeNode.left = createTree(preOrder.substring(1, nodeIndex + 1),
                inOrder.substring(0, nodeIndex));
        treeNode.right = createTree(preOrder.substring(nodeIndex + 1),
                inOrder.substring(1 + nodeIndex));
        return treeNode;
    }


    public static String getPostOrder(String preOrder, String inOrder) {

        if (preOrder.isEmpty()) {
            return "";
        }

        int root = preOrder.charAt(0) - '0';
        int rootIndex = inOrder.indexOf(root + '0');

        return getPostOrder(preOrder.substring(1, rootIndex + 1), inOrder.substring(0, rootIndex))
                + getPostOrder(preOrder.substring(rootIndex + 1), inOrder.substring(1 + rootIndex));


    }

    public static boolean judge(int[] arr) {
        if (arr.length == 0) {
            return false;
        }
        return VerifySquenceOfBST(arr, 0, arr.length - 1);
    }

    // 1 3 2 5 7 6 4
    // 1, 2, 3, 4, 0, 6, 4
    // 4, 8, 6, 12, 16, 14, 10
    private static boolean VerifySquenceOfBST(int[] sequence, int begin, int end) {

        if (begin >= end) {
            return true;
        }

        int i = end;
        while (i > begin && sequence[i - 1] > sequence[end]) {
            i--;
        }

        for (int j = i - 1; j >= begin; --j) {
            if (sequence[j] > sequence[end]) {
                return false;
            }
        }

        return VerifySquenceOfBST(sequence, begin, i - 1) &&
                VerifySquenceOfBST(sequence, i, end - 1);


        // if (end - begin == 0 || end == 0 || end == 1) {
        //     return true;
        // }
        //
        // int root = sequence[end];
        //
        // int index = 0;
        //
        // for (int i = end - 1; i >= begin; i--) {
        //     if (sequence[i] < root) {
        //         index = i + 1;
        //         break;
        //     }
        // }
        //
        // if (index != 0) {
        //     for (int i = begin; i < index; i++) {
        //         if (sequence[i] > root) {
        //             return false;
        //         }
        //     }
        // }
        // for (int i = index; i < end; i++) {
        //     if (sequence[i] < root) {
        //         return false;
        //     }
        // }
        //
        // boolean b = true;
        // if (index != 0) {
        //     b = VerifySquenceOfBST(sequence, begin, index - 1);
        // }
        // if (!b) {
        //     return false;
        // }
        // if (index != end) {
        //     b = VerifySquenceOfBST(sequence, index, end - 1);
        // }
        // return b;
    }

    public static List<Integer> preOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.data);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return list;
    }

    public static List<Integer> midOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.data);
                cur = cur.right;
            }
        }
        return list;
    }

    public static TreeNode first(TreeNode node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }



    public static String postOrder(String preOrder, String inOrder) {
        if (preOrder.isEmpty()) {
            return "";
        }
        int root = preOrder.charAt(0) - '0';
        int rootIndex = inOrder.indexOf(root + '0');
        return postOrder(preOrder.substring(1, 1 + rootIndex), inOrder.substring(0, rootIndex)) +
                postOrder(preOrder.substring(1 + rootIndex), inOrder.substring(1 + rootIndex));
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }
}
