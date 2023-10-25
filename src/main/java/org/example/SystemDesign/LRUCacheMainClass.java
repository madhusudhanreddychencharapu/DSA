package org.example.SystemDesign;

public class LRUCacheMainClass {
    public static void main(String[] args) {
        LRUCacheUsingDLL lru = new LRUCacheUsingDLL(2);
//        lru.put(1,8);
//        lru.put(2,15);
//        lru.put(3,16);
//        lru.put(4,24);
//        lru.displayCache();
//        System.out.println(lru.get(4));
//        lru.displayCache();
//        lru.put(2,20);
//        lru.displayCache();
//        lru.put(9,110);
//        lru.displayCache();
//        System.out.println(lru.get(1));
        System.out.println(lru.get(2));
        lru.put(2,6);
        lru.displayCache();
        System.out.println(lru.get(1));
        lru.put(1,5);
        lru.displayCache();
        lru.put(1,2);
        lru.displayCache();
        System.out.println(lru.get(1));
        System.out.println(lru.get(2));

    }
}
