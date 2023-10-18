package org.example.HashSets;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
       // int[] arr = {100,101,102,103,104,1,2,3,4,105};
        int[] arr = {100,4,200,1,3,2};
        System.out.println("The longest sequence is :"
                +longestConsecutiveSequence(arr));
    }
    static int longestConsecutiveSequence(int[] arr){
        Set<Integer> st = new HashSet<>();
        for(int num :arr) st.add(num);
        int maxSeqLen= 1;

        for (Integer num : st){
            int currNum = num;
            //Length of the current consecutive seq
            int currSeqLen= 1;
            //It is checking the whether the starting number in series
            if(!st.contains(currNum-1)){
                while(st.contains(num+1)){
                    currSeqLen++;
                    currNum++;
                    System.out.println("I am running in a while");
                }
            }
            maxSeqLen = Math.max(maxSeqLen,currSeqLen);
        }
        return  maxSeqLen;
    }
}
