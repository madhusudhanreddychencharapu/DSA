package org.example.Recursion.arrays;

import java.util.ArrayList;
import java.util.List;

public class LinearSearch {
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4 , 4, 4, 8};
        //  ArrayList<Integer> list_local = new ArrayList<>();
        //System.out.println(search(arr,88,0));
        System.out.println("all indices matches to target :" + findAll3(arr, 4, 0));
    }

    static int search(int[] arr, int target, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == target) {
            return i;
        }
        return search(arr, target, ++i);
    }

    //Create the list and all the index which is matching to the target
    // The list is created as global static and return the list
    static List findAll(int[] arr, int target, int i) {
        if (i == arr.length) {
            if (list.isEmpty()) {
                list.add(-1);
            }
            return list;
        }
        if (arr[i] == target) {
            list.add(i);
        }
        return findAll(arr, target, ++i);
    }

    /**
     * Here we are not going to create the list as the global variable we are going to create the
     * list as a local variable and passing as the argument
     *
     * Here we are creating the list only once  and passing that list as the argument variable
     *
     * why we are passing as a argument variable instead of creating as a body function variable
     * beacause the answer should be stored in a list that is not global list;.
     * **/
    static List findAll2(int[] arr, int target, int i, ArrayList<Integer> list) {
        if (i == arr.length) {
            if (list.isEmpty()) {
                list.add(-1);
            }
            return list;
        }
        if (arr[i] == target) {
            list.add(i);
        }
        return findAll2(arr, target, ++i, list);
    }

    /**
     *  Very Very Important : return the list but dont take as argument or the static variable
     *  The list which is returning from the function may contain the n number of the maximum elements
     *  but the list created in the current function contain max element of 1
      **/

    static List findAll3(int[] arr, int target, int i) {
        ArrayList<Integer> list3 = new ArrayList<>();
        if (i == arr.length) {
            return list3;
        }

        // This will contain answer for that function call only
        // One more thing that the max elements containing the list is only one and minimum is zero
        if (arr[i] == target) {
            list3.add(i);
        }
        ArrayList<Integer> list_temp = (ArrayList<Integer>) findAll3(arr, target, ++i);

        if (list3.isEmpty()) {
            return list_temp;
        }
        // The add function adds at the last index of the list
        list_temp.add(list3.get(0));
        return list_temp;

      /*  ArrayList<Integer> list_temp = (ArrayList<Integer>) findAll(arr,target,++i);
        list.addAll(list_temp);
        return  list; */
    }
}