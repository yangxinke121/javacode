package org.learn.tree;


import java.util.*;

/**
 * @author: yxk
 * @date: 2019-04-01 15:39
 */
public class Solution {

    private static class Node{
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.printf("%d ", root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.printf("%d ", root.data);
        inOrder(root.right);
    }

    public void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.printf("%d ", poll.data);
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
    }

    private static boolean isCompleteTreeNode(Node root) {
        if (root == null) {
            return false;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean result = true;
        boolean hasNoChild = false;
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            if (hasNoChild) {
                if (current.left != null || current.right != null) {
                    result = false;
                    break;
                }
            } else {
                if (current.left != null && current.right != null) {
                    queue.add(current.left);
                    queue.add(current.right);
                } else if (current.left != null) {
                    queue.add(current.left);
                    hasNoChild = true;

                } else if (current.right != null) {
                    result = false;
                    break;
                } else {
                    hasNoChild = true;
                }
            }

        }
        return result;
    }


    public int culTreeLevel(Node node, int index) {
        if (node == null) {
            return index;
        }
        int maxLeft = 0;
        if (node.left != null) {
            maxLeft = culTreeLevel(node.left, index + 1);
        }

        int maxRight = 0;
        if (node.right != null) {
            maxRight = culTreeLevel(node.right, index + 1);
        }

        return Math.max(maxLeft, maxRight) + 1;
    }

    private void levelOrder1(Node root) {
        if (root == null) {
            return;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.printf("%d ",poll.data);
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
    }

    private void preOrderUnRecur(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node pop = stack.pop();
            System.out.printf("%d ", pop.data);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    private void inOrderUnRecur(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.printf("%d ", root.data);
                root = root.right;
            }
        }
    }

    private void preOrderUnRecur1(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            System.out.printf("%d ", pop.data);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    private void inOrderUnRecur1(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.printf("%d ", root.data);
                root = root.right;
            }
        }
    }

    private List<Integer> inOrderUnRecur3(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        LinkedList<Node> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
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

    private Node postOrder(String pre, String in) {
        if (pre.length() == 0) {
            return null;
        }
        int root = pre.charAt(0) - '0';
        int rootIndex = in.indexOf(root + '0');

        Node node = new Node(root);

        node.left = postOrder(pre.substring(1, 1 + rootIndex), in.substring(0, rootIndex));

        node.right = postOrder(pre.substring(rootIndex + 1), in.substring(rootIndex + 1));
        return node;
    }

    private String postOrderUseString(String pre, String in) {
        if (pre.isEmpty()) {
            return "";
        }

        int root = pre.charAt(0) - '0';
        int rootIndex = in.indexOf(root + '0');


        return postOrderUseString(pre.substring(1, 1 + rootIndex), in.substring(0, rootIndex)) +
                postOrderUseString(pre.substring(rootIndex + 1), in.substring(rootIndex + 1)) + root;
    }

    public static void main(String[] args) {
        Node treeNode = new Node(4);
        treeNode.left = new Node(2);
        treeNode.right = new Node(6);
        treeNode.left.left = new Node(1);
        treeNode.left.right = new Node(3);
        treeNode.right.left = new Node(5);
        treeNode.right.right = new Node(7);

        Solution solution = new Solution();

        solution.preOrder(treeNode);
        System.out.println();

        solution.preOrderUnRecur(treeNode);
        System.out.println();

        solution.inOrder(treeNode);
        System.out.println();


        System.out.println(solution.postOrderUseString("4213657", "1234567"));

        List<Integer> list = solution.inOrderUnRecur3(treeNode);
        for (int i : list) {
            System.out.println(i);
        }
    }
}
