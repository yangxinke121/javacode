package org.linkedListProblem;

public class RemoveLastKthNode {

    private static Node solution(Node head, int k) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node fast = dummy;
        Node slow = dummy;
        while(k > 0){
            if (fast.next == null) {
                return dummy.next;
            }
            fast = fast.next;
            k--;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        if(slow.next != null)
            slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        Node solution = solution(head, 1);

        while (solution != null) {
            System.out.printf("%d ", solution.data);
            solution = solution.next;
        }
    }
}
