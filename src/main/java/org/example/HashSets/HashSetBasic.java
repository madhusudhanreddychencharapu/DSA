package org.example.HashSets;

import java.util.HashSet;
import java.util.Set;

public class HashSetBasic {
    public static void main(String[] args) {
        Set<String> st = new HashSet<>();
        st.add("madhu");
        st.add("sai");
        st.add("madhu");
        System.out.println(st);
        System.out.println(st.contains("sai"));
        System.out.println(st.remove("sai"));
        System.out.println(st);
    }
}
