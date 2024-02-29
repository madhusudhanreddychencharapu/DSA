package org.example.BinarySearchTrees;

class AVLTree{
    public   Node root;

    public  int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }
    public void insert(int num){
        root = insert(root, num);
    }
    private Node insert(Node node, int val){
        if(node == null){
            return new Node(val);
        }
        if(val < node.Value){
            node.left = insert(node.left,val);
        }
        if(val > node.Value){
            node.right = insert(node.right , val);
        }
        node.height = Math.max(height(node.right),height(node.left))+1;
        return rotate(node);
    }
    public Node rotate(Node node){
        if((height(node.left) - height(node.right)) >1){
            //Left Unbalanced
            if(node.left != null) {
                if ((height(node.left.left) - height(node.left.right)) > 0) {
                    //Left Left Unbalanced
                    return rightRotate(node);
                }
                if ((height(node.left.left) - height(node.left.right)) < 0) {
                    // Left Right Unbalanced
                    node.left = leftRotate(node.left);
                    return rightRotate(node);

                }
            }
        }
        if((height(node.left) - height(node.right)) < -1){
            //Right Unbalanced
            if(node.right != null) {
                if ((height(node.right.left) - height(node.right.right)) < 0) {
                    //Right Right Unbalanced
                    return leftRotate(node);
                }
                if ((height(node.right.left) - height(node.right.right)) > 0) {
                    // Right Left Unbalanced
                    node.right = rightRotate(node.right);
                    return leftRotate(node);

                }
            }
        }
        return node;
    }
    private Node rightRotate(Node p){
        Node c = p.left;
        Node t2 = c.right;

        c.right = p;
        p.left = t2;

        p.height = Math.max(height(p.left), height(p.right))+1;
        c.height = Math.max(height(c.left) ,height(c.right))+1;

        return c;
    }
    
    private Node  leftRotate(Node p){
        Node c = p.right;
        Node t = c.left;

        c.left = p;
        p.right = t;

        c.height = Math.max(height(c.left) ,height(c.right))+1;
        p.height = Math.max(height(p.left), height(p.right))+1;

        return c;
    }
    
    private class Node{
        public int Value;
        public Node left;
        public Node right;
        public int height;

        public Node(int Value){
            this.Value = Value;
        }
    }
}