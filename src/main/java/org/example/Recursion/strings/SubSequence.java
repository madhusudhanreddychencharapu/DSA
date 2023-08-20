package org.example.Recursion.strings;

import java.util.ArrayList;

public class SubSequence {
    public static void main(String[] args) {
        String str = "abc";
        String res = "";
      //  ArrayList<String> listString= subSequenceStringList("",str);
      //  System.out.println(listString);
      //  subSequenceAscii(res,str);
        System.out.println(subSequenceAsciiList(res,str));
    }
    static void subSequenceString(String p , String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subSequenceString( p+ch, up.substring(1));
        subSequenceString( p, up.substring(1));
    }
    static ArrayList<String> subSequenceStringList(String p , String up){
        ArrayList<String> left;
        ArrayList<String> right;
        if(up.isEmpty()){
            ArrayList<String > str = new ArrayList<>();
            System.out.println(p);
            str.add(p);
            return str;
        }
        char ch = up.charAt(0);
        left = subSequenceStringList( p+ch, up.substring(1));
        right = subSequenceStringList( p, up.substring(1));
        left.addAll(right);
        return  left;
    }
    static ArrayList<String> subSequenceAscii(String p , String up){
        if(up.isEmpty()){
            System.out.println(p);
            return null;
        }
        char ch = up.charAt(0);
        subSequenceAscii( p+ch, up.substring(1));
        subSequenceAscii( p, up.substring(1));
        subSequenceAscii( p+(ch+0), up.substring(1));
        return null;
    }
    static ArrayList<String> subSequenceAsciiList(String p , String up){
        if(up.isEmpty()){
            ArrayList<String> listString = new ArrayList<>();
            listString.add(p);
            return listString;
        }
        char ch = up.charAt(0);
        ArrayList<String> first = subSequenceAsciiList( p+ch, up.substring(1));
        ArrayList<String> second = subSequenceAsciiList( p, up.substring(1));
        ArrayList<String> third = subSequenceAsciiList( p+(ch+0), up.substring(1));

        first.addAll(second);
        first.addAll(third);

        return first;
    }
}
