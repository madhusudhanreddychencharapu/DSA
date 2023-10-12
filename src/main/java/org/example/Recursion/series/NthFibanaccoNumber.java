package org.example.Recursion.series;

public class NthFibanaccoNumber{
    static int count;
    static int fun1count;
    static int fun0count;
    public static void main(String[] args) {
        System.out.println(fib(15));
        System.out.println("The total no of function calls is :"+count);
        System.out.println("total fun(0) calls :"+fun0count);
        System.out.println("total fun(1) calls :"+fun1count);
    }
    static int fib(int n){
        count++;
        if(n == 0){
            fun0count++;
            return 0;
        }
        if(n == 1){
            fun1count++;
            return 1;
        }
        int a = fib(n-1);
        int b = fib(n-2);

        return a+b;
    }
//    static long fiboTimeComplexity(int n){
//        return (long) Math.pow((1+Math.sqrt(5)/2),n);
//    }
//    static long fiboFormulaMethod(int n){
//        return (long)((Math.pow((1+Math.sqrt(5)/2),n)-(Math.pow((1+Math.sqrt(5)/2),n));
//    }
}
