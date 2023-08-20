package org.example.arrays;

public class Pivot {
    public static void main(String[] args) {
       // int arr[] = {89,112,216,324,486,502,689,1,52,63,75};
        int arr[] = {2,9,2,2,2};
        System.out.println("The index of the target : "+search(arr,2));
    }

    static int search(int[] nums, int target) {

        int pivot = pivot(nums);

        System.out.println("pivot +"+pivot);

        // If pivot ==-1 means array is not rotated
        if(pivot == -1){
            return binarySearch(nums,0,nums.length-1,target );

        }
        if(nums[pivot]== target){
            return pivot;
        }
        if(target >= nums[0]){
            return binarySearch(nums,0,pivot-1,target);
        }
        return binarySearch(nums,pivot+1,nums.length-1,target);
    }
    static int pivot(int[] arr){
        int start = 0,end = arr.length-1,mid =0;

        while (start<=end) {
            mid = start + (end - start) / 2;

            //case 1: arr[mid]> arr[mid+1] only it exists
            if(mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            //case 2: arr[mid]< arr[mid-1]
            if(mid > start && arr[mid] < arr[mid-1] ){
                return mid-1;
            }
            //case 3: If the mid element less the start element
            if(arr[mid]<=arr[start]){
                end = mid-1;
            }
            //case 4: If the mid element greater than the start element
            if(arr[mid]>arr[start]){
                start = mid+1;
            }
        }
        return -1;
    }


    static int binarySearch(int[] arr,int start,int end, int target){
        int mid =0;
        while(start<=end){

            mid = start+(end -start)/2;

            if(target > arr[mid]){
                start = mid +1;
            }else if(target < arr[mid]) {
                end = mid-1;
            }else{
                return mid;
            }

        }
        return -1;
    }
    static int pivotIndex(int[] arr){

        // There are four cases in finding the pivot

        int start = 0, end = arr.length-1,mid = 0;

        while (start<end) {
            mid = start + (end - start) / 2;

            //case 1: arr[mid]> arr[mid+1] only it exists
            if(mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            //case 2: arr[mid]< arr[mid-1]
            if(mid-1 > 0 && arr[mid] < arr[mid-1] ){
                return mid-1;
            }
            //case 3: If the mid element less the start element
            if(arr[mid]<arr[start]){
                end = mid-1;
            }
            //case 4: If the mid element greater than the start element
            if(arr[mid]>arr[start]){
                start = mid+1;
            }
        }
        return start;
    }
}
