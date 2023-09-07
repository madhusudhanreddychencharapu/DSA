package org.example.Recursion.strings;

import java.util.ArrayList;
import java.util.List;

public class Permutation_String {
    public static void main(String[] args) {
        // permutation("","abcd");
        // List<String> res = permutationList("","abc");
        //System.out.println(res);
        int temp = countingPermutations("","abc");
        System.out.println("The total no of Permutations :"+temp);

    }
    /**
     * Here we are printing the permutations but concept of recursion if different from
     * the combination and subset.
     * Here the recursion calls may differ after each level for example in combinations
     * there are only two recursion calls for specific function.
     * But here The no of recursion calls will depend on the length of the processod string.
     * **/
    static void permutation(String p , String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int length = p.length();
        char ch = up.charAt(0);
        for(int i = 0 ; i <= length; i++){
            permutation(p.substring(0,i)+ch+p.substring(i),up.substring(1));
        }
    }

    /**
     * In this function it returns the arraylist of the Strings having permutations
     * in it.
     * **/
    static List<String> permutationList(String p , String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int length = p.length();
        char ch = up.charAt(0);

        List<String> ans = new ArrayList<>();
        for(int i = 0 ; i <= length; i++){
            List<String> temp =permutationList(p.substring(0,i)+ch+p.substring(i),up.substring(1));
            ans.addAll(temp);
        }
        return ans;
    }

    /**
     * Here in the function it is going to print the total permutations
     * But we should observe that we should take a count variable
     * and update the count variable after every recursion call because?
     * here we cannot use variables directly because it is calling dynamically
     * the recursion count calls may different for after each level.
    **/
    static int countingPermutations(String p , String up){
        if(up.isEmpty()){
            return 1;
        }
        int count = 0;
        int length = p.length();
        char ch = up.charAt(0);
        for(int i = 0 ; i <= length; i++){
             int temp = countingPermutations(p.substring(0,i)+ch+p.substring(i),up.substring(1));
             count = count + temp;
        }
        return count;
    }
}
