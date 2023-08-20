package org.example.arrays.Sorting;

import java.io.OutputStream;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
       // int[] arr = {10,80,30,90,40,50,70};
        int[] arr = {8,15,3,12,1,6,2,9};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void quickSort(int[] arr ,int low ,int high){
        System.out.println("Just now function is started");
        System.out.println("low is :"+ low +"high is :"+high);
        int target = arr[high];

        int start = low;
        int end = high;

        while(start < end){
            while(arr[start]<target){
                start++;
            }
            while(arr[end]>target){
                end--;
            }
            if(start < end && end >=0) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
        if(high-low <= 1){
            return;
        }
        System.out.println("Printing array after every call :"+Arrays.toString(arr));
        System.out.println("start : "+start+","+"end :"+end);

        if(start >0) {
            quickSort(arr, low, start - 1);
        }
        if(end < high) {
            quickSort(arr, end + 1, high);
        }
    }
}
