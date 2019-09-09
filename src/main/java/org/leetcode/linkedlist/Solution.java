package org.leetcode.linkedlist;

import java.util.*;

public class Solution {

    /**
     * 删除指定节点
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 删除链表倒数第n个节点
     * @param head
     * @param n
     * @return
     */
    private ListNode removeNthFromEnd(ListNode head, int n) {
        // ListNode dummy = new ListNode(0);
        // dummy.next = head;
        // ListNode fast = dummy;
        // ListNode slow = dummy;
        // while (n > 0) {
        //     if (fast.next == null) {
        //         return dummy.next;
        //     }
        //     fast = fast.next;
        //     n--;
        // }
        // while (fast.next != null) {
        //     fast = fast.next;
        //     slow = slow.next;
        // }
        // if (slow.next != null) {
        //     slow.next = slow.next.next;
        // }
        // return dummy.next;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while(fast.next != null){
            if(n <= 0)
                slow = slow.next;
            fast = fast.next;
            n--;
        }
        if(slow.next != null)
            slow.next = slow.next.next;
        return dummy.next;


    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // ListNode pre = head;
        // ListNode second = head.next;
        // ListNode temp;
        //
        // while (second != null) {
        //     temp = second.next;
        //     second.next = pre;
        //     pre = second;
        //     second = temp;
        // }
        // head.next = null;
        // return pre;

        ListNode temp = null;
        while (head != null) {
            ListNode p = head.next;
            head.next = temp;
            temp = head;
            head = p;
        }
        return temp;
    }

    private ListNode reverseList(ListNode head) {
        return reverseListHelper(head, null);
    }

    private ListNode reverseListHelper(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        return reverseListHelper(next, head);
    }

    /**
     * 是否为回文链表
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {

        // if (head == null) {
        //     return false;
        // }
        //
        // ListNode pre = head;
        // ListNode dummy = new ListNode(0);
        // ListNode temp;
        // while (head != null) {
        //     ListNode node = new ListNode(head.val);
        //     temp = dummy;
        //     while (temp.next != null) {
        //         temp = temp.next;
        //     }
        //     temp.next = node;
        //
        //     head = head.next;
        // }
        //
        // ListNode reverse = reverse(dummy.next);
        // while (pre != null) {
        //     if (pre.val == reverse.val) {
        //         pre = pre.next;
        //         reverse = reverse.next;
        //     } else {
        //         return false;
        //     }
        // }
        // return true;

        ListNode l = head;
        Stack<Integer> stack = new Stack<>();
        while (l != null) {
            stack.push(l.val);
            l = l.next;
        }

        while (head != null) {
            if (head.val == stack.pop()) {
                head = head.next;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {


        ListNode node = new ListNode(0);
        ListNode node1 = node;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                node.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            node = node.next;
        }

        while (l1 != null) {
            node.next = new ListNode(l1.val);
            l1 = l1.next;
            node = node.next;
        }

        while (l2 != null) {
            node.next = new ListNode(l2.val);
            l2 = l2.next;
            node = node.next;
        }
        return node1.next;
    }

    /**
     * 合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsRecur(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val <= l2.val) {
            l1.next = mergeTwoListsRecur(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsRecur(l1, l2.next);
            return l2;
        }
    }

    /**
     * 环形链表
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // ListNode dummyHead = new ListNode(0);
        // ListNode p = l1, q = l2, curr = dummyHead;
        // int carry = 0;
        // while (p != null || q != null) {
        //     int x = (p != null) ? p.val : 0;
        //     int y = (q != null) ? q.val : 0;
        //     int sum = carry + x + y;
        //     carry = sum / 10;
        //     curr.next = new ListNode(sum % 10);
        //     curr = curr.next;
        //     if (p != null) p = p.next;
        //     if (q != null) q = q.next;
        // }
        // if (carry > 0) {
        //     curr.next = new ListNode(carry);
        // }
        // return dummyHead.next;

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return dummy.next;
    }

    /**
     * 反转链表 从 m到n
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode start = pre.next;
        ListNode then = start.next;
        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        return dummy.next;
    }

    /**
     * 目标和
     * @param nums
     * @param S
     * @return
     */
    private int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        // int length = nums.length;
        // if (length == 0) {
        //     return 0;
        // }
        // findTarget(nums, 0, S, length, 0);
        // return count;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        int w = (sum + S) / 2;
        int[] dp = new int[w + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = w; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[w];
    }

    private void findTarget(int[] nums, int i, int S, int len, int sum) {
        if (i >= len) {
            if (sum == S) {
                count++;
            }
            return;
        }
        findTarget(nums, i + 1, S, len, sum - nums[i]);
        findTarget(nums, i + 1, S, len, sum + nums[i]);
    }

    /**
     * 和为 k的连续子数组 个数
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        for (int i : nums) {
            sum += i;
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    private List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> findThreeSum(int[] nums, int k, int sum) {
        List<Integer> list = new ArrayList<>();
        findThreeSum(nums, 0, k, list, sum);
        return lists;
    }

    private void findThreeSum(int[] nums, int i, int k, List<Integer> list, int sum) {
        if (i >= 9) {
            if (list.size() >= k && sum == 0) {
                lists.add(new ArrayList<>(list));
            }
            return;
        }
        findThreeSum(nums, i + 1, k, list, sum);
        list.add(nums[i]);
        findThreeSum(nums, i + 1, k, list, sum - nums[i]);
        list.remove(list.size() - 1);
    }


    private ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        for (int i = 1; i < k && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            return head;
        }
        ListNode t2 = temp.next;
        temp.next = null;
        ListNode newHead = reverse(head);
        head.next = reverseKGroup(t2, k);
        return newHead;
    }

    /**
     * 分组反转链表
     * @param head
     * @param k
     * @return
     */
    public ListNode solve(ListNode head, int k) {
        head = reverse(head);
        head = reverseKGroup(head, k);
        head = reverse(head);
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(2);
        node2.next.next = new ListNode(3);
        node2.next.next.next = new ListNode(4);
        node2.next.next.next.next = new ListNode(5);

        Solution solution = new Solution();
        // ListNode node1 = solution.removeNthFromEnd(node, 6);
        // ListNode node1 = solution.reverse(node);

        // ListNode node1 = solution.mergeTwoLists(node, null);
        // while (node1 != null) {
        //     System.out.print(node1.val + " ");
        //     node1 = node1.next;
        // }

        System.out.println(solution.isPalindrome(node));

        solution.reverseBetween(node, 1, 4);

        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));

        System.out.println(solution.subarraySum(new int[]{-1,-1,1}, 0));

        List<List<Integer>> threeSum = solution.findThreeSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 3, 9);
        for (List<Integer> list : threeSum) {
            for (Integer i : list) {
                System.out.printf("%d ", i);
            }
            System.out.println();
        }

        ListNode solve = solution.solve(node, 2);
        while (solve != null) {
            System.out.print(solve.val + " ");
            solve = solve.next;
        }
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
