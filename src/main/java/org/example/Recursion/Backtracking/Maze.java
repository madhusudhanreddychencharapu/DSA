package org.example.Recursion.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Maze {
    static int countPaths = 0;
    public static void main(String[] args) {
        //int res = countPaths(3,3);
        // System.out.println("The total no of paths are : "+result);

        //mazePaths("",3,3);
        // System.out.println("Total paths"+listString);
        //System.out.println("The number of recursion calls :"+count);

        //ArrayList<String > ans = mazePathList("",3,3);
        //System.out.println("The resultant list is :"+ans);

        boolean[][] arr = {
                {true,true,true},
                {true,true,true},
                {true,true,true},
            };
        mazePathsAllSides("",arr,0,0);
//        System.out.println("The total of paths moving four sides :"+countPaths);
//        for (boolean[] booleans : arr) {
//            System.out.println(Arrays.toString(booleans));
//        }
//        int[][] abc = new int[arr.length][arr[0].length];
//        printMazePathArray("",arr,0,0,abc,1);
    }

    // Here we return the  no of possible ways of to pass from reaching A to end.
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
     //   count++;
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
    static void mazePathsObstacles(String p,boolean[][] arr,int r , int c){
        if(r == arr.length-1 && c == arr[0].length-1){
            System.out.println(p);
            return;
        }
        if(!arr[r][c]){
            return;
        }
        if(r < arr.length-1) {
            mazePathsObstacles(p + "D",arr,r + 1, c);
        }
        if(c < arr[0].length-1) {
            mazePathsObstacles(p+"R",arr,r, c + 1);
        }
    }

    /*
    * Here the person can go any of the four ways 1.UP 2.DOWN 3.RIGHT 4.LEFT
    *
    * we are using the BackTracking now means initially we are changing the
    * original array after moving it making false then calling the next function
    *
    * while at the time of Returning we are changing the array to its original position
    * when it is called.
    *
    * */
    static void mazePathsAllSides(String p,boolean[][] arr,int r , int c) {

        if (r == arr.length - 1 && c == arr[0].length - 1) {
            countPaths++;
            System.out.println(p);
            // arr[r][c] = true;
            return;

        }
        if (arr[r][c] == false) {
            return;
        }

        arr[r][c] = false;
        if (r < arr.length - 1) {
            //  arr[r][c] = false;
            mazePathsAllSides(p + "D", arr, r + 1, c);
            //  arr[r][c] = true;
        }
        if (c < arr[0].length - 1) {
           // arr[r][c] = false;
            mazePathsAllSides(p + "R", arr, r, c + 1);
           // arr[r][c] = true;
        }
        if (r > 0) {
            //  arr[r][c] = false;
            mazePathsAllSides(p + "U", arr, r - 1, c);
            //  arr[r][c] = true;
        }
        if (c > 0) {
           // arr[r][c] = false;
            mazePathsAllSides(p + "L", arr, r, c - 1);
            //arr[r][c] = true;
        }


        //This line is where the function call will be over
        // So before the function gets removed ,also remove the changes that were made in the function
        arr[r][c] = true;

    }

    /*
    * The function basically prints the  Maze path as a number array
    * Here we used additional 2-D int array ,countlevel variable
    * */
    static  void printMazePathArray(String p , boolean[][] arr,int r,int c,int[][] abc , int countLevel){
        //checking for the condition of the target
        if(r == arr.length-1 && c == arr[0].length-1){
            abc[r][c] = countLevel;
            for(int[] num : abc){
                System.out.println(Arrays.toString(num));
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        //checking for the current path is already visited
        if(arr[r][c] == false){
            return;
        }

        //Marking the current Path
        arr[r][c] = false;

        //adding the count value to the matrix
        abc[r][c] = countLevel;

        //By adding  here we can eliminate the counting for function calls
        //which are basically false we will end the recursion here
        //countLevel++;

        //make the recursive calls for all the paths
        if(r < arr.length-1){
            printMazePathArray(p+"D" , arr, r+1 ,c, abc , countLevel+1);
        }
        if(c < arr[0].length-1){
            printMazePathArray(p+"R" , arr, r ,c+1, abc ,countLevel+1);
        }
        if(c > 0){
            printMazePathArray(p+"L" , arr, r ,c-1 , abc , countLevel+1);
        }
        if(r > 0){
            printMazePathArray(p+"U" , arr, r-1 ,c, abc , countLevel+1);
        }

        // making the maze to return to its original position
        arr[r][c] = true;

        //making the printing array to return its original position
        abc[r][c] = 0;
    }

}
