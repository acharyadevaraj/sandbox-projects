package com.learning.leetcodepractice.problems;

class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

public class LinkedListProblemSolutions {

    /**
     * Reverses a given linked list.
     * <p>
     * Approach:
     * 1. Initialize 'prev' as null and 'current' as head.
     * 2. Iterate through the list, reversing the links.
     * 3. Return 'prev' as the new head of the reversed list.
     *
     * @param head The head node of the linked list.
     * @return The new head of the reversed linked list.
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    /**
     * Inserts a new node at the beginning of the linked list.
     *
     * @param head The head node of the linked list.
     * @param x    The value of the new node.
     * @return The new head of the linked list.
     */
    public static ListNode insertAtFirst(ListNode head, int x) {
        ListNode newNode = new ListNode(x);
        newNode.next = head;
        head = newNode;
        return head;
    }

    /**
     * Inserts a new node at the end of the linked list.
     *
     * @param head The head node of the linked list.
     * @param x    The value of the new node.
     * @return The head of the linked list after insertion.
     */
    public static ListNode insertAtEnd(ListNode head, int x) {
        ListNode newNode = new ListNode(x);
        if (head == null) {
            return newNode;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    /**
     * Finds the middle node of the linked list.
     * <p>
     * Approach:
     * 1. Use two pointers: 'slow' (moves 1 step) and 'fast' (moves 2 steps).
     * 2. When 'fast' reaches the end, 'slow' will be at the middle.
     *
     * @param head The head node of the linked list.
     * @return The middle node of the linked list.
     */
    public static ListNode findMiddle(ListNode head) {
        if (head == null) return null;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * Finds the last node value of the linked list.
     *
     * @param head The head node of the linked list.
     * @return The value of the last node.
     */
    public static int findLastValue(ListNode head) {
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.value;
    }

    /**
     * Swaps consecutive pairs of nodes in the linked list.
     * <p>
     * Approach:
     * 1. Use a dummy node to simplify head manipulation.
     * 2. Swap adjacent nodes in pairs.
     * 3. Adjust pointers to maintain the list structure.
     *
     * @param head The head node of the linked list.
     * @return The head of the modified list.
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = first.next;
            first.next = second.next;
            second.next = first;
            prev.next = second;
            prev = first;
        }
        return dummy.next;
    }

    /**
     * Finds the Nth node from the end of the linked list.
     *
     * @param head The head node of the linked list.
     * @param n    The position from the end.
     * @return The Nth node from the end.
     */
    public static ListNode findNthElementEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;
        for (int i = 0; i < n; i++) {
            if (fast == null) return null;
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * Finds the Nth node from the start of the linked list.
     *
     * @param head The head node of the linked list.
     * @param n    The position from the start.
     * @return The Nth node from the start.
     */
    public static ListNode findNthElementStart(ListNode head, int n) {
        ListNode current = head;
        for (int i = 1; i < n; i++) {
            if (current == null) return null;
            current = current.next;
        }
        return current;
    }

    /**
     * Prints the linked list elements.
     *
     * @param head The head node of the linked list.
     */
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        head = reverseList(head);
        System.out.println("Reversed List:");
        printList(head);

        ListNode middle = findMiddle(head);
        System.out.println("Middle Node Value: " + middle.value);

        int last = findLastValue(head);
        System.out.println("Last Node Value: " + last);

        head = swapPairs(head);
        System.out.println("List after swapping consecutive nodes:");
        printList(head);
    }
}