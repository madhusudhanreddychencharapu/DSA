package org.example.Recursion.strings;

import java.util.Arrays;

public class RemoveAlphabetFromString{
    public static void main(String[] args) {
       // String str = "baccadah";
        String str = "madhuapplesudhan";
        String res = "";
        //remove(str,res);
        res=removeApple(str);
        System.out.println(res);
    }

    //Approach 1: Pass the answer string in its argument and using void return type
    static void remove(String str ,String res){
        if(str.equals("")){
            System.out.println(res);
            return;
        }
        char ch = str.charAt(0);
        if(ch =='a'){
            remove(str.substring(1),res);
        }else{
            remove(str.substring(1),res+ch);
        }
    }

    //Approach : Create the answer variable in function body and return the string
    //           arguments should not have more than the single variable
    static String remove2(String str){
        if(str.equals("")){
            return "";
        }
        char ch = str.charAt(0);
        if(ch =='a'){
            return remove2(str.substring(1));
        }else{
           return ch+remove2(str.substring(1));
        }
    }
    static String removeApple(String str){
        if(str.equals("")){
            return "";
        }
        char ch = str.charAt(0);
        if(str.startsWith("apple")){
            return removeApple(str.substring(5));
        }
        else{
            return ch+removeApple(str.substring(1));
        }
    }

}

