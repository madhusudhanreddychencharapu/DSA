package org.example.Recursion.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    static int count=0;
    public static void main(String[] args) {
        int res = countPaths(3,3);
        // System.out.println("The total no of paths are : "+result);

        mazePaths("",3,3);
       // System.out.println("Total paths"+listString);
        System.out.println("The number of recursion calls :"+count);

       ArrayList<String > ans = mazePathList("",3,3);
        System.out.println("The resultant list is :"+ans);

    }

    // Here we return the to no of possible ways of to pass from reaching A to end.
    static int countPaths(int r, int c){
        if(r == 1 || c == 1){
            return 1;
        }
        int left = countPaths(r-1,c);
        int right = countPaths(r,c-1);

        return left+right;
    }

    //Here we are printing the Possible paths from the reaching A to end.
    //Here are we are using the recursion calls like :
    //path till the point + F(Reduced array)
    static void mazePaths(String p,int r , int c){
        count++;
        if(r == 1 && c == 1){
            System.out.println(p);
        }
        if(r>1) {
            mazePaths(p + "D",r - 1, c);
        }
        if(c>1) {
            mazePaths(p+"R",r, c - 1);
        }
    }

    static ArrayList<String> mazePathList(String p , int r, int c){
        if(r == 1 && c == 1){
            ArrayList<String> temp = new ArrayList<>();
            temp.add(p);
            return temp;
        }
        ArrayList<String> left = new ArrayList<>();
        ArrayList<String> right = new ArrayList<>();
        if(r>1) {
            left = mazePathList(p + "D", r - 1, c);
        }
        if(c>1) {
             right = mazePathList(p + "R", r, c - 1);
        }
        left.addAll(right);
        return left;
    }
}
