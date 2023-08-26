package org.example.arrays.binarySearch;

import java.util.Arrays;

public class FirstLastIndexSortedArray {
    public static void main(String[] args) {
        int[] arr = {5,7,8,8,8,8,9};
        int[] res = searchRange(arr,8);
        for(int i =0;i<res.length;i++){
            System.out.print(res[i]+ " ");
        }
    }
    static int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length-1, mid = 0,i=0;
        int[] arr = new int[nums.length];
        int[] res = new int[2];

        while(start<= end){
            mid = start + (end-start)/2;
            if(target == nums[mid]){
                arr[i]=mid;
                i++;
            }
            if(target>nums[mid]){
                start = mid+1;
            }else{
                end = mid -1;
            }
        }
        Arrays.sort(arr,0,i);
        for(int j=0;j<arr.length;j++){
            System.out.println(arr[j]);
        }
        if(arr.length>1){
            res[0]=arr[0];
            res[1]=arr[1];
        }
        if(arr.length<2){
            res[0]=-1;
            res[1]=-1;
            return res;
        }

        return res;


    }
}
