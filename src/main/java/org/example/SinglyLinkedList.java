package org.example;

public class SinglyLinkedList {

    private ListNode head;
    private  ListNode tail;

class ListNode {
    int val;
    ListNode next;

    //ListNode prev;


    ListNode(int val) {
        this.val = val;
    }
}


    // Constructor
    public SinglyLinkedList() {

    head = null;

    }

    // Method to insert a new node at the beginning of the linked list
    public void insertAtBeginning(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
    }

    // Method to insert a new node at the end of the linked list
    public void insertAtEnd(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Method to delete a node with given value from the linked list
    public void delete(int val) {
        if (head == null) return;
        if (head.val == val) {
            head = head.next;
            return;
        }

        ListNode prev = null;
        ListNode current = head;
        while (current != null && current.val != val) {
            prev = current;
            current = current.next;
        }
        if (current != null) {
            prev.next = current.next;
        }
    }

    // Method to print the elements of the linked list
    public void printList() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();


    }
}
