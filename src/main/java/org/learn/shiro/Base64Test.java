package org.learn.shiro;

import org.springframework.util.Base64Utils;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Base64Test {

    /**
     * Shiro 记住密码采用的是AES加密，AES key length 需要是16位，该方法生成16位的key
     */
    public static void main(String[] args) {

        String keyStr = "guns";

        byte[] keys;
        try {
            keys = keyStr.getBytes("UTF-8");
            System.out.println(Base64Utils.encodeToString(Arrays.copyOf(keys, 16)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        int[] arr = new int[]{11, 8, 3, 9, 7, 1, 2, 5};
        for (int a : arr) {
            System.out.printf("%d ", a);
        }
        mergeSortTest(arr, 0, arr.length - 1);
        System.out.println();
        for (int a : arr) {
            System.out.printf("%d ", a);
        }


        TreeNode treeNode = new TreeNode(15);
        treeNode.left = new TreeNode(8);
        treeNode.right = new TreeNode(20);
        treeNode.left.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(10);
        treeNode.right.left = new TreeNode(16);
        treeNode.right.right = new TreeNode(30);



        System.out.println();
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        Node reverse = reverse(node);
        while (reverse != null) {
            System.out.printf("%d ", reverse.data);
            reverse = reverse.next;
        }


        System.out.println();
        int[] a = new int[]{2,4,1,8,4,7,9,5};
        insertSort(a);
        for (int i1 : a) {
            System.out.printf("%d ", i1);
        }

    }

    /**
     * merge(A[p...r], A[p...q], A[q+1...r]) {
     *   var i := p，j := q+1，k := 0 // 初始化变量 i, j, k
     *   var tmp := new array[0...r-p] // 申请一个大小跟 A[p...r] 一样的临时数组
     *   while i<=q AND j<=r do {
     *     if A[i] <= A[j] {
     *       tmp[k++] = A[i++] // i++ 等于 i:=i+1
     *     } else {
     *       tmp[k++] = A[j++]
     *     }
     *   }
     *
     *   // 判断哪个子数组中有剩余的数据
     *   var start := i，end := q
     *   if j<=r then start := j, end:=r
     *
     *   // 将剩余的数据拷贝到临时数组 tmp
     *   while start <= end do {
     *     tmp[k++] = A[start++]
     *   }
     *
     *   // 将 tmp 中的数组拷贝回 A[p...r]
     *   for i:=0 to r-p do {
     *     A[p+i] = tmp[i]
     *   }
     * }
     * @param arr
     * @param p
     * @param q
     * @return
     */

    public static void merge(int[] arr, int p, int q, int r) {

        int i = p, j = q + 1, k = 0;
        int[] temp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            temp[k++] = arr[start++];
        }
        for (i = 0; i <= r - p; i++) {
            arr[p + i] = temp[i];
        }
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }


    public static void pre_sort(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.printf("%d ", root.val);
        pre_sort(root.left);
        pre_sort(root.right);
    }


    public static void mergeSortTest(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSortTest(arr, start, mid);
        mergeSortTest(arr, mid + 1, end);
        mergeTest(arr, start, mid, end);
    }

    /**
     * merge(A[p...r], A[p...q], A[q+1...r])
     * @param arr
     * @param p
     * @param q
     * @param r
     */
    private static void mergeTest(int[] arr, int p, int q, int r) {

        int i = p, j = q + 1, k = 0;

        int[] temp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= q) {
            temp[k++] = arr[i++];
        }
        while (j <= r) {
            temp[k++] = arr[j++];
        }
        for (i = 0; i <= r - p; i++) {
            arr[p + i] = temp[i];
        }
    }

    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node reverse = reverse(head.next);
        Node next = head.next;
        next.next = head;
        head.next = null;
        return reverse;
    }


    public static Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node node = null;
        while (head != null) {
            Node next = head.next;
            head.next = node;
            node = head;
            head = next;
        }
        return node;
    }


    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            if (i != j) {
                arr[j + 1] = temp;
            }
        }
    }
}

class Node{

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
