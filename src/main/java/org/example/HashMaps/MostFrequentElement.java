package org.example.HashMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MostFrequentElement {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,2,1,4,1,1,1,3,3,4,3};
        System.out.println("The most Frequent Element is :"+mostFrequentElement(arr));
    }
    static int mostFrequentElement(int[] arr){
        int maxfreq  = 0 , key = 0;
        Map<Integer,Integer> mp = new HashMap<>();
        for(Integer num : arr) {
            if(mp.containsKey(num)){
                mp.put(num, mp.get(num)+1);
            }else {
                mp.put(num,1);
            }
        }
        System.out.println(mp.entrySet());

        //Traversing through the entrySet Method
        /*for(var e: mp.entrySet()){
            if(e.getValue()>maxfreq){
                maxfreq = e.getValue();
                key = e.getKey();
            }
        }*/

        //Traversing through the  KeySet
        for(Integer e :  mp.keySet()){
            if(mp.get(e)>maxfreq){
                maxfreq = mp.get(e);
                key = e;
            }
        }
        return key;
    }
}
