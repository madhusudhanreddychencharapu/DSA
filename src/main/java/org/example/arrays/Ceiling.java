package org.example.arrays;

public class Ceiling {
    public static void main(String[] args) {
        int arr[] ={2,3,5,9,14,16,18};
        char[] ch = {'e','e','e','e','e','n','n','n','n'};
        System.out.println(greatestLetter(ch,'e'));
    }
    static int ceilingOfNum(int[] arr, int target){
        if(target > arr[arr.length-1]){
                return -1;
        }
        System.out.println("Program started");
        int start = 0,end = arr.length-1;
        int mid = 0;
        while(start <= end){
           // System.out.println("I am in a while loop");
            mid = start+(end-start)/2;
            if(target>arr[mid]){
                start = mid+1;
            }else if(target<arr[mid]){
                end = mid-1;
            }else {
                return mid;
            }
        }
        return start;
    }
    static char greatestLetter(char[] arr, char target){
        if(target > arr[arr.length-1]){
            return arr[0];
        }
        System.out.println("Program started");
        int start = 0,end = arr.length-1;
        int mid = 0;
        while(start <= end){
             System.out.println("I am in a while loop");
            mid = start+(end-start)/2;
            if(target>arr[mid]){
                start = mid+1;
            }else if(target<arr[mid]){
                end = mid-1;
            }else {
                if(arr[mid]==arr[mid+1]){
                    while(arr[mid]==arr[mid+1]){
                        mid++;
                    }
                }
                return arr[mid+1];
            }
        }
        System.out.println("I am out of the loop");
        return arr[start];
    }
}
