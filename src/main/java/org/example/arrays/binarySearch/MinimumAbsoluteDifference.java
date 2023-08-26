package org.example.arrays.binarySearch;

import java.util.Arrays;

public class MinimumAbsoluteDifference {
    public static void main(String[] args) {
        //int arr1[] = {1,10,4,4,2,7};
        //int arr2[] = {9,3,5,1,7,4};
        int arr1[] = {1,28,21};
        int arr2[] = {9,21,20};
        System.out.println(minAbsoluteSumDiff(arr1,arr2));
    }
    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {

        int target = Math.abs(nums1[0]-nums2[0]);
        int targetIndex = 0 ,sum =0;

        for (int i = 0;i <= nums1.length-1; i++){
            if (target < Math.abs(nums1[i]-nums2[i])){
                target = Math.abs(nums1[i]-nums2[i]);
                targetIndex = i;
            }
        }

        int max = Math.abs(nums1[0]-nums2[targetIndex]);
        int maxIndex = 0;
        for (int i = 0; i<= nums1.length-1;i++){
            int temp =Math.abs(nums1[i]-nums2[targetIndex]);
            if(max > temp){
                max = temp;
                maxIndex = i;
            }
        }
        nums1[targetIndex] =nums1[maxIndex];
        for(int i = 0 ; i<= nums1.length-1;i++){
            sum += Math.abs(nums1[i]-nums2[i]);
        }
        return sum;
    }
}
