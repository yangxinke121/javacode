package org.learn;

import sun.awt.geom.AreaOp;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

    // private static class Node{
    //     private int data;
    //     private Node next;
    //
    //     Node(int data) {
    //         this.data = data;
    //     }
    // }
    //
    // private static Node head;
    //
    // public static void reverseLinkedList() {
    //     if (head == null || head.next == null) {
    //         return;
    //     }
    //     Node p1 = head;
    //     Node p2 = head.next;
    //     Node p3;
    //     while (p2 != null) {
    //         p3 = p2.next;
    //         p2.next = p1;
    //         p1 = p2;
    //         p2 = p3;
    //     }
    //     head.next = null;
    //     head = p1;
    // }
    //
    public static void main(String[] args) {
        // head = new Node(3);
        // head.next = new Node(5);
        // Node temp = head.next;
        // temp.next = new Node(1);
        // temp = temp.next;
        // temp.next = new Node(4);
        // temp = temp.next;
        // temp.next = new Node(7);
        //
        // temp = head;
        // while (temp != null) {
        //     System.out.printf("%d ", temp.data);
        //     temp = temp.next;
        // }
        //
        // reverseLinkedList();
        // System.out.println();
        // temp = head;
        // while (temp != null) {
        //     System.out.printf("%d ", temp.data);
        //     temp = temp.next;
        // }

            // Class<?> testLoad = Class.forName("org.learn.TestLoad");
            // testLoad.newInstance();

            Class<TestLoad> testLoadClass = TestLoad.class;
            // Constructor<TestLoad> constructor = testLoadClass.getDeclaredConstructor((Class<?>) null);
            // constructor.newInstance();

    }

    // public static void main(String[] args) {
    //     Student student = new Student();
    //     StudentProxy studentProxy = new StudentProxy(student);
    //     Person o = (Person) Proxy.newProxyInstance(student.getClass().getClassLoader(), student.getClass().getInterfaces(), studentProxy);
    //
    //     o.sayHello("yxk", 24);
    //     o.sayGoodBye(true, 12);
    // }

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private static Node head;

    private static void reverseLinkedList() {
        if (head == null || head.next == null) {
            return;
        }
        Node p1 = head;
        Node p2 = head.next;
        Node p3;

        while (p2 != null) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        head.next = null;
        head = p1;
    }

    private static class ListNode{
        private int data;
        private ListNode next;

        ListNode(int data) {
            this.data = data;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode fast = first;
        ListNode slow = first;
        while (fast.next != null) {
            if (n <= 0) {
                slow = slow.next;
            }
            fast = fast.next;
            n--;
        }
        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        return slow;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static ListNode reverseList1(ListNode head, int m) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        while (m > 0) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            m--;
        }
        return pre;
    }

    public static ListNode recursionList(ListNode head, ListNode next) {
        if (head == null) {
            return next;
        }
        ListNode node = head.next;
        head.next = next;
        return recursionList(node, head);
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre1 = dummy;
        for (int i = 0; i < m - 1; i++) {
            pre1 = pre1.next;
        }
        ListNode start = pre1.next;
        ListNode pre2 = dummy;
        for (int i = 0; i < n - 1; i++) {
            pre2 = pre2.next;
        }
        ListNode end = pre2.next.next;

        // ListNode then = start.next;
        //
        // for (int i = 0; i < n - m; i++) {
        //     start.next = then.next;
        //     then.next = pre.next;
        //     pre.next = then;
        //     then = start.next;
        // }
        ListNode node = reverseList1(start, n - m + 1);
        pre1.next = node;
        start.next = end;
        return dummy.next;
    }
}
