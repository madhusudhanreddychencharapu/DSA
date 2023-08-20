package org.example.arrays.Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {4,3,6,8,1,2};
       // int[] res = mergeSortOptimized(arr,0,arr.length-1);
       // int[] res = mergeSort(arr);//
        mergeSortInPlace(arr,0,arr.length-1);
        System.out.println("result array length :"+arr.length);
        System.out.println(Arrays.toString(arr));
    }

    /*
     * Here the merge sort the argument is only a array
     * For every recursion call we are creating a new copy of the array by defining
       the starting and ending point.
     * The new array is created for example Arrays.copyOfRange(arr,0,mid)
     * Here the array is created  with starting index of 0 and ending index is mid-1;
     * we should clearly see that ends with mid-1 index not mid index
     */
    static int[] mergeSort(int[] arr){
        if(arr.length == 1){
            return arr;
        }
        int mid = arr.length/2;

        int[] Left = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] Right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));

        return mergeSortedArray(Left,Right);
    }

    /*
      This is the inplace merge means we are not creating the recursion calls for every
      single function call , we are going to work with the start ,end ,middle working with
      the same array
     */
    static int[] mergeSortOptimized(int[] arr ,int start ,int end){
        if(start == end){
            int[] arr_temp = new int[1];
            arr_temp[0]=arr[start];
            return arr_temp;
        }
        int mid = (start+end)/2;
        int[] Left = mergeSortOptimized(arr,start,mid);
        int[] Right = mergeSortOptimized(arr,mid+1,end);

        return mergeSortedArray(Left,Right);
    }

    // This is the actual merge sorting  code inplace method
    static void mergeSortInPlace(int[] arr,int s, int e){
        System.out.println("I was entered into a mergesort inplace");
        if(s < e) {
            int m = (s + e) / 2;

            mergeSortInPlace(arr, s, m);
            mergeSortInPlace(arr, m + 1, e);

            mergeInPlace(arr, s, m, e);
        }
        System.out.println("returned");
    }

    static  void mergeInPlace(int[] arr, int s,int m, int e){
        System.out.println("I am entering in a merging function");
        //here we are passing end = arr.length-1;
        int[] mix = new int[e-s+1];
        //[4,5,1,2,3] here s=0,end = arr.length-1 ,mid = s+e/2;
        int i = s ,j = m+1;
        int k = 0;
        while (i <= m && j <= e){
            if(arr[i]<arr[j]){
                mix[k++] = arr[i++];
            }else {
                mix[k++] = arr[j++];
            }
        }
        while(i <= m){
            mix[k++] = arr[i++];
        }
        while(j <= e){
            mix[k++] = arr[j++];
        }
        // Here we are copying the elements to the orginal array
        for(k = 0; k< mix.length;k++){
            arr[s+k] = mix[k];
        }
        System.out.println("printing mix after every merging"+Arrays.toString(mix));
        System.out.println("printing arr after every merging"+Arrays.toString(arr));
    }

    //This is the method used to merge the sorted the arrays using two pointer
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
      //The further code is the one of the array is greater than another array
        // then to add the further array to the result
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
