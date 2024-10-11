package org.example.arrays.Sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {1,6,4,0,5};
        //int[] res = insertionSort(arr);
        insertionSortRecursive(arr,2);
        System.out.println("The resultant array after sorting "+Arrays.toString(arr));
    }
    public static int[] insertionSort(int[] arr){
        for (int i = 1 ; i <= arr.length-1; i++){
            int e = arr[i];
            int j = i-1;
            while(arr[j] > e && j > 0) {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = e;
        }
        return  arr;
    }
    public static void swap(int[] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void insertionSortRecursive(int[] arr , int i){
        if(i == arr.length){
            return;
        }
        int j = i;
        while(j > 0 && arr[j-1]>arr[j]){
            int temp = arr[j-1];
            arr[j-1] = arr[j];
            arr[j] = temp;
            j--;
        }
        insertionSortRecursive(arr, i+1);
    }
}
