package org.point_offer;

import java.util.*;

public class Solution {

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    /**
     * 获得路径和
     *
     * @param root
     * @param target
     * @return
     */
    private ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        if (root == null) {
            return listAll;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            listAll.add(new ArrayList<>(list));
        }
        findPath(root.left, target);
        findPath(root.right, target);
        list.remove(list.size() - 1);
        return listAll;
    }

    /**
     * 找到缺失的数字
     *
     * @param nums
     * @return
     */
    public int getMissingNumber(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int right = nums.length - 1;
        int left = 0;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] != mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] == left) {
            return nums[left] + 1;
        }
        return left;
    }

    /**
     * 二叉搜索树的后序遍历
     *
     * @param arr
     * @return
     */
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
    }


    /**
     * 找出数组中重复的数字
     *
     * @param nums
     * @return
     */
    public int duplicateInArray(int[] nums) {
        int length = nums.length;
        if (length == 0 || length == 1) {
            return -1;
        }

        Arrays.sort(nums);
        int temp = nums[0];
        for (int i = 1; i < length; i++) {
            if (temp < 0 || length <= nums[length - 1]) {
                return -1;
            }
            if (temp == nums[i]) {
                return temp;
            }
            temp = nums[i];
        }
        return -1;
    }

    /**
     * 不修改数组找出重复的数字
     *
     * @param nums
     * @return
     */
    public int duplicateInArray1(int[] nums) {

        int length = nums.length;

        int[] arr = new int[length];
        for (int i : nums) {
            arr[i]++;
        }
        for (int i = 0; i < length; i++) {
            if (arr[i] > 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 二维数组中的查找
     *
     * @param array
     * @param target
     * @return
     */
    public boolean searchArray(int[][] array, int target) {

        int row = array.length - 1;
        if (row < 0) {
            return false;
        }
        int col = array[0].length;

        int column = 0;

        while (row >= 0 && column < col) {
            int temp = array[row][column];
            if (target > temp) {
                column++;
            } else if (target < temp) {
                row--;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 替换空格
     *
     * @param str
     * @return
     */
    public String replaceSpaces(StringBuffer str) {

        String s = str.toString();
        return s.replace(" ", "%20");
    }

    /**
     * 从尾到头打印链表
     *
     * @param head
     * @return
     */
    public int[] printListReversingly(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        int n = 0;
        int i = 0;
        ListNode temp = null;
        while (head != null) {
            n++;
            ListNode next = head.next;
            head.next = temp;
            temp = head;
            head = next;
        }

        int[] arr = new int[n];

        while (temp != null) {
            arr[i++] = temp.val;
            temp = temp.next;
        }
        return arr;
    }

    /**
     * 重建 二叉树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0) {
            return null;
        }

        int root = preorder[0];
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                index = i;
            }
        }
        TreeNode tree = new TreeNode(root);
        tree.left = buildTree(subArr(preorder, 1, 1 + index),
                subArr(inorder, 0, index));

        tree.right = buildTree(subArr(preorder, index + 1, preorder.length),
                subArr(inorder, index + 1, inorder.length));
        return tree;
    }

    private int[] subArr(int[] arr, int start, int end) {
        int[] a = new int[end - start];
        int temp = 0;
        for (int i = start; i < end; i++) {
            a[temp++] = arr[i];
        }
        return a;
    }

    /**
     * 二叉树的下一个节点
     *
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode p) {
        // 右子树不为null
        if (p.right != null) {
            return first(p.right);
        } else {
            while (p.father != null && p.father.left != p) {
                p = p.father;
            }
            return p.father;
        }
    }

    private TreeNode first(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode curNode = node;
        while (curNode.left != null) {
            curNode = curNode.left;
        }
        return curNode;
    }

    /**
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        int first = 1;
        int second = 1;
        int sum = 0;
        for (int i = 0; i < n - 2; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }

    /**
     * 旋转数组的最小数字 (二分)
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {

        if (nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;

        while (high > 0 && nums[high] == nums[0]) {
            high--;
        }
        if (nums[high] >= nums[0]) {
            return nums[0];
        }
        while (low < high) {
            int mid = (low + high) >> 1;
            if (nums[mid] < nums[0]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums[high];
    }

    /**
     * 矩阵中的路径
     *
     * @param matrix
     * @param str
     * @return
     */
    public boolean hasPath(char[][] matrix, String str) {
        if (matrix == null || matrix.length == 0 || str.isEmpty()) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] flag = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (isOk(matrix, str, row, col, 0, flag)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isOk(char[][] matrix, String str, int row, int col, int pathLength, boolean[][] flag) {

        if (str.length() - 1 == pathLength) {
            return true;
        }
        if (matrix[row][col] != str.charAt(pathLength)) {
            return false;
        }
        int[] x = {0, 0, 1, -1};
        int[] y = {1, -1, 0, 0};
        flag[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int a = row + x[i];
            int b = col + y[i];
            if (a >= 0 && a < matrix.length && b >= 0 && b < matrix[row].length && !flag[a][b]) {
                if (isOk(matrix, str, a, b, pathLength + 1, flag)) {
                    return true;
                }
            }
        }
        flag[row][col] = false;
        return false;
    }

    /**
     * 机器人的运动范围
     *
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount(int threshold, int rows, int cols) {

        if (threshold < 0 || rows < 0 || cols < 0) {
            return 0;
        }
        boolean[][] flag = new boolean[rows][cols];
        return isMovingOk(threshold, 0, 0, rows, cols, flag, 0);
    }

    private int isMovingOk(int threshold, int row, int col, int rows, int cols, boolean[][] flag, int countSum) {
        int count = 0;
        int row1 = row;
        while (row1 > 0) {
            count += row1 % 10;
            row1 = row1 / 10;
        }
        int col1 = col;
        while (col1 > 0) {
            count += col1 % 10;
            col1 = col1 / 10;
        }
        if (count > threshold) {
            return countSum;
        }
        if (row < rows && row >= 0 && col < cols && col >= 0 && !flag[row][col]) {
            flag[row][col] = true;
            countSum = 1 + isMovingOk(threshold, row, col + 1, rows, cols, flag, countSum)
                    + isMovingOk(threshold, row + 1, col, rows, cols, flag, countSum)
                    + isMovingOk(threshold, row - 1, col, rows, cols, flag, countSum)
                    + isMovingOk(threshold, row, col - 1, rows, cols, flag, countSum);
        }
        return countSum;
    }

    /**
     * 剪绳子
     *
     * @param length
     * @return
     */
    public int maxProductAfterCutting(int length) {
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int len = (length + 1) / 2;
        int sum = 0;
        for (int i = 2; i <= len; i++) {
            int preSum = 1;
            int i1 = length / i;
            int i2 = length % i;
            for (int j = 0; j < i1 - 1; j++) {
                preSum *= i;
            }
            if (i2 != 0) {
                preSum = Math.max(preSum * i2 * i, preSum * (i2 + i));
            } else {
                preSum = preSum * i;
            }
            sum = Math.max(sum, preSum);
        }
        return sum;
    }

    /**
     * 位运算
     *
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int sum = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                sum++;
            }
            n = n >>> 1;
        }
        return sum;
    }

    /**
     * 链表中环的入口节点
     *
     * @param head
     * @return
     */
    public ListNode entryNodeOfLoop(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        ListNode node = head;
        int num = 1;
        while (fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = fast.next;
                while (fast != slow) {
                    num++;
                    fast = fast.next;
                }

                for (int i = 0; i < num; i++) {
                    node = node.next;
                }

                ListNode node_ = head;
                while (node != node_) {
                    node = node.next;
                    node_ = node_.next;

                }
                return node;
            }
        }
        return null;
    }

    /**
     * 数值的整数次方
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        boolean flag = false;
        if (exponent < 0) {
            exponent = -exponent;
            flag = true;
        }
        int sum = 1;
        for (int i = 0; i < exponent; i++) {
            sum *= base;
        }
        return flag ? 1.0 / sum : sum;
    }

    /**
     * 在O(1)时间删除链表结点
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 删除链表中重复的节点
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplication(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode temp = dummy.next;

        ListNode pre = dummy;
        // while (temp != null && temp.next != null) {
        //     int val = temp.val;
        //     if (val == temp.next.val) {
        //         temp = temp.next.next;
        //         while (temp != null && val == temp.val) {
        //             temp = temp.next;
        //         }
        //         pre.next = temp;
        //     } else {
        //         pre = pre.next;
        //         temp = temp.next;
        //     }
        // }

        while (pre.next != null) {
            ListNode q = pre.next;
            while (q != null && pre.next.val == q.val) {
                q = q.next;
            }

            if (pre.next.next == q) {
                pre = pre.next;
            } else {
                pre.next = q;
            }
        }
        return dummy.next;
    }

    /**
     * 调整数组顺序使奇数位于偶数前面
     *
     * @param array
     */
    public void reOrderArray(int[] array) {
        int length = array.length;
        if (length < 2) {
            return;
        }
        // 新建一个数组
        // int n = 0;
        // int[] temp = new int[length];
        // for (int value : array) {
        //     if (value % 2 == 1) {
        //         temp[n++] = value;
        //     }
        // }
        // for (int value : array) {
        //     if (value % 2 == 0) {
        //         temp[n++] = value;
        //     }
        // }
        // System.arraycopy(temp, 0, array, 0, length);

        // 插入排序做
        // for (int i = 1; i < length; i++) {
        //     int value = array[i];
        //     int j = i - 1;
        //     while (j >= 0 && array[j] % 2 == 0) {
        //         array[j + 1] = array[j];
        //         j--;
        //     }
        //     array[j + 1] = value;
        // }

        // 双指针
        int left = 0;
        int right = length - 1;
        while (left < right) {
            while (left < right && array[left] % 2 == 1) {
                left++;
            }
            while (left < right && array[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
    }

    /**
     * 链表中倒数第 k 个节点
     *
     * @param pListHead
     * @param k
     * @return
     */
    public ListNode findKthToTail(ListNode pListHead, int k) {
        if (pListHead == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = pListHead;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (k > 0 && fast != null) {
            fast = fast.next;
            k--;
        }

        if (fast == null) {
            return null;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
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
     * 树的子结构
     *
     * @param pRoot1
     * @param pRoot2
     * @return
     */
    public boolean hasSubtree(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot1 == null || pRoot2 == null) {
            return false;
        }
        if (isSame(pRoot1, pRoot2)) {
            return true;
        }
        return hasSubtree(pRoot1.left, pRoot2) || hasSubtree(pRoot1.right, pRoot2);
    }

    private boolean isSame(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot2 == null) {
            return true;
        }
        if (pRoot1 == null || pRoot1.val != pRoot2.val) {
            return false;
        }
        return isSame(pRoot1.left, pRoot2.left) && isSame(pRoot1.right, pRoot2.right);
    }

    /**
     * 二叉树的镜像
     *
     * @param root
     */
    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        }

        mirror(root.left);
        mirror(root.right);

        TreeNode treeNode = root.left;
        root.left = root.right;
        root.right = treeNode;
    }

    /**
     * 对称的二叉树
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    private boolean isSymmetric(TreeNode root, TreeNode root1) {

        if (root == null && root1 == null) {
            return true;
        }
        if (root == null || root1 == null || root.val != root1.val) {
            return false;
        }
        return isSymmetric(root.left, root1.right) && isSymmetric(root.right, root1.left);
    }

    /**
     * 顺时针打印矩阵
     *
     * @param matrix
     * @return
     */
    public int[] printMatrix(int[][] matrix) {

        int rows = matrix.length;
        if (rows == 0) {
            return new int[]{};
        }
        int cols = matrix[0].length;

        int len = rows * cols;
        int[] temp = new int[len];
        int n = 0;

        int row = 0;
        int col = 0;

        int crow = 0;
        int ccol = 0;

        int c = rows / 2 + 1;

        for (int i = 0; i < c && n < len; i++) {
            while (col != cols && n < len) {
                temp[n++] = matrix[i][col++];
            }
            row++;
            while (row != rows && n < len) {
                temp[n++] = matrix[row++][col - 1];
            }
            col--;
            while (col > ccol && n < len) {
                temp[n++] = matrix[row - 1][--col];
            }
            row = row - 2;
            while (row > crow && n < len) {
                temp[n++] = matrix[row--][col];
            }

            crow++;
            ccol++;
            col = ccol;
            row = crow;

            cols--;
            rows--;
        }
        return temp;
    }

    /**
     * 栈的压入、弹出序列
     *
     * @param pushV
     * @param popV
     * @return
     */
    public boolean isPopOrder(int[] pushV, int[] popV) {
        int push = pushV.length;
        int pop = popV.length;
        if (push != pop) {
            return false;
        }

        int popId = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int value : pushV) {
            stack.push(value);
            while (!stack.isEmpty() && stack.peek() == popV[popId]) {
                stack.pop();
                popId++;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 不分行从上往下打印二叉树
     *
     * @param root
     * @return
     */
    public List<Integer> printFromTopToBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        int deep = maxDepth(root);
        for (int i = 1; i <= deep; i++) {
            help1(root, list, i);
        }
        return list;
    }

    /**
     * 二叉树最大深度
     *
     * @param root
     * @return
     */
    private int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int deep = 0;
        deep++;
        int i = maxDepth(root.left) + deep;
        int i1 = maxDepth(root.right) + deep;
        return Math.max(i, i1);
    }

    private void help1(TreeNode root, List<Integer> list, int i) {
        if (root == null || i == 0) {
            return;
        }
        if (i == 1) {
            list.add(root.val);
        }
        if (root.left != null) {
            help1(root.left, list, i - 1);
        }
        if (root.right != null) {
            help1(root.right, list, i - 1);
        }
    }

    /**
     * 分行从上往下打印二叉树
     *
     * @param root
     * @return
     */
    public List<List<Integer>> printFromTopToBottom1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        helpLevel(root, 0, lists);
        return lists;
    }

    private void helpLevel(TreeNode root, int i, List<List<Integer>> lists) {
        if (lists.size() == i) {
            lists.add(new ArrayList<>());
        }
        lists.get(i).add(root.val);
        if (root.left != null) {
            helpLevel(root.left, i + 1, lists);
        }
        if (root.right != null) {
            helpLevel(root.right, i + 1, lists);
        }
    }

    /**
     * 之字形打印二叉树
     *
     * @param root
     * @return
     */
    public List<List<Integer>> printFromTopToBottom2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> lists = new ArrayList<>();

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                while (!stack1.isEmpty()) {
                    TreeNode node = stack1.pop();
                    list.add(node.val);
                    if (node.left != null) {
                        stack2.push(node.left);
                    }
                    if (node.right != null) {
                        stack2.push(node.right);
                    }
                }
                lists.add(list);
            }
            if (!stack2.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                while (!stack2.isEmpty()) {
                    TreeNode node = stack2.pop();
                    list.add(node.val);
                    if (node.right != null) {
                        stack1.push(node.right);
                    }
                    if (node.left != null) {
                        stack1.push(node.left);
                    }
                }
                lists.add(list);
            }
        }
        return lists;
    }

    /**
     * 二叉搜索树的后序遍历序列
     *
     * @param sequence
     * @return
     */
    public boolean verifySequenceOfBST(int[] sequence) {

        int length = sequence.length;
        if (length == 0) {
            return true;
        }
        return ju(sequence, 0, length - 1);
    }

    private boolean ju(int[] sequence, int begin, int end) {
        if (begin >= end) {
            return true;
        }
        int i = end;
        while (i > begin && sequence[i - 1] > sequence[end]) {
            i--;
        }

        for (int j = i - 1; j >= begin; j--) {
            if (sequence[i] > sequence[end]) {
                return false;
            }
        }
        return ju(sequence, begin, i - 1) && ju(sequence, i, end - 1);
    }

    /**
     * 二叉树中和为某一值的路径
     *
     * @param root
     * @param sum
     * @return
     */
    private List<List<Integer>> lists = new ArrayList<>();
    private List<Integer> list1 = new ArrayList<>();

    public List<List<Integer>> findPath1(TreeNode root, int sum) {

        if (root == null) {
            return lists;
        }
        list1.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            lists.add(new ArrayList<>(list1));
        }

        findPath1(root.left, sum);
        findPath1(root.right, sum);
        list1.remove(list1.size() - 1);
        return lists;
    }

    /**
     * 复杂链表的复制
     *
     * @param head
     * @return
     */
    public ListNode copyRandomList(ListNode head) {
        ListNode newNode = new ListNode(0);
        ListNode temp;
        while (head != null) {
            ListNode listNode = new ListNode(head.val);

            temp = newNode;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = listNode;
            if (head.random == null) {
                temp.next.random = null;
            } else {
                temp.next.random = head.random;
            }
            head = head.next;
        }
        return newNode.next;
    }

    /**
     * 二叉搜索树与双向链表
     *
     * @param root
     * @return
     */
    public TreeNode convert(TreeNode root) {

        if (root == null) {
            return null;
        }
        TreeNode last = null;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                TreeNode cur = root;
                cur.left = last;
                if (last != null) {
                    last.right = cur;
                }
                last = cur;
                root = root.right;
            }
        }
        TreeNode node = last;
        while (node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * 先序遍历
     *
     * @param root
     */
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.printf("%d ", pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.printf("%d ", root.val);
                root = root.right;
            }
        }
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    public void postOrder(TreeNode root) {
        Deque<Integer> deque = new LinkedList<>();
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            // 和传统先序遍历不一样，先将左结点入栈
            if (node.left != null) {
                stack.push(node.left);
            }
            // 后将右结点入栈
            if (node.right != null) {
                stack.push(node.right);
            }
            // 逆序添加结点值
            deque.addFirst(node.val);
        }

        for (Integer i : deque) {
            System.out.printf("%d ", i);
        }
    }

    /**
     * 数字排列
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permutation(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return new ArrayList<>();
        }
        boolean[] book = new boolean[length];
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, book, list, lists, length);
        return lists;
    }

    private void dfs(int[] nums, int n, boolean[] book, List<Integer> list, List<List<Integer>> lists, int length) {

        if (n == length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (book[i] || i > 0 && nums[i] == nums[i - 1] && book[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            book[i] = true;
            dfs(nums, n + 1, book, list, lists, length);
            book[i] = false;
            list.remove(list.size() - 1);
        }
    }

    /**
     * 数组中出现次数超过一半的数字
     *
     * @param nums
     * @return
     */
    public int moreThanHalfNum_Solution(int[] nums) {

        // int result = nums[0];
        // int times = 1;
        // for (int i = 1; i < nums.length; i++) {
        //     if (times == 0) {
        //         result = nums[i];
        //         times = 1;
        //     } else if (nums[i] == result) {
        //         times++;
        //     } else {
        //         times--;
        //     }
        // }
        // return result;

        int length = nums.length;
        int mid = length >> 1;
        int start = 0;
        int end = length - 1;
        int partition = partition(nums, start, end);
        while (partition != mid) {
            if (partition > mid) {
                end = partition - 1;
                partition = partition(nums, start, end);
            } else {
                start = partition + 1;
                partition = partition(nums, start, end);
            }
        }
        return nums[mid];
    }

    private int partition(int[] arr, int begin, int end) {
        int temp = arr[begin];
        while (begin < end) {
            while (begin < end && arr[end] >= temp) {
                end--;
            }
            arr[begin] = arr[end];
            while (begin < end && arr[begin] <= temp) {
                begin++;
            }
            arr[end] = arr[begin];
        }
        arr[begin] = temp;
        return begin;
    }

    /**
     * 最小的 k个数
     *
     * @param input
     * @param k
     * @return
     */
    public List<Integer> getLeastNumbers_Solution(int[] input, int k) {

        int length = input.length;
        if (length == 0) {
            return new ArrayList<>();
        }
        // PriorityQueue<Integer> queue = new PriorityQueue<>(4);
        // for (int value : input) {
        //     queue.add(value);
        // }
        // List<Integer> list = new ArrayList<>();
        // for (int i = 0; i < k; i++) {
        //     list.add(queue.poll());
        // }
        // return list;

        int start = 0;
        int end = length - 1;
        int partition = partition(input, start, end);
        while (partition != k - 1) {
            if (partition > k - 1) {
                end = partition - 1;
                partition = partition(input, start, end);
            } else {
                start = partition + 1;
                partition = partition(input, start, end);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        list.sort(null);
        return list;
    }

    /**
     * 数据流中的中位数
     *
     * @param num
     */
    private List<Integer> listNum = new ArrayList<>();

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public void insert(Integer num) {
        if (((minHeap.size() + maxHeap.size()) & 1) == 1) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
    }

    public Double getMedian() {
        // int[] array = listNum.stream().mapToInt(Integer::valueOf).toArray();
        // int size = listNum.size();
        // if (size % 2 == 1) {
        //     return (double) binaryselect(array, size / 2);
        //
        // } else {
        //     return (binaryselect(array, size / 2) + binaryselect(array, size / 2 - 1)) / 2.0;
        // }

        if (((minHeap.size() + maxHeap.size()) & 1) == 1) {
            return (double) maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

    private int binaryselect(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = partition(arr, start, end);
            if (mid == k) {
                return arr[mid];
            } else if (mid < k) {
                start = mid + 1;
            } else {
                end = end - 1;
            }
        }
        return -1;
    }


    /**
     * 快排 链表
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        //采用快速排序
        quickSort(head, null);
        return head;
    }

    public static void quickSort(ListNode head, ListNode end) {
        if (head != end) {
            ListNode node = partion(head, end);
            quickSort(head, node);
            quickSort(node.next, end);
        }
    }

    public static ListNode partion(ListNode head, ListNode end) {
        ListNode p1 = head;
        ListNode p2 = head.next;

        // 走到末尾才停
        while (p2 != end) {

            // 大于key值时，p1向前走一步，交换p1与p2的值
            if (p2.val < head.val) {
                p1 = p1.next;

                int temp = p1.val;
                p1.val = p2.val;
                p2.val = temp;
            }
            p2 = p2.next;
        }

        // 当有序时，不交换p1和key值
        if (p1 != head) {
            int temp = p1.val;
            p1.val = head.val;
            head.val = temp;
        }
        return p1;
    }


    /**
     * 归并 链表
     *
     * @param head
     * @return
     */
    public ListNode sortMList(ListNode head) {
        //采用归并排序
        if (head == null || head.next == null) {
            return head;
        }
        //获取中间结点
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;
        //合并
        return mergeSort(sortMList(head), sortMList(right));
    }

    /**
     * 获取链表的中间结点,偶数时取中间第一个
     *
     * @param head
     * @return
     */
    private ListNode getMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //快慢指针
        ListNode slow = head, quick = head;
        //快2步，慢一步
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }

    /**
     * 归并两个有序的链表
     *
     * @param head1
     * @param head2
     * @return
     */
    private ListNode mergeSort(ListNode head1, ListNode head2) {
        ListNode p1 = head1;
        ListNode p2 = head2;
        ListNode head;
        //得到头节点的指向
        if (head1.val < head2.val) {
            head = head1;
            p1 = p1.next;
        } else {
            head = head2;
            p2 = p2.next;
        }

        ListNode p = head;
        //比较链表中的值
        while (p1 != null && p2 != null) {

            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
                p = p.next;
            } else {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
            }
        }
        //第二条链表空了
        if (p1 != null) {
            p.next = p1;
        }
        //第一条链表空了
        if (p2 != null) {
            p.next = p2;
        }
        return head;
    }

    /**
     * 连续数组的最大和
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        // int preSum = nums[0];
        // int sum = preSum;
        int[] dp = new int[length];
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            // preSum = preSum > 0 ? preSum + nums[i] : nums[i];
            // sum = Math.max(preSum, sum);
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            // dp[i] = Math.max(dp[i], dp[i - 1]);
        }
        int max = dp[0];
        for (int i = 1; i < length; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    /**
     * 两个链表的第一个公共节点
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode findFirstCommonNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (!set.add(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * 平衡二叉树
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {

        return getDepth(root) > 0;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        if (left < 0) {
            return -1;
        }
        int right = getDepth(root.right);
        if (right < 0) {
            return -1;
        }
        int diff = left - right;
        if (diff > 1 || diff < -1) {
            return -1;
        }
        return 1 + Math.max(left, right);
    }

    private int getMaxDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getMaxDeep(root.left);
        int right = getMaxDeep(root.right);
        return Math.max(left, right) + 1;
    }

    private int getMinDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getMinDeep(root.left);
        int right = getMinDeep(root.right);
        return Math.min(left, right) + 1;
    }

    /**
     * 打印从 1 到最大的 n位数
     *
     * @param n
     */
    public void printToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        Arrays.fill(number, '0');
        while (!increment(number)) {
            printNumber(number);
        }
    }

    private void printNumber(char[] number) {
        boolean begin = true;
        for (char c : number) {
            if (begin && c != '0') {
                begin = false;
            }
            if (!begin) {
                System.out.printf("%c", c);
            }
        }
        System.out.println();
    }

    private boolean increment(char[] number) {
        boolean isOverflow = false;
        int nTakeOver = 0;
        int length = number.length;
        for (int i = length - 1; i >= 0; i--) {
            int nSum = number[i] - '0' + nTakeOver;
            if (i == length - 1) {
                nSum++;
            }
            if (nSum >= 10) {
                if (i == 0) {
                    isOverflow = true;
                } else {
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = (char) ('0' + nSum);
                }
            } else {
                number[i] = (char) ('0' + nSum);
                break;
            }
        }
        return isOverflow;
    }

    /**
     * 礼物的最大价值
     *
     * @param grid
     * @return
     */
    public int getMaxValue(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < cols; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][cols - 1];
    }

    /**
     * 数字序列中某一位数字
     *
     * @param n
     * @return
     */
    public int digitAtIndex(int n) {
        if (n < 0) {
            return -1;
        }
        int digit = 1;
        while (true) {
            int number = countOfIntegers(digit);
            int i = number * digit;
            if (i < 0) {
                i = Integer.MAX_VALUE;
            }
            if (n < i) {
                return digitAtIndex(n, digit);
            }
            n -= i;
            digit++;
        }
    }

    private int digitAtIndex(int n, int digit) {
        long number = beginNumber(digit) + n / digit;
        int index = digit - n % digit;
        for (int i = 1; i < index; i++) {
            number /= 10;
        }
        return (int) (number % 10);
    }

    private long beginNumber(int digit) {
        if (digit == 1) {
            return 0;
        }
        return (long) Math.pow(10, digit - 1);
    }

    private int countOfIntegers(int digit) {
        if (digit == 1) {
            return 10;
        }
        int count = (int) Math.pow(10, digit - 1);
        return 9 * count;
    }

    /**
     * 最长不含重复字符的子字符串
     *
     * @param s
     * @return
     */
    public int longestSubstringWithoutDuplication(String s) {
        // if (s == null || s.equals("")) {
        //     return 0;
        // }
        // Set<Character> set = new HashSet<>();
        // int count = 0;
        // int sum = 0;
        // int length = s.length();
        // int i = 0;
        // while (i < length) {
        //     if (set.add(s.charAt(i))) {
        //         count++;
        //     } else {
        //         char c = s.charAt(i);
        //         while (s.charAt(--i) != c);
        //         set.clear();
        //         count = 0;
        //     }
        //     sum = Math.max(count, sum);
        //     i++;
        // }
        // return sum;


        // DP
        // int curLength = 0;
        // int maxLength = 0;
        // int[] dp = new int[26];
        // for (int i = 0; i < 26; i++) {
        //     dp[i] = -1;
        // }
        // for (int i = 0; i < s.length(); i++) {
        //     int index = s.charAt(i) - 'a';
        //     int preIndex = dp[index];
        //     if (preIndex < 0 || i - preIndex > curLength) {
        //         ++curLength;
        //     } else {
        //         if (curLength > maxLength) {
        //             maxLength = curLength;
        //         }
        //         curLength = i - preIndex;
        //     }
        //     dp[index] = i;
        // }
        // if (curLength > maxLength) {
        //     maxLength = curLength;
        // }
        // return maxLength;

        int n = s.length();
        int max = 0;
        int[] temp = new int[128];
        for (int i = 0, j = 0; i < n; i++) {
            j = Math.max(temp[s.charAt(i)], j);
            max = Math.max(max, i - j + 1);
            temp[s.charAt(i)] = i + 1;
        }
        return max;
    }


    /**
     * 把数组排成最小的数
     *
     * @param nums
     * @return
     */
    public String printMinNumber(int[] nums) {
        StringBuilder s = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });

        for (int i : list) {
            s.append(i);
        }
        return s.toString();
    }

    /**
     * 把数字翻译成字符串
     * @param s
     * @return
     */
    public int getTranslationCount(String s) {

        char[] chars = s.toCharArray();
        int length = chars.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return 1;
        }
        int[] dp = new int[length];
        dp[0] = 1;
        dp[1] = 1;
        if (chars[0] == '1' || (chars[0] == '2' && chars[1] < '6')) {
            dp[1] = 2;
        }
        for (int i = 2; i < length; i++) {
            dp[i] = dp[i - 1];
            if (chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[i] < '6')) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[length - 1];
    }

    /**
     * 丑数
     * @param n
     * @return
     */
    public int getUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        // int number = 0;
        // int uglyCount = 0;
        // while (uglyCount < n) {
        //     number++;
        //     if (isUgly(number)) {
        //         uglyCount++;
        //     }
        // }
        // return number;

        int[] pUglyNumbers = new int[n];
        pUglyNumbers[0] = 1;
        int next = 1;

        int i = 0;
        int j = 0;
        int k = 0;
        while (next < n) {
            int min = Math.max(Math.min(pUglyNumbers[i] * 2, pUglyNumbers[j] * 3), pUglyNumbers[k] * 5);
            pUglyNumbers[next] = min;
            while (pUglyNumbers[i] * 2 <= pUglyNumbers[next]) {
                i++;
            }
            while (pUglyNumbers[j] * 3 <= pUglyNumbers[next]) {
                j++;
            }
            while (pUglyNumbers[k] * 5 <= pUglyNumbers[next]) {
                k++;
            }
            next++;
        }
        return pUglyNumbers[n - 1];
    }

    private boolean isUgly(int number) {
        while (number % 2 == 0) {
            number /= 2;
        }
        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }
        return number == 1;
    }

    public int duplicateInArray11(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        int l = 1;
        int r = length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            int s = 0;
            for (int i : nums) {
                int b = i >= l && i <= mid ? 1 : 0;
                s += b;
            }
            if (s > mid - l + 1) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    /**
     * 字符串中第一个只出现一次的字符
     * @param s
     * @return
     */
    public char firstNotRepeatingChar(String s) {

        if (s == null) {
            return '#';
        }
        int length = s.length();
        if (length == 0) {
            return '#';
        }
        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (char i : chars) {
            if (map.get(i) == null) {
                map.put(i, 1);
            } else {
                Integer integer = map.get(i);
                map.put(i, ++integer);
            }
        }
        Set<Character> characters = map.keySet();
        for (Character c : characters) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return '#';
    }

    //Insert one char from stringstream
    Map<Character, Integer> map = new LinkedHashMap<>();
    public void insert(char ch){
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }
    //return the first appearence once char in current stringstream
    public char firstAppearingOnce(){
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> c : entries) {
            if (c.getValue() == 1) {
                return c.getKey();
            }
        }
        return '#';
    }

    /**
     * 数字在排序数组中出现的次数
     * @param nums
     * @param k
     * @return
     */
    public int getNumberOfK(int[] nums, int k) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int i = firstSearch1(nums, 0, length - 1, k);
        if (i == -1) {
            return 0;
        }
        int i1 = lastSearch1(nums, 0, length - 1, k);
        return i1 - i + 1;
    }

    private int firstSearch1(int[] a, int low, int high, int value) {
        // int low = 0;
        // int high = n - 1;
        // while (low <= high) {
        //     int mid = low + ((high - low) >> 1);
        //     if (a[mid] > value) {
        //         high = mid - 1;
        //     } else if (a[mid] < value) {
        //         low = mid + 1;
        //     } else {
        //         if (mid == 0 || a[mid - 1] != value) {
        //             return mid;
        //         } else {
        //             high = mid - 1;
        //         }
        //     }
        // }
        // return -1;

        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (a[mid] > value) {
            high = mid - 1;
        } else if (a[mid] < value) {
            low = mid + 1;
        } else {
            if (mid == 0 || a[mid - 1] != value) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
        return firstSearch1(a, low, high, value);
    }

    private int lastSearch1(int[] a, int low, int high, int value) {
        // int low = 0;
        // int high = n - 1;
        // while (low <= high) {
        //     int mid = low + ((high - low) >> 1);
        //     if (a[mid] > value) {
        //         high = mid - 1;
        //     } else if (a[mid] < value) {
        //         low = mid + 1;
        //     } else {
        //         if (mid == n - 1 || a[mid + 1] != value) {
        //             return mid;
        //         } else {
        //             low = mid + 1;
        //         }
        //     }
        // }
        // return -1;

        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (a[mid] > value) {
            high = mid - 1;
        } else if (a[mid] < value) {
            low = mid + 1;
        } else {
            if (mid == a.length - 1 || a[mid + 1] != value) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        return lastSearch1(a, low, high, value);
    }

    /**
     * 数组中数值和下标相等的元素
     * @param nums
     * @return
     */
    public int getNumberSameAsIndex(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] < mid) {
                low = mid + 1;
            } else if (nums[mid] > mid) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二叉搜索树的第k个结点
     * @param root
     * @param k
     * @return
     */
    public TreeNode kthNode(TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        while ((!stack.isEmpty() || root != null) && k > 0) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (k == 1) {
                    return root;
                }
                root = root.right;
            }
            k--;
        }
        return null;
    }

    /**
     * 数组中只出现一次的两个数字
     * @param nums
     * @return
     */
    public int[] findNumsAppearOnce(int[] nums) {

        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        int first = findFirstBits(result);
        int num1 = 0;
        int num2 = 0;
        for (int num : nums) {
            if (isBit(num, first)) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        return new int[]{num1, num2};
    }

    private boolean isBit(int num, int first) {
        num = num >> first;
        return (num & 1) == 1;
    }

    private int findFirstBits(int result) {
        int index = 0;
        while ((result & 1) == 0) {
            result = result >> 1;
            ++index;
        }
        return index;
    }

    /**
     * 数组中唯一只出现一次的数字
     * @param nums
     * @return
     */
    public int findNumberAppearingOnce(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] temp = new int[32];
        for (int num : nums) {
            int bitMark = 1;
            for (int j = 31; j >= 0; j--) {
                int bit = num & bitMark;
                if (bit == 1) {
                    temp[j] += 1;
                }
                bitMark = bitMark << 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result += temp[i] % 3;
        }
        return result;
    }

    /**
     * 和为S的两个数字
     * @param nums
     * @param target
     * @return
     */
    public int[] findNumbersWithSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(target - i)) {
                return new int[]{i, target - i};
            } else {
                set.add(i);
            }
        }
        return new int[]{};
    }

    /**
     * 和为S的连续正数序列
     * @param sum
     * @return
     */
    public List<List<Integer>> findContinuousSequence(int sum) {
        int left = 1;
        int right = 2;
        int mid = (sum >> 1) + 1;

        int tempSum = left + right;
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        while (left <= mid && right <= mid) {

            if (tempSum < sum) {
                right++;
                tempSum += right;
            } else if (tempSum > sum) {
                tempSum -= left;
                left++;
            } else {
                for (int i = left; i <= right; i++) {
                    list.add(i);
                }
                lists.add(new ArrayList<>(list));
                list.clear();
                tempSum -= left;
                left++;
            }
        }
        return lists;
    }

    /**
     * 翻转单词顺序
     * @param s
     * @return
     */
    public String reverseWords(String s) {

        char[] chars = s.toCharArray();

        int len = chars.length - 1;
        reverse(chars, 0, len);

        int start = 0;
        int end = 0;
        for (char c : chars) {
            if (c == ' ') {
                reverse(chars, start, end - 1);
                start = end + 1;
                end++;
            } else if (end == len) {
                reverse(chars, start, end);
                break;
            } else {
                end++;
            }
        }
        return new String(chars);
    }

    private void reverse(char[] arr, int start, int end) {
        int mid = (end - start) >> 1;
        for (int i = 0; i <= mid; i++) {
            char temp = arr[start + i];
            arr[start + i] = arr[end - i];
            arr[end - i] = temp;
        }
    }

    /**
     * 左旋转字符串
     * @param str
     * @param n
     * @return
     */
    public String leftRotateString(String str, int n) {
        if (str == null) {
            return "";
        }
        int length = str.length();
        char[] chars = str.toCharArray();
        reverse(chars, 0, length - 1);
        reverse(chars, 0, length - n - 1);
        reverse(chars, length - n, length - 1);
        return new String(chars);
    }

    /**
     * 树中两个结点的最低公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    private List<TreeNode> l1 = new ArrayList<>();
    private List<TreeNode> l2 = new ArrayList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // List<TreeNode> ll1 = new ArrayList<>();
        //
        // List<TreeNode> ll2 = new ArrayList<>();
        // findRoot1(root, p, ll1);
        // findRoot2(root, q, ll2);
        //
        // int i = 0;
        // int s1 = l1.size();
        // int s2 = l2.size();
        // TreeNode temp = null;
        // while (i < s1 && i < s2) {
        //     if (l1.get(i) != l2.get(i)) {
        //         return temp;
        //     }
        //     temp = l1.get(i);
        //     i++;
        // }
        // return temp;

        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    private void findRoot1(TreeNode root, TreeNode node, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        if (root == node) {
            l1 = new ArrayList<>(list);
            return;
        }
        findRoot1(root.left, node, list);
        findRoot1(root.right, node, list);
        list.remove(list.size() - 1);
    }

    private void findRoot2(TreeNode root, TreeNode node, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        if (root == node) {
            l2 = new ArrayList<>(list);
            return;
        }
        findRoot2(root.left, node, list);
        findRoot2(root.right, node, list);
        list.remove(list.size() - 1);
    }

    /**
     * 滑动窗口的最大值
     * @param nums
     * @param k
     * @return
     */
    public int[] maxInWindows(int[] nums, int k) {
        // int length = nums.length;
        // int[] temp = new int[length - k + 1];
        // int index = 0;
        // for (int i = 0; i <= length - k; i++) {
        //     int max = nums[i];
        //     for (int j = 1; j < k; j++) {
        //         if (nums[j + i] > max) {
        //             max = nums[j + i];
        //         }
        //     }
        //     temp[index++] = max;
        // }
        // return temp;

        int length = nums.length;
        int[] res = new int[length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (!deque.isEmpty() && i - deque.getFirst() >= k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (i >= k - 1) {
                res[index++] = nums[deque.getFirst()];
            }
        }
        return res;
    }

    /**
     * 骰子的点数
     * @param n
     * @return
     */
    private int maxValue = 6;
    public int[] numberOfDice(int n) {

        if (n < 1) {
            return new int[]{};
        }
        int maxSum = n * maxValue;
        int[] temp = new int[maxSum - n + 1];

        probability(n, temp);
        return temp;
    }

    private void probability(int n, int[] temp) {
        for (int i = 1; i <= maxValue; i++) {
            probability(n, n, i, temp);
        }
    }

    private void probability(int original, int current, int sum, int[] temp) {
        if (current == 1) {
            temp[sum - original]++;
        } else {
            for (int i = 1; i <= maxValue; i++) {
                probability(original, current - 1, i + sum, temp);
            }
        }
    }

    /**
     * 圆圈中最后剩下的数字
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int index = 0;
        while (list.size() > 1) {
            for (int i = 1; i < m; i++) {
                index = (index + 1) % list.size();
            }
            list.remove(index);
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 3, 5, 6};
        Solution solution = new Solution();

        // System.out.println(solution.getMissingNumber(nums));
        //
        // System.out.println(solution.duplicateInArray1(new int[]{2,3,5,4,3,2,6,7}));
        //
        // int[][] arrays = new int[][]{
        //         {1,2,8,9},
        //         {2,4,9,12},
        //         {4,7,10,13},
        //         {6,8,11,15}
        // };
        //
        // System.out.println(solution.searchArray(new int[][]{}, 5));

        // String s = "We are happy.";
        // StringBuffer sb = new StringBuffer(s);
        // System.out.println(solution.replaceSpaces(sb));
        //
        // System.out.println(solution.movingCount(7, 4, 5));
        //
        //
        // System.out.println(solution.maxProductAfterCutting(10));
        //
        // System.out.println(solution.NumberOf1(-9));
        //
        // System.out.println(solution.Power(0, -2));
        //
        // int[] arr = new int[]{1,2,3,3,4,4,5};
        // ListNode dummy = new ListNode(0);
        // ListNode temp;
        // int length = arr.length;
        // int i = 0;
        // while (length-- > 0) {
        //     ListNode node = new ListNode(arr[i++]);
        //     temp = dummy;
        //     while (temp.next != null) {
        //         temp = temp.next;
        //     }
        //     temp.next = node;
        // }
        // ListNode listNode = solution.findKthToTail(dummy.next, 7);
        // System.out.println(listNode.val);

        int[][] matrix = new int[][]{
                {1},
                {5},
                {9}
        };
        int[] ints = solution.printMatrix(matrix);
        for (int i : ints) {
            System.out.printf("%d ", i);
        }
        System.out.println();


        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(11);
        treeNode.left.left = new TreeNode(6);
        treeNode.left.right = new TreeNode(14);
        treeNode.left.right.right = new TreeNode(5);


        // List<List<Integer>> lists = solution.printFromTopToBottom2(treeNode);
        // lists.forEach(integers -> integers.forEach(i -> System.out.printf("%d ", i)));

        solution.preOrder(treeNode);
        System.out.println();
        solution.inOrder(treeNode);
        System.out.println();
        solution.postOrder(treeNode);
        System.out.println();

        List<Integer> leastNumbers_solution = solution.getLeastNumbers_Solution(new int[]{4, 5, 1, 7, 2, 9}, 4);
        leastNumbers_solution.forEach(i -> System.out.printf("%d ", i));

        System.out.println(solution.maxSubArray(new int[]{1, -2, 3, 10, -4, 7, 2, -5}));


        System.out.println(solution.getMinDeep(treeNode));

        // solution.printToMaxOfNDigits(2);

        System.out.println(solution.getMaxValue(new int[][]{
                {2, 3, 1},
                {1, 7, 1},
                {4, 6, 1}
        }));

        System.out.println(solution.longestSubstringWithoutDuplication("kcowegerrbhwdqvxzudfiqecgexwsfxshqrkfwhqvxpzigithslrqzxiehurjdztugqpclekpdrihxdgmxzvnxqnsedmbyyywbnm"));


        System.out.println(solution.printMinNumber(new int[]{3,32,321}));

        System.out.println(solution.getTranslationCount("12258"));

        System.out.println(solution.duplicateInArray11(new int[]{2,3,5,4,4,2,6,7}));

        System.out.println(solution.findNumberAppearingOnce(new int[]{1, 1, 1, 2, 2, 2, 3, 4, 4, 4}));

        System.out.println(solution.leftRotateString("a", 0));


        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(12);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(4);

        solution.lowestCommonAncestor(node, node.right, node.right.left);

        int[] ints1 = solution.numberOfDice(3);
        for (int i : ints1) {
            System.out.printf("%d ", i);
        }


        System.out.println(solution.reverseWords("the sky is            blue!"));

    }
}


class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode father = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

class ListNode {

    int val;

    ListNode next;

    ListNode random;

    ListNode(int x) {
        val = x;
    }
}


class MyQueue {

    private Stack<Integer> in;
    private Stack<Integer> out;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        in.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return in.empty() && out.empty();
    }
}