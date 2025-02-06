package com.learning.leetcodepractice.problems;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListProblemSolutions {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;  // Store next node
            System.out.println("Reversing: " + current.val);

            current.next = prev;  // Reverse link
            prev = current;  // Move prev forward
            current = nextNode;  // Move current forward

            System.out.println("Prev now points to: " + (prev != null ? prev.val : "null"));
        }
        return prev;  // New head of the reversed list
    }

    public static ListNode insertAtFirst(ListNode head, int x) {
        ListNode newNode = new ListNode(x);
        if (head == null) {
            return newNode;
        }
        newNode.next = head;
        head = newNode;
        return head;
    }

    public static ListNode insertAtEnd(ListNode head, int x) {
        ListNode newNode = new ListNode(x);
        if (head == null) {
            return newNode;
        }

        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;

    }

    public static ListNode findMiddle(ListNode head) {
        if (head == null) return null;

        ListNode slow = head, fast = head;

        while (slow != null && fast.next != null) {
            slow = slow.next;         // Move one step
            fast = fast.next.next;    // Move two steps
        }
        return slow;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        // Reversing the linked list
        head = reverseList(head);

        System.out.println("Reversed List:");
        printList(head);

        ListNode middle = findMiddle(head);
        System.out.println("Middle Node Value: " + middle.val);
    }
}
