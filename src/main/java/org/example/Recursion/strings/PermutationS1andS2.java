package org.example.Recursion.strings;

public class PermutationS1andS2 {
    public static void main(String[] args) {
        System.out.println("I am doing my work");
        System.out.println(checkInclusion("ab","eidboaoo"));
    }
    static boolean res;
    public static  boolean checkInclusion(String s1, String s2) {
        permutation("",s1,s2);
        return res;
    }
    static void permutation(String p ,String up ,String s2){
        if(up.isEmpty()){
            System.out.println(p);
            if(s2.contains(p)){
                System.out.println("I am going heere");
                res = true;
            }
            return;
        }
        int len = p.length();
        char ch = up.charAt(0);

        for(int i = 0;i <= len ;i++){
            permutation(p.substring(0,i)+ch+p.substring(i) , up.substring(1) , s2);
        }
    }
}
