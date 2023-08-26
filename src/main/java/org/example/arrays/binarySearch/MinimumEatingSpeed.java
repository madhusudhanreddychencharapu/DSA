package org.example.arrays.binarySearch;

public class MinimumEatingSpeed {
    public static void main(String[] args) {
       // int[] arr = {3,6,7,11};
        int[] arr ={30,11,23,4,20};
        System.out.println("My eating speed of bananas per hour is : "+minEatingSpeed(arr,6));
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = piles[0] ,arraysum = 0;
        for(int i = 0;i<= piles.length-1;i++){
            arraysum += piles[i];
            if(end <piles[i]){
                end = piles[i];
            }
        }
        while(start < end) {
            int pieces = 0;
           int mid = start + (end - start)/2;

           System.out.println("Mid :"+ mid);
           for(int i = 0; i <= piles.length-1; i++){
               if(piles[i]%mid == 0){
                   pieces += piles[i] / mid ;
               }else {
                   pieces += piles[i] / mid + 1;
               }
           }

           System.out.println(" pieces : "+pieces);
           if(pieces <= h){
               end = mid;
           }else {
               start = mid + 1;
           }
        }
        return  start;

    }
}
