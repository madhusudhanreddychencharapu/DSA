//package org.example.HashMaps;
//
//import javax.swing.colorchooser.ColorSelectionModel;
//import java.util.*;
//
//public class HashMapSorting {
//    public static void main(String[] args) {
//        Map<String,Integer> mp = new HashMap<>();
//        mp.put("madhu",91);
//        mp.put("vamshi",96);
//        mp.put("Ravi",99);
//        mp.put("Pandu",92);
//        Comparator<Integer> cmp = new Comparator<>(){
//            @Override
//            public int compare(Object o1, Object o2) {
//                return 0;
//            }
//
//            public int compare(Integer a, Integer b){
//                if(a>b){
//                    return 1;
//                }
//                return -1;
//            }
//        };
//        //Collections.sort(mp,cmp);
//        List<Integer> list = (List<Integer>) mp.values();
//
//    }
//}
