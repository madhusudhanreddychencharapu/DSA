package org.example.HashSets;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class UniquePairCount {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4    };
        System.out.println("The unique pair count :"+uniquePairCount(arr));
        System.out.println("The unique pair count using optimized way:"
                +uniquePairCountOptimized(arr));
    }

    //It is the time complexity of the O(N^2) so we have to optimize it
    static  int uniquePairCount(int[] nums){
        Set<Point> st = new HashSet<>();
        for(int i = 0;i< nums.length;i++){
            for(int j = 0;j < nums.length;j++){
                st.add(new Point(nums[i],nums[j]));
            }
        }
        System.out.println(st);
        return st.size();
    }

    /*
    *Here is we are passing elements to string means deleting repeated values
    *for unique element of array length n then unique pairs will be 2^n
    * The time complexity of the code is O(N)
    */
    static int uniquePairCountOptimized(int[] arr){
        Set<Integer> st = new HashSet<>();
        for(int num : arr) st.add(num);
        return (int)Math.pow(2,st.size());
    }
}
