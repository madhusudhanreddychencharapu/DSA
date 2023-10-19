package org.example.HashMaps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxSubArraySumOfLengthK {
    public static void main(String[] args) {
        //int[] arr = { 100,101,102,2,8,6,15,12,7,1,10 };
         int[] arr = {1,1,1,7,8,9};
        //int[] arr = { 1,5,4,2,9,9,9,9};
        int res = maxSubArraySumOfLengthK(arr,3);
        System.out.println("The max sum of k sum subarray :"+res);
        System.out.println("The max sum of k sum subarray optimized :"
         +maxSubArraySumOfSizeKOptimized(arr,3));
    }
    static int maxSubArraySumOfLengthK(int[] arr ,int k){
        int maxsum = 0;
        for(int i = 0;i< arr.length-k+1;i++){
            int tempsum = 0;
            for (int j = i; j < k+i; j++){
                tempsum = tempsum + arr[j];
            }
            maxsum = Math.max(tempsum,maxsum);
        }
        return maxsum;
    }
    static int maxSubArraySumOfSizeKOptimized(int[] arr ,int k){
        int sum = 0, maxlen = 0;
        Set<Integer> st = new HashSet<>();
        for(int i = 0;i < arr.length; i++){
            if(i < k-1){
                if(!st.contains(arr[i])) {
                    st.add(arr[i]);
                    sum = sum + arr[i];
                }
            }else if(i == k-1){
                if(!st.contains(arr[i])) {
                    st.add(arr[i]);
                    sum = sum + arr[i];
                    maxlen = sum;
                }
            }
            else{
                if(!st.contains(arr[i])){
                    st.add(arr[i]);
                    if(st.size() <= k) {
                        sum = sum + arr[i];
                        maxlen = Math.max(maxlen, sum);
                    }else {
                        st.remove(arr[i-k]);
                        sum = sum + arr[i] - arr[i - k];
                        maxlen = Math.max(maxlen, sum);
                    }
                }
            }
        }
        return maxlen;
    }
}
