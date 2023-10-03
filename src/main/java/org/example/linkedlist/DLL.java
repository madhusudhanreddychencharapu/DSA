package org.example.linkedlist;

public class DLL {
    public Node head;
    public Node tail;
    public int index;
    public int size;

    /*
    * Here we are going to check whether DLL is empty or not
    *   if empty then head = node; tail = head;
    *
    *   else then create connection to head to newly created node and
    *   and node to the head then change the head = node.
    * */
    public void addFirst(int num){
        Node node = new Node(num);
        Node temp = head;
        if(temp == null){
            head = node;
            tail = head;
            size++;
            return;
        }

        head.prev = node;
        node.next = head;
        head = node;
        size++;
    }
    /*
    * Here we are going to check whether the size equal to zero
    *   if size is 0 then call the addFirst()
    *
    *   else there is three steps if we have tail pointer
    *   1.tail.next = node;(connection-1)
    *   2.node.prev = tail;(connection-2)
    *   3.tail = node;
    * */
    public void addLast(int num){
        if(size == 0){
            addFirst(num);
            return;
        }
       Node node = new Node(num);
       tail.next = node;
       node.prev = tail;
       tail = node;
       size++;
    }
    /*
    * Here we are checking for index = 0 and index = size-1 then calling
    * respective functions
    * Then first should be traversed up to temp equal to node of index=1
    * Then there are four different connections should be connected
    * the main important thing temp.next = node.next we are saving info here
    * directly the next function.
    * */
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
    /*
    * Here first it is having single node or multiple nodes according that
    * we are doing so.
    * */
    public int deleteFirst(){
        if(head == null){
            return -1;
        }
        if(size == 1){
            int tempNum = head.num;
            head = null;
            tail = null;
            size--;
            return tempNum;
        }
        int tempNum = head.num;
        head = head.next;
        head.prev = null;
        size--;
        return tempNum;
    }
    public int deleteLast(){
        if(head.next == null){
            int tempNum = head.num;
            head = null;
            tail = null;
            return tempNum;
        }
        int tempNum = tail.num;
        Node nodetemp = tail.prev;
        tail.prev = null;
        tail = nodetemp;
        tail.next = null;

        return tempNum;
    }
    public int deleteAtIndex(int index){
        int i = 0;
        Node temp = head;
        while (i++ < index-1){
            temp = temp.next;
        }
        int tempNum = temp.next.num;
        temp.next = temp.next.next;
        temp.next.prev = temp;
        return tempNum;
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
