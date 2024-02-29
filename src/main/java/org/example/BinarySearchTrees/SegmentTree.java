package org.example.BinarySearchTrees;

public class SegmentTree {
    Node root;
    public void insert(int index ,int num){

    }
  /*  private Void insert(int index, int num, Node root){
        if(root == null){
            return new Node(index,index,num);
        }
        if(root.start == root.end){
            root.value = num;
            return root;
        }
        root.value = root.value + num;
        root.end = index;

        if(index < root.end){
            insert(index , num , root.left);
        }
        if(index > root.end){
            insert(index , num , root.right);
        }

    }*/
    private class Node{
        public int value;
        public int start;
        public int end;
        public Node left;
        public Node right;

        public Node(int start, int end ,int value){
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }
}






