package org.example.arrays.Sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,4};
        bubbleSortAscending(arr);
    }
    static void bubbleSortAscending(int[] arr){
        //Here i is just the counter which counts upto n-1 times
        for (int i = 0;i < arr.length-1;i++){
            boolean swap = false;
            // here we are going to compare next element is greater than the current element then swap
            for (int j = 0;j < arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                        swap = true;
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                }
            }
            System.out.println("After every pass the array is :");
            System.out.println(Arrays.toString(arr));
            //Here we are checking for the atleast 1 swap for particular element of i
            //here we are going to check the whether we are doing atleast 1 swap
            //otherwise the array is already sorted.
            if(!swap){
                break;
            }
        }
    }
    static void bubbleSortDescending(int[] arr){
        for (int i = 0;i < arr.length-1;i++){
            for (int j = 0;j < arr.length-1-i;j++){
                if(arr[j]<arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.println("After every pass the array is :");
            System.out.println(Arrays.toString(arr));
        }
    }
}
