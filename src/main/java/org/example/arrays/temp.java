package org.example.arrays;

import java.util.ArrayList;
import java.util.List;

public class temp {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0 ;i< 6;i++){
            arrayList.add(i,i+2);
        }
        arrayList.add(2,95);
        arrayList.add(4,99);
        arrayList.set(2,77);
        arrayList.remove(Integer.valueOf(5));
        System.out.println(arrayList);
        for(int i = 0;i < arrayList.size();i++ ){
            System.out.println(arrayList.get(i));
        }


    }
}
