package org.example.HashSets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxSubArraySumOfLengthKOptimized {
    public static void main(String[] args) {
       int[] arr = {1,1,1,7,8,9};
       //int[] arr = {9,9,9,1,2,3};
        System.out.println(maxSumOfDistinctSubarray(arr,3));
        System.out.println("I am done executing the function");
    }
    static int maxSumOfDistinctSubarray(int[] arr ,int k){
        int i = 0,j = 0 ,sum = 0 ,maxsum = 0;
        Map<Integer,Integer> mp = new HashMap<>();
        while(j < arr.length){
            sum = sum + arr[j];
            //Here we are counting the frequency of elements of subarray
            if(j < arr.length) {
                if (mp.containsKey(arr[j])) {
                    mp.put(arr[j], mp.get(arr[j]) + 1);
                } else {
                    mp.put(arr[j], 1);
                }
            }
            if((j-i+1) < k){
                j++;
            }else if(j-i+1 == k) {
                // checking the condition for the max sum
                if(mp.size() == k){
                    maxsum = Math.max(sum,maxsum);
                }
                sum = sum - arr[i];

                /* here we are going to remove elements after checking because
                 * for ex [9,9,9,1,2,3] here 9 occurred thrice the key -value stores
                 * as 9(key) - 3(value) without checking if we remove then directiy
                 * it removes whole entry , but we should maintain the window size
                 * parallel hence we should remove the one occurrence.
                 * After removal the key value pair becomes 9(key)-2(value)
                 */
                if(mp.containsKey(arr[i]) && mp.get(arr[i]) >= 2){
                    mp.put(arr[i],mp.get(arr[i])-1);
                }else{
                    mp.remove(arr[i]);
                }
                i++;
                j++;
            }
        }
        return maxsum;
    }
    static int maxSubArraySumLengthK(int[] arr ,int k){
        if(k > arr.length){
            return 0;
        }
        int i = 0,j = 0 ,sum = 0, maxsum = 0;
        Boolean bool = true;
        Set<Integer> st = new HashSet<>();
        while (j < arr.length){
            sum = sum + arr[j];
            if(j-i+1 < k){
                if(st.contains(arr[j])){
                    bool = false;
                }else{
                    st.add(arr[j]);
                }
                j++;
            }
            else if(j-i+1 == k){
                if(st.contains(arr[j]) || st.size() < 3 || bool == false){
                    st.add(arr[j]);
                    bool = true;
                    sum = sum - arr[i];
                    i++;
                    j++;
                }else {
                    bool = true;
                    maxsum = Math.max(sum,maxsum);
                    st.add(arr[j]);
                    sum = sum - arr[i];
                    st.remove(arr[i]);
                    i++;
                    j++;
                }
            }
        }
        return maxsum;
    }
}
