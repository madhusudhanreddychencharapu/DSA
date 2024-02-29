package org.example.SystemDesign;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheUsingDLL {
    public Node head = new Node(-1,-1);
    public Node tail = new Node(-1,-1);
    public int capacity;
    Map<Integer,Node> mp = new HashMap<>();

    /*
    * Here we are taking two nodes intially head and tail which in Double Linked List
    * i.e head.next is pointing to , tail.prev is pointing to the head
    * Here we are doing these things in constructor.
    *
    * There are only two concepts
    * 1. Adding the node after head which is recently used or new element is added
    * 2. In get() concept which we are deleting a node and before that storing num
    *   and adding the node once again
    *
    * These things will maintain the Least Recently Used Data Structure which is to
    * delete things which are not used recently
    * */

    /*
    * Note : Here first we should check whether key is containing because if key is
    * already present then we are deleting and adding the node
    * means like doesn't depend on capacity ,what ever may be size of cache(-1 +1 = 0)
    * */
    public void put(int key , int value ){
        if(mp.containsKey(key)){
            remove(mp.get(key));
        }
        if(mp.size() == capacity){
            remove(tail.prev);
        }
        insert(key,value);
    }

    /*
    * Here concept is like if element is present first deletion and then adding the
    * same key and value(It comes in starting of node).
    * */
    public int get(int key){
        if(!mp.containsKey(key)){
            return -1;
        }else{
            Node temp = mp.get(key);
            int value = temp.value;
            remove(temp);
            insert(key,value);
            return value;
        }
    }
    public void insert(int key ,int value){
        Node node = new Node(key,value);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        mp.put(key,node);
    }
    public void remove(Node node){
        mp.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void displayCache(){
        Node temp = head;
        while(temp.next != null){
            System.out.print(temp.key+":"+temp.value);
            System.out.print("->");
            temp = temp.next;
        }
        System.out.println();
    }
    public LRUCacheUsingDLL(int capacity){
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    private class Node{
        int key;
        int value;
        Node next;
        Node prev;
        public Node(int key ,int value){
            this.key = key;
            this.value = value;
        }
    }
}
