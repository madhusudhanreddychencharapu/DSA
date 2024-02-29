package org.example.BinarySearchTrees;

public class BST {
    public BST(){
    }
    private Node root;
    public int height(Node node){
        if(node == null){
            return 0;
        }
        return node.height;
    }
    public boolean isEmpty(){
        return root == null;
    }

    public void insert(int value){
        root = insert(value ,root);
    }
    private Node insert(int value,Node node){
        if(node == null){
            return new Node(value);
        }
        node.height = count(node);
        if(value < node.value){
            node.left = insert(value,node.left);
        }
        if(value > node.value){
            node.right = insert(value,node.right);
        }
        return node;
    }
    private int count(Node node){
        if(node == null){
            return 0;
        }
        int left = 1+ count(node.left);
        int right = 1+ count(node.right);
        return Math.max(left,right);
    }
    public void populate(int[] nums){
        for(int i = 0; i< nums.length ; i++){
            this.insert(nums[i]);
        }
    }
    public boolean balanced(){
          return   balanced(root);
    }
    private boolean balanced(Node node){
        if(node == null){
            return true;
        }
        return Math.abs(height(node.left)-height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }
    public void display(){
        display(this.root,"root node is :");
    }
    private void display(Node node,String details){
        if(node == null){
            return;
        }
        System.out.println(details + node.value);
        display(node.left, "Left node of "+node.value+" : ");
        display(node.right, "Right node of "+node.value+" : ");
    }

    public void populateSorted(int[] nums) {
        populateSorted(nums, 0 ,nums.length-1);
    }
    private void populateSorted(int[] nums , int start , int end){
        if(start >= end){
            return;
        }
        int mid = (start+end)/2;
        this.insert(nums[mid]);
        populateSorted(nums,start,mid);
        populateSorted(nums,mid+1,end);
    }

    public static class Node{
        public int value;
        Node left;
        private Node right;
        public  int height;

        public  Node(int value){
            this.value = value;
        }
        public int getValue(){
            return this.value;
        }
    }
}
