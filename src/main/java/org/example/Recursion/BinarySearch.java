package org.example.Recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr ={ 1,2,3,5,23,78,456};
        System.out.println(binarySearch(arr,4,0,arr.length-1));
    }
    static int binarySearch(int[] arr,int target,int start,int end){
        int mid = start + (end - start)/2;
        if(target == arr[mid]){
            return mid;
        }
        if(start > end){
            return -1;
        }
        if(target > arr[mid]){
            return binarySearch(arr,target,mid+1,end);
        }else{
            return binarySearch(arr,target,start,mid-1);
        }
    }
}
