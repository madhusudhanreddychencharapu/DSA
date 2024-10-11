package org.example.revision;

import java.util.ArrayList;
import java.util.List;

public class MaxElementIndexList {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        list.add(-1);
        System.out.println("The size of the list is "+list.size());
        int[] arr = {1,5,4,0,3,2};
        insertionSortRecursive(arr ,1);
         list.remove(list.size()-1);
        System.out.println(list);
   /*     list.add(6);
        list.add(99);
        list.add(15);
        list.add(26);
        list.add(55);
        System.out.println(maxElementIndexList(list,list.size()-1));

        insertListElement(list , list.size()-1, 33);
        System.out.println("The List after adding 33 is "+list);
        insertListElement(list, list.size()-1, 23);
        System.out.println("The list after adding 23 is "+list);*/
    }
    public static int maxElementIndexList(List<Integer> numList , int n){
        if(n == 0 ){
            return 0;
        }
        int currVal = numList.get(n);
        int maxIndexEle = maxElementIndexList(numList,n-1);
        if(currVal > numList.get(maxIndexEle)){
            return n;
        }else {
            return maxIndexEle;
        }
    }
    public static void insertListElement(List<Integer> numList , int n , int x){
        if(n == 0){
            numList.add(0,x);
            return;
        }
        if(numList.get(n) > x && x > numList.get(n-1)){
            numList.add(n,x);
            return;
        }
        insertListElement(numList , n-1 , x);
    }

    public static void insertionSortRecursive(int[] arr ,int i){
        if(i == arr.length){
            return;
        }
        insertListElement(list ,list.size()-1,arr[i]);
        insertionSortRecursive(arr , i+1);
    }




}
