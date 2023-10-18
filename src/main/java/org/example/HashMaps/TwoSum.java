package org.example.HashMaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int target = 8, arr[] = {3, 8, 6, 4, 6, 4, 9};
        int[] res = twoSumTarget(arr, target);
        System.out.println("This is Brute force approach :" + Arrays.toString(res));
        System.out.println("using HashMap approach :" +
                Arrays.toString(twoSumTargetHashMap(arr, target)));

    }
    /*
    *You should not use the element twice arr = {3,2,5,7} target is 6 the o/p is -1
    * It is BruteForce approach checking the every combination
    * then time complexity  is O(N^2) and space complexity is O(N)
    * we have to optimize it
    * */
    static int[] twoSumTarget(int[] nums ,int target){
        int[] res = {-1,-1};
        for (int i = 0;i < nums.length;i++){
            for(int j = 0; j < nums.length;j++){
                if(i == j){
                }else{
                    if(nums[i]+nums[j] == target){
                        res[0] = j;
                        res[1] = i;
                    }
                }
            }
        }
        return res;
    }

    /*
    * Here we are going to get in the O(N) time complexity but space complexity
    * increased to the O(1) to O(N)
    * */
    static int[] twoSumTargetHashMap(int[] nums ,int target){
        int[] res = {-1,-1};
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i  = 0; i < nums.length;i++){
            mp.put(nums[i],i);
        }
        for(int i = 0;i< nums.length;i++){
            int temp = Math.abs(nums[i]-target);
            if(mp.containsKey(temp)){
                res[0] = i;
                res[1] = mp.get(temp);
                return res;
            }
        }
        return res;
    }
    static int[] twoSumHashPerfectOptimized(int[] nums, int target) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i = 0; i< nums.length;i++){
            int temp = target - nums[i];
            if(mp.containsKey(temp)){
                return new int[]{mp.get(temp),i};
            }else{
                mp.put(nums[i],i);
            }
        }
        return null;
    }
}
