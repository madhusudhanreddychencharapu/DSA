package org.example.arrays.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tab {
    private final String name;
    private final List<Comparable[]> tuples;
    public Tab(String name , List<Comparable[]> tuples){
        this.name = name;
        this.tuples = tuples;
    }
    public void find(int col , Comparable val){
        for (int i = 0; i < tuples.size(); i++) {
          //  System.out.println(myList.get(i));
            if(tuples.get(i)[0] == val){
                System.out.println("Found the answer");
                System.out.println(tuples.get(i).toString());
                Comparable[] temp = tuples.get(i);
                System.out.println(Arrays.toString(temp));
            };
        }
        System.out.println("Not found");
    };

    public static void main(String[] args) {
        List<Comparable[]> ts = new ArrayList<Comparable[]>();
        ts.add(new Comparable[]{
                "starwars ", 1977, 124, "scifi", "fox", 12345});
        ts.add(new Comparable[]{
                "starwars 2 ", 1980, 124, "scifi", "fox", 12345});
        ts.add(new Comparable[]{
                "Rocky ", 1985, 200, "action", "Universal", 12345});
        ts.add(new Comparable[]{
                "Rambo ", 1978, 100, "action", "Universal", 12345});


        Tab movie = new Tab("movie", ts);
        movie.find(0 , "Rambo ");
    }
}
