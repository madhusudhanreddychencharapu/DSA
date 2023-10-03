package org.example.Recursion.strings;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberCombination {
    public static void main(String[] args) {
//        List<String> combList = phoneCombinationList(" ","12");
//        System.out.println(combList);
        int count = phoneCombinationCount("","234");
        System.out.println("The Combination count is "+count);
        List<String> size = phoneCombinationList("","234");
        System.out.println("The combination count using list is "+size);
    }
    static void phoneCombination(String p , String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int digit = Integer.parseInt(up.substring(0,1));
        //System.out.println("The digits printing are"+digit);
        for(int i = (digit-1)*3 ; i<digit*3;i++){
            char ch = (char) ('a'+i);
           // System.out.println("I am printing "+ch);
            phoneCombination(p+ch,up.substring(1));
        }
    }
    static List<String> phoneCombinationList(String p , String up){
        List<String> list = new ArrayList<>();
        if(up.isEmpty()){
            List<String> listTemp = new ArrayList<>();
            listTemp.add(p);
            return listTemp;
        }
        int digit = Integer.parseInt(up.substring(0,1));
        for(int i = (digit-1)*3 ; i<digit*3;i++){
            char ch = (char) ('a'+i);
            List<String> left = phoneCombinationList(p+ch,up.substring(1));
            list.addAll(left);
        }
        return list;
    }
    static int phoneCombinationCount(String p , String up){
        int count = 0;
        if(up.isEmpty()){
            return 1;
        }
        int digit = Integer.parseInt(up.substring(0,1));
        for(int i = (digit-1)*3 ; i<digit*3;i++){
            char ch = (char) ('a'+i);
            count += phoneCombinationCount(p+ch,up.substring(1));
        }
        return count;
    }
    /*
    * Here we are practical keypad phone arry
    *   1       2(abc) 3(def)
    *   4(ghi)  5(jkl) 6(mno)
    *   7(pqrs) 8(tuv) 9(wxyz)
    *
    * Here we are using the same subset  permutation approach by varying the
    * no of the function calls through the while loop
    *
    * Just additionally we are mapping to a-z to the 2-9
    * */
    static List<String> keypadPhoneCombinationList(String p, String up){
        List<String> list = new ArrayList<>();
        if(up.isEmpty()){
            list.add(p);
            return list;
        }
        //Here we are mapping the a-z to the 1-9
        int i = 0, e = 0;
        /*we are subtracting ascii value
        for example "3" is digit ascii of 3 is 51
                            ascii value of 0 is 48
                            then resultant is three
        Internally it is taking the ascii value there is no need of conversion
        * */
        int digit = up.charAt(0)-'0';
        i = (digit-2)*3;
        if(digit > 7){
            i++;
        }
        e = i+3;
        if(digit == 7 || digit == 9){
            e = i+4;
        }

        while(i < e){
            //we are converting using explicit conversion because in addition
            //it is taking default value int
            char ch = (char)('a' + i);
            List<String> temp = keypadPhoneCombinationList(p + ch,up.substring(1));
            list.addAll(temp);
            i++;
        }
        return list;

    }
}
