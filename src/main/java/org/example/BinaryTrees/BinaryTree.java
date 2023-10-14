package org.example.BinaryTrees;

import java.util.Scanner;

public class BinaryTree {
    private Node root;

    public void populate(Scanner scanner){
        System.out.println("Enter the root Node : ");
        int val = scanner.nextInt();
        Node node = new Node(val);
        root = node;
    }
    public void populate(Scanner scanner ,Node node){
        System.out.println("Do you want to insert left :"+node.value);
        boolean left = scanner.hasNextBoolean();

        if(left){
            System.out.println("Enter the value of left of Node :"+node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner,node.left);
        }

        System.out.println("Do you want to insert Right :"+node.value);
        boolean right = scanner.hasNextBoolean();

        if(left){
            System.out.println("Enter the value of right of Node :"+node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner,node.right);
        }


    }

    public static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }
}
