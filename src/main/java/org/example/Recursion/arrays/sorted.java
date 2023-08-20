package org.example.Recursion.arrays;

public class sorted {
    public static void main(String[] args) {
        int[] arr = { 1,3,5,8,3};
        System.out.println(isSorted(arr,0));
    }
    static  Boolean isSorted(int[] arr, int i){
        if(i == arr.length-1){
            return true;
        }
        if(arr[i] <= arr[i+1]){
            return isSorted(arr,i+1);
        }
        return false;
    }
}
