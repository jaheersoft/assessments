package com.workouts.problems.datastructures;

import java.util.Stack;

public class LinkedList<T> {

    private Node<T> head;
    private int size;

    public LinkedList() {
        this.head = null;
        size = 0;
    }
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addAtHead(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = this.head; //current head as next to newNode
        this.head = newNode; // now assign newNode to head
        size++;
    }

    public void addAtTail(T data) {
        if(isEmpty()) {
            head = new Node<>(data);
            return;
        }
        Node newNode = new Node(data);
        newNode.next = null;
        Node currNode = head;
        while(currNode.next != null ) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
        size++;
    }

    public LinkedList<T> reverseWithStack() {
        Stack<T> value = new Stack<>();
        while(this.head != null) {
            value.push(this.head.data);
            this.head = this.head.next;
        }
        LinkedList<T> list = new LinkedList<>();
        while(!value.isEmpty()) {
            list.addAtTail(value.pop());
        }
        return list;
    }

    public void reverseWithOutStack() {
        if(this.head == null) {
            return;
        }
        if(this.head.next == null) {
            addAtTail(this.head.data);
            return;
        }
        Node<T> prevNode = null;
        Node<T> currNode = this.head;
        while(currNode != null) {
            Node<T> nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        head = prevNode;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtTail(4);
        list.reverseWithOutStack();
        while(list.head != null) {
            System.out.println(list.head.data);
            list.head = list.head.next;;
        }

    }
}
