package org.example.HashMaps;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        String str1 = "silent";
        String str2 = "listem";
        System.out.println("st1 and str2 is anagram  "+
                isValidAnagramUsingSingleHashMap(str1,str2)+" using hashmap");
        System.out.println("str1 and str2 is anagram "+
                isValidAnagramUsingArray(str1,str2)+"  using array");
    }

    /*
    * This approach takes the time complexity O(2n) and space complexity O(2n)
    * little higher we can reduce the space complexity to O(n)
    * */
    static boolean isValidAnagram(String str1 ,String str2){
        //Here we are checking whether both string of same length for anagram
        if(str1.length() != str2.length()){
            return false;
        }
        Map<Character,Integer> mp1 = makeFreqMap(str1);
        Map<Character,Integer> mp2 = makeFreqMap(str2);

        /*
         Here we are checking the both the maps are equal by using the .equals()
         method.
         Internally it compares the map1.entrySet() == map2.entrySet()
         if(mp1.equals(mp2)){
            return true;
         }*/

        /*
        * Here we are traversing the hashmaps to check whether the both the hash maps
        * are equal using keySet();
        *  */
        for(Character key :mp1.keySet()){
           if(mp1.get(key) != mp2.get(key)){
               return false;
           }
        }

        return true;
    }

    /*
    * Here it is an optimised version of the above code the time complexity is O(n)
    * */
    static boolean isValidAnagramUsingSingleHashMap(String str1 , String str2){
        Map<Character,Integer> mp = makeFreqMap(str1);
        for (int i = 0 ; i < str2.length();i++){
            Character ch = str2.charAt(i);

            if(mp.containsKey(ch)){
                mp.put(ch,mp.get(ch)-1);
                //here we are trying to see that map is empty
                //if value is 0 means it is balanced can be removed
                if(mp.get(ch)== 0){
                    mp.remove(ch);
                }
            }else {
                return false;
            }
        }
        if(mp.isEmpty()) return true;
        return false;
        /*All values of mp should be zero for s and t to be anagrams
        for ( Integer value : mp.values()){
            if(value != 0){
                return false;
            }
        }
        return true;
         */
    }

    static boolean isValidAnagramUsingArray(String s, String t){
        int[] arr = new int[26];
        if(s.length() != t.length()) return false;
        for(int i = 0; i< s.length();i++){
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        }
        return isArrayZero(arr);
    }
    static boolean isArrayZero(int[] arr){
        for(int i = 0; i<26;i++){
            if(arr[i] != 0) return false;
        }
        return true;
    }
    static Map<Character,Integer> makeFreqMap(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (mp.containsKey(ch)){
                mp.put(ch,mp.get(ch)+1);
            }else {
                mp.put(ch , 1);
            }
        }
        return mp;
    }
}
