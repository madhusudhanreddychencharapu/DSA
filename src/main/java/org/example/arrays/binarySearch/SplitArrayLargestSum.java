package org.example.arrays.binarySearch;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] arr ={7,2,5,10,8};
        System.out.println("The array largest sum :"+splitArray(arr,2));
    }
    public static int splitArray(int[] nums, int k) {
        int start = nums[0];
        int end = 0 ;
        for(int i = 0; i<=nums.length-1;i++){
            if(start<nums[i]){
                start = nums[i];
            }
            end+= nums[i];
        }
        System.out.println("Start :"+start+" End : "+end);
        // The possible answer lies between start and end
        //Apply Binary Search to the start and end i.e range of the values
        while(start < end){
            int pieces = 1;
            int sum = 0;
            int mid = start + (end - start)/2;
            System.out.println("Printing mid values  :"+mid);
            for(int i = 0;i<=nums.length-1;i++){
                if((sum + nums[i])>mid){
                    pieces++;
                    sum = nums[i];
                }else {
                    sum += nums[i];
                }
            }
            System.out.println("The piece info : "+pieces);
            //If pieces less than the specified value we should decrease the mid value
            //else increase the mid value by start = mid+1;
            if(pieces <= k){
                end = mid;
            }else {
                start = mid+1;
            }
        }
        return start;
    }
}
