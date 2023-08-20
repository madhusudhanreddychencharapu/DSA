package org.example.linkedlist;

public class DLL {
    public Node head;
    public Node tail;
    public int index;
    public int size;

    public void addFirst(int num){
        Node node = new Node(num);
        Node temp = head;

        if(temp != null) {
                head.prev = node;
        }
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }
        size++;
    }
    public void addLast(int num){
       Node node = new Node(num);
       tail.next = node;
       node.prev = tail;
       tail = node;
       size++;
    }
    public void addAtIndex( int index,int value) {
        Node node = new Node(value);
        Node temp = head;
        if(index == 0){
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        }
        else {
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
            node.prev = temp;
            node.next.prev = node;
            size++;
        }
    }
    public void display(){
        Node temp = head;
        while(temp!= null){
            System.out.print(temp.num+"->");
            temp = temp.next;
        }
        System.out.println("End");
    }
    public void displayReverse(){
        Node temp = tail;
        while(temp != null){
            System.out.print(temp.num+"<-");
            temp = temp.prev;
        }
        System.out.println("End");
    }
    private class Node{
        int num;
        Node next;
        Node prev;

        public Node(int num){
            this.num = num;
        }
    }
}
