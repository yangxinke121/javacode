package org.linkedListProblem;

public class PrintCommonPart {

    public static void solution(Node head1, Node head2) {
        while (head1 != null && head2 != null) {
            if (head1.data > head2.data) {
                head2 = head2.next;
            } else if (head1.data < head2.data) {
                head1 = head1.next;
            } else {
                System.out.printf("%d ", head1.data);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);

        Node head2 = new Node(2);
        head2.next = new Node(3);
        head2.next.next = new Node(4);

        solution(head1, head2);

    }
}
