package org.example.dynamicprogramming;

import java.util.Arrays;

public class FibonaccoProblem {
    static int[] memo ;
    public static void main(String[] args) {
        int n = 6;
        int res = fibo(n);
        memo = new int[n+1];
        System.out.println("Fibonacco using rescursion result " + res);
        int res_memo = fibo_memo(n);
        System.out.println("Fibonacco using dp memoization "+res_memo);
        System.out.println(Arrays.toString(memo));
    }
    //first using the recursion method
    public static int fibo(int n){
        if(n<2){
            return 1;
        }
        return fibo(n-2)+fibo(n-1);
    }
    //dp - memoization method
    public static int fibo_memo(int n){
        if(n <= 2){
            return n;
        }
        if(memo[n] != 0){
            return n;
        }
        memo[n] = fibo_memo(n-2)+fibo_memo(n-1);
        return memo[n];
    }
    //dp - Tabular method
}
