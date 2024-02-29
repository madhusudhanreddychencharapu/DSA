package org.example.revision;

import java.util.ArrayList;
import java.util.List;

public class TempPractice {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> alist = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> a1= new ArrayList<>();
        a1.add(25);
        a1.add(36);
        a1.add(49);
        a1.add(25);
        alist.add(a1);

        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(1);
        a2.add(2);
        a2.add(3);
        alist.add(a2);

        ArrayList<Integer> a3 = new ArrayList<>();
        a3.add(66);
        a3.add(77);
        a3.add(88);
        alist.add(a3);

        System.out.println(alist);
        for(int i = 0; i < alist.size();i++){
            for(int j = 0; j < alist.get(i).size(); j++){
                System.out.print(alist.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
