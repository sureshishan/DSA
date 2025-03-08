package com.dsa.airtribedsa.ll;

public class LinkedListADT {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        Node head = new Node(10);

        Node second = new Node(20);
        head.next = second;

        Node third = new Node(30);
        second.next = third;

        Node fourth = new Node(40);
        third.next = fourth;

        printLinkedList(head);
        System.out.println();
        sizeOfLinkedList(head);
        System.out.println();
        System.out.println("After inserting 25 at position 2");
        insertAtKthPosition(head, 2, 25);
        System.out.println();
        sizeOfLinkedList(head);
        System.out.println();

        insertAtTheTail(head, 100);
        System.out.println("After inserting 100 at the tail");
        printLinkedList(head);
        System.out.println();
        sizeOfLinkedList(head);
        System.out.println();
//        oddDataNodesFirstThenEvenDataNodes(head);

        evenDataNodesFirstThenOddDataNodes(head);

        reverseTheLinkedList(head);

    }

    private static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    private static void insertAtKthPosition(Node head, int k, int data) {
        Node temp = head;
        Node newNode = new Node(data);
        int count = 1;
        while (temp != null) {
            if (count == k - 1) {
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            count++;
            temp = temp.next;
        }
        printLinkedList(head);
    }

    private static int sizeOfLinkedList(Node head) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Size of linked list is: " + count);
        return count;
    }

    private static void insertAtTheTail(Node head, int data) {
        Node temp = head;
        Node newNode = new Node(data);

        while (temp.next != null) {
            temp = temp.next;

        }
        temp.next = newNode;
    }

    private static void oddDataNodesFirstThenEvenDataNodes(Node head) {
        Node temp = head;
        Node oddHead = null;
        Node oddTemp = null;
        Node evenHead = null;
        Node evenTemp = null;

        while (temp != null) {
            if (temp.data % 2 != 0) {
                if (oddHead == null) {
                    oddHead = temp;
                    oddTemp = temp;
                } else {
                    oddTemp.next = temp;
                    oddTemp = oddTemp.next;
                }
            } else {
                if (evenHead == null) {
                    evenHead = temp;
                    evenTemp = temp;
                } else {
                    evenTemp.next = temp;
                    evenTemp = evenTemp.next;
                }
            }
            temp = temp.next;
        }

        oddTemp.next = evenHead;
        evenTemp.next = null;

        printLinkedList(oddHead);
    }

    private static void reverseTheLinkedList(Node head) {
        Node next = null;
        Node current = head;
        Node prev = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        System.out.println("After reversing the linked list");
        printLinkedList(head);
    }

    private static void evenDataNodesFirstThenOddDataNodes(Node head) {
        Node temp = head;
        Node evenHead = null;
        Node evenTemp = null;
        Node oddHead = null;
        Node oddTemp = null;

        while (temp != null) {
            if (temp.data % 2 == 0) {
                if (evenHead == null) {
                    evenHead = temp;
                    evenTemp = temp;
                } else {
                    evenTemp.next = temp;
                    evenTemp = evenTemp.next;
                }
            } else {
                if (oddHead == null) {
                    oddHead = temp;
                    oddTemp = temp;
                } else {
                    oddTemp.next = temp;
                    oddTemp = oddTemp.next;
                }

            }
            temp = temp.next;
        }

        evenTemp.next = oddHead;
        oddTemp.next = null;
        printLinkedList(head);
    }
}
