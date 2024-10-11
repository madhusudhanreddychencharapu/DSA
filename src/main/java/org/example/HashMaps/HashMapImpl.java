package org.example.HashMaps;


import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.LinkedList;

public class HashMapImpl {
    static class MyHashMap<K,V>{
        public static final int DEFAULT_CAPACITY = 4;
        public static final float DEFAULT_LOAD_FACTOR = 0.75f;
        private class Node{
            K key;
            V value;
            public Node(K key ,V value){
                this.key = key;
                this.value =value;
            }
        }
        private int n;//The no.of Entries in the Map
        private LinkedList<Node>[] buckets;

        public MyHashMap(){
            initBuckets(DEFAULT_CAPACITY);
        }
        public void initBuckets(int N){//where N ->capacity
            buckets = new LinkedList[N];
            for(int i = 0; i < buckets.length;i++){
                buckets[i] = new LinkedList<Node>();
            }
        }
        private int hashFunc(K key){
            int hashcode = key.hashCode();
            return Math.abs(hashcode)%DEFAULT_CAPACITY;
        }
        private int searchInBucket(LinkedList<Node> llist ,K key){
            for(int i = 0 ;i<llist.size();i++){
                if(llist.get(i).key ==key){
                    return i;
                }
            }
            return -1;
        }
        private void rehash(){
            LinkedList<Node>[] oldBuckets = buckets;
            initBuckets(oldBuckets.length*2);
            n=0; //making the size to zero because we are hashing from starting
//            for(var bucket: oldBuckets){
//                for(var node : bucket){
//                    put(node.key,node.value);
//                }
//            }

        }

        public int size(){
            return n;
        }
        public int capacity(){
            return buckets.length;
        }
        public float loadFactor(){
            return (n*1.0f)/buckets.length;
        }
        public void put(K key,V value){
            //Here first we are getting the bucket index
            int bi = hashFunc(key);
            LinkedList<Node> currBucket = buckets[bi];
            int index = searchInBucket(currBucket,key);
            if(index == -1) {//Key doesnt exist already Adding the new node
                Node node = new Node(key,value);
                currBucket.add(node);
                n++;
            }else{
                //key exist already update the Value in the node
                // currBucket.add(index,node);
                Node currNode = currBucket.get(index);
                currNode.value = value;
            }
            //If the entries greater than the threshold we should double the size
            //of array and once rehash the old buckets
            if(n>= buckets.length*DEFAULT_LOAD_FACTOR){
                rehash();
            }
        }
        public V get(K key){
            int bi = hashFunc(key);
            LinkedList<Node> currBucket = buckets[bi];
            int index = searchInBucket(currBucket,key);
            if(index == -1){  //Key not existed case
                return null;
            }else{  // key  existed case
                Node currNode = currBucket.get(index);
                return currNode.value;
            }
        }
        public V remove(K key){
            int bi = hashFunc(key);
            LinkedList<Node> currBucket = buckets[bi];
            int index = searchInBucket(currBucket,key);
            if(index != -1){
                V value =  currBucket.get(index).value;
                currBucket.remove(index);
                n--;
                return  value;

            }else {
                return null;
            }
        }
    }
    public static void main(String[] args) {
        MyHashMap<String,Integer> m1 = new MyHashMap<>();
        m1.put("madhu",21);
        m1.put("madhu",21);
        System.out.println(" size of the hash mp :"+m1.size());
        System.out.println(" capacity of hash table  :"+m1.capacity());
        System.out.println(" load factor :"+m1.loadFactor());
        m1.put("madhu",21);
        m1.put("sai",24);
        m1.put("shiva ",16);
        m1.put("tinku",13);
        System.out.println();
        System.out.println(" size of the hash mp :"+m1.size());
        System.out.println(" capactiy of hash table :"+m1.capacity());
        System.out.println(" load factor :"+m1.loadFactor());

        m1.put("ravali",32);
        m1.put("mohini",28);
        m1.put("razi",65);
        System.out.println();
        System.out.println(" size of the hash mp :"+m1.size());
        System.out.println(" capactiy of hash table :"+m1.capacity());
        System.out.println(" load factor :"+m1.loadFactor());

        m1.put("krishna",32);
        m1.put("shekar",45);
        System.out.println();
        System.out.println(" size of the hash mp :"+m1.size());
        System.out.println(" capactiy of hash table :"+m1.capacity());
        System.out.println(" load factor :"+m1.loadFactor());


//        System.out.println("Testing put method ");
//        m1.put("a",1);
//        m1.put("b",2);
//        m1.put("c",3);
//        System.out.println("The size of hashMap is : "+m1.size());
//        m1.put("a",300);
//
//        //Testing the get method
//        System.out.println("Testing get method");
//        System.out.println(m1.get("a"));
//        System.out.println(m1.get("b"));
//        System.out.println(m1.get("c"));
//
//        //Testing the remove method
//        System.out.println("the removed  value is : "+m1.remove("a"));
//        System.out.println(m1.remove("a"));
//        System.out.println("The size of HashMap is : "+m1.size());
//
//        System.out.println(m1.remove("madhu"));
    }
}
