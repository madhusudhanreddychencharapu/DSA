package org.example.Recursion;

public class CountZeroes {
    public static void main(String[] args) {
        System.out.println(count2(5050,0));
    }
    static  int count(int num ,int count){
        if(num ==0){
            return count;
        }
        if(num%10 == 0){
            count++;
        }
        return count(num/10,count);
    }
    static int count2(int num,int count){
        if(num == 0){
            return count;
        }
        if(num%10 == 0){
            return count2(num/10,++count);
        }
        return count2(num/10,count);

    }
}
