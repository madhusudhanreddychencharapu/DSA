package org.example.revision;

import java.util.HashMap;
import java.util.Map;

public class twosumproblem {
    public static void main(String[] args) {
        int[] arr = {5, 8, 9, -3, 15};
                   //0  1  2   3   4
        int target = 6;
        int[] res = twoSumHashMap(arr,target);
        System.out.println("i :"+res[0]+"j :"+res[1]);

    }
    public static int[] twoSum(int[] arr, int target){
        int[] res = {-1,-1};
        outerloop :
        for(int i = 0;i < arr.length ;i++){
            for(int j = 0 ;j < arr.length;j++){
                if(arr[i]+arr[j] == target ){
                    res[0] = i;
                    res[1] = j;
                    break outerloop;
                }
            }
        }
        return res;
    }
    public static int[] twoSumHashMap(int[] arr ,int target){
        int[] res = {-1,-1};
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i = 0; i< arr.length ;i++){
            if(mp.containsKey(target-arr[i])){
                res[0] = i;
                res[1] = mp.get(target-arr[i]);
                break;
            }else {
                mp.put(arr[i],i);
            }
        }
        return res;
    }
}
