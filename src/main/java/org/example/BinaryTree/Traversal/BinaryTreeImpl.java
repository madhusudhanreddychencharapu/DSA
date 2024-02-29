package org.example.BinaryTree.Traversal;

import java.util.*;

public class BinaryTreeImpl {
    public static void main(String[] args) {
        Node node = new Node(3);
        node.left = new Node(9);
        node.right = new Node(20);
//        node.left.left = new Node(4);
//        node.left.right = new Node(5);
        node.right.left = new Node(15);
        node.right.right = new Node(17);
//        node.left.right.left = new Node(8);
//        node.right.right.left = new Node(9);
//        node.right.right.right = new Node(10);

        System.out.println("After inorder traversal");
        inorder(node);
        System.out.println();

        System.out.println("After preorder traversal");
        preOrder(node);
        System.out.println();

        System.out.println("After PostOrder Traversal");
        postOrder(node);

        System.out.println(inOrder(node));

        System.out.println("After PreOrder iterative procedure");
        System.out.println(preOrderIterative(node));

        System.out.println("After InOrder iterative procedure");
        System.out.println(inOrderIterative(node));
    }

    /*
    * DEPTH FOR SEARCH TECHNIQUE(DFS)
    * 1. Inorder Traversal (Left Root Right)
    * 2. Preorder Traversal (Root Left Right)
    * 3. Postorder Traversal (Left Right Root)
    * */

    /*
    * Inorder Traversal
    * approach:
    * Simple recursion
    *  */
    public static void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    /*
    * PreOrder Traversal - Simple Recursion
    * */
    public static void preOrder(Node node){
        if(node == null){
            return;
        }

        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    /*
    * PostOrder Traversal - Simple Recursion
    * */
    public static void postOrder(Node node){
        if(node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data+" ");
    }

    public static List<Integer> inOrder(Node node){
        if(node == null){
            return new ArrayList<>();
        }
        List<Integer> l1 = inOrder(node.left);
            l1.add(node.data);
        List<Integer> l2 = inOrder(node.right);
        l1.addAll(l2);

        return l1;
    }

    /**
     * Here we are using queue and arraylist of the arraylist
     * approach :
     * 1. we are going to create a queue and enqueue the initial root
     * 2. Then dequeue the root and enqueue if child exists parallely adding into a arraylist
     * the elements after completion of a level the list is added to the list of the list
     * <p>
     * Note : we are going to take the initial size of the queue (i.e queue.size()) but not in
     * the for loop which varies after each iteration
     * <p>
     * At starting we know that at max it can have two children and in next iteration by deque the
     * elements and enqueue the children makes the total count of the children of the next level.
     * <p>
     * Since it should follow the left to right in sequence because of that we used the stace data structure.
     */
    public static List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> alist = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> arr = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node != null) {
                    arr.add(node.data);

                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            alist.add(arr);
        }
        return alist;
    }

    /* Iterative Traversal Begins and takes the help of the stack */

    /*
    * PreOrder Iterative Method - Basically pops and push the children from right to left
    * Because we need from left to right and stack is LIFO
    * */
    public static List<Integer> preOrderIterative(Node root){
        Stack<Node> st = new Stack<>();
        List<Integer> ls = new ArrayList<>();
        st.push(root);

        while (!st.empty()){
            Node node = st.pop();
            ls.add(node.data);

            if(node.right != null){
                st.push(node.right);
            }
            if(node.left != null){
                st.push(node.left);
            }
        }
        return ls;
    }

    /*
    * Here it is similar inorder recursion
    * three steps
    * 1. push the current node if not equal to null and assign left child
    * 2. If the current node is null then pop and add to the list
    *   assign the right child
    * 3. If the stack is empty then break
    * (Note : we are not keeping stack.empty() in while because we have to
    * print the root node at that time stack is empty but right child is not
    * traversed )
    * */
    public static List<Integer> inOrderIterative(Node node){
        List<Integer> list = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        while(true){
            if(node != null){
                st.push(node);
                node = node.left;
            }
            else{
                if(st.empty()){
                    break;
                }
                node = st.pop();
                list.add(node.data);
                node = node.right;
            }
        }
        return list;
    }
}
class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}
