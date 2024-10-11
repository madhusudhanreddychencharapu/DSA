package org.example.arrays.Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {85,65,28,15,4};
        selectionSortEndingIndex(arr);
        System.out.println(Arrays.toString(arr));
    }
    //selection sort through the arranging  element from the starting index
    static void selectionSortStartingIndex(int[] arr){
        for (int i = 0; i < arr.length ; i++){
            int min = arr[i];
            int index = i;
            for (int j = i+1; j<arr.length ; j++){
                if(arr[j] < min){
                    min = arr[j];
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }
    //selection sort through the arranging  element from the last index
    static void selectionSortEndingIndex(int[] arr){
        for (int i = arr.length-1 ; i >= 0; i--){
            int max = arr[i];
            int index = i;
            for (int j = 0; j < i ; j++){
                if(arr[j] > max){
                    max = arr[j];
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }
}
