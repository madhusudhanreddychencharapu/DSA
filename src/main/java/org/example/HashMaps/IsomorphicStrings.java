package org.example.HashMaps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "abcdec";
        String t = "xyzabc";
        System.out.println("It is a valid Isomorphic string : "+isValidIsomorphicStrings(s,t));
    }
    /*
    * If two strings are isomorphic - All the occurrences of character must be replaced
    * with the another character while preserving the order of elements
    *
    * No two characters may map to same character.
    * s = "abcdec" t = "xyzabz" output : True
    * s = "abcdec" t = "xyzabc" output : false

    * In this method we are using mp.containsValue(Obj) it takes O(N) time complexity
    * but not the O(1)
    * The overall time complexity is O(N^2) and space complexity is O(N)
    *
    * try to optimize it to the O(N) ??? -> Is it possible -yup then read further function.
    * */
    static boolean isValidIsomorphicStrings(String s ,String t){
        Map<Character,Character> mp = new HashMap<>();
        if(s.length() != t.length()){
            return false;
        }
        for(int i = 0; i < s.length();i++){
            if(mp.containsKey(s.charAt(i))){
                char ch = mp.get(s.charAt(i));
                if(ch != t.charAt(i)){
                    return false;
                }
            }else {
                if(mp.containsValue(t.charAt(i))) return false;
                mp.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }
    /*
    * The time complexity T(N) reduced to O(N) but the space complexity increased to
    * the O(2N) using the data structure Set
    * */
    static boolean isValidIsomorphicStringsOptimized(String s ,String t){
        Map<Character,Character> mp = new HashMap<>();
        Set<Character> set = new HashSet<>();
        if(s.length() != t.length()){
            return false;
        }
        for(int i = 0; i < s.length();i++){
            if(mp.containsKey(s.charAt(i))){
                char ch = mp.get(s.charAt(i));
                if(ch != t.charAt(i)){
                    return false;
                }
            }else {
                //Here contains is going to take the O(1) constant time complexity .
                if(set.contains(t.charAt(i))) return false;

                mp.put(s.charAt(i),t.charAt(i));
                set.add(t.charAt(i));
            }
        }
        return true;
    }
}
