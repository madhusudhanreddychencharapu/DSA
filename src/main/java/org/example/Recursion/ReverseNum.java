package org.example.Recursion;

public class ReverseNum {
    static int sum = 0;
    public static void main(String[] args) {
        reverse(1947);
        System.out.println(sum);
    }
    static void reverse(int num ){
        if(num<=0){
            return;
        }
        sum = sum *10 + num%10;
        reverse(num/10);
    }
}
