package org.leetcode.tree;

import java.util.*;

public class Solution {

    /**
     * 二叉树最大深度
     *
     * @param root
     * @return
     */
    private int maxDepth(TreeNode root) {

        // if (root == null) {
        //     return 0;
        // }
        // int deep = 0;
        // deep++;
        // int i = maxDepth(root.left) + deep;
        // int i1 = maxDepth(root.right) + deep;
        // return Math.max(i, i1);

        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 验证二叉搜索树
     *
     * @param root
     * @return
     */
    TreeNode pre;

    public boolean isValidBST(TreeNode root) {
        // return bst(root, null, null);

        if (root == null) return true;

        if (!isValidBST(root.left)) return false;

        if (pre != null && pre.val >= root.val) {
            return false;
        }

        pre = root;

        return isValidBST(root.right);
    }

    private boolean bst(TreeNode root, Integer min, Integer max) {

        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min) {
            return false;
        }

        if (max != null && root.val >= max) {
            return false;
        }

        return bst(root.right, root.val, max) && bst(root.left, min, root.val);
    }

    /**
     * 二叉搜索树的层次遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> listAll = new ArrayList<>();
        if (root == null) {
            return listAll;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            listAll.add(list);
        }
        return listAll;
    }


    /**
     * 层次遍历树 递归
     *
     * @param root
     * @return
     */
    List<List<Integer>> listAll = new ArrayList<>();

    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return listAll;
        }
        helper(root, 0);
        return listAll;
    }

    private void helper(TreeNode root, int i) {
        if (listAll.size() == i) {
            listAll.add(new ArrayList<>());
        }
        listAll.get(i).add(root.val);
        if (root.left != null) {
            helper(root.left, i + 1);
        }
        if (root.right != null) {
            helper(root.right, i + 1);
        }
    }

    /**
     * 对称二叉树
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {

        // return isSymmetric(root, root);
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    private boolean isSymmetric(TreeNode root, TreeNode root1) {

        if (root == null && root1 == null) {
            return true;
        }
        if (root == null || root1 == null) {
            return false;
        }
        if (root.val != root1.val) {
            return false;
        }
        return isSymmetric(root.left, root1.right) &&
                isSymmetric(root.right, root1.left);
    }

    /**
     * 将有序数组转换为二叉搜索树
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }
        return sub(nums, 0, nums.length - 1);
    }

    private TreeNode sub(int[] nums, int low, int high) {

        if (high < low) {
            return null;
        }
        int mid = (low + high) >> 1;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = sub(nums, low, mid - 1);
        treeNode.right = sub(nums, mid + 1, high);
        return treeNode;
    }

    /**
     * 有序链表转换二叉搜索树
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return helper(head, null);
    }

    private TreeNode helper(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(head, slow);
        root.right = helper(slow.next, tail);
        return root;
    }


    public TreeNode sortedListToBST1(ListNode head) {

        int size = findSize(head);
        return convertListToBST(0, size - 1, head);
    }

    private int findSize(ListNode head) {
        ListNode ptr = head;
        int c = 0;
        while (ptr != null) {
            ptr = ptr.next;
            c += 1;
        }
        return c;
    }

    private TreeNode convertListToBST(int l, int r, ListNode head) {
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode left = convertListToBST(l, mid - 1, head);
        TreeNode node = new TreeNode(head.val);
        node.left = left;
        head = head.next;
        node.right = convertListToBST(mid + 1, r, head);
        return node;
    }

    /**
     * 二叉树中的最大路径和
     * @param root
     * @return
     */
    private int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return res;
    }

    private int getMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, getMax(root.left));
        int right = Math.max(0, getMax(root.right));
        res = Math.max(res, root.val + left + right);
        return Math.max(left, right) + root.val;
    }

    /**
     * 二叉树的中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(-10);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);
        // tree.left.right = new TreeNode(8);

        Solution solution = new Solution();

        System.out.println(solution.isValidBST(tree));

        int[] arr = new int[]{-10, -3, 0, 5, 9};
        TreeNode treeNode = solution.sortedArrayToBST(arr);
        // solution.inOrder(treeNode);

        solution.level(treeNode);

        System.out.println(solution.maxDepth(tree));

        System.out.println(solution.maxPathSum(tree));
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.printf("%d ", root.val);
        inOrder(root.right);
    }

    private void level(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            System.out.println(root.val);
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
        }
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

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}