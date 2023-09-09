package org.example.HashMaps;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasic {
    public static void main(String[] args) {
        hashMapMethods();
    }
    static void hashMapMethods(){
        //syntax
        Map<String,Integer> mp = new HashMap<>();

        //Adding Elements
        mp.put("Akash",21);
        mp.put("Yash",12);
        mp.put("Lav",17);
        mp.put("Madhu",23);
        mp.put("Harry",18);
        System.out.println(mp);

        //Retrieve a value for the particular key
        System.out.println("The age of the madhu :"+mp.get("Madhu"));

        //change or update the value of the hashMap
        mp.put("Madhu",18);
        System.out.println(mp);

        //Remove a pair from the hashMap
        System.out.println("The Harry pair is removed");
        mp.remove("Harry");
        System.out.println(mp);
        System.out.println("Returns null key is not found  lets see: "+mp.remove("sai"));

        //checking if a key is in the HashMap
        System.out.println( "checking for the key yash :"+mp.containsKey("Yash"));
        System.out.println("checking for the key sai :"+ mp.containsKey("Sai"));

        //Adding the new entry if the new key doesn't already exist
        System.out.println();
        System.out.println("Trying to add the key yash");
        if(!mp.containsKey("Yash")){
            mp.put("Yash",31);
            System.out.println(mp);
        }else {
            System.out.println("The key already existed");
        }
        //another direct method we can use to new entry if key doesn't exist
        System.out.println(mp.putIfAbsent("Madhu" , 24));
        System.out.println("The sai key is added through putIfAbsent method :"+mp);

        //Get all the keys in the HashMap
        System.out.println(mp.keySet());

        //Traverse all the entries of HashMap using the keySet() method
        for(String key :  mp.keySet()){
            System.out.printf("The age of %s is %d\n",key,mp.get(key));
        }

        //Get all the values in the HashMap
        System.out.println(mp.values());

        //Traverse all the entries of HashMap through entrySet Method
        System.out.println(mp.entrySet());
        for (Map.Entry<String, Integer> res : mp.entrySet()) {
            System.out.printf("The age of %s is %d \n",res.getKey(),res.getValue());
        }

    }
}
