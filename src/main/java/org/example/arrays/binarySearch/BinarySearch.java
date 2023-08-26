package org.example.arrays.binarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,66,89,96,99};
       // int[] arr = {5,4,3,2,1,0,-9};
        //int[] arr = {99,96,89,66,2,1};
        System.out.println(agnosticBinarySearch(arr,96));
    }
    static int agnosticBinarySearch(int[] arr,int target){
        int start = 0,end = arr.length-1;
        int mid = 0,asc = 0;

        if(arr[0]<arr[arr.length-1]){
            asc++;
        }
        while(start<=end){
            mid =(start +end)/2;
           // System.out.println(mid);
            if(target == arr[mid]){
                return mid;
            }
            if(target >arr[mid]){
                if(asc == 1) {
                    start = mid+1;
                }else {
                    end = mid-1;
                }
            }
            else{
                if(asc == 1){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }

        }
        return -1;
    }
    //normal Binary Search
    static  int binarySearch(int[] arr , int target){
        int start = 0 ,end = arr.length-1;
        int mid = 0;
        while(start<=end){
            mid = (start + end)/2;
            if(arr[mid] == target || start == end){
                return mid;
            }
            if(arr[mid]>target){
                end = mid-1;
            }
            if(arr[mid]<target){
                start = mid+1;
            }
        }
        return -99;
    }
}