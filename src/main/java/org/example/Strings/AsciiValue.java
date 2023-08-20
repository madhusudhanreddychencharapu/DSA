package org.example.Strings;

import java.util.Arrays;

public class AsciiValue {
    public static void main(String[] args) {
        char ch = 'a';
        int asciiNum = ch + 1;
        String str1 = "madhu";
        char[] arr = {'m','a','d','h','u'};
       // String str = Integer.toString(asciiNum);
       // System.out.println(str + asciiNum);
        System.out.println(Arrays.toString(arr));
    }
}
