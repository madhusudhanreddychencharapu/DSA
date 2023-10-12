package org.example.Recursion.Backtracking;

import java.util.Arrays;

public class NQueens {
    public static void main(String[] args) {
        boolean[][] arr = new boolean[4][4];
        for (boolean[] temp : arr) {
            System.out.println(Arrays.toString(temp));
        }
        //Arrays.fill(arr,false);
        nQueens(arr,0,0);
    }
    static void nQueens(boolean[][] arr,int r,int c){
        //Base condition
        if(r >= 4 || c >= 4){
            System.out.println("I am executing here");
            return;
        }
        for(int i = 0;i < 4;i++){
            System.out.println("I am running");
            if(r >= 4 || c >= 4){
                System.out.println("I am executing");
                return;
            }

            if(!check(arr,r,c)){
                System.out.println(r +"+"+c  + "i am in the false");
                for (boolean[] temp : arr) {
                    System.out.println(Arrays.toString(temp));
                }
                nQueens(arr , r ,++c);
                //break;
            }
            if(check(arr,r,c) && r< arr.length && c< arr.length){
                arr[r][c] = true;
                if( r == 3 && arr[r][c]){
                    System.out.println("This is one of answer ************************* answer");
                    for (boolean[] temp : arr) {
                        System.out.println(Arrays.toString(temp));
                    }
                    return;
                }
                //Printing the array for the testing
                System.out.println(r +"+"+c);
                for (boolean[] temp : arr) {
                    System.out.println(Arrays.toString(temp));
                }

                nQueens(arr, ++r ,0);
                arr[r][c] = false;
                c++;
            }
        }
    }
    static boolean check(boolean[][] arr,int r,int c) {
        // when the element is in the diagonal
        if(r == c){
            for(int i =r,j = c;i >= 0 && j >= 0;i--,j--){
                if (arr[i][c]) {
                    return false;
                }
            }
        }
        //check the vertical side
        for (int i = r; i >= 0 ; i--) {
            System.out.println("r in for loop "+i+"  c in for loop "+c);
            if (arr[i][c]) {
                return false;
            }
        }
        //checking the right diagonal
        for (int i = r, j = c; i >= 0 && j < arr.length; i--, j++) {
            if (arr[i][j]) {
                return false;
            }
        }
        //checking the left diagonal
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j]) {
                return false;
            }
        }
        return true;
    }
}
