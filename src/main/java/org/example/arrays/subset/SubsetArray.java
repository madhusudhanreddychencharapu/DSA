package org.example.arrays.subset;

import java.util.ArrayList;
import java.util.List;

public class SubsetArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println("I am in the main");
        List<List<Integer>> res = subset(arr);
        for(List<Integer> temp : res){
            System.out.println(temp);
        }

    }
    static List<List<Integer>> subset(int[] nums){
        List<List<Integer>> outer = new ArrayList<>();
        /*
        * Here this is the most important step because we have create and add empty
        * list of Integer.
        *  we already thought that we are created Outer list but we created an empty
        * List<List<Integer>> which is empty didnt have any elements.
        * To Start the Process an empty list<integer> should be created and added to
        * get initial size n = 1(1+1=2) otherwise 0 cant be doubled 0+0=0.
        *
        * */
        outer.add(new ArrayList<>());

        for(int num : nums) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                /*Here we are creating the copy of the list<integer> of element i of the
                list through the constructor
                Adding the num to the created(copied) list and adding to the outer list
                */

                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);

                outer.add(inner);
            }
        }
        return outer;
    }
}
