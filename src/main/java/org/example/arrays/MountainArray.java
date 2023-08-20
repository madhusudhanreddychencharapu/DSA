package org.example.arrays;

public class MountainArray {
    public static void main(String[] args) {
        int[] arr ={1,2,3,5,8,9,5,3,2,1};
        System.out.println("The peak index of the MountainArray :"+peakIndex(arr));
    }
    static int peakIndex(int[] marr){
        int start = 0,end = marr.length-1,mid =0;

        while(start < end){
            mid = start + (end -start)/2;

            if(marr[mid]>marr[mid+1]){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return start;
    }
}
