package org.example.HashMaps;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWithZeroSum {
    public static void main(String[] args) {
        int[] arr = { 15,-2,2,-8,1,7,10,23 };
        int maxlength = largestSubArrayWithZeroSum(arr);
        System.out.println("The max subarray length bruteforce  :"+maxlength);
        System.out.println("The max subarray length optmized  :"
                +largestSubArrayWithZeroSumOptimized(arr));

    }
    static int largestSubArrayWithZeroSum(int[] arr){
        int maxlength = 0;
        for(int i = 0; i< arr.length;i++){
            int k = 0,sum = 0;
            for (int j = i;j < arr.length;j++){
                sum = sum + arr[j];
                k++;
                if(sum == 0){
                    if(k>maxlength){
                        maxlength = k;
                    }
                }
            }
        }
        return maxlength;
    }
    static int largestSubArrayWithZeroSumOptimized(int[] arr){
        int maxlength = 0,sum = 0;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i = 0; i <arr.length;i++){
            sum = sum + arr[i];
            if(mp.containsKey(sum)){
                maxlength = i-mp.get(sum);
            }else{
                mp.put(sum,i);
            }
        }
        return maxlength;
    }
}
