package org.example.linkedlist;

public class CLL {
    private Node head;
    private Node tail;
    private int Size;

    public void insert(int num){
        Node node = new Node(15);
        Node temp = head;
        if(head == null){
            head = node;
            tail = node;
            return;
        }
       // while (temp)

    }
    private class Node{
        int num;
        Node node;

        public Node(int num){
            this.num = num;
        }
    }
}