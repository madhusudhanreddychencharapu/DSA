package org.example.Recursion.strings;
public class Permutation {
    public static void main(String[] args) {
        permutationString(" ","abcd");
    }
    static void permutationString(String p,String up){
        //Base Condition
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int n = up.length();
        for(int i = 0 ; i< n ;i++){
            char ch = up.charAt(i);
            permutationString(p+ch,up.substring(0,i)+up.substring(i+1));
        }
    }
}
