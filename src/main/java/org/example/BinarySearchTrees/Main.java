package org.example.BinarySearchTrees;

public class Main {
    public static void main(String[] args) {
//        BST tree = new BST();
//        int[] nums = {1,2,3,4,5,6,7,8,9};
//        //tree.populate(nums);
//        tree.populateSorted(nums);
//        tree.display();

        AVLTree avlTree = new AVLTree();
        for(int i = 3; i>0; i--){
            avlTree.insert(i);
        }
        System.out.println(avlTree.height(avlTree.root));
    }
}
