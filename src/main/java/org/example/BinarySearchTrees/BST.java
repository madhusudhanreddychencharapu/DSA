package org.example.BinarySearchTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<List<Integer>> BFS(){
        return BFS(root);
    }
    private List<List<Integer>> BFS(Node root){
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!(queue.isEmpty())){
            List<Integer> currLevel = new ArrayList<>();
            int levelCount = queue.size();
            for(int i = 0; i < levelCount; i++) {
                Node node = queue.poll();
                currLevel.add(node.value);
                //System.out.print(node.value + "->");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(currLevel);
        }
        return result;
    }
    public List<Double> averageOfLevels(){
        return averageOfLevels(root);
    }
    private List<Double> averageOfLevels(Node root){
        List<Double> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            Double sum = 0.0;
            int levelSize = queue.size();
            for(int i = 0; i< levelSize; i++){
                Node currNode = queue.poll();
                sum += currNode.value;
                if(currNode.left != null){
                    queue.add(currNode.left);
                }
                if(currNode.right != null){
                    queue.add(currNode.right);
                }
            }
            result.add(sum/levelSize);
        }
        return result;
    }
    public int levelOrderSuccessor(int element){
        return levelOrderSuccessor(root ,element);
    }
    private int levelOrderSuccessor(Node root, int element){
        if (root == null){
            return -1;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int levelCount = queue.size();
            for (int i = 0; i < levelCount ;i++){
                Node currNode = queue.poll();
                if(currNode.left != null){
                    queue.add(currNode.left);
                }
                if(currNode.right != null){
                    queue.add(currNode.right);
                }

                if(currNode.value == element){
                    Node resNode = queue.poll();
                    if(resNode != null){
                        return resNode.value;
                    }else {
                        return 0;
                    }
                }
            }
        }
        return -1;
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
