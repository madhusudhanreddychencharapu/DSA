package org.example.BinarySearchTrees;

public class SegmentTree {

    Node root;
    public static  int count = 0;
    public SegmentTree(int[] arr) {
        root = constructTree(arr,0,arr.length-1);
    }
   private Node constructTree(int[] arr,int startIndex ,int endIndex ){
        if(startIndex == endIndex) {
            //Leaf Node
            Node leaf = new Node(startIndex , endIndex);
            leaf.value = arr[startIndex];
            return leaf;
        }
        Node node = new Node(startIndex , endIndex);
  /*
        Instead we collect the values of the left node and right node and sum it off
        int sum = 0;
        for (int i = startIndex ; i <= endIndex ;i++){
            sum += arr[i];
        node.value = sum;
        }*/
        int mid = (startIndex + endIndex)/2;
        node.left = constructTree(arr , startIndex , mid);
        node.right = constructTree(arr , mid+1 , endIndex);

        node.value = node.left.value + node.right.value;
        return node;
    }

    public int querySum(int qsi ,int qei){
        return querySum(root,qsi,qei);
    }
    private int querySum(Node node, int qsi , int qei){
            count++;
        if(node.start > qei || node.end < qsi){
            return 0;
        }
        if(node.start >= qsi && node.end <= qei){
            return node.value;
        }
//        if(node.start == node.end){
//            return 0;
//        }

        int left = querySum(node.left , qsi , qei);
        int right = querySum(node.right , qsi , qei);

        return  left + right;
    }
    private class Node{
        public int value;
        public int start;
        public int end;
        public Node left;
        public Node right;

        public Node(int start ,int end){
            this.start = start;
            this.end = end;
        }
        public Node(int start, int end ,int value){
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }
}






