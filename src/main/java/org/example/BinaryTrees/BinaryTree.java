package org.example.BinaryTrees;

import java.util.Scanner;

public class BinaryTree {
    private Node root;

    public void populate(Scanner scanner){
        System.out.println("Enter the root Node : ");
        int val = scanner.nextInt();
        Node node = new Node(val);
        root = node;
        populate(scanner, node);
    }
    public void populate(Scanner scanner ,Node node){
        System.out.println("Do you want to insert left :"+node.value);
        boolean left = scanner.nextBoolean();

        if(left){
            System.out.println("Enter the value of left of Node :"+node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner,node.left);
        }

        System.out.println("Do you want to insert Right :"+node.value);
        boolean right = scanner.nextBoolean();

        if(right){
            System.out.println("Enter the value of right of Node :"+node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner,node.right);
        }
    }

    public void display(){
        display(this.root ,"");
    }
    private void display(Node node , String indent){
        if(node == null){
            return;
        }
        System.out.println(indent+node.value);
        display(node.left ,indent+"\t");
        display(node.right , indent+"\t");
    }

    public void prettyDisplay(){
        prettyDisplay(this.root , 0);
    }
    private void prettyDisplay(Node node ,int level){
        if(node == null){
            return;
        }
        prettyDisplay(node.right,level+1);

        if(level != 0) {
            for (int i = 0; i < level-1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|---->"+node.value);

        }else{
            System.out.println(node.value);
        }
        prettyDisplay(node.left,level+1);
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
