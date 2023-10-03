package org.example.Recursion.strings.Dice;

import java.util.ArrayList;
import java.util.List;

public class DiceSum {
    public static void main(String[] args) {
        //diceSum("",4);
        int count = diceFaceSumCount("",8,6);
        System.out.println("The total count of target 8 is "+count);
        List<String> list = diceFaceSumList("",8,6);
        System.out.println("The total veryfying count is "+list.size());

    }
    // Here we are just printing the pattern which is target sum
    static void  diceSum(String p, int up){
        if(up == 0){
            System.out.println(p);
            return ;
        }
        for(int i = 1;i <= up;i++){
            diceSum(p+i,up-i);
        }
    }

    //here we are just taking the output in the form of the List
    static List<String> diceSumList(String p, int target){
        List<String> list = new ArrayList<>();
        if(target == 0){
            list.add(p);
            return list;
        }
        for(int i = 1;i<= 6 && i <= target;i++){
            List<String> temp = diceSumList(p+i,target-i);
            list.addAll(temp);
        }
        return list;
    }

    /*
    * Here we are writing code for the dice which has variable no of faces
    * but not exactly 6
    *
    * here i <= face condition is useful only when we want the output
    * to restrict the no .of faces
    * */
    static List<String> diceFaceSumList(String p, int target ,int face){
        List<String> list = new ArrayList<>();
        if(target == 0){
            list.add(p);
            return list;
        }
        for(int i = 1;i <= face && i <= target;i++){
            List<String> temp = diceFaceSumList(p+i,target-i,face);
            list.addAll(temp);
        }
        return list;
    }

    static int diceFaceSumCount(String p, int target ,int face){
        if(target == 0){
            return 1;
        }
        int count = 0;
        for(int i = 1;i <= face && i <= target;i++){
            count = count + diceFaceSumCount(p+i,target-i,face);
        }
        return count;
    }
}
