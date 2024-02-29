package org.example.BinaryTrees;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree Tree = new BinaryTree();
        Tree.populate(sc);
      //  Tree.display();
        Tree.prettyDisplay();
    }
}
