package org.example.HashSets;

import java.util.*;

public class ThreeSumZero {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        var res = threeSumZero(arr);
        System.out.println(res);
        for(var list : res){
            //System.out.println("I am printing");
            System.out.println(list);
        }
    }
    static List<List<Integer>> threeSumZero(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        for(int i = 0;i < arr.length;i++){
           // System.out.println("I am in the outer loop");
            int x = arr[i];
            Map<Integer,Integer> mp = new HashMap<>();
            for (int j = i+1; j <arr.length;j++){
               // System.out.println("I am in the inner loop");
                int y = arr[i+1];
                int z = -x-y;
               // System.out.println("map value is :"+mp);
                if(mp.containsKey(z)){
                    //System.out.println("i a entering into if loop");
                    List<Integer> inner = new ArrayList<>();
                    inner.add(x);
                    inner.add(y);
                    inner.add(z);
                    outer.add(inner);
                    break;
                }else {
                    mp.put(arr[j],j);
                }
            }
        }
        return  outer;
    }
}
