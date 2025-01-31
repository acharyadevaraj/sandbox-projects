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
}
