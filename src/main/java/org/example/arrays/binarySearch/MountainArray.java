package org.example.arrays.binarySearch;

public class MountainArray {
    public static void main(String[] args) {
       // int[] arr ={1,2,3,5,8,9,5,3,2,1};
        int[] arr = {0,18,1,0};
        System.out.println("The peak index of the MountainArray :"+peakIndex(arr));
        System.out.println("The peak element of the MountainArray :"+arr[peakIndex(arr)]);

    }
    static int peakIndex(int[] arr){
        int start = 0,end = arr.length-1,mid =0;

        while(start < end){
            mid = start + (end -start)/2;

            if(arr[mid]>arr[mid+1]){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return start;
    }
}
