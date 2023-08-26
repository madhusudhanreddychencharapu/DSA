package org.example.arrays.binarySearch;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {3,4,8,13,15,16};
        int[] arr2 = {5,6,12,};
        int[] arr = mergeSortedArray(arr1,arr2);
        for (int i: arr) {
            System.out.print(i+",");
        }
    }
    static int[] mergeSortedArray(int[] arr1,int[] arr2){
        int[] arr3 = new int[arr1.length+arr2.length];
        int i = 0,j = 0,k = 0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]){
                arr3[k++] = arr1[i++];
            }else{
                arr3[k++] = arr2[j++];
            }
        }
        System.out.println("i :"+i+"j :"+j);
        if(j != arr2.length){
            while (j<arr2.length){
                arr3[k++] = arr2[j++];
            }
        }
        if(i != arr1.length){
            while (i<arr1.length){
                arr3[k++] = arr1[i++];
            }
        }
        return arr3;
    }
}
