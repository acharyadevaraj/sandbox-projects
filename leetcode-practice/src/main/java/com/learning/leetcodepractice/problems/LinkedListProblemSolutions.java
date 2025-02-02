package com.learning.leetcodepractice.problems;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListProblemSolutions {
    public static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;  // Store next node
            System.out.println("Reversing: " + current.val);

            current.next = prev;  // Reverse link
            prev = current;  // Move prev forward
            current = nextNode;  // Move current forward

            System.out.println("Prev now points to: " + (prev != null ? prev.val : "null"));
        }
        return prev;  // New head of the reversed list
    }

    public static Node insertAtFirst(Node head, int x) {
        Node newNode = new Node(x);
        if(head == null){
            return newNode;
        }
        newNode.next = head;
        head = newNode;
        return head;
    }

    public static Node insertAtEnd(Node head, int x) {
        Node newNode = new Node(x);
        if(head == null){
            return newNode;
        }

        Node temp = newNode;
        while(temp != null){
            temp = temp.next;
        }
        temp.next = newNode;
        return head;

    }
}
