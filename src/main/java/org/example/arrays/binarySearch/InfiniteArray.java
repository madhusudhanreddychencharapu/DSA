package org.example.arrays.binarySearch;

public class InfiniteArray {
    public static void main(String[] args) {
       int[] arr ={1,2,3,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34};
       int[] temp = findingStartEndinRange(arr,30);
       System.out.println("Start Index :"+temp[0]+"\nEnd Index :"+temp[1]);
       System.out.println("The output of BinarySearch :"+arr[binarySearch(arr,16,temp[0],temp[1])]);
    }
    static int[] findingStartEndinRange(int[] arr,int target){
        int start = 0,end =0;
        int[] temp = new int[2];
        int n = 0;
        while(true){
            if(target>arr[end]){
                start = end+1;
                end = (int)Math.pow(2,n++);
            }else{
                temp[0] = start;
                temp[1] = end;
                return  temp;
            }
        }
    }
    static int binarySearch(int[] arr, int target,int start ,int end ){
        int mid =0;
        while(start<=end){
            mid = start +(end - start)/2;
            if(target>arr[mid]){
                start = mid + 1;
            }else if(target< arr[mid]){
                end = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
