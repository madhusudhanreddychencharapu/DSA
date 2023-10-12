package org.example.HashMaps;

import java.util.*;

public class HashMapPractice {
    public static void main(String[] args) {
        int arr[] = {1,1,2,2,4,5,8,1,1,9,2,2,3,2,5,2};
        Map<Integer,Integer> mp = new HashMap<>();
        int maxCount = 0 ,element = 0;

        for(int num : arr){
            if(mp.containsKey(num)){
                  mp.put(num,mp.get(num)+1);
            }else {
                mp.put(num, 1);
            }
        }

        for (int key :mp.keySet()){
            if(maxCount < mp.get(key)){
                maxCount = mp.get(key) ;
                element = key;
            }
        }
        TreeMap<Integer,Integer> sorted = new TreeMap<>();
        sorted.putAll(mp);
        System.out.println("Normal map is "+mp);
        System.out.println("Sorted map is :"+sorted);


        System.out.println(mp);
        System.out.println( "Element is : "+ element + " maxfrequency I: "+ maxCount);


//        Map<String,Integer> mp = new HashMap<>();
//        mp.put("akash",21);
//        mp.put("yash",16);
//        mp.put("lav",17);
//        mp.put("madhu",23);
//        mp.put("Hari",18);
//        //System.out.println(mp.putIfAbsent("madhus",32));
//        System.out.println(mp.containsKey("madhus"));
//
//        System.out.println(mp);

//        System.out.println("I am printing the map");
//        System.out.println(mp);
//
//        Set<String> temp = mp.keySet();
//        System.out.println("I am printing the result of mp.keyset"+temp);
//        for(String name:temp){
//            System.out.println(mp.get(name));
//        }
//
//        //another method of traversing
//        for (Map.Entry<String,Integer> entry :mp.entrySet()){
//            System.out.println("key :"+entry.getKey()+", Value :"+entry.getValue());
//        }
    }
}
